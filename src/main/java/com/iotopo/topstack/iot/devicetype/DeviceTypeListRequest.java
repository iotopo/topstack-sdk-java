package com.iotopo.topstack.iot.devicetype;

public class DeviceTypeListRequest {
    private String search;
    private String groupName;
    private Integer pageNum;
    private Integer pageSize;

    public DeviceTypeListRequest() {}

    public DeviceTypeListRequest(String search, Integer pageNum, Integer pageSize) {
        this.search = search;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getSearch() { return search; }
    public void setSearch(String search) { this.search = search; }
    
    public String getGroupName() { return groupName; }
    public void setGroupName(String groupName) { this.groupName = groupName; }
    
    public Integer getPageNum() { return pageNum; }
    public void setPageNum(Integer pageNum) { this.pageNum = pageNum; }
    
    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
} 