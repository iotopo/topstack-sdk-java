package com.iotopo.topstack.nats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * 数据通道状态
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ChannelState {
    
    @JsonProperty("projectID")
    private String projectID;
    
    @JsonProperty("gatewayID")
    private String gatewayID;
    
    @JsonProperty("channelID")
    private String channelID;
    
    @JsonProperty("running")
    private Boolean running;
    
    @JsonProperty("connected")
    private Boolean connected;
    
    @JsonProperty("timestamp")
    private OffsetDateTime timestamp;
    
    @JsonProperty("gatewayName")
    private String gatewayName;
    
    @JsonProperty("channelName")
    private String channelName;
    
    // Constructors
    public ChannelState() {}
    
    public ChannelState(String projectID, String gatewayID, String channelID, 
                      Boolean running, Boolean connected, OffsetDateTime timestamp,
                      String gatewayName, String channelName) {
        this.projectID = projectID;
        this.gatewayID = gatewayID;
        this.channelID = channelID;
        this.running = running;
        this.connected = connected;
        this.timestamp = timestamp;
        this.gatewayName = gatewayName;
        this.channelName = channelName;
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
    
    public String getChannelID() {
        return channelID;
    }
    
    public void setChannelID(String channelID) {
        this.channelID = channelID;
    }
    
    public Boolean getRunning() {
        return running;
    }
    
    public void setRunning(Boolean running) {
        this.running = running;
    }
    
    public Boolean getConnected() {
        return connected;
    }
    
    public void setConnected(Boolean connected) {
        this.connected = connected;
    }
    
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public String getGatewayName() {
        return gatewayName;
    }
    
    public void setGatewayName(String gatewayName) {
        this.gatewayName = gatewayName;
    }
    
    public String getChannelName() {
        return channelName;
    }
    
    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }
    
    @Override
    public String toString() {
        return "ChannelState{" +
                "projectID='" + projectID + '\'' +
                ", gatewayID='" + gatewayID + '\'' +
                ", channelID='" + channelID + '\'' +
                ", running=" + running +
                ", connected=" + connected +
                ", timestamp=" + timestamp +
                ", gatewayName='" + gatewayName + '\'' +
                ", channelName='" + channelName + '\'' +
                '}';
    }
} 