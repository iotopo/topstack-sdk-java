package com.iotopo.topstack.alert.alertrecord;

public class ActivityRequest {
    private String start;
    private String end;
    private String alertTypeID;
    private String deviceGroupID;
    private String deviceID;
    private String deviceTags;
    private String mode;

    public String getStart() { return start; }
    public void setStart(String start) { this.start = start; }
    public String getEnd() { return end; }
    public void setEnd(String end) { this.end = end; }
    public String getAlertTypeID() { return alertTypeID; }
    public void setAlertTypeID(String alertTypeID) { this.alertTypeID = alertTypeID; }
    public String getDeviceGroupID() { return deviceGroupID; }
    public void setDeviceGroupID(String deviceGroupID) { this.deviceGroupID = deviceGroupID; }
    public String getDeviceID() { return deviceID; }
    public void setDeviceID(String deviceID) { this.deviceID = deviceID; }
    public String getDeviceTags() { return deviceTags; }
    public void setDeviceTags(String deviceTags) { this.deviceTags = deviceTags; }
    public String getMode() { return mode; }
    public void setMode(String mode) { this.mode = mode; }
} 