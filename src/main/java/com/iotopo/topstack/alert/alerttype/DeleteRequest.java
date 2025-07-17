package com.iotopo.topstack.alert.alerttype;

import com.iotopo.topstack.client.RequestData;

public class DeleteRequest extends RequestData {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
} 