package com.iotopo.topstack.ems.meter;

import com.iotopo.topstack.client.RequestData;

public class MeterListRequest extends RequestData {
    private Integer page;
    private Integer size;
    private String name;
    private String sectorId;
    private String subentryId;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getSubentryId() {
        return subentryId;
    }

    public void setSubentryId(String subentryId) {
        this.subentryId = subentryId;
    }
} 