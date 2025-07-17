package com.iotopo.topstack.alert.alertrecord;

import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

public class AlertRecordApi {
    
    public static AlertRecordListResponse query(TopstackClient client, AlertRecordListRequest request) throws TopstackException {
        return client.get("/alert/open_api/v1/alert_record", request, AlertRecordListResponse.class);
    }
    
    public static ActivityResponse getActivity(TopstackClient client, ActivityRequest request) throws TopstackException {
        return client.get("/alert/open_api/v1/alert_record/activity", request, ActivityResponse.class);
    }
    
    public static IgnoredBatchResponse ignoredBatch(TopstackClient client, IgnoredBatchRequest request) throws TopstackException {
        return client.put("/alert/open_api/v1/alert_record/ignoredBatch", request, IgnoredBatchResponse.class);
    }
} 