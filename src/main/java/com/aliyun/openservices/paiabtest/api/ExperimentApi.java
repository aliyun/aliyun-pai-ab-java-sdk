package com.aliyun.openservices.paiabtest.api;

import com.aliyun.openservices.paiabtest.common.Constants;
import com.aliyun.openservices.paiabtest.model.Experiment;
import com.aliyun.paiabtest20240119.models.ListExperimentsRequest;
import com.aliyun.paiabtest20240119.models.ListExperimentsResponse;
import com.aliyun.paiabtest20240119.models.ListExperimentsResponseBody;

import java.util.ArrayList;
import java.util.List;

public class ExperimentApi extends BaseApi{

    public ExperimentApi(ApiClient apiClient) {
        super(apiClient);
    }

    public List<Experiment> listExperiment(String expLayerId, int expStatusRunning) throws Exception {
        List<Experiment> experimentList = new ArrayList<>();
        ListExperimentsRequest listExperimentsRequest = new ListExperimentsRequest();
        listExperimentsRequest.setAll(true);
        listExperimentsRequest.setLayerId(expLayerId);
        if (expStatusRunning == Constants.ExpStatusRunning) {
            listExperimentsRequest.setStatus("Running");
        }

        ListExperimentsResponse listExperimentsResponse = apiClient.getClient().listExperiments(listExperimentsRequest);
        for(ListExperimentsResponseBody.ListExperimentsResponseBodyExperiments item : listExperimentsResponse.getBody().getExperiments()) {
            Experiment experiment = new Experiment();
            experiment.setExpId(Integer.valueOf(item.getExperimentId()));
            experiment.setExpName(item.getName());
            experiment.setExpLayerId(Integer.valueOf(item.getLayerId()));
            experiment.setDebugUsers(item.getDebugUsers());
            experiment.setDebugCrowdIds(item.getCrowdIds());
            if ("Random".equals(item.getBucketType())) {
                experiment.setBucketType(Constants.ExpBucketTypeRand);
                experiment.setExperimentFlow(item.getFlow());
                experiment.setBuckets(item.getBuckets());
            } else if ("Condition".equals(item.getBucketType())) {
                experiment.setBucketType(Constants.ExpBucketTypeCond);
                experiment.setFilter(item.getCondition());
            }

            if ("Running".equals(item.getStatus())) {
                experiment.setStatus(Constants.ExpStatusRunning);
            }
            experiment.setStartTime(item.getStartTime());
            experiment.setEndTime(item.getEndTime());

            experimentList.add(experiment);
        }

        return experimentList;
    }
}
