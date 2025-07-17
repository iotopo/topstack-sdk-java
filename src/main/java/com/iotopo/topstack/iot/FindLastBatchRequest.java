package com.iotopo.topstack.iot;

import java.util.List;

public class FindLastBatchRequest {
    private List<FindLastRequest> requests;

    public FindLastBatchRequest() {}

    public FindLastBatchRequest(List<FindLastRequest> requests) {
        this.requests = requests;
    }

    public List<FindLastRequest> getRequests() {
        return requests;
    }

    public void setRequests(List<FindLastRequest> requests) {
        this.requests = requests;
    }
} 