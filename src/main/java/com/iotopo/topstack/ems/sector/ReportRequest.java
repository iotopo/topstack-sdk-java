package com.iotopo.topstack.ems.sector;

import java.time.OffsetDateTime;
import java.util.List;

public class ReportRequest {
    private String sectorID;
    private OffsetDateTime start;
    private OffsetDateTime end;
    private String aggregation;
    private String interval;
    private List<String> pointIDs;

    public String getSectorID() {
        return sectorID;
    }

    public void setSectorID(String sectorID) {
        this.sectorID = sectorID;
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