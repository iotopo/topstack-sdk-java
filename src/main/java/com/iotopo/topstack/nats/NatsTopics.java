package com.iotopo.topstack.nats;

/**
 * NATS 主题工具类
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class NatsTopics {
    
    /**
     * 生成实时测点数据主题 V2
     * 
     * @param projectID 项目ID
     * @param deviceTypeID 设备类型ID
     * @param deviceID 设备ID
     * @param pointID 测点ID
     * @return 主题字符串
     */
    public static String realtimePointTopicV2(String projectID, String deviceTypeID, String deviceID, String pointID) {
        return String.format("iot.platform.device.datas.%s.%s.%s.%s", projectID, deviceTypeID, deviceID, pointID);
    }
    
    /**
     * 生成实时测点数据主题
     * 
     * @param projectID 项目ID
     * @param deviceID 设备ID
     * @param pointID 测点ID
     * @return 主题字符串
     */
    public static String realtimePointTopic(String projectID, String deviceID, String pointID) {
        return realtimePointTopicV2(projectID, "*", deviceID, pointID);
    }
    
    /**
     * 生成数据通道状态主题
     * 
     * @param projectID 项目ID
     * @param channelID 通道ID
     * @return 主题字符串
     */
    public static String channelStateTopic(String projectID, String channelID) {
        return String.format("iot.platform.channel.state.%s.%s", projectID, channelID);
    }
    
    /**
     * 生成网关状态主题
     * 
     * @param projectID 项目ID
     * @param gatewayID 网关ID
     * @return 主题字符串
     */
    public static String gatewayStateTopic(String projectID, String gatewayID) {
        return String.format("iot.platform.gateway.state.%s.%s", projectID, gatewayID);
    }
    
    /**
     * 生成设备状态主题
     * 
     * @param projectID 项目ID
     * @param deviceID 设备ID
     * @return 主题字符串
     */
    public static String deviceStateTopic(String projectID, String deviceID) {
        return String.format("iot.platform.device.state.%s.%s", projectID, deviceID);
    }
    
    /**
     * 生成告警主题
     * 
     * @param projectID 项目ID
     * @return 主题字符串
     */
    public static String alertTopic(String projectID) {
        return String.format("iot.platform.alert.%s.>", projectID);
    }
    
    /**
     * 生成设备告警主题
     * 
     * @param projectID 项目ID
     * @param deviceID 设备ID
     * @return 主题字符串
     */
    public static String deviceAlertTopic(String projectID, String deviceID) {
        if (deviceID == null || deviceID.isEmpty()) {
            deviceID = "not_device";
        }
        return String.format("iot.platform.alert.%s.%s", projectID, deviceID);
    }
} 