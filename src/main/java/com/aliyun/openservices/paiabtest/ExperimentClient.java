package com.aliyun.openservices.paiabtest;

import com.aliyun.openservices.paiabtest.api.ApiClient;
import com.aliyun.openservices.paiabtest.common.Constants;
import com.aliyun.openservices.paiabtest.model.Domain;
import com.aliyun.openservices.paiabtest.model.Experiment;
import com.aliyun.openservices.paiabtest.model.ExperimentContext;
import com.aliyun.openservices.paiabtest.model.ExperimentResult;
import com.aliyun.openservices.paiabtest.model.ExperimentVersion;
import com.aliyun.openservices.paiabtest.model.Feature;
import com.aliyun.openservices.paiabtest.model.Layer;
import com.aliyun.openservices.paiabtest.model.Project;
import com.aliyun.openservices.paiabtest.util.FNV;
import com.aliyun.tea.utils.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExperimentClient {
    public static Logger logger = LoggerFactory.getLogger(ExperimentClient.class);

    private ApiClient apiClient ;

    /**
     * cache experiment data by per project
     */
    Map<String, Project> projectMap = new HashMap<>();

    ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);

    boolean started = false;

    public ExperimentClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    private static class ExperimentWorker extends Thread {

        ExperimentClient experimentClient;

        public ExperimentWorker(ExperimentClient client) {
            experimentClient = client;
            super.setDaemon(true);
        }

        @Override
        public void run() {
            try {
                experimentClient.loadExperimentData();
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }
    }

    public synchronized void init() throws Exception {
        if (started) {
            return;
        }

        logger.debug("experiment client init");
        loadExperimentData();
        ExperimentWorker worker = new ExperimentWorker(this);
        scheduledThreadPool.scheduleWithFixedDelay(worker, 60, 60, TimeUnit.SECONDS);

        started = true;
    }


    /**
     * load experiment data from ab server
     *
     * @throws Exception
     */
    public void loadExperimentData() throws Exception {
        Map<String, Project> projectMap = new HashMap<>();

        List<Project> projects= apiClient.getProjectApi().listAllProjects();

        for (Project project : projects) {
            List<Domain> domains = apiClient.getDomainApi().listDomains(String.valueOf(project.getExpProjectId()));

            for (Domain domain : domains) {
                if (!StringUtils.isEmpty(domain.getDebugCrowdIds())) {
                    String[] debugCrowdIds = domain.getDebugCrowdIds().split(",");
                    for (String crowdId : debugCrowdIds) {
                        List<String> crowdUsers = apiClient.getCrowdApi().listCrowdUsers(crowdId);
                        domain.addDebugUsers(crowdUsers);
                    }
                }
                domain.init();
                if (domain.isIsDefaultDomain()) {
                    project.setDefaultDomain(domain);
                }
                project.addDomain(domain);

                List<Feature>  features = apiClient.getFeatureApi().listFeatures(String.valueOf(domain.getExpDomainId()));
                for (Feature feature: features) {
                    feature.init();
                    domain.addFeature(feature);
                }
                List<Layer>  layers = apiClient.getLayerApi().listLayers(String.valueOf(domain.getExpDomainId()));

                for (Layer layer : layers) {
                    domain.addLayer(layer);
                    project.addLayer(layer);

                    List<Experiment> experiments = apiClient.getExperimentApi().listExperiment(String.valueOf(layer.getExpLayerId()), Constants.ExpStatusRunning);

                    for (Experiment experiment : experiments) {
                        if (!StringUtils.isEmpty(experiment.getDebugCrowdIds() )) {
                            String[] debugCrowdIds = experiment.getDebugCrowdIds().split(",");
                            for (String crowdId : debugCrowdIds) {
                                List<String> crowdUsers = apiClient.getCrowdApi().listCrowdUsers(crowdId);
                                experiment.addDebugUsers(crowdUsers);
                            }
                        }
                        experiment.init();
                        layer.addExperiment(experiment);

                        List<ExperimentVersion> experimentVersions = apiClient.getExperimentVersionApi().listExperimentVersion(String.valueOf(experiment.getExpId()));

                        for (ExperimentVersion experimentVersion : experimentVersions) {
                            if (!StringUtils.isEmpty(experimentVersion.getDebugCrowdIds() )) {
                                String[] debugCrowdIds = experimentVersion.getDebugCrowdIds().split(",");
                                for (String crowdId : debugCrowdIds) {
                                    List<String> crowdUsers = apiClient.getCrowdApi().listCrowdUsers(crowdId);
                                    experimentVersion.addDebugUsers(crowdUsers);
                                }
                            }
                            experimentVersion.init();
                            experimentVersion.setExperiment(experiment);
                            experiment.addExperimentVersion(experimentVersion);
                        }
                    }
                }
            }
            for (Map.Entry<Integer, Domain>  domainEntry: project.getDomainMap().entrySet()) {
                if (!domainEntry.getValue().isIsDefaultDomain()) {
                    Layer layer = project.getLayerMap().get(domainEntry.getValue().getExpLayerId());
                    if (null != layer) {
                        layer.addDomain(domainEntry.getValue());
                    }
                }
            }

            projectMap.put(project.getProjectName(), project);
        }

        if (projectMap.size() > 0) {
            this.projectMap = projectMap;
        }
    }

    public Map<String, Project> getProjectMap() {
        return projectMap;
    }

    /**
     * This method determines traffic based on the experimental context and returns the matching result
     *
     * @param projectName project name
     * @param experimentContext
     * @return ExperimentResult
     */
    public ExperimentResult matchExperiment(String projectName, ExperimentContext experimentContext) {
        Map<String, Project> projectData = projectMap;
        if (!projectData.containsKey(projectName)) {
            logger.warn("project:{}, not found the project info", projectName);
            ExperimentResult experimentResult = new ExperimentResult(experimentContext);
            experimentResult.setProjectName(projectName);
            return experimentResult;
        }

        Project project = projectData.get(projectName);
        ExperimentResult experimentResult = new ExperimentResult(project, experimentContext);

        this.matchDomain(project.getDefaultDomain(), experimentResult);
        experimentResult.init();
        return experimentResult;
    }

    private void matchDomain(Domain domain, ExperimentResult experimentResult) {
        if (null == domain) {
            return;
        }

        for (Feature feature : domain.getFeatures()) {
            if (feature.match(experimentResult.getExperimentContext())) {
                experimentResult.getExperimentParams().addParams(feature.getParams());
            }
        }

        for (Layer layer : domain.getLayers()) {
            this.matchLayer(layer, experimentResult);
        }
    }

    private void matchLayer(Layer layer, ExperimentResult experimentResult) {
        if (null == layer) {
            return;
        }

        for (Experiment experiment : layer.getExperiments()) {
            if (experiment.matchDebugUsers(experimentResult.getExperimentContext())) {
                logger.info("match debug user for experiment:{}", experiment.getExpName());
                this.matchExp(experiment, experimentResult);
                return;
            }
        }

        for (Domain domain : layer.getDomains()) {
            if (domain.matchDebugUsers(experimentResult.getExperimentContext())) {
                logger.info("match debug user for domain:{}", domain.getExpDomainName());
                this.matchDomain(domain, experimentResult);
            }
        }
        StringBuilder hashKey = new StringBuilder(experimentResult.getExperimentContext().getUid());
        hashKey.append("_LAYER").append(layer.getExpLayerId());
        String hashValue = this.hashValue(hashKey.toString());

        ExperimentContext experimentContext = new ExperimentContext();
        experimentContext.setUid(hashValue);
        experimentContext.setFilterParams(experimentResult.getExperimentContext().getFilterParams());

        List<Experiment> matchExperiments = new ArrayList<>();
        for (Experiment experiment : layer.getExperiments()) {
            if (experiment.match(experimentContext)) {
                matchExperiments.add(experiment);
            }
        }

        if (matchExperiments.size() == 1) {
            this.matchExp(matchExperiments.get(0), experimentResult);
            return;
        } else if (matchExperiments.size() > 1) {
            for (Experiment experiment : matchExperiments) {
                if (experiment.getBucketType() == Constants.ExpBucketTypeCond) {
                    this.matchExp(experiment, experimentResult);
                    return;
                }
            }
            // if not find the cond bucket, so here have one more rand experiment match
            // should not happen
            logger.warn("match more than one experiment under layer:{}, id:{}", layer.getLayerName(), layer.getExpLayerId());
            this.matchExp(matchExperiments.get(0), experimentResult);
            return;
        }

        List<Domain> domainList = new ArrayList<>();
        for (Domain domain : layer.getDomains()) {
            if (domain.match(experimentContext)) {
                domainList.add(domain);
            }
        }

        if (domainList.size() == 1) {
            this.matchDomain(domainList.get(0), experimentResult);
            return;
        } else if (domainList.size() > 1 ) {
            for (Domain domain : domainList) {
                if (domain.getBucketType() == Constants.DomainBucketTypeCond) {
                    this.matchDomain(domain, experimentResult);
                    return;
                }
            }

            logger.warn("match more than one domain under layer:{}, id:{}", layer.getLayerName(), layer.getExpLayerId());
            this.matchDomain(domainList.get(0), experimentResult);
            return;
        }
    }

    private void matchExp(Experiment experiment, ExperimentResult experimentResult) {
        if (null == experiment) {
            return;
        }

        for (ExperimentVersion experimentVersion : experiment.getExperimentVersions()) {
            if (experimentVersion.matchDebugUsers(experimentResult.getExperimentContext())) {
                logger.info("match debug user for experimentVersion:%s", experimentVersion.getExpVersionName());
                experimentResult.getExperimentParams().addParams(experimentVersion.getParams());
                experimentResult.addExperimentVersion(experimentVersion);
                return;
            }
        }
        StringBuilder hashKey = new StringBuilder(experimentResult.getExperimentContext().getUid());
        hashKey.append("_EXPERIMENT").append(experiment.getExpId());
        String hashValue = this.hashValue(hashKey.toString());

        ExperimentContext experimentContext = new ExperimentContext();
        experimentContext.setUid(hashValue);
        experimentContext.setFilterParams(experimentResult.getExperimentContext().getFilterParams());

        for (ExperimentVersion experimentVersion : experiment.getExperimentVersions()) {
            if (experimentVersion.match(experimentContext)) {
                experimentResult.getExperimentParams().addParams(experimentVersion.getParams());
                experimentResult.addExperimentVersion(experimentVersion);
                return;

            }
        }
    }

    private String hashValue(String hashKey) {
        byte[] md5Hex = DigestUtils.md5(hashKey);
        BigInteger value = (new FNV()).fnv1_64(md5Hex);

        return value.toString();
    }

    public void close() throws Exception {
        scheduledThreadPool.awaitTermination(1, TimeUnit.SECONDS);
        scheduledThreadPool.shutdownNow();
        started = false;
    }

}