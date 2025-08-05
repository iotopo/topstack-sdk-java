 package com.iotopo.topstack.nats;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.iotopo.topstack.nats.model.*;
import io.nats.client.*;
import io.nats.client.support.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.StandardCharsets;

/**
 * NATS 数据总线
 * 
 * <p>提供与 NATS 消息总线的连接和订阅功能，支持实时数据接收。</p>
 * <p>参考 Go 版本实现，提供相同的功能接口。</p>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class NatsBus implements AutoCloseable {
    
    private static final Logger logger = LoggerFactory.getLogger(NatsBus.class);
    private final Connection connection;
    private final ObjectMapper objectMapper;
    private final Dispatcher dispatcher;

    /**
     * 构造函数
     * 
     * @param config NATS 配置
     * @throws Exception 连接失败时抛出异常
     */
    public NatsBus(NatsConfig config) throws Exception {
        this.objectMapper = new ObjectMapper();
        // 注册 JavaTimeModule 以支持 Java 8 日期时间类型
        this.objectMapper.registerModule(new JavaTimeModule());

        // 禁用将日期写为时间戳，这样会使用 ISO-8601 格式
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

        // 允许空对象序列化，避免 FAIL_ON_EMPTY_BEANS 错误
        this.objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        Options.Builder optionsBuilder = new Options.Builder()
                .maxReconnects(-1);

        optionsBuilder.connectionListener(new ConnectionListener() {
            @Override
            public void connectionEvent(Connection connection, Events events) {
                logger.info("NATS connection event: {}", events);
            }
        });
        optionsBuilder.errorListener(new ErrorListener() {
            @Override
            public void errorOccurred(Connection conn, String error) {
                logger.error("NATS connection error: {}", error);
            }

            @Override
            public void exceptionOccurred(Connection conn, Exception exp) {
                logger.error("NATS connection exception: {}", exp.getMessage());
            }

            @Override
            public void slowConsumerDetected(Connection conn, Consumer consumer) {
                logger.warn("NATS slow consumer detected");
            }
        });
        
        // 添加认证信息
        if (config.getToken() != null && !config.getToken().isEmpty()) {
            optionsBuilder.token(config.getToken());
        }
        
        if (config.getUsername() != null && !config.getUsername().isEmpty() && 
            config.getPassword() != null && !config.getPassword().isEmpty()) {
            optionsBuilder.userInfo(config.getUsername(), config.getPassword());
        }

        // 添加自定义选项

        this.connection = Nats.connect(optionsBuilder.server(config.getAddr()).build());
        this.dispatcher = this.connection.createDispatcher();
        logger.info("NATS connection established to {}", config.getAddr());
    }

    /**
     * 订阅设备测点数据
     * 
     * @param projectID 项目ID
     * @param deviceID 设备ID
     * @param pointID 测点ID
     * @param callback 数据回调函数
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    public Subscriber subscribePointData(String projectID, String deviceID, String pointID, 
                                       DataCallback<PointData> callback) throws Exception {
        String topic = NatsTopics.realtimePointTopic(projectID, deviceID, pointID);
        return subscribe(topic, PointData.class, callback);
    }

    /**
     * 订阅同设备模型下的测点数据
     * 
     * @param projectID 项目ID
     * @param deviceTypeID 设备类型ID
     * @param pointID 测点ID
     * @param callback 数据回调函数
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    public Subscriber subscribeDeviceTypeData(String projectID, String deviceTypeID, String pointID, 
                                            DataCallback<PointData> callback) throws Exception {
        String topic = NatsTopics.realtimePointTopicV2(projectID, deviceTypeID, "*", pointID);
        return subscribe(topic, PointData.class, callback);
    }

    /**
     * 订阅设备状态数据
     * 
     * @param projectID 项目ID
     * @param deviceID 设备ID
     * @param callback 数据回调函数
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    public Subscriber subscribeDeviceState(String projectID, String deviceID, 
                                        DataCallback<DeviceState> callback) throws Exception {
        String topic = NatsTopics.deviceStateTopic(projectID, deviceID);
        return subscribe(topic, DeviceState.class, callback);
    }

    /**
     * 订阅网关状态数据
     * 
     * @param projectID 项目ID
     * @param callback 数据回调函数
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    public Subscriber subscribeGatewayState(String projectID, 
                                          DataCallback<GatewayState> callback) throws Exception {
        String topic = NatsTopics.gatewayStateTopic(projectID, "*");
        return subscribe(topic, GatewayState.class, callback);
    }

    /**
     * 订阅数据通道状态数据
     * 
     * @param projectID 项目ID
     * @param callback 数据回调函数
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    public Subscriber subscribeChannelState(String projectID, 
                                          DataCallback<ChannelState> callback) throws Exception {
        String topic = NatsTopics.channelStateTopic(projectID, "*");
        return subscribe(topic, ChannelState.class, callback);
    }

    /**
     * 订阅全部告警消息
     * 
     * @param projectID 项目ID
     * @param callback 数据回调函数
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    public Subscriber subscribeAlertInfo(String projectID, 
                                       DataCallback<AlertInfo> callback) throws Exception {
        String topic = NatsTopics.alertTopic(projectID);
        return subscribe(topic, AlertInfo.class, callback);
    }

    /**
     * 订阅设备告警信息
     * 
     * @param projectID 项目ID
     * @param deviceID 设备ID
     * @param callback 数据回调函数
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    public Subscriber subscribeDeviceAlertInfo(String projectID, String deviceID, 
                                             DataCallback<AlertInfo> callback) throws Exception {
        String topic = NatsTopics.deviceAlertTopic(projectID, deviceID);
        return subscribe(topic, AlertInfo.class, callback);
    }

    /**
     * 通用订阅方法
     * 
     * @param topic 主题
     * @param dataClass 数据类型
     * @param callback 回调函数
     * @param <T> 数据类型
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    private <T> Subscriber subscribe(String topic, Class<T> dataClass, DataCallback<T> callback) throws Exception {
        Subscription subscription = dispatcher.subscribe(topic, msg -> {
            try {
                String data = new String(msg.getData(), StandardCharsets.UTF_8);
                T obj = objectMapper.readValue(data, dataClass);
                callback.onData(obj);
            } catch (Exception e) {
                logger.error("Failed to unmarshal data for topic: {}", msg.getSubject(), e);
            }
        });
        return new NatsSubscriber(subscription, dispatcher);
    }

    /**
     * 带主题的通用订阅方法
     * 
     * @param topic 主题
     * @param dataClass 数据类型
     * @param callback 回调函数
     * @param <T> 数据类型
     * @return 订阅者对象
     * @throws Exception 订阅失败时抛出异常
     */
    private <T> Subscriber subscribeWithTopic(String topic, Class<T> dataClass, TopicDataCallback<T> callback) throws Exception {
        Subscription subscription = dispatcher.subscribe(topic, msg -> {
            try {
                String data = new String(msg.getData(), StandardCharsets.UTF_8);
                T obj = objectMapper.readValue(data, dataClass);
                callback.onData(msg.getSubject(), obj);
            } catch (Exception e) {
                logger.error("Failed to unmarshal data for topic: {}", topic, e);
            }
        });

        return new NatsSubscriber(subscription, dispatcher);
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
            logger.info("NATS connection closed");
        }
    }

    /**
     * 数据回调接口
     * 
     * @param <T> 数据类型
     */
    @FunctionalInterface
    public interface DataCallback<T> {
        void onData(T data);
    }

    /**
     * 带主题的数据回调接口
     * 
     * @param <T> 数据类型
     */
    @FunctionalInterface
    public interface TopicDataCallback<T> {
        void onData(String topic, T data);
    }

    /**
     * NATS 订阅者实现
     */
    private static class NatsSubscriber implements Subscriber {
        private final Subscription subscription;
        private final Dispatcher dispatcher;

        public NatsSubscriber(Subscription subscription, Dispatcher dispatcher) {
            this.subscription = subscription;
            this.dispatcher = dispatcher;
        }

        @Override
        public void unsubscribe() throws Exception {
            if (subscription != null && dispatcher != null) {
                dispatcher.unsubscribe(subscription);
            }
        }
    }
}