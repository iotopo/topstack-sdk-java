package com.iotopo.topstack.iot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FindLastBatchResponse {
    private List<FindLastResponse> responses;

    public List<FindLastResponse> getResponses() {
        return responses;
    }

    public void setResponses(List<FindLastResponse> responses) {
        this.responses = responses;
    }
} 