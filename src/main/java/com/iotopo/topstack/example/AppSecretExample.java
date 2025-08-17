package com.iotopo.topstack.example;

import com.iotopo.topstack.TopstackSDK;
import com.iotopo.topstack.client.ResponseData;
import com.iotopo.topstack.client.TopstackException;
import com.iotopo.topstack.iot.*;

/**
 * AppID/AppSecret 认证方式示例
 * 
 * <p>展示如何使用 AppID/AppSecret 认证方式创建 SDK 实例并进行 API 调用。</p>
 * 
 * <p>使用方式：</p>
 * <pre>{@code
 * // 使用 AppID/AppSecret 认证方式创建 SDK 实例
 * TopstackSDK sdk = new TopstackSDK("http://localhost:8000", "your-app-id", "your-app-secret");
 * 
 * try {
 *     // 进行 API 调用，SDK 会自动处理令牌获取和认证
 *     FindLastRequest req = new FindLastRequest("device001", "temperature");
 *     ResponseData<FindLastResponse> response = sdk.getIotApi().findLast(req);
 *     System.out.println("设备温度: " + response.getData().getValue());
 * } finally {
 *     // 关闭客户端，释放资源
 *     sdk.getClient().close();
 * }
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class AppSecretExample {
    public static void main(String[] args) {
        // 使用 AppID/AppSecret 认证方式初始化 SDK
        TopstackSDK sdk = new TopstackSDK("http://localhost:8000", "your-app-id", "your-app-secret");

        try {
            System.out.println("=== AppID/AppSecret 认证示例 ===");
            
            // IoT 模块示例 - 查询单测点实时值
            System.out.println("--- 查询设备实时数据 ---");
            FindLastRequest findLastReq = new FindLastRequest("dev1", "v1");
            ResponseData<FindLastResponse> findLastResp = sdk.getIotApi().findLast(findLastReq);
            System.out.println("单测点实时值: " + findLastResp.getData().getValue());

            // 批量查询多测点实时值
            System.out.println("--- 批量查询设备数据 ---");
            FindLastRequest req1 = new FindLastRequest("dev1", "v1");
            FindLastRequest req2 = new FindLastRequest("dev2", "v2");
            java.util.List<FindLastRequest> batchReqs = java.util.Arrays.asList(req1, req2);
            ResponseData<java.util.List<FindLastResponse>> batchResp = sdk.getIotApi().findLastBatch(batchReqs);
            System.out.println("批量查询结果数量: " + batchResp.getData().size());

            // 控制指令下发
            System.out.println("--- 发送控制指令 ---");
            SetValueRequest setValueReq = new SetValueRequest("dev1", "v1", "2");
            ResponseData<Object> setValueResp = sdk.getIotApi().setValue(setValueReq);
            System.out.println("控制指令下发成功");

            // 历史数据查询
            System.out.println("--- 查询历史数据 ---");
            HistoryRequest historyReq = new HistoryRequest();
            Point point = new Point("dev1", "v1");
            historyReq.setPoints(java.util.Arrays.asList(point));
            // 使用 OffsetDateTime 设置时间范围
            historyReq.setStart(java.time.OffsetDateTime.now(java.time.ZoneOffset.UTC).minusMinutes(10).toString()); //10分钟前
            historyReq.setEnd(java.time.OffsetDateTime.now(java.time.ZoneOffset.UTC).toString());
            historyReq.setInterval("10s");
            historyReq.setAggregation("last");
            ResponseData<HistoryResponse> historyResp = sdk.getIotApi().queryHistory(historyReq);
            System.out.println("历史数据查询结果数量: " + historyResp.getData().getResults().size());
            if (historyResp.getData().getResults().size() > 0) {
                HistoryResponse.Result result = historyResp.getData().getResults().get(0);
                if (result.getValues() != null) {
                    System.out.println("数据点数量: " + result.getValues().size());
                } else {
                    System.out.println("数据点为空");
                }
            }

            System.out.println("\n=== 认证方式说明 ===");
            System.out.println("当前使用的是 AppID/AppSecret 认证方式");
            System.out.println("SDK 会自动调用 /open_api/v1/auth/access_token 接口获取访问令牌");
            System.out.println("访问令牌会自动缓存，并在过期前5分钟自动刷新");
            System.out.println("所有 API 调用都会自动携带 Bearer 令牌进行认证");

        } catch (TopstackException e) {
            System.err.println("API 调用失败: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 关闭客户端，释放资源
            sdk.getClient().close();
            System.out.println("\n客户端已关闭，资源已释放");
        }
    }
}
