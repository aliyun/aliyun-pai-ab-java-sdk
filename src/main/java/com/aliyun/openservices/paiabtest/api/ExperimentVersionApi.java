
package com.aliyun.openservices.paiabtest.api;

import com.aliyun.openservices.paiabtest.common.Constants;
import com.aliyun.openservices.paiabtest.model.ExperimentVersion;
import com.aliyun.paiabtest20240119.models.ListExperimentVersionsRequest;
import com.aliyun.paiabtest20240119.models.ListExperimentVersionsResponse;
import com.aliyun.paiabtest20240119.models.ListExperimentVersionsResponseBody;

import java.util.ArrayList;
import java.util.List;

public class ExperimentVersionApi extends BaseApi{
    public ExperimentVersionApi(ApiClient apiClient) {
        super(apiClient);
    }

    public List<ExperimentVersion> listExperimentVersion(String expId) throws Exception {
        List<ExperimentVersion> experimentVersionList = new ArrayList<>();
        ListExperimentVersionsRequest listExperimentVersionsRequest = new ListExperimentVersionsRequest();
        listExperimentVersionsRequest.setAll(true);
        listExperimentVersionsRequest.setExperimentId(expId);
        ListExperimentVersionsResponse listExperimentVersionsResponse = apiClient.getClient().listExperimentVersions(listExperimentVersionsRequest);

        for(ListExperimentVersionsResponseBody.ListExperimentVersionsResponseBodyExperimentVersions item :
                listExperimentVersionsResponse.getBody().getExperimentVersions()) {
            ExperimentVersion experimentVersion = new ExperimentVersion();
            experimentVersion.setExpVersionId(Integer.valueOf(item.getExperimentVersionId()));
            experimentVersion.setExpId(Integer.valueOf(item.getExperimentId()));
            experimentVersion.setExpVersionName(item.getName());
            if ("Baseline".equals(item.getType())) {
                experimentVersion.setExpVersionType(Constants.ExpVersionTypeBase);
            } else if ("Normal".equals(item.getType())) {
                experimentVersion.setExpVersionType(Constants.ExpVersionTypeNormal);
            }

            experimentVersion.setExperimentFlow(item.getFlow());
            experimentVersion.setBuckets(item.getBuckets());
            experimentVersion.setExpVersionConfig(item.getConfig());
            experimentVersion.setDebugUsers(item.getDebugUsers());
            experimentVersion.setDebugCrowdIds(item.getCrowdIds());

            experimentVersionList.add(experimentVersion);
        }

        return  experimentVersionList;
    }
}
