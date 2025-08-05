package com.iotopo.topstack.nats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * 设备状态(在线/离线)
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceState {
    
    @JsonProperty("projectID")
    private String projectID;
    
    @JsonProperty("gatewayID")
    private String gatewayID;
    
    @JsonProperty("deviceID")
    private String deviceID;
    
    @JsonProperty("state")
    private Integer state; // 0: 离线， 1：在线
    
    @JsonProperty("timestamp")
    private OffsetDateTime timestamp; // 时间戳
    
    // Constructors
    public DeviceState() {}
    
    public DeviceState(String projectID, String gatewayID, String deviceID, 
                      Integer state, OffsetDateTime timestamp) {
        this.projectID = projectID;
        this.gatewayID = gatewayID;
        this.deviceID = deviceID;
        this.state = state;
        this.timestamp = timestamp;
    }
    
    // Getters and Setters
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
    
    public String getDeviceID() {
        return deviceID;
    }
    
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
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
        return "DeviceState{" +
                "projectID='" + projectID + '\'' +
                ", gatewayID='" + gatewayID + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", state=" + state +
                ", timestamp=" + timestamp +
                '}';
    }
} 