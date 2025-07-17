package com.iotopo.topstack.ems.subentry;

import com.iotopo.topstack.client.RequestData;

public class DetailRequest extends RequestData {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
} 