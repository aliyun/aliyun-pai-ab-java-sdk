
package com.aliyun.openservices.paiabtest.api;


import com.aliyun.openservices.paiabtest.model.Layer;
import com.aliyun.paiabtest20240119.models.ListLayersRequest;
import com.aliyun.paiabtest20240119.models.ListLayersResponse;
import com.aliyun.paiabtest20240119.models.ListLayersResponseBody;

import java.util.ArrayList;
import java.util.List;

public class LayerApi extends BaseApi{
    public LayerApi(ApiClient apiClient) {
        super(apiClient);
    }

    public List<Layer> listLayers(String expDomainId) throws Exception {
        List<Layer> layerList = new ArrayList<>();
        ListLayersRequest listLayersRequest = new ListLayersRequest();
        listLayersRequest.setAll(true);
        listLayersRequest.setDomainId(expDomainId);
        ListLayersResponse listLayersResponse = apiClient.getClient().listLayers(listLayersRequest);
        for (ListLayersResponseBody.ListLayersResponseBodyLayers item : listLayersResponse.getBody().getLayers()) {
           Layer layer = new Layer();
           layer.setExpDomainId(Integer.valueOf(item.getDomainId()));
           layer.setExpLayerId(Integer.valueOf(item.getLayerId()));
           layer.setLayerName(item.getName());
           layer.setLayerInfo(item.getDescription());
           layer.setExpProjectId(Integer.valueOf(item.getProjectId()));
           layer.setIsDefaultLayer(item.getIsDefaultLayer());
           layerList.add(layer);
        }

        return layerList;
    }
}
