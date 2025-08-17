# TopStack SDK Java

官方网址：https://www.iotopo.com

TopStack 是一款轻量型 Web 组态软件，提供设备数据采集、定时任务、控制策略、联动控制、设备告警、设备维护管理、设备绩效管理、能源管理、组态开发、报表开发等功能。支持移动端访问，支持本地部署，可帮助企业从无到有快速搭建工业物联网平台。

TopStack 目前已完成了信创生态的全面适配：

* 适配国产服务器：龙芯、飞腾、鲲鹏、海光、兆芯等。
* 适配国产操作系统：麒麟、统信等操作系统。
* 适配国产数据库：达梦、人大金仓等国产数据库。

本项目为 TopStack SDK 的 Java 版本，支持 JDK8及以上版本。

## 安装

### Maven

```xml
<dependency>
    <groupId>com.iotopo.topstack</groupId>
    <artifactId>topstack-sdk</artifactId>
    <version>1.0.1</version>
</dependency>
```

## 认证方式

TopStack SDK Java 使用 AppID/AppSecret 认证方式：

```java
import com.iotopo.topstack.TopstackSDK;

// 使用 AppID/AppSecret 认证方式
TopstackSDK sdk = new TopstackSDK("http://localhost:8000", "your-app-id", "your-app-secret");
```

**认证方式说明：**
- **AppID/AppSecret 认证**：通过获取访问令牌进行认证，支持令牌自动刷新，适合企业级应用
- 自动调用 `/open_api/v1/auth/access_token` 接口获取访问令牌
- 访问令牌自动缓存，并在过期前5分钟自动刷新
- 所有 API 调用自动携带 Bearer 令牌进行认证

## 快速开始

### 初始化客户端

#### 方式一：使用 TopstackSDK（推荐）

```java
import com.iotopo.topstack.TopstackSDK;

// 使用 AppID/AppSecret 认证方式
TopstackSDK sdk = new TopstackSDK("http://localhost:8000", "your-app-id", "your-app-secret");

// 获取各个模块的 API 实例
IotApi iotApi = sdk.getIotApi();
```

#### 方式二：直接使用 TopstackClient

```java
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.iot.IotApi;

// 使用 AppID/AppSecret 认证方式
TopstackClient client = new TopstackClient("http://localhost:8000", "your-app-id", "your-app-secret");

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

### NATS 实时数据订阅

NATS 数据总线模块是独立的，不依赖 TopStack SDK，可以直接使用：

```java
import com.iotopo.topstack.nats.NatsBus;
import com.iotopo.topstack.nats.NatsConfig;
import com.iotopo.topstack.nats.Subscriber;
import com.iotopo.topstack.nats.model.*;

// 配置 NATS 连接
NatsConfig natsConfig = new NatsConfig("nats://localhost:4222");
NatsBus natsBus = new NatsBus(natsConfig);

// 订阅设备测点数据
Subscriber subscriber = natsBus.subscribePointData(
    "project001", "device001", "temperature",
    data -> {
        System.out.println("收到测点数据: " + data.getValue());
        System.out.println("设备ID: " + data.getDeviceID());
        System.out.println("测点ID: " + data.getPointID());
        System.out.println("时间戳: " + data.getTimestamp());
    }
);

// 订阅设备状态数据
Subscriber stateSubscriber = natsBus.subscribeDeviceState(
    "project001", "device001",
    state -> {
        System.out.println("设备状态: " + (state.getState() == 1 ? "在线" : "离线"));
    }
);

// 订阅告警信息
Subscriber alertSubscriber = natsBus.subscribeAlertInfo(
    "project001",
    (alert) -> {
        System.out.println("收到告警: " + alert.getTitle());
        System.out.println("告警内容: " + alert.getContent());
    }
);

// 取消订阅
subscriber.unsubscribe();
stateSubscriber.unsubscribe();
alertSubscriber.unsubscribe();

// 关闭连接
natsBus.close();
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
# 运行 NATS 示例
mvn exec:java@run-nats-example

# 运行完整示例
mvn exec:java@run-complete-example

# 运行 IoT 示例
mvn exec:java@run-iot-example
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
├── nats/                   # NATS 数据总线模块
│   ├── model/             # 数据模型
│   │   ├── PointData.java
│   │   ├── DeviceState.java
│   │   ├── GatewayState.java
│   │   ├── ChannelState.java
│   │   └── AlertInfo.java
│   ├── NatsBus.java       # NATS 总线实现
│   ├── NatsConfig.java    # NATS 配置
│   ├── NatsTopics.java    # 主题工具类
│   └── Subscriber.java    # 订阅者接口
└── datav/                  # 数据可视化模块
```

## 许可证

MIT License 