package com.iotopo.topstack.iot.device;

public class PointQueryRequest {
    private String search;
    private String deviceID;
    private String type;
    private String order;
    private Integer pageNum;
    private Integer pageSize;

    public PointQueryRequest() {}

    public PointQueryRequest(String deviceID, Integer pageNum, Integer pageSize) {
        this.deviceID = deviceID;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    public String getSearch() { return search; }
    public void setSearch(String search) { this.search = search; }
    
    public String getDeviceID() { return deviceID; }
    public void setDeviceID(String deviceID) { this.deviceID = deviceID; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public String getOrder() { return order; }
    public void setOrder(String order) { this.order = order; }
    
    public Integer getPageNum() { return pageNum; }
    public void setPageNum(Integer pageNum) { this.pageNum = pageNum; }
    
    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
} 