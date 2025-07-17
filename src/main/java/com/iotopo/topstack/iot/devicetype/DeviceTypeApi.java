package com.iotopo.topstack.iot.devicetype;

import com.fasterxml.jackson.databind.JavaType;
import com.iotopo.topstack.client.ResponseData;
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

public class DeviceTypeApi {
    private final TopstackClient client;

    public DeviceTypeApi(TopstackClient client) {
        this.client = client;
    }

    public ResponseData<DeviceTypeListResponse> query(DeviceTypeListRequest req) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, DeviceTypeListResponse.class);
        return client.sendRequest("GET", "/iot/open_api/v1/device_type/query", req, type);
    }

    public ResponseData<PointQueryResponse> queryPoint(PointQueryRequest req) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, PointQueryResponse.class);
        return client.sendRequest("GET", "/iot/open_api/v1/device_type_point/query", req, type);
    }
} 