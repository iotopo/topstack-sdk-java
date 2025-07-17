package com.iotopo.topstack.ems.subentry;

import com.iotopo.topstack.client.RequestData;

public class SubentryListRequest extends RequestData {
    private Integer page;
    private Integer size;
    private String name;
    private String sectorId;

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
} 