package com.aliyun.openservices.paiabtest;

import com.aliyun.openservices.paiabtest.api.ApiClient;
import com.aliyun.openservices.paiabtest.api.Configuration;
import com.aliyun.openservices.paiabtest.model.ExperimentContext;
import com.aliyun.openservices.paiabtest.model.ExperimentResult;

import java.util.HashMap;
import java.util.Map;

public class ExperimentTest {
    static ExperimentClient experimentClient;

    public static void main(String[] args) throws Exception {
        // set up experiment client
        String regionId = "cn-beijing";
        String accessId = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_ID");
        String accessKey = System.getenv("ALIBABA_CLOUD_ACCESS_KEY_SECRET");
        Configuration configuration = new Configuration(regionId, accessId, accessKey);
        ApiClient apiClient = new ApiClient(configuration);
        experimentClient = new ExperimentClient(apiClient);

        // init load experiment data
        experimentClient.init();

        // set up experiment context
        ExperimentContext experimentContext = new ExperimentContext();
        experimentContext.setRequestId("req_id");
        // set uid
        experimentContext.setUid("149");
        // set filter params for condition filter match
        Map<String, Object> filterParams = new HashMap<>();
        filterParams.put("sex", "male");
        experimentContext.setFilterParams(filterParams);

        // match experiment
        ExperimentResult experimentResult =  experimentClient.matchExperiment("DefaultProject", experimentContext);

        // print experiment info
        System.out.println(experimentResult.info());
        // print exp id
        System.out.println(experimentResult.getExpId());
        // print exp params
        System.out.println(experimentResult.getExperimentParams().get("recall_v", "not exist"));
        System.out.println(experimentResult.getExperimentParams().get("rank_v", "not exist"));
        System.out.println(experimentResult.getExperimentParams().get("male_v", "not exist"));
    }
}
