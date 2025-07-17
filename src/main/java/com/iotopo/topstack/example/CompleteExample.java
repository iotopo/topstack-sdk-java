package com.iotopo.topstack.example;

import com.iotopo.topstack.TopstackSDK;
import com.iotopo.topstack.alert.AlertApi;
import com.iotopo.topstack.alert.alertlevel.AlertLevelApi;
import com.iotopo.topstack.asset.workorder.WorkOrderApi;
import com.iotopo.topstack.client.ResponseData;
import com.iotopo.topstack.client.TopstackException;
import com.iotopo.topstack.datav.DatavApi;
import com.iotopo.topstack.ems.meter.MeterApi;
import com.iotopo.topstack.iot.*;
import com.iotopo.topstack.iot.device.DeviceApi;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Arrays;
import java.util.List;

public class CompleteExample {
    public static void main(String[] args) {
        // 初始化 SDK
        TopstackSDK sdk = new TopstackSDK("http://localhost:8000", "x248z0728lhn", "iotopo");

        try {
            // IoT 模块示例
            System.out.println("=== IoT 模块示例 ===");
            
            // 查询单测点实时值
            FindLastRequest findLastReq = new FindLastRequest("dev1", "v1");
            ResponseData<FindLastResponse> findLastResp = sdk.getIotApi().findLast(findLastReq);
            System.out.println("单测点实时值: " + findLastResp.getData().getValue());

            // 批量查询多测点实时值
            FindLastRequest req1 = new FindLastRequest("dev1", "v1");
            FindLastRequest req2 = new FindLastRequest("dev2", "v2");
            List<FindLastRequest> batchReqs = Arrays.asList(req1, req2);
            ResponseData<List<FindLastResponse>> batchResp = sdk.getIotApi().findLastBatch(batchReqs);
            System.out.println("批量查询结果数量: " + batchResp.getData().size());

            // 控制指令下发
            SetValueRequest setValueReq = new SetValueRequest("dev1", "v1", "2");
            ResponseData<Object> setValueResp = sdk.getIotApi().setValue(setValueReq);
            System.out.println("控制指令下发成功");

            // 历史数据查询
            HistoryRequest historyReq = new HistoryRequest();
            Point point = new Point("dev1", "v1");
            historyReq.setPoints(Arrays.asList(point));
            // 使用 OffsetDateTime 设置时间范围
            historyReq.setStart(OffsetDateTime.now(ZoneOffset.UTC).minusMinutes(10).toString()); //10分钟前
            historyReq.setEnd(OffsetDateTime.now(ZoneOffset.UTC).toString());
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

            // 设备查询 - 使用新的子模块
            DeviceApi deviceApi = new DeviceApi(sdk.getClient());
            com.iotopo.topstack.iot.device.DeviceListRequest deviceQueryReq = new com.iotopo.topstack.iot.device.DeviceListRequest("dev1", 1, 10);
            ResponseData<com.iotopo.topstack.iot.device.DeviceListResponse> deviceQueryResp = deviceApi.query(deviceQueryReq);
            System.out.println("设备查询结果数量: " + deviceQueryResp.getData().getItems().size());

            // 设备属性查询 - 使用新的子模块
            ResponseData<List<com.iotopo.topstack.iot.device.PropsQueryResponse.Property>> devicePropsResp = deviceApi.queryProps("dev1");
            System.out.println("设备属性查询成功，属性数量: " + devicePropsResp.getData().size());

            // Alert 模块示例
            System.out.println("\n=== Alert 模块示例 ===");
            com.iotopo.topstack.alert.alertlevel.AlertLevelListRequest alertLevelReq = new com.iotopo.topstack.alert.alertlevel.AlertLevelListRequest();
            com.iotopo.topstack.alert.alertlevel.AlertLevelListResponse alertLevelResp = AlertLevelApi.query(sdk.getClient(), alertLevelReq);
            System.out.println("告警等级查询结果数量: " + alertLevelResp.getData().size());

            // EMS 模块示例
            System.out.println("\n=== EMS 模块示例 ===");
            com.iotopo.topstack.ems.meter.MeterListRequest meterQueryReq = new com.iotopo.topstack.ems.meter.MeterListRequest();
            meterQueryReq.setPage(1);
            meterQueryReq.setSize(10);
            ResponseData<com.iotopo.topstack.ems.meter.MeterListResponse> meterQueryResp = MeterApi.query(sdk.getClient(), meterQueryReq);
            System.out.println("仪表列表查询结果数量: " + meterQueryResp.getData().getItems().size());

            // Asset 模块示例
            System.out.println("\n=== Asset 模块示例 ===");
            com.iotopo.topstack.asset.workorder.WorkOrderListRequest workOrderQueryReq = new com.iotopo.topstack.asset.workorder.WorkOrderListRequest();
            workOrderQueryReq.setPage(1);
            workOrderQueryReq.setSize(10);
            com.iotopo.topstack.asset.workorder.WorkOrderListResponse workOrderQueryResp = WorkOrderApi.queryAlert(sdk.getClient(), workOrderQueryReq);
            System.out.println("告警工单查询结果数量: " + workOrderQueryResp.getData().size());

            // Datav 模块示例
            System.out.println("\n=== Datav 模块示例 ===");
            String pageUrl = DatavApi.getPageUrl(
                "http://localhost:8000",
                "ct9osgj6lmas2l2hl0",
                "861337fe3e34e1bf0ee1a4e15d3a63",
                "",
                "",
                new DatavApi.Param[0]
            );
            System.out.println("组态画面访问地址: " + pageUrl);

        } catch (TopstackException e) {
            System.err.println("API调用失败: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("其他错误: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 确保资源被正确释放
            try {
                sdk.getClient().close();
                System.out.println("资源清理完成");
            } catch (Exception e) {
                System.err.println("资源清理时出错: " + e.getMessage());
            }
        }
    }
} 