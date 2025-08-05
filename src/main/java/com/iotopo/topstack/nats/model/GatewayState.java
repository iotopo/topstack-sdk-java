package com.iotopo.topstack.nats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * 网关状态
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayState {
    
    @JsonProperty("sn")
    private String sn;
    
    @JsonProperty("name")
    private String name;
    
    @JsonProperty("projectID")
    private String projectID;
    
    @JsonProperty("gatewayID")
    private String gatewayID;
    
    @JsonProperty("state")
    private Integer state; // 0: 离线， 1：在线
    
    @JsonProperty("timestamp")
    private OffsetDateTime timestamp; // 时间戳
    
    // Constructors
    public GatewayState() {}
    
    public GatewayState(String sn, String name, String projectID, String gatewayID, 
                       Integer state, OffsetDateTime timestamp) {
        this.sn = sn;
        this.name = name;
        this.projectID = projectID;
        this.gatewayID = gatewayID;
        this.state = state;
        this.timestamp = timestamp;
    }
    
    // Getters and Setters
    public String getSn() {
        return sn;
    }
    
    public void setSn(String sn) {
        this.sn = sn;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getProjectID() {
        return projectID;
    }
    
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
    
    public String getGatewayID() {
        return gatewayID;
    }
    
    public void setGatewayID(String gatewayID) {
        this.gatewayID = gatewayID;
    }
    
    public Integer getState() {
        return state;
    }
    
    public void setState(Integer state) {
        this.state = state;
    }
    
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    @Override
    public String toString() {
        return "GatewayState{" +
                "sn='" + sn + '\'' +
                ", name='" + name + '\'' +
                ", projectID='" + projectID + '\'' +
                ", gatewayID='" + gatewayID + '\'' +
                ", state=" + state +
                ", timestamp=" + timestamp +
                '}';
    }
} 