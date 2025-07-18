# TopStack SDK Java

官方网址：https://www.iotopo.com

TopStack SDK 的 Java 版本，支持 JDK8及以上版本。

TopStack 是一款轻量型 Web 组态软件，提供设备数据采集、定时任务、控制策略、联动控制、设备告警、设备维护管理、设备绩效管理、能源管理、组态开发、报表开发等功能。支持移动端访问，支持本地部署，可帮助企业从无到有快速搭建工业物联网平台。

TopStack 目前已完成了信创生态的全面适配：

* 适配国产服务器：龙芯、飞腾、鲲鹏、海光、兆芯等。
* 适配国产操作系统：麒麟、统信等操作系统。
* 适配国产数据库：达梦、人大金仓等国产数据库。

## 安装

### Maven

```xml
<dependency>
    <groupId>com.iotopo.topstack</groupId>
    <artifactId>topstack-sdk</artifactId>
    <version>1.0.0</version>
</dependency>
```

## 快速开始

### 初始化客户端

```java
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.iot.IotApi;

// 初始化客户端
TopstackClient client = new TopstackClient("http://localhost:8000", "your-api-key", "your-project-id");
IotApi iotApi = new IotApi(client);
```

### 查询单测点实时值

```java
import com.iotopo.topstack.iot.FindLastRequest;
import com.iotopo.topstack.iot.FindLastResponse;
import com.iotopo.topstack.client.ResponseData;

FindLastRequest request = new FindLastRequest();
request.setDeviceID("device-id");
request.setPointID("point-id");
ResponseData<FindLastResponse> response = iotApi.findLast(request);
System.out.println("实时值: " + response.getData().getValue());
```

### 批量查询多测点实时值

```java
import java.util.Arrays;
import java.util.List;

FindLastRequest req1 = new FindLastRequest();
req1.setDeviceID("device1");
req1.setPointID("point1");
FindLastRequest req2 = new FindLastRequest();
req2.setDeviceID("device2");
req2.setPointID("point2");
List<FindLastRequest> requests = Arrays.asList(req1, req2);
ResponseData<List<FindLastResponse>> response = iotApi.findLastBatch(requests);
```

### 控制指令下发

```java
import com.iotopo.topstack.iot.SetValueRequest;

SetValueRequest request = new SetValueRequest();
request.setDeviceID("device-id");
request.setPointID("point-id");
request.setValue("value");
ResponseData<Object> response = iotApi.setValue(request);
```

### 历史数据查询

```java
import com.iotopo.topstack.iot.HistoryRequest;
import com.iotopo.topstack.iot.HistoryResponse;
import com.iotopo.topstack.iot.Point;
import java.time.OffsetDateTime;

HistoryRequest request = new HistoryRequest();
Point point = new Point("device-id", "point-id");
request.setPoints(Arrays.asList(point));
request.setStart(OffsetDateTime.now().minusMinutes(10).toString()); // 10分钟前
request.setEnd(OffsetDateTime.now().toString());
request.setInterval("10s");
request.setAggregation("last");
ResponseData<HistoryResponse> response = iotApi.queryHistory(request);
```

### 设备查询

```java
import com.iotopo.topstack.iot.device.DeviceApi;
import com.iotopo.topstack.iot.device.DeviceListRequest;
import com.iotopo.topstack.iot.device.DeviceListResponse;

DeviceApi deviceApi = new DeviceApi(client);
DeviceListRequest request = new DeviceListRequest();
request.setPageNum(1);
request.setPageSize(10);
ResponseData<DeviceListResponse> response = deviceApi.query(request);
```

### 告警等级查询

```java
import com.iotopo.topstack.alert.alertlevel.AlertLevelApi;
import com.iotopo.topstack.alert.alertlevel.AlertLevelListRequest;
import com.iotopo.topstack.alert.alertlevel.AlertLevelListResponse;

AlertLevelListRequest request = new AlertLevelListRequest();
AlertLevelListResponse response = AlertLevelApi.query(client, request);
```

### 告警类型查询

```java
import com.iotopo.topstack.alert.alerttype.AlertTypeApi;
import com.iotopo.topstack.alert.alerttype.AlertTypeListRequest;
import com.iotopo.topstack.alert.alerttype.AlertTypeListResponse;

AlertTypeListRequest request = new AlertTypeListRequest();
AlertTypeListResponse response = AlertTypeApi.query(client, request);
```

### 告警记录查询

```java
import com.iotopo.topstack.alert.alertrecord.AlertRecordApi;
import com.iotopo.topstack.alert.alertrecord.AlertRecordListRequest;
import com.iotopo.topstack.alert.alertrecord.AlertRecordListResponse;

AlertRecordListRequest request = new AlertRecordListRequest();
AlertRecordListResponse response = AlertRecordApi.query(client, request);
```

### 仪表查询

```java
import com.iotopo.topstack.ems.meter.MeterApi;
import com.iotopo.topstack.ems.meter.MeterListRequest;
import com.iotopo.topstack.ems.meter.MeterListResponse;

MeterListRequest request = new MeterListRequest();
request.setPage(1);
request.setSize(10);
ResponseData<MeterListResponse> response = MeterApi.query(client, request);
```

### 工单查询

```java
import com.iotopo.topstack.asset.workorder.WorkOrderApi;
import com.iotopo.topstack.asset.workorder.WorkOrderListRequest;
import com.iotopo.topstack.asset.workorder.WorkOrderListResponse;

WorkOrderListRequest request = new WorkOrderListRequest();
request.setPage(1);
request.setSize(10);
WorkOrderListResponse response = WorkOrderApi.queryAlert(client, request);
```

## 异常处理

```java
import com.iotopo.topstack.client.TopstackException;

try {
    ResponseData<FindLastResponse> response = iotApi.findLast(request);
} catch (TopstackException e) {
    System.err.println("API调用失败: " + e.getMessage());
    System.err.println("错误代码: " + e.getCode());
}
```

## 运行测试

```bash
mvn test
```

## 编译项目

```bash
mvn compile
```

## 打包项目

```bash
mvn clean package -DskipTests
```

## 运行示例

```bash
mvn exec:java
```

## 项目结构

```
src/main/java/com/iotopo/topstack/
├── client/                 # 客户端核心
│   ├── TopstackClient.java
│   ├── TopstackException.java
│   └── ResponseData.java
├── iot/                    # IoT 模块
│   ├── device/            # 设备管理
│   ├── devicetype/        # 设备类型
│   ├── gateway/           # 网关管理
│   ├── IotApi.java        # 数据接口
│   └── *.java            # 数据相关请求响应
├── alert/                  # 告警模块
│   ├── alertlevel/        # 告警等级
│   ├── alerttype/         # 告警类型
│   └── alertrecord/       # 告警记录
├── ems/                    # 能源管理模块
│   ├── meter/             # 仪表管理
│   ├── sector/            # 用能单元
│   └── subentry/          # 能源分项
├── asset/                  # 资产管理模块
│   └── workorder/         # 工单管理
└── datav/                  # 数据可视化模块
```

## 许可证

MIT License 