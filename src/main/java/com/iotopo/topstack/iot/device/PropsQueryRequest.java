package com.iotopo.topstack.iot.device;

public class PropsQueryRequest {
    private String deviceID;

    public PropsQueryRequest(String deviceID) {
        this.deviceID = deviceID;
    }

    public String getDeviceID() {
        return deviceID;
    }

    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }
} 