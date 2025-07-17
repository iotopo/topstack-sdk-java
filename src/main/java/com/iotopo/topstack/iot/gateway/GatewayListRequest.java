package com.iotopo.topstack.iot.gateway;

public class GatewayListRequest {
    private Integer page;
    private Integer pageSize;
    private String search;
    private String userGroupID;
    private String isManaged;
    private String isVirtual;

    public GatewayListRequest() {}

    public GatewayListRequest(String search, Integer page, Integer pageSize) {
        this.search = search;
        this.page = page;
        this.pageSize = pageSize;
    }

    public Integer getPage() { return page; }
    public void setPage(Integer page) { this.page = page; }
    
    public Integer getPageSize() { return pageSize; }
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
    
    public String getSearch() { return search; }
    public void setSearch(String search) { this.search = search; }
    
    public String getUserGroupID() { return userGroupID; }
    public void setUserGroupID(String userGroupID) { this.userGroupID = userGroupID; }
    
    public String getIsManaged() { return isManaged; }
    public void setIsManaged(String isManaged) { this.isManaged = isManaged; }
    
    public String getIsVirtual() { return isVirtual; }
    public void setIsVirtual(String isVirtual) { this.isVirtual = isVirtual; }
} 