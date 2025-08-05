 package com.iotopo.topstack.nats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

 /**
 * 设备测点数据
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
 @JsonIgnoreProperties(ignoreUnknown = true)
public class PointData {
    
    @JsonProperty("deviceID")
    private String deviceID;
    
    @JsonProperty("pointID")
    private String pointID;
    
    @JsonProperty("value")
    private Object value;
    
    @JsonProperty("quality")
    private Integer quality; // 1 表示离线，2 表示无效
    
    @JsonProperty("timestamp")
    private OffsetDateTime timestamp; // 时间戳，单位:毫秒
    
    @JsonProperty("status")
    private Integer status; // TODO: 状态: 0 表示正常，> 0 表示越上限，< 0 表示越下限
    
    // 接收到数据后补充, 然后再转发到 nats 消息总线
    @JsonProperty("deviceTypeID")
    private String deviceTypeID;
    
    @JsonProperty("projectID")
    private String projectID;
    
    @JsonProperty("gatewayID")
    private String gatewayID;
    
    @JsonProperty("notSave")
    private Boolean notSave; // 不持久化存储
    
    // Constructors
    public PointData() {}
    
    public PointData(String deviceID, String pointID, Object value, Integer quality, 
                    OffsetDateTime timestamp, Integer status, String deviceTypeID,
                    String projectID, String gatewayID, Boolean notSave) {
        this.deviceID = deviceID;
        this.pointID = pointID;
        this.value = value;
        this.quality = quality;
        this.timestamp = timestamp;
        this.status = status;
        this.deviceTypeID = deviceTypeID;
        this.projectID = projectID;
        this.gatewayID = gatewayID;
        this.notSave = notSave;
    }
    
    // Getters and Setters
    public String getDeviceID() {
        return deviceID;
    }
    
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
    
    public String getPointID() {
        return pointID;
    }
    
    public void setPointID(String pointID) {
        this.pointID = pointID;
    }
    
    public Object getValue() {
        return value;
    }
    
    public void setValue(Object value) {
        this.value = value;
    }
    
    public Integer getQuality() {
        return quality;
    }
    
    public void setQuality(Integer quality) {
        this.quality = quality;
    }
    
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }
    
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
    
    public Integer getStatus() {
        return status;
    }
    
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getDeviceTypeID() {
        return deviceTypeID;
    }
    
    public void setDeviceTypeID(String deviceTypeID) {
        this.deviceTypeID = deviceTypeID;
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
    
    public Boolean getNotSave() {
        return notSave;
    }
    
    public void setNotSave(Boolean notSave) {
        this.notSave = notSave;
    }
    
    @Override
    public String toString() {
        return "PointData{" +
                "deviceID='" + deviceID + '\'' +
                ", pointID='" + pointID + '\'' +
                ", value=" + value +
                ", quality=" + quality +
                ", timestamp=" + timestamp +
                ", status=" + status +
                ", deviceTypeID='" + deviceTypeID + '\'' +
                ", projectID='" + projectID + '\'' +
                ", gatewayID='" + gatewayID + '\'' +
                ", notSave=" + notSave +
                '}';
    }
}