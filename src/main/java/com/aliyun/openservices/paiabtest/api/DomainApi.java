
package com.aliyun.openservices.paiabtest.api;

import com.aliyun.openservices.paiabtest.common.Constants;
import com.aliyun.openservices.paiabtest.model.Domain;
import com.aliyun.paiabtest20240119.models.ListDomainsRequest;
import com.aliyun.paiabtest20240119.models.ListDomainsResponse;
import com.aliyun.paiabtest20240119.models.ListDomainsResponseBody;

import java.util.ArrayList;
import java.util.List;

public class DomainApi extends  BaseApi{

    public DomainApi(ApiClient apiClient) {
            super(apiClient);
    }

    public List<Domain> listDomains(String projectId) throws Exception {
        List<Domain> domainList = new ArrayList<>();
        ListDomainsRequest listDomainsRequest = new ListDomainsRequest();
        listDomainsRequest.setAll(true);
        listDomainsRequest.setProjectId(projectId);
        ListDomainsResponse listDomainsResponse = this.apiClient.getClient().listDomains(listDomainsRequest);
        for (ListDomainsResponseBody.ListDomainsResponseBodyDomains item : listDomainsResponse.getBody().getDomains()) {
            Domain domain = new Domain();
            domain.setExpDomainId(Integer.valueOf(item.getDomainId()));
            domain.setExpProjectId(Integer.valueOf(item.getProjectId()));
            domain.setIsDefaultDomain(item.getIsDefaultDomain());
            domain.setExpDomainName(item.getName());
            domain.setExpDomainInfo(item.getDescription());
            if ("Random".equals(item.getBucketType())) {
                domain.setBucketType(Constants.DomainBucketTypeRand);
                domain.setExperimentFlow(item.getFlow().intValue());
            } else if ("Condition".equals(item.getBucketType())) {
                domain.setBucketType(Constants.DomainBucketTypeCond);
                domain.setFilter(item.getCondition());
            }
            domain.setDebugUsers(item.getDebugUsers());
            domain.setDebugCrowdIds(item.getCrowdIds());

            domain.setExpLayerId(Integer.valueOf(item.getLayerId()));
            domain.setLayerName(item.getLayerName());

            domainList.add(domain);
        }
        return domainList;
    }
}
