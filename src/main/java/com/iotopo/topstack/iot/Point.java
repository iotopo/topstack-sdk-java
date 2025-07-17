package com.iotopo.topstack.iot;

/**
 * 测点信息
 * 
 * <p>表示一个设备测点的基本信息，包含设备标识和测点标识。</p>
 * 
 * <p>字段说明：</p>
 * <ul>
 *   <li>{@code deviceID}：设备标识</li>
 *   <li>{@code pointID}：测点标识</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * Point point = new Point("device001", "temperature");
 * 
 * // 在历史数据查询中使用
 * List<Point> points = Arrays.asList(point);
 * HistoryRequest req = new HistoryRequest();
 * req.setPoints(points);
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 * @see HistoryRequest
 */
public class Point {
    private String deviceID;
    private String pointID;

    /**
     * 默认构造函数
     */
    public Point() {}

    /**
     * 构造函数
     * 
     * @param deviceID 设备标识
     * @param pointID 测点标识
     */
    public Point(String deviceID, String pointID) {
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