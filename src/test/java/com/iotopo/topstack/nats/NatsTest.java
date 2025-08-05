package com.iotopo.topstack.nats;

import com.iotopo.topstack.nats.model.*;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * NATS 功能测试类
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class NatsTest {
    
    @Test
    public void testNatsConfig() {
        NatsConfig config = new NatsConfig("nats://localhost:4222", "token", "user", "pass");
        
        assertEquals("nats://localhost:4222", config.getAddr());
        assertEquals("token", config.getToken());
        assertEquals("user", config.getUsername());
        assertEquals("pass", config.getPassword());
    }
    
    @Test
    public void testNatsTopics() {
        String pointTopic = NatsTopics.realtimePointTopic("project001", "device001", "temperature");
        assertEquals("iot.platform.device.datas.project001.*.device001.temperature", pointTopic);
        
        String deviceStateTopic = NatsTopics.deviceStateTopic("project001", "device001");
        assertEquals("iot.platform.device.state.project001.device001", deviceStateTopic);
        
        String gatewayStateTopic = NatsTopics.gatewayStateTopic("project001", "gateway001");
        assertEquals("iot.platform.gateway.state.project001.gateway001", gatewayStateTopic);
        
        String alertTopic = NatsTopics.alertTopic("project001");
        assertEquals("iot.platform.alert.project001.>", alertTopic);
        
        String deviceAlertTopic = NatsTopics.deviceAlertTopic("project001", "device001");
        assertEquals("iot.platform.alert.project001.device001", deviceAlertTopic);
    }
    
    @Test
    public void testPointDataModel() {
        PointData data = new PointData();
        data.setDeviceID("device001");
        data.setPointID("temperature");
        data.setValue(25.5);
        data.setQuality(0);
        data.setProjectID("project001");
        data.setDeviceTypeID("deviceType001");
        data.setGatewayID("gateway001");
        
        assertEquals("device001", data.getDeviceID());
        assertEquals("temperature", data.getPointID());
        assertEquals(25.5, data.getValue());
        assertEquals(Integer.valueOf(0), data.getQuality());
        assertEquals("project001", data.getProjectID());
        assertEquals("deviceType001", data.getDeviceTypeID());
        assertEquals("gateway001", data.getGatewayID());
    }
    
    @Test
    public void testDeviceStateModel() {
        DeviceState state = new DeviceState();
        state.setProjectID("project001");
        state.setDeviceID("device001");
        state.setState(1);
        
        assertEquals("project001", state.getProjectID());
        assertEquals("device001", state.getDeviceID());
        assertEquals(Integer.valueOf(1), state.getState());
    }
    
    @Test
    public void testGatewayStateModel() {
        GatewayState state = new GatewayState();
        state.setGatewayID("gateway001");
        state.setName("测试网关");
        state.setState(1);
        
        assertEquals("gateway001", state.getGatewayID());
        assertEquals("测试网关", state.getName());
        assertEquals(Integer.valueOf(1), state.getState());
    }
    
    @Test
    public void testChannelStateModel() {
        ChannelState state = new ChannelState();
        state.setChannelID("channel001");
        state.setChannelName("测试通道");
        state.setRunning(true);
        state.setConnected(true);
        
        assertEquals("channel001", state.getChannelID());
        assertEquals("测试通道", state.getChannelName());
        assertTrue(state.getRunning());
        assertTrue(state.getConnected());
    }
    
    @Test
    public void testAlertInfoModel() {
        AlertInfo alert = new AlertInfo();
        alert.setId("alert001");
        alert.setTitle("测试告警");
        alert.setContent("这是一个测试告警");
        alert.setStatus("unhandled");
        alert.setProjectID("project001");
        alert.setDeviceID("device001");
        
        assertEquals("alert001", alert.getId());
        assertEquals("测试告警", alert.getTitle());
        assertEquals("这是一个测试告警", alert.getContent());
        assertEquals("unhandled", alert.getStatus());
        assertEquals("project001", alert.getProjectID());
        assertEquals("device001", alert.getDeviceID());
    }
}