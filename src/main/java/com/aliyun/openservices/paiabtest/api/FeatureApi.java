
package com.aliyun.openservices.paiabtest.api;


import com.aliyun.openservices.paiabtest.common.Constants;
import com.aliyun.openservices.paiabtest.model.Feature;
import com.aliyun.paiabtest20240119.models.ListFeaturesRequest;
import com.aliyun.paiabtest20240119.models.ListFeaturesResponse;
import com.aliyun.paiabtest20240119.models.ListFeaturesResponseBody;

import java.util.ArrayList;
import java.util.List;

public class FeatureApi extends BaseApi{

    public FeatureApi(ApiClient apiClient) {
        super(apiClient);
    }

    public List<Feature> listFeatures(String expDomainId ) throws Exception {
        List<Feature> featureList = new ArrayList<>();
        ListFeaturesRequest listFeaturesRequest = new ListFeaturesRequest();
        listFeaturesRequest.setAll(true);
        listFeaturesRequest.setDomainId(expDomainId);
        ListFeaturesResponse listFeaturesResponse =  apiClient.getClient().listFeatures(listFeaturesRequest);
        for (ListFeaturesResponseBody.ListFeaturesResponseBodyFeatures item : listFeaturesResponse.getBody().getFeatures()) {
            Feature feature = new Feature();
            feature.setFeatureId(Integer.valueOf(item.getFeatureId()));
            feature.setFeatureName(item.getName());
            feature.setConfig(item.getConfig());
            feature.setExpDomainId(Integer.valueOf(item.getDomainId()));
            feature.setExpDomainName(item.getDomainName());
            feature.setExpProjectId(Integer.valueOf(item.getProjectId()));
            feature.setExpId(Integer.valueOf(item.getExperimentId()));
            feature.setExpVersionId(Integer.valueOf(item.getExperimentVersionId()));
            feature.setFilter(item.getFilter());
            feature.setConfig(item.getConfig());
            if ("Published".equals(item.getStatus())) {
                feature.setStatus(Constants.FeatureStatusReleased);
            } else if ("UnPublished".equals(item.getStatus())) {
                feature.setStatus(Constants.FeatureStatusUnreleased);
            }

            featureList.add(feature);
        }
        return featureList;
    }
}
