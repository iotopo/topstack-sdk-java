# 日志配置说明

## 概述

TopStack SDK Java 使用 SLF4J 作为日志门面，支持多种日志实现。

## 日志实现选择

### 1. 开发/测试环境
在开发和测试环境中，我们使用 `slf4j-simple` 作为日志实现，配置为 `optional` 依赖，用户可以选择是否包含。

### 2. 生产环境
在生产环境中，用户可以选择以下日志实现：

#### 推荐方案：Logback
```xml
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.4.11</version>
</dependency>
```

#### 备选方案：Log4j2
```xml
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.20.0</version>
</dependency>
```

## 运行示例时的日志配置

### 方法1：使用 Maven 命令（推荐）
```bash
# 运行 NATS 示例
mvn exec:java@run-nats-example

# 运行完整示例
mvn exec:java@run-complete-example

# 运行 IoT 示例
mvn exec:java@run-iot-example
```

这些命令会自动配置日志输出到控制台。

### 方法2：手动配置
如果直接运行 Java 类，可以添加以下系统属性：

```bash
java -Dorg.slf4j.simpleLogger.defaultLogLevel=info \
     -Dorg.slf4j.simpleLogger.showDateTime=true \
     -Dorg.slf4j.simpleLogger.dateTimeFormat=yyyy-MM-dd HH:mm:ss.SSS \
     -cp target/classes com.iotopo.topstack.example.NatsExample
```

## 日志级别

- `DEBUG`: 详细的调试信息
- `INFO`: 一般信息（默认）
- `WARN`: 警告信息
- `ERROR`: 错误信息

## 自定义日志配置

### 使用 Logback（推荐）
创建 `src/main/resources/logback.xml`：

```xml
<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
        </encoder>
    </appender>
    
    <logger name="com.iotopo.topstack" level="INFO"/>
    <logger name="io.nats" level="WARN"/>
    
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>
```

### 使用 Log4j2
创建 `src/main/resources/log4j2.xml`：

```xml
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Logger name="com.iotopo.topstack" level="INFO"/>
        <Logger name="io.nats" level="WARN"/>
        <Root level="INFO">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>
```

## 注意事项

1. **依赖管理**: SDK 中的 `slf4j-simple` 配置为 `optional` 依赖，不会自动传递到用户项目
2. **用户选择**: 用户可以根据需要选择自己的日志实现，SDK 不会强制使用特定的日志实现
3. **性能考虑**: 在生产环境中，建议使用 Logback 或 Log4j2 而不是 slf4j-simple
4. **配置优先级**: 系统属性配置会覆盖配置文件中的设置

## 依赖管理

### SDK 依赖配置
- `slf4j-api`: 必需依赖，提供日志门面
- `slf4j-simple`: 可选依赖，仅在开发和测试时使用

### 用户项目配置
用户项目可以选择以下方式之一：

#### 方式1：使用 SDK 的默认日志实现
```xml
<dependency>
    <groupId>com.iotopo.topstack</groupId>
    <artifactId>topstack-sdk</artifactId>
    <version>1.0.1</version>
    <classifier>sources</classifier>
</dependency>
```

#### 方式2：使用自己的日志实现（推荐）
```xml
<dependency>
    <groupId>com.iotopo.topstack</groupId>
    <artifactId>topstack-sdk</artifactId>
    <version>1.0.1</version>
    <exclusions>
        <exclusion>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-simple</artifactId>
        </exclusion>
    </exclusions>
</dependency>

<!-- 添加自己的日志实现 -->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.4.11</version>
</dependency>
```

## 故障排除

### 问题：SLF4J 警告 "No SLF4J providers were found"
**解决方案**: 添加日志实现依赖，如 Logback 或 slf4j-simple

### 问题：日志输出过多
**解决方案**: 调整日志级别或添加过滤器

### 问题：日志格式不符合预期
**解决方案**: 检查日志配置文件或系统属性设置 