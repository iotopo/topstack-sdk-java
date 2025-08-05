/**
 * NATS 数据总线模块
 * 
 * <p>提供与 NATS 消息总线的连接和订阅功能，支持实时数据接收。</p>
 * <p>这是一个独立的模块，不依赖 TopStack SDK API，可以直接使用。</p>
 * 
 * <p>主要功能：</p>
 * <ul>
 *   <li>设备测点数据订阅</li>
 *   <li>设备状态数据订阅</li>
 *   <li>网关状态数据订阅</li>
 *   <li>数据通道状态订阅</li>
 *   <li>告警信息订阅</li>
 * </ul>
 * 
 * <p>推荐使用方式（独立使用）：</p>
 * <pre>{@code
 * // 创建 NATS 配置
 * NatsConfig config = new NatsConfig("nats://localhost:4222");
 * 
 * // 直接使用 NatsBus
 * NatsBus natsBus = new NatsBus(config);
 * 
 * // 订阅设备测点数据
 * Subscriber subscriber = natsBus.subscribePointData(
 *     "project001", "device001", "temperature",
 *     data -> System.out.println("收到数据: " + data.getValue())
 * );
 * 
 * // 取消订阅
 * subscriber.unsubscribe();
 * 
 * // 关闭连接
 * natsBus.close();
 * }</pre>
 * 

 * 
 * <p>主要类：</p>
 * <ul>
 *   <li>{@link NatsBus}：NATS 总线实现（推荐直接使用）</li>
 *   <li>{@link NatsConfig}：NATS 配置类</li>
 *   <li>{@link NatsTopics}：主题工具类</li>
 *   <li>{@link Subscriber}：订阅者接口</li>
 * </ul>
 * 
 * <p>数据模型：</p>
 * <ul>
 *   <li>{@link com.iotopo.topstack.nats.model.PointData}：设备测点数据</li>
 *   <li>{@link com.iotopo.topstack.nats.model.DeviceState}：设备状态数据</li>
 *   <li>{@link com.iotopo.topstack.nats.model.GatewayState}：网关状态数据</li>
 *   <li>{@link com.iotopo.topstack.nats.model.ChannelState}：数据通道状态</li>
 *   <li>{@link com.iotopo.topstack.nats.model.AlertInfo}：告警信息</li>
 * </ul>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
package com.iotopo.topstack.nats;