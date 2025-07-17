package com.iotopo.topstack.alert.alertrecord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IgnoredBatchResponse {
    private List<String> ids;

    public List<String> getIds() { return ids; }
    public void setIds(List<String> ids) { this.ids = ids; }
} 