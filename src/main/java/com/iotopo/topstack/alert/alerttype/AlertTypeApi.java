package com.iotopo.topstack.alert.alerttype;

import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

public class AlertTypeApi {
    
    public static AlertTypeListResponse query(TopstackClient client, AlertTypeListRequest request) throws TopstackException {
        return client.get("/alert/open_api/v1/alert_type", request, AlertTypeListResponse.class);
    }
    
    public static CreateResponse create(TopstackClient client, CreateRequest request) throws TopstackException {
        return client.post("/alert/open_api/v1/alert_type", request, CreateResponse.class);
    }
    
    public static CreateResponse update(TopstackClient client, UpdateRequest request) throws TopstackException {
        return client.put("/alert/open_api/v1/alert_type", request, CreateResponse.class);
    }
    
    public static CreateResponse delete(TopstackClient client, DeleteRequest request) throws TopstackException {
        return client.delete("/alert/open_api/v1/alert_type/" + request.getId(), request, CreateResponse.class);
    }
} 