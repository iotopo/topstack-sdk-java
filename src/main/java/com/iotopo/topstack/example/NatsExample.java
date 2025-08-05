package com.iotopo.topstack.example;

import com.iotopo.topstack.nats.NatsBus;
import com.iotopo.topstack.nats.NatsConfig;
import com.iotopo.topstack.nats.Subscriber;
import com.iotopo.topstack.nats.model.*;

/**
 * NATS 示例
 * 
 * <p>演示如何使用 NATS 总线订阅各种数据。</p>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class NatsExample {
    
    public static void main(String[] args) {
        try {
            // 配置 NATS 连接
            NatsConfig natsConfig = new NatsConfig();
            natsConfig.setAddr("nats://localhost:4222");
            NatsBus natsBus = new NatsBus(natsConfig);
            
            System.out.println("开始订阅 NATS 数据...");
            
            // 订阅设备测点数据
            Subscriber pointDataSubscriber = natsBus.subscribePointData(
//                "project001", "device001", "temperature",
                    "*", "*", "*",
                data -> {
                    System.out.println("收到测点数据: " + data);
                    System.out.println("设备ID: " + data.getDeviceID());
                    System.out.println("测点ID: " + data.getPointID());
                    System.out.println("数值: " + data.getValue());
                    System.out.println("时间戳: " + data.getTimestamp());
                    System.out.println("---");
                }
            );
            
            // 订阅设备状态数据
            Subscriber deviceStateSubscriber = natsBus.subscribeDeviceState(
                "project001", "device001",
                state -> {
                    System.out.println("收到设备状态: " + state);
                    System.out.println("设备ID: " + state.getDeviceID());
                    System.out.println("状态: " + (state.getState() == 1 ? "在线" : "离线"));
                    System.out.println("时间戳: " + state.getTimestamp());
                    System.out.println("---");
                }
            );
            
            // 订阅网关状态数据
            Subscriber gatewayStateSubscriber = natsBus.subscribeGatewayState(
                "project001",
                (state) -> {
                    System.out.println("收到网关状态: " + state);
                    System.out.println("网关ID: " + state.getGatewayID());
                    System.out.println("网关名称: " + state.getName());
                    System.out.println("状态: " + (state.getState() == 1 ? "在线" : "离线"));
                    System.out.println("---");
                }
            );
            
            // 订阅告警信息
            Subscriber alertSubscriber = natsBus.subscribeAlertInfo(
                "project001",
                (alert) -> {
                    System.out.println("收到告警信息: " + alert);
                    System.out.println("告警ID: " + alert.getId());
                    System.out.println("告警标题: " + alert.getTitle());
                    System.out.println("告警内容: " + alert.getContent());
                    System.out.println("告警状态: " + alert.getStatus());
                    System.out.println("---");
                }
            );
            
            // 订阅设备告警信息
            Subscriber deviceAlertSubscriber = natsBus.subscribeDeviceAlertInfo(
                "project001", "device001",
                (alert) -> {
                    System.out.println("收到设备告警: " + alert);
                    System.out.println("设备ID: " + alert.getDeviceID());
                    System.out.println("告警标题: " + alert.getTitle());
                    System.out.println("---");
                }
            );
            
            // 订阅数据通道状态
            Subscriber channelStateSubscriber = natsBus.subscribeChannelState(
                "project001",
                (state) -> {
                    System.out.println("收到通道状态: " + state);
                    System.out.println("通道ID: " + state.getChannelID());
                    System.out.println("通道名称: " + state.getChannelName());
                    System.out.println("运行状态: " + (state.getRunning() ? "运行中" : "已停止"));
                    System.out.println("连接状态: " + (state.getConnected() ? "已连接" : "未连接"));
                    System.out.println("---");
                }
            );
            
            // 订阅同设备模型下的测点数据
            Subscriber deviceTypeDataSubscriber = natsBus.subscribeDeviceTypeData(
                "project001", "deviceType001", "temperature",
                data -> {
                    System.out.println("收到设备类型测点数据: " + data);
                    System.out.println("设备类型ID: " + data.getDeviceTypeID());
                    System.out.println("设备ID: " + data.getDeviceID());
                    System.out.println("测点ID: " + data.getPointID());
                    System.out.println("数值: " + data.getValue());
                    System.out.println("---");
                }
            );
            
            System.out.println("所有订阅已启动，等待数据...");
            System.out.println("按 Ctrl+C 退出");
            
            // 保持程序运行
            Thread.sleep(Long.MAX_VALUE);
            
        } catch (Exception e) {
            System.err.println("NATS 示例运行出错: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 