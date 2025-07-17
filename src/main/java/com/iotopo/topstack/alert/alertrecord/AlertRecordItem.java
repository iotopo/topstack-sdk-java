package com.iotopo.topstack.alert.alertrecord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertRecordItem {
    private String id;
    private String status;
    private String createdAt;
    private String recoveredAt;
    private String handledAt;
    private String handler;
    private Boolean orderCreated;
    private String occurContent;
    private String ruleID;
    private String ruleName;
    private String ruleContent;
    private String alertTypeID;
    private String alertTypeName;
    private List<String> notifyChannels;
    private String alertLevelID;
    private Integer alertLevelValue;
    private String alertLevelColor;
    private String alertLevelLabel;
    private String triggerID;
    private String triggerType;
    private String deviceTypeID;
    private String deviceTypeName;
    private String deviceID;
    private String deviceName;
    private String mode;
    private Integer duration;
    private String inputValue;
    private String pointID;
    private String pointName;
    private String compareMode;
    private String compareValue;
    private String deviceStatus;
    private String cron;
    private String projectID;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
    public String getRecoveredAt() { return recoveredAt; }
    public void setRecoveredAt(String recoveredAt) { this.recoveredAt = recoveredAt; }
    public String getHandledAt() { return handledAt; }
    public void setHandledAt(String handledAt) { this.handledAt = handledAt; }
    public String getHandler() { return handler; }
    public void setHandler(String handler) { this.handler = handler; }
    public Boolean getOrderCreated() { return orderCreated; }
    public void setOrderCreated(Boolean orderCreated) { this.orderCreated = orderCreated; }
    public String getOccurContent() { return occurContent; }
    public void setOccurContent(String occurContent) { this.occurContent = occurContent; }
    public String getRuleID() { return ruleID; }
    public void setRuleID(String ruleID) { this.ruleID = ruleID; }
    public String getRuleName() { return ruleName; }
    public void setRuleName(String ruleName) { this.ruleName = ruleName; }
    public String getRuleContent() { return ruleContent; }
    public void setRuleContent(String ruleContent) { this.ruleContent = ruleContent; }
    public String getAlertTypeID() { return alertTypeID; }
    public void setAlertTypeID(String alertTypeID) { this.alertTypeID = alertTypeID; }
    public String getAlertTypeName() { return alertTypeName; }
    public void setAlertTypeName(String alertTypeName) { this.alertTypeName = alertTypeName; }
    public List<String> getNotifyChannels() { return notifyChannels; }
    public void setNotifyChannels(List<String> notifyChannels) { this.notifyChannels = notifyChannels; }
    public String getAlertLevelID() { return alertLevelID; }
    public void setAlertLevelID(String alertLevelID) { this.alertLevelID = alertLevelID; }
    public Integer getAlertLevelValue() { return alertLevelValue; }
    public void setAlertLevelValue(Integer alertLevelValue) { this.alertLevelValue = alertLevelValue; }
    public String getAlertLevelColor() { return alertLevelColor; }
    public void setAlertLevelColor(String alertLevelColor) { this.alertLevelColor = alertLevelColor; }
    public String getAlertLevelLabel() { return alertLevelLabel; }
    public void setAlertLevelLabel(String alertLevelLabel) { this.alertLevelLabel = alertLevelLabel; }
    public String getTriggerID() { return triggerID; }
    public void setTriggerID(String triggerID) { this.triggerID = triggerID; }
    public String getTriggerType() { return triggerType; }
    public void setTriggerType(String triggerType) { this.triggerType = triggerType; }
    public String getDeviceTypeID() { return deviceTypeID; }
    public void setDeviceTypeID(String deviceTypeID) { this.deviceTypeID = deviceTypeID; }
    public String getDeviceTypeName() { return deviceTypeName; }
    public void setDeviceTypeName(String deviceTypeName) { this.deviceTypeName = deviceTypeName; }
    public String getDeviceID() { return deviceID; }
    public void setDeviceID(String deviceID) { this.deviceID = deviceID; }
    public String getDeviceName() { return deviceName; }
    public void setDeviceName(String deviceName) { this.deviceName = deviceName; }
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public String getInputValue() { return inputValue; }
    public void setInputValue(String inputValue) { this.inputValue = inputValue; }
    public String getPointID() { return pointID; }
    public void setPointID(String pointID) { this.pointID = pointID; }
    public String getPointName() { return pointName; }
    public void setPointName(String pointName) { this.pointName = pointName; }
    public String getCompareMode() { return compareMode; }
    public void setCompareMode(String compareMode) { this.compareMode = compareMode; }
    public String getCompareValue() { return compareValue; }
    public void setCompareValue(String compareValue) { this.compareValue = compareValue; }
    public String getDeviceStatus() { return deviceStatus; }
    public void setDeviceStatus(String deviceStatus) { this.deviceStatus = deviceStatus; }
    public String getCron() { return cron; }
    public void setCron(String cron) { this.cron = cron; }
    public String getProjectID() { return projectID; }
    public void setProjectID(String projectID) { this.projectID = projectID; }
} 