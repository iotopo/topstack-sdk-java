package com.iotopo.topstack.alert.alertrecord;

import com.iotopo.topstack.client.RequestData;

public class AlertRecordListRequest extends RequestData {
    private String alertTypeId;
    private String alertLevelId;
    private String deviceId;
    private String startTime;
    private String endTime;
    private Integer status;
    private Integer page;
    private Integer size;

    public String getAlertTypeId() {
        return alertTypeId;
    }

    public void setAlertTypeId(String alertTypeId) {
        this.alertTypeId = alertTypeId;
    }

    public String getAlertLevelId() {
        return alertLevelId;
    }

    public void setAlertLevelId(String alertLevelId) {
        this.alertLevelId = alertLevelId;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }
} 