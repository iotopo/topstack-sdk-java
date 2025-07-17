package com.iotopo.topstack.iot.gateway;

import com.fasterxml.jackson.databind.JavaType;
import com.iotopo.topstack.client.ResponseData;
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

public class GatewayApi {
    private final TopstackClient client;

    public GatewayApi(TopstackClient client) {
        this.client = client;
    }

    public ResponseData<GatewayListResponse> query(GatewayListRequest req) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, GatewayListResponse.class);
        return client.sendRequest("GET", "/iot/open_api/v1/gateway/query", req, type);
    }
} 