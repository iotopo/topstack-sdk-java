package com.iotopo.topstack.example;

import com.iotopo.topstack.client.ResponseData;
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;
import com.iotopo.topstack.iot.*;

import java.time.Instant;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;

public class IotExample {
    public static void main(String[] args) {
        // 初始化客户端
        TopstackClient client = new TopstackClient("http://localhost:8000", "8mphozy98fkor6iu", "iotopo");
        IotApi iotApi = new IotApi(client);

        try {
            // 查询单测点实时值
            FindLastRequest findLastReq = new FindLastRequest("dev1", "v1");
            ResponseData<FindLastResponse> findLastResp = iotApi.findLast(findLastReq);
            System.out.println("单测点实时值: " + findLastResp.getData().getValue());

            // 批量查询多测点实时值
            FindLastRequest req1 = new FindLastRequest("dev1", "v1");
            FindLastRequest req2 = new FindLastRequest("dev2", "v2");
            List<FindLastRequest> batchReqs = Arrays.asList(req1, req2);
            ResponseData<List<FindLastResponse>> batchResp = iotApi.findLastBatch(batchReqs);
            System.out.println("批量查询结果数量: " + batchResp.getData().size());

            // 控制指令下发
            SetValueRequest setValueReq = new SetValueRequest("dev1", "v1", "2");
            ResponseData<Object> setValueResp = iotApi.setValue(setValueReq);
            System.out.println("控制指令下发成功");

            // 历史数据查询
            HistoryRequest historyReq = new HistoryRequest();
            Point point = new Point("dev1", "v1");
            historyReq.setPoints(Arrays.asList(point));
            // 使用 ISO-8601 格式的时间字符串
            historyReq.setStart(Instant.now().minusSeconds(600).toString()); //10分钟前
            historyReq.setEnd(Instant.now().toString());
            historyReq.setInterval("10s");
            historyReq.setAggregation("last");
            ResponseData<HistoryResponse> historyResp = iotApi.queryHistory(historyReq);
            System.out.println("历史数据查询结果数量: " + historyResp.getData().getResults().size());
            if (historyResp.getData().getResults().size() > 0) {
                HistoryResponse.Result result = historyResp.getData().getResults().get(0);
                if (result.getValues() != null) {
                    System.out.println("数据点数量: " + result.getValues().size());
                } else {
                    System.out.println("数据点为空");
                }
            }

        } catch (TopstackException e) {
            System.err.println("API调用失败: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("其他错误: " + e.getMessage());
            e.printStackTrace();
        }
    }
} 