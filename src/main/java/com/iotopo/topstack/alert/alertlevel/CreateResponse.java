package com.iotopo.topstack.alert.alertlevel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CreateResponse {
    private String id;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
} 