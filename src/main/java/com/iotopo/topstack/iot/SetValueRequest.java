package com.iotopo.topstack.iot;

/**
 * 单点数据下发请求
 * 
 * <p>用于向指定设备的指定测点下发控制指令。</p>
 * 
 * <p>请求参数：</p>
 * <ul>
 *   <li>{@code deviceID}：设备标识，必填</li>
 *   <li>{@code pointID}：测点标识，必填</li>
 *   <li>{@code value}：要下发的值，必填</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * SetValueRequest req = new SetValueRequest("device001", "switch", "true");
 * ResponseData<Object> response = iotApi.setValue(req);
 * if (response.getSuccess()) {
 *     System.out.println("下发成功");
 * }
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 * @see IotApi#setValue(SetValueRequest)
 */
public class SetValueRequest {
    private String deviceID;
    private String pointID;
    private String value;

    /**
     * 默认构造函数
     */
    public SetValueRequest() {}

    /**
     * 构造函数
     * 
     * @param deviceID 设备标识
     * @param pointID 测点标识
     * @param value 要下发的值
     */
    public SetValueRequest(String deviceID, String pointID, String value) {
        this.deviceID = deviceID;
        this.pointID = pointID;
        this.value = value;
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

    /**
     * 获取要下发的值
     * 
     * @return 要下发的值
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置要下发的值
     * 
     * @param value 要下发的值
     */
    public void setValue(String value) {
        this.value = value;
    }
} 