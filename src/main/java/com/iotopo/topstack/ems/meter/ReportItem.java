package com.iotopo.topstack.ems.meter;

import java.util.List;

public class ReportItem {
    private String meterId;
    private String meterName;
    private List<MeterValue> values;

    public String getMeterId() {
        return meterId;
    }

    public void setMeterId(String meterId) {
        this.meterId = meterId;
    }

    public String getMeterName() {
        return meterName;
    }

    public void setMeterName(String meterName) {
        this.meterName = meterName;
    }

    public List<MeterValue> getValues() {
        return values;
    }

    public void setValues(List<MeterValue> values) {
        this.values = values;
    }
} 