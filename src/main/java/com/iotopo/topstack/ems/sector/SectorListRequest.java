package com.iotopo.topstack.ems.sector;

import com.iotopo.topstack.client.RequestData;

public class SectorListRequest extends RequestData {
    private Integer page;
    private Integer size;
    private String name;

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
} 