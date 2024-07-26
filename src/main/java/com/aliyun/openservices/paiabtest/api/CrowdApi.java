package com.aliyun.openservices.paiabtest.api;




import com.aliyun.paiabtest20240119.models.ListCrowdsRequest;
import com.aliyun.paiabtest20240119.models.ListCrowdsResponse;
import com.aliyun.paiabtest20240119.models.ListCrowdsResponseBody;
import com.aliyun.tea.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class CrowdApi extends  BaseApi{

    public CrowdApi(ApiClient apiClient) {
        super(apiClient);
    }


    public List<String> listCrowdUsers(String crowdId) throws Exception {
        List<String> users = new ArrayList<>();
        ListCrowdsRequest listCrowdsRequest = new ListCrowdsRequest();
        listCrowdsRequest.setCrowdId(crowdId);
        listCrowdsRequest.setAll(true);
        ListCrowdsResponse listCrowdsResponse = apiClient.getClient().listCrowds(listCrowdsRequest);

        for (ListCrowdsResponseBody.ListCrowdsResponseBodyCrowds item : listCrowdsResponse.getBody().getCrowds()) {
            String[] list = item.getUsers().split(",");
            for (String s : list) {
                if (!StringUtils.isEmpty(s)) {
                    users.add(s);
                }
            }
        }

        return users;
    }

}