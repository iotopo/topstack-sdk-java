package com.iotopo.topstack.iot;

/**
 * 单点实时数据查询请求
 * 
 * <p>用于查询指定设备的指定测点的最新实时数据。</p>
 * 
 * <p>请求参数：</p>
 * <ul>
 *   <li>{@code deviceID}：设备标识，必填</li>
 *   <li>{@code pointID}：测点标识，必填</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * FindLastRequest req = new FindLastRequest("device001", "temperature");
 * ResponseData<FindLastResponse> response = iotApi.findLast(req);
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 * @see IotApi#findLast(FindLastRequest)
 */
public class FindLastRequest {
    private String deviceID;
    private String pointID;

    /**
     * 默认构造函数
     */
    public FindLastRequest() {}

    /**
     * 构造函数
     * 
     * @param deviceID 设备标识
     * @param pointID 测点标识
     */
    public FindLastRequest(String deviceID, String pointID) {
        this.deviceID = deviceID;
        this.pointID = pointID;
    }

    /**
     * 获取设备标识
     * 
     * @return 设备标识
     */
    public String getDeviceID() {
        return deviceID;
    }

    /**
     * 设置设备标识
     * 
     * @param deviceID 设备标识
     */
    public void setDeviceID(String deviceID) {
        this.deviceID = deviceID;
    }

    /**
     * 获取测点标识
     * 
     * @return 测点标识
     */
    public String getPointID() {
        return pointID;
    }

    /**
     * 设置测点标识
     * 
     * @param pointID 测点标识
     */
    public void setPointID(String pointID) {
        this.pointID = pointID;
    }
} 