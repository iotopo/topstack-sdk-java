package com.iotopo.topstack.nats.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import java.util.Map;

/**
 * 告警信息
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertInfo {
    
    // AlertBase fields
    @JsonProperty("id")
    private String id;
    
    @JsonProperty("status")
    private String status; // unhandled/handled/ignored/auto, 默认为 unhandled
    
    @JsonProperty("createdAt")
    private OffsetDateTime createdAt; // 创建时间
    
    @JsonProperty("recoveredAt")
    private OffsetDateTime recoveredAt; // 解除时间
    
    @JsonProperty("handledAt")
    private OffsetDateTime handledAt; // 确认或忽略时间
    
    @JsonProperty("expiredAt")
    private OffsetDateTime expiredAt; // 过期时间
    
    @JsonProperty("handler")
    private String handler; // 确认人或忽略人
    
    @JsonProperty("orderCreated")
    private Boolean orderCreated; // 是否创建过工单
    
    @JsonProperty("edge")
    private Boolean edge; // 是否为边缘侧产生
    
    @JsonProperty("title")
    private String title; // 通知标题
    
    @JsonProperty("content")
    private String content; // 通知内容
    
    @JsonProperty("remark")
    private String remark; // 确认信息的备注
    
    @JsonProperty("ruleTemplateID")
    private String ruleTemplateID;
    
    // 触发器信息
    @JsonProperty("triggerID")
    private String triggerID;
    
    @JsonProperty("mode")
    private String mode; // 触发方式: property(属性值触发), status(上下线触发), logic
    
    @JsonProperty("compareMode")
    private String compareMode; // 比较模式
    
    @JsonProperty("compareValue")
    private String compareValue; // 比较值
    
    @JsonProperty("duration")
    private Integer duration; // 持续时长（秒）
    
    @JsonProperty("inputValue")
    private String inputValue; // 输入值
    
    @JsonProperty("pointID")
    private String pointID; // 测点ID匹配
    
    @JsonProperty("deadBand")
    private Double deadBand; // 死区值
    
    @JsonProperty("diff")
    private Double diff; // 偏差值
    
    @JsonProperty("projectID")
    private String projectID;
    
    @JsonProperty("deviceID")
    private String deviceID; // 关联
    
    @JsonProperty("alertTypeID")
    private String alertTypeID; // 告警类型ID
    
    @JsonProperty("alertLevelID")
    private String alertLevelID; // 告警等级 ID
    
    // AlertInfo specific fields
    @JsonProperty("ruleName")
    private String ruleName;
    
    @JsonProperty("alertTypeName")
    private String alertTypeName;
    
    @JsonProperty("alertTypeCode")
    private String alertTypeCode;
    
    @JsonProperty("alertLevelCode")
    private String alertLevelCode;
    
    @JsonProperty("alertLevelColor")
    private String alertLevelColor;
    
    @JsonProperty("alertLevelName")
    private String alertLevelName;
    
    @JsonProperty("deviceName")
    private String deviceName;
    
    @JsonProperty("pointName")
    private String pointName;
    
    @JsonProperty("deviceTypeID")
    private String deviceTypeID;
    
    @JsonProperty("deviceGroupID")
    private String deviceGroupID;
    
    @JsonProperty("deviceAttr")
    private Map<String, Object> deviceAttr;
    
    // Constructors
    public AlertInfo() {}
    
    // Getters and Setters
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }
    
    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }
    
    public OffsetDateTime getRecoveredAt() {
        return recoveredAt;
    }
    
    public void setRecoveredAt(OffsetDateTime recoveredAt) {
        this.recoveredAt = recoveredAt;
    }
    
    public OffsetDateTime getHandledAt() {
        return handledAt;
    }
    
    public void setHandledAt(OffsetDateTime handledAt) {
        this.handledAt = handledAt;
    }
    
    public OffsetDateTime getExpiredAt() {
        return expiredAt;
    }
    
    public void setExpiredAt(OffsetDateTime expiredAt) {
        this.expiredAt = expiredAt;
    }
    
    public String getHandler() {
        return handler;
    }
    
    public void setHandler(String handler) {
        this.handler = handler;
    }
    
    public Boolean getOrderCreated() {
        return orderCreated;
    }
    
    public void setOrderCreated(Boolean orderCreated) {
        this.orderCreated = orderCreated;
    }
    
    public Boolean getEdge() {
        return edge;
    }
    
    public void setEdge(Boolean edge) {
        this.edge = edge;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getContent() {
        return content;
    }
    
    public void setContent(String content) {
        this.content = content;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
    public String getRuleTemplateID() {
        return ruleTemplateID;
    }
    
    public void setRuleTemplateID(String ruleTemplateID) {
        this.ruleTemplateID = ruleTemplateID;
    }
    
    public String getTriggerID() {
        return triggerID;
    }
    
    public void setTriggerID(String triggerID) {
        this.triggerID = triggerID;
    }
    
    public String getMode() {
        return mode;
    }
    
    public void setMode(String mode) {
        this.mode = mode;
    }
    
    public String getCompareMode() {
        return compareMode;
    }
    
    public void setCompareMode(String compareMode) {
        this.compareMode = compareMode;
    }
    
    public String getCompareValue() {
        return compareValue;
    }
    
    public void setCompareValue(String compareValue) {
        this.compareValue = compareValue;
    }
    
    public Integer getDuration() {
        return duration;
    }
    
    public void setDuration(Integer duration) {
        this.duration = duration;
    }
    
    public String getInputValue() {
        return inputValue;
    }
    
    public void setInputValue(String inputValue) {
        this.inputValue = inputValue;
    }
    
    public String getPointID() {
        return pointID;
    }
    
    public void setPointID(String pointID) {
        this.pointID = pointID;
    }
    
    public Double getDeadBand() {
        return deadBand;
    }
    
    public void setDeadBand(Double deadBand) {
        this.deadBand = deadBand;
    }
    
    public Double getDiff() {
        return diff;
    }
    
    public void setDiff(Double diff) {
        this.diff = diff;
    }
    
    public String getProjectID() {
        return projectID;
    }
    
    public void setProjectID(String projectID) {
        this.projectID = projectID;
    }
    
    public String getDeviceID() {
        return deviceID;
    }
    
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
    
    public String getAlertTypeID() {
        return alertTypeID;
    }
    
    public void setAlertTypeID(String alertTypeID) {
        this.alertTypeID = alertTypeID;
    }
    
    public String getAlertLevelID() {
        return alertLevelID;
    }
    
    public void setAlertLevelID(String alertLevelID) {
        this.alertLevelID = alertLevelID;
    }
    
    public String getRuleName() {
        return ruleName;
    }
    
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }
    
    public String getAlertTypeName() {
        return alertTypeName;
    }
    
    public void setAlertTypeName(String alertTypeName) {
        this.alertTypeName = alertTypeName;
    }
    
    public String getAlertTypeCode() {
        return alertTypeCode;
    }
    
    public void setAlertTypeCode(String alertTypeCode) {
        this.alertTypeCode = alertTypeCode;
    }
    
    public String getAlertLevelCode() {
        return alertLevelCode;
    }
    
    public void setAlertLevelCode(String alertLevelCode) {
        this.alertLevelCode = alertLevelCode;
    }
    
    public String getAlertLevelColor() {
        return alertLevelColor;
    }
    
    public void setAlertLevelColor(String alertLevelColor) {
        this.alertLevelColor = alertLevelColor;
    }
    
    public String getAlertLevelName() {
        return alertLevelName;
    }
    
    public void setAlertLevelName(String alertLevelName) {
        this.alertLevelName = alertLevelName;
    }
    
    public String getDeviceName() {
        return deviceName;
    }
    
    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }
    
    public String getPointName() {
        return pointName;
    }
    
    public void setPointName(String pointName) {
        this.pointName = pointName;
    }
    
    public String getDeviceTypeID() {
        return deviceTypeID;
    }
    
    public void setDeviceTypeID(String deviceTypeID) {
        this.deviceTypeID = deviceTypeID;
    }
    
    public String getDeviceGroupID() {
        return deviceGroupID;
    }
    
    public void setDeviceGroupID(String deviceGroupID) {
        this.deviceGroupID = deviceGroupID;
    }
    
    public Map<String, Object> getDeviceAttr() {
        return deviceAttr;
    }
    
    public void setDeviceAttr(Map<String, Object> deviceAttr) {
        this.deviceAttr = deviceAttr;
    }
    
    @Override
    public String toString() {
        return "AlertInfo{" +
                "id='" + id + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", recoveredAt=" + recoveredAt +
                ", handledAt=" + handledAt +
                ", expiredAt=" + expiredAt +
                ", handler='" + handler + '\'' +
                ", orderCreated=" + orderCreated +
                ", edge=" + edge +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", remark='" + remark + '\'' +
                ", ruleTemplateID='" + ruleTemplateID + '\'' +
                ", triggerID='" + triggerID + '\'' +
                ", mode='" + mode + '\'' +
                ", compareMode='" + compareMode + '\'' +
                ", compareValue='" + compareValue + '\'' +
                ", duration=" + duration +
                ", inputValue='" + inputValue + '\'' +
                ", pointID='" + pointID + '\'' +
                ", deadBand=" + deadBand +
                ", diff=" + diff +
                ", projectID='" + projectID + '\'' +
                ", deviceID='" + deviceID + '\'' +
                ", alertTypeID='" + alertTypeID + '\'' +
                ", alertLevelID='" + alertLevelID + '\'' +
                ", ruleName='" + ruleName + '\'' +
                ", alertTypeName='" + alertTypeName + '\'' +
                ", alertTypeCode='" + alertTypeCode + '\'' +
                ", alertLevelCode='" + alertLevelCode + '\'' +
                ", alertLevelColor='" + alertLevelColor + '\'' +
                ", alertLevelName='" + alertLevelName + '\'' +
                ", deviceName='" + deviceName + '\'' +
                ", pointName='" + pointName + '\'' +
                ", deviceTypeID='" + deviceTypeID + '\'' +
                ", deviceGroupID='" + deviceGroupID + '\'' +
                ", deviceAttr=" + deviceAttr +
                '}';
    }
} 