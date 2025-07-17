package com.iotopo.topstack.iot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;

/**
 * 单点实时数据查询响应
 * 
 * <p>包含指定设备的指定测点的最新实时数据。</p>
 * 
 * <p>响应字段：</p>
 * <ul>
 *   <li>{@code deviceID}：设备标识</li>
 *   <li>{@code pointID}：测点标识</li>
 *   <li>{@code value}：测点值，可能是字符串、数字或布尔值</li>
 *   <li>{@code quality}：数据质量，0=正常、1=离线、2=无效</li>
 *   <li>{@code timestamp}：时间戳，ISO 8601格式</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * FindLastRequest req = new FindLastRequest("device001", "temperature");
 * ResponseData<FindLastResponse> response = iotApi.findLast(req);
 * if (response.getSuccess()) {
 *     FindLastResponse data = response.getData();
 *     System.out.println("设备: " + data.getDeviceID());
 *     System.out.println("测点: " + data.getPointID());
 *     System.out.println("值: " + data.getValue());
 *     System.out.println("时间: " + data.getTimestamp());
 * }
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 * @see IotApi#findLast(FindLastRequest)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class FindLastResponse {
    private String deviceID;
    private String pointID;
    private Object value;
    private int quality;
    private OffsetDateTime timestamp;

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
     * 获取测点值
     * 
     * <p>返回值可能是字符串、数字或布尔值，具体类型取决于测点的数据类型。</p>
     * 
     * @return 测点值
     */
    public Object getValue() {
        return value;
    }

    /**
     * 设置测点值
     * 
     * @param value 测点值
     */
    public void setValue(Object value) {
        this.value = value;
    }

    /**
     * 获取数据质量
     * 
     * <p>数据质量标识：</p>
     * <ul>
     *   <li>0：正常</li>
     *   <li>1：离线</li>
     *   <li>2：无效</li>
     * </ul>
     * 
     * @return 数据质量
     */
    public int getQuality() {
        return quality;
    }

    /**
     * 设置数据质量
     * 
     * @param quality 数据质量
     */
    public void setQuality(int quality) {
        this.quality = quality;
    }

    /**
     * 获取时间戳
     * 
     * <p>数据采集时间，ISO 8601格式。</p>
     * 
     * @return 时间戳
     */
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    /**
     * 设置时间戳
     * 
     * @param timestamp 时间戳
     */
    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }
} 