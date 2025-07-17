package com.iotopo.topstack.ems.meter;

import java.time.OffsetDateTime;
import java.util.List;

public class ReportRequest {
    private String meterID;
    private OffsetDateTime start;
    private OffsetDateTime end;
    private String aggregation;
    private String interval;
    private List<String> pointIDs;

    public String getMeterID() {
        return meterID;
    }

    public void setMeterID(String meterID) {
        this.meterID = meterID;
    }

    public OffsetDateTime getStart() {
        return start;
    }

    public void setStart(OffsetDateTime start) {
        this.start = start;
    }

    public OffsetDateTime getEnd() {
        return end;
    }

    public void setEnd(OffsetDateTime end) {
        this.end = end;
    }

    public String getAggregation() {
        return aggregation;
    }

    public void setAggregation(String aggregation) {
        this.aggregation = aggregation;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public List<String> getPointIDs() {
        return pointIDs;
    }

    public void setPointIDs(List<String> pointIDs) {
        this.pointIDs = pointIDs;
    }
} 