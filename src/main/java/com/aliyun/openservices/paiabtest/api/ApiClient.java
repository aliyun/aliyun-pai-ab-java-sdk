
package com.aliyun.openservices.paiabtest.api;


import com.aliyun.paiabtest20240119.Client;

public class ApiClient {
    private Configuration configuration;
    Client client;

    private CrowdApi crowdApi;

    private ProjectApi projectApi;

    private DomainApi domainApi;

    private LayerApi layerApi;
    private ExperimentApi experimentApi ;

    private ExperimentVersionApi experimentVersionApi ;

    private FeatureApi featureApi ;


    public ApiClient(Configuration configuration) throws Exception {
        this.configuration = configuration;
        this.client = new Client(configuration.getConfig());

        this.projectApi = new ProjectApi(this);
        this.domainApi = new DomainApi(this);
        this.layerApi = new LayerApi(this);
        this.experimentApi = new ExperimentApi(this);
        this.experimentVersionApi = new ExperimentVersionApi(this);
        this.featureApi = new FeatureApi(this);
        this.crowdApi = new CrowdApi(this);
    }

    public Client getClient() {
        return client;
    }

    public String getInstanceId() {
        return this.configuration.getInstanceId();
    }

    public CrowdApi getCrowdApi() {
        return crowdApi;
    }

    public LayerApi getLayerApi() {
        return layerApi;
    }


    public ExperimentApi getExperimentApi() {
        return experimentApi;
    }

    public ProjectApi getProjectApi() {
        return projectApi;
    }

    public DomainApi getDomainApi() {
        return domainApi;
    }

    public ExperimentVersionApi getExperimentVersionApi() {
        return experimentVersionApi;
    }

    public FeatureApi getFeatureApi() {
        return featureApi;
    }

    public Configuration getConfiguration() {
        return configuration;
    }
}