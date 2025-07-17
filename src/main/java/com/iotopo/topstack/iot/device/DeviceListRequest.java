package com.iotopo.topstack.iot.device;

/**
 * 设备列表查询请求
 * 
 * <p>用于分页查询设备列表，支持多种筛选条件。</p>
 * 
 * <p>查询参数：</p>
 * <ul>
 *   <li>{@code search}：按名称或标识进行搜索，可选</li>
 *   <li>{@code gatewayID}：网关标识，可选</li>
 *   <li>{@code typeID}：设备类型标识，可选</li>
 *   <li>{@code connectMode}：连接模式，可选</li>
 *   <li>{@code dataChannelID}：数据通道标识，可选</li>
 *   <li>{@code customChannelID}：自定义通道标识，可选</li>
 *   <li>{@code state}：设备状态，可选（0=离线，1=在线）</li>
 *   <li>{@code userGroupID}：用户组标识，可选</li>
 *   <li>{@code empty}：是否只查询未分组设备，可选</li>
 *   <li>{@code groupID}：设备分组标识，可选</li>
 *   <li>{@code pageNum}：当前页序列，第一页为 1，可选</li>
 *   <li>{@code pageSize}：每页显示的数量，默认为 10，可选</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * DeviceListRequest req = new DeviceListRequest();
 * req.setPageNum(1);
 * req.setPageSize(10);
 * req.setSearch("温度传感器");
 * req.setState("1"); // 只查询在线设备
 * 
 * ResponseData<DeviceListResponse> response = deviceApi.query(req);
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 * @see DeviceApi#query(DeviceListRequest)
 */
public class DeviceListRequest {
    private String search;
    private String gatewayID;
    private String typeID;
    private String connectMode;
    private String dataChannelID;
    private String customChannelID;
    private String state;
    private String userGroupID;
    private Boolean empty;
    private String groupID;
    private Integer pageNum;
    private Integer pageSize;

    /**
     * 默认构造函数
     */
    public DeviceListRequest() {}

    /**
     * 构造函数
     * 
     * @param search 搜索关键词
     * @param pageNum 页码
     * @param pageSize 每页大小
     */
    public DeviceListRequest(String search, Integer pageNum, Integer pageSize) {
        this.search = search;
        this.pageNum = pageNum;
        this.pageSize = pageSize;
    }

    /**
     * 获取搜索关键词
     * 
     * @return 搜索关键词
     */
    public String getSearch() { return search; }
    
    /**
     * 设置搜索关键词
     * 
     * @param search 搜索关键词
     */
    public void setSearch(String search) { this.search = search; }
    
    /**
     * 获取网关标识
     * 
     * @return 网关标识
     */
    public String getGatewayID() { return gatewayID; }
    
    /**
     * 设置网关标识
     * 
     * @param gatewayID 网关标识
     */
    public void setGatewayID(String gatewayID) { this.gatewayID = gatewayID; }
    
    /**
     * 获取设备类型标识
     * 
     * @return 设备类型标识
     */
    public String getTypeID() { return typeID; }
    
    /**
     * 设置设备类型标识
     * 
     * @param typeID 设备类型标识
     */
    public void setTypeID(String typeID) { this.typeID = typeID; }
    
    /**
     * 获取连接模式
     * 
     * @return 连接模式
     */
    public String getConnectMode() { return connectMode; }
    
    /**
     * 设置连接模式
     * 
     * @param connectMode 连接模式
     */
    public void setConnectMode(String connectMode) { this.connectMode = connectMode; }
    
    /**
     * 获取数据通道标识
     * 
     * @return 数据通道标识
     */
    public String getDataChannelID() { return dataChannelID; }
    
    /**
     * 设置数据通道标识
     * 
     * @param dataChannelID 数据通道标识
     */
    public void setDataChannelID(String dataChannelID) { this.dataChannelID = dataChannelID; }
    
    /**
     * 获取自定义通道标识
     * 
     * @return 自定义通道标识
     */
    public String getCustomChannelID() { return customChannelID; }
    
    /**
     * 设置自定义通道标识
     * 
     * @param customChannelID 自定义通道标识
     */
    public void setCustomChannelID(String customChannelID) { this.customChannelID = customChannelID; }
    
    /**
     * 获取设备状态
     * 
     * <p>设备状态：0=离线，1=在线</p>
     * 
     * @return 设备状态
     */
    public String getState() { return state; }
    
    /**
     * 设置设备状态
     * 
     * @param state 设备状态（0=离线，1=在线）
     */
    public void setState(String state) { this.state = state; }
    
    /**
     * 获取用户组标识
     * 
     * @return 用户组标识
     */
    public String getUserGroupID() { return userGroupID; }
    
    /**
     * 设置用户组标识
     * 
     * @param userGroupID 用户组标识
     */
    public void setUserGroupID(String userGroupID) { this.userGroupID = userGroupID; }
    
    /**
     * 获取是否只查询未分组设备
     * 
     * @return 是否只查询未分组设备
     */
    public Boolean getEmpty() { return empty; }
    
    /**
     * 设置是否只查询未分组设备
     * 
     * @param empty 是否只查询未分组设备
     */
    public void setEmpty(Boolean empty) { this.empty = empty; }
    
    /**
     * 获取设备分组标识
     * 
     * @return 设备分组标识
     */
    public String getGroupID() { return groupID; }
    
    /**
     * 设置设备分组标识
     * 
     * @param groupID 设备分组标识
     */
    public void setGroupID(String groupID) { this.groupID = groupID; }
    
    /**
     * 获取页码
     * 
     * <p>当前页序列，第一页为 1</p>
     * 
     * @return 页码
     */
    public Integer getPageNum() { return pageNum; }
    
    /**
     * 设置页码
     * 
     * @param pageNum 页码，第一页为 1
     */
    public void setPageNum(Integer pageNum) { this.pageNum = pageNum; }
    
    /**
     * 获取每页大小
     * 
     * <p>每页显示的数量，默认为 10</p>
     * 
     * @return 每页大小
     */
    public Integer getPageSize() { return pageSize; }
    
    /**
     * 设置每页大小
     * 
     * @param pageSize 每页显示的数量
     */
    public void setPageSize(Integer pageSize) { this.pageSize = pageSize; }
} 