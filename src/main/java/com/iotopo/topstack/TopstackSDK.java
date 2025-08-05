package com.iotopo.topstack;

import com.iotopo.topstack.alert.AlertApi;
import com.iotopo.topstack.asset.AssetApi;
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.ems.EmsApi;
import com.iotopo.topstack.iot.IotApi;

/**
 * TopStack SDK 主入口类
 * 
 * <p>TopStack SDK 的主要入口类，提供对所有功能模块的统一访问接口。</p>
 * 
 * <p>主要功能模块：</p>
 * <ul>
 *   <li>{@link IotApi}：IoT 数据接口，提供设备数据查询和控制功能</li>
 *   <li>{@link AlertApi}：告警管理，提供告警等级、类型、记录管理功能</li>
 *   <li>{@link EmsApi}：能源管理，提供仪表、用能单元、分项能耗管理功能</li>
 *   <li>{@link AssetApi}：资产管理，提供工单管理功能</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * // 创建 SDK 实例
 * TopstackSDK sdk = new TopstackSDK("http://localhost:8000", "api-key", "project-id");
 * 
 * try {
 *     // 使用 IoT 模块
 *     FindLastRequest req = new FindLastRequest("device001", "temperature");
 *     ResponseData<FindLastResponse> response = sdk.getIotApi().findLast(req);
 *     
 *     // 使用告警模块
 *     AlertLevelListRequest alertReq = new AlertLevelListRequest();
 *     AlertLevelListResponse alertResponse = AlertLevelApi.query(sdk.getClient(), alertReq);
 *     
 *     // 使用能源管理模块
 *     MeterListRequest meterReq = new MeterListRequest();
 *     ResponseData<MeterListResponse> meterResponse = MeterApi.query(sdk.getClient(), meterReq);
 *     
 *     // 使用资产管理模块
 *     WorkOrderListRequest workOrderReq = new WorkOrderListRequest();
 *     WorkOrderListResponse workOrderResponse = WorkOrderApi.queryAlert(sdk.getClient(), workOrderReq);
 *     
 *     // 使用 NATS 数据总线（独立使用）
 *     // NatsConfig natsConfig = new NatsConfig("nats://localhost:4222");
 *     // NatsBus natsBus = new NatsBus(natsConfig);
 *     // Subscriber subscriber = natsBus.subscribePointData("project001", "device001", "temperature", 
 *     //     data -> System.out.println("Received point data: " + data));
 * } finally {
 *     // 关闭客户端，释放资源
 *     sdk.getClient().close();
 * }
 * }</pre>
 * 
 * <p>注意事项：</p>
 * <ul>
 *   <li>使用完毕后应该调用 {@link TopstackClient#close()} 方法释放资源</li>
 *   <li>所有 API 调用都可能抛出 {@link com.iotopo.topstack.client.TopstackException}</li>
 *   <li>建议在 try-with-resources 语句中使用，或在 finally 块中关闭客户端</li>
 * </ul>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 * @see IotApi
 * @see AlertApi
 * @see EmsApi
 * @see AssetApi
 * @see TopstackClient
 */
public class TopstackSDK {
    private final TopstackClient client;
    private final IotApi iotApi;
    private final AlertApi alertApi;
    private final EmsApi emsApi;
    private final AssetApi assetApi;

    /**
     * 构造函数
     * 
     * <p>创建一个新的 TopStack SDK 实例，初始化所有功能模块。</p>
     * 
     * @param baseUrl TopStack 平台的基础 URL，例如 "http://localhost:8000"
     * @param apiKey API 认证密钥
     * @param projectId 项目标识
     * 
     * @throws IllegalArgumentException 如果 baseUrl、apiKey 或 projectId 为 null 或空
     */
    public TopstackSDK(String baseUrl, String apiKey, String projectId) {
        this.client = new TopstackClient(baseUrl, apiKey, projectId);
        this.iotApi = new IotApi(client);
        this.alertApi = new AlertApi();
        this.emsApi = new EmsApi();
        this.assetApi = new AssetApi();
    }

    /**
     * 获取 IoT API 实例
     * 
     * <p>返回 IoT 数据接口的 API 实例，用于设备数据查询和控制。</p>
     * 
     * @return IoT API 实例
     * @see IotApi
     */
    public IotApi getIotApi() {
        return iotApi;
    }

    /**
     * 获取告警 API 实例
     * 
     * <p>返回告警管理的 API 实例，用于告警等级、类型、记录管理。</p>
     * 
     * @return 告警 API 实例
     * @see AlertApi
     */
    public AlertApi getAlertApi() {
        return alertApi;
    }

    /**
     * 获取能源管理 API 实例
     * 
     * <p>返回能源管理的 API 实例，用于仪表、用能单元、分项能耗管理。</p>
     * 
     * @return 能源管理 API 实例
     * @see EmsApi
     */
    public EmsApi getEmsApi() {
        return emsApi;
    }

    /**
     * 获取资产管理 API 实例
     * 
     * <p>返回资产管理的 API 实例，用于工单管理。</p>
     * 
     * @return 资产管理 API 实例
     * @see AssetApi
     */
    public AssetApi getAssetApi() {
        return assetApi;
    }



    /**
     * 获取 TopStack 客户端实例
     * 
     * <p>返回底层的 TopStack 客户端实例，可用于直接调用 API 或获取配置信息。</p>
     * 
     * @return TopStack 客户端实例
     * @see TopstackClient
     */
    public TopstackClient getClient() {
        return client;
    }
} 