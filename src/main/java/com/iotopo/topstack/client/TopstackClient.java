package com.iotopo.topstack.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * TopStack SDK 客户端
 * 
 * <p>TopStack SDK 的核心客户端类，负责与 TopStack 平台进行 HTTP 通信。
 * 支持 JSON 序列化/反序列化，自动处理认证头部，并提供便捷的 HTTP 方法。</p>
 * 
 * <p>主要功能：</p>
 * <ul>
 *   <li>HTTP 请求发送和响应处理</li>
 *   <li>JSON 数据序列化和反序列化</li>
 *   <li>自动添加认证头部（X-API-Key 和 X-ProjectID）</li>
 *   <li>支持 Java 8 时间类型（ISO-8601 格式）</li>
 *   <li>连接超时和读取超时配置</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * TopstackClient client = new TopstackClient("http://localhost:8000", "your-api-key", "your-project-id");
 * try {
 *     // 发送请求
 *     ResponseData<DeviceListResponse> response = client.get("/iot/open_api/v1/device/query", null, DeviceListResponse.class);
 * } finally {
 *     client.close();
 * }
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class TopstackClient {
    private final OkHttpClient httpClient;
    private final String baseUrl;
    private final String apiKey;
    private final String projectId;
    private final ObjectMapper objectMapper;

    /**
     * 构造函数
     * 
     * <p>创建一个新的 TopStack 客户端实例。</p>
     * 
     * @param baseUrl TopStack 平台的基础 URL，例如 "http://localhost:8000"
     * @param apiKey API 认证密钥
     * @param projectId 项目标识
     * 
     * @throws IllegalArgumentException 如果 baseUrl、apiKey 或 projectId 为 null 或空
     */
    public TopstackClient(String baseUrl, String apiKey, String projectId) {
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("baseUrl cannot be null or empty");
        }
        if (apiKey == null || apiKey.trim().isEmpty()) {
            throw new IllegalArgumentException("apiKey cannot be null or empty");
        }
        if (projectId == null || projectId.trim().isEmpty()) {
            throw new IllegalArgumentException("projectId cannot be null or empty");
        }
        
        this.baseUrl = baseUrl;
        this.apiKey = apiKey;
        this.projectId = projectId;
        this.httpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build();
        this.objectMapper = new ObjectMapper();
        
        // 注册 JavaTimeModule 以支持 Java 8 日期时间类型
        this.objectMapper.registerModule(new JavaTimeModule());
        
        // 禁用将日期写为时间戳，这样会使用 ISO-8601 格式
        this.objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        
        // 允许空对象序列化，避免 FAIL_ON_EMPTY_BEANS 错误
        this.objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    /**
     * 发送 HTTP 请求
     * 
     * <p>通用的 HTTP 请求发送方法，支持 GET、POST、PUT、DELETE 方法。
     * 自动添加认证头部和内容类型头部。</p>
     * 
     * @param method HTTP 方法（GET、POST、PUT、DELETE）
     * @param url 请求路径，相对于 baseUrl
     * @param body 请求体对象，将被序列化为 JSON
     * @param responseType 响应类型
     * @param <T> 响应类型参数
     * @return 反序列化后的响应对象
     * @throws TopstackException 当请求失败或响应解析失败时
     */
    public <T> T sendRequest(String method, String url, Object body, Class<T> responseType) throws TopstackException {
        try {
            RequestBody requestBody = null;
            if (body != null) {
                String json = objectMapper.writeValueAsString(body);
                requestBody = RequestBody.create(json, MediaType.parse("application/json"));
            }
            Request.Builder builder = new Request.Builder()
                    .url(baseUrl + url)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-API-Key", apiKey)
                    .addHeader("X-ProjectID", projectId);
            if (method.equalsIgnoreCase("GET")) {
                builder.get();
            } else if (method.equalsIgnoreCase("POST")) {
                builder.post(requestBody);
            } else if (method.equalsIgnoreCase("PUT")) {
                builder.put(requestBody);
            } else if (method.equalsIgnoreCase("DELETE")) {
                if (requestBody != null) {
                    builder.delete(requestBody);
                } else {
                    builder.delete();
                }
            }
            Request request = builder.build();
            try (Response response = httpClient.newCall(request).execute()) {
                String respBody = response.body() != null ? response.body().string() : "";
                if (!response.isSuccessful()) {
                    throw new TopstackException(response.code(), respBody);
                }
                return objectMapper.readValue(respBody, responseType);
            }
        } catch (IOException e) {
            throw new TopstackException(-1, e.getMessage());
        }
    }

    /**
     * 发送 HTTP 请求（支持复杂泛型类型）
     * 
     * <p>支持复杂泛型类型的 HTTP 请求发送方法，例如 {@code ResponseData<List<DeviceItem>>}。</p>
     * 
     * @param method HTTP 方法（GET、POST、PUT、DELETE）
     * @param url 请求路径，相对于 baseUrl
     * @param body 请求体对象，将被序列化为 JSON
     * @param javaType 响应类型（JavaType）
     * @param <T> 响应类型参数
     * @return 反序列化后的响应对象
     * @throws TopstackException 当请求失败或响应解析失败时
     */
    public <T> T sendRequest(String method, String url, Object body, JavaType javaType) throws TopstackException {
        try {
            RequestBody requestBody = null;
            if (body != null) {
                String json = objectMapper.writeValueAsString(body);
                requestBody = RequestBody.create(json, MediaType.parse("application/json"));
            }
            Request.Builder builder = new Request.Builder()
                    .url(baseUrl + url)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("X-API-Key", apiKey)
                    .addHeader("X-ProjectID", projectId);
            if (method.equalsIgnoreCase("GET")) {
                builder.get();
            } else if (method.equalsIgnoreCase("POST")) {
                builder.post(requestBody);
            } else if (method.equalsIgnoreCase("PUT")) {
                builder.put(requestBody);
            } else if (method.equalsIgnoreCase("DELETE")) {
                if (requestBody != null) {
                    builder.delete(requestBody);
                } else {
                    builder.delete();
                }
            }
            Request request = builder.build();
            try (Response response = httpClient.newCall(request).execute()) {
                String respBody = response.body() != null ? response.body().string() : "";
                if (!response.isSuccessful()) {
                    throw new TopstackException(response.code(), respBody);
                }
                return objectMapper.readValue(respBody, javaType);
            }
        } catch (IOException e) {
            throw new TopstackException(-1, e.getMessage());
        }
    }

    /**
     * 获取 ObjectMapper 实例
     * 
     * <p>返回客户端使用的 ObjectMapper 实例，可用于自定义序列化/反序列化配置。</p>
     * 
     * @return ObjectMapper 实例
     */
    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }
    
    /**
     * 发送 POST 请求
     * 
     * @param url 请求路径
     * @param body 请求体
     * @param responseType 响应类型
     * @param <T> 响应类型参数
     * @return 响应对象
     * @throws TopstackException 当请求失败时
     */
    public <T> T post(String url, Object body, Class<T> responseType) throws TopstackException {
        return sendRequest("POST", url, body, responseType);
    }
    
    /**
     * 发送 GET 请求
     * 
     * @param url 请求路径
     * @param body 请求体（通常为 null）
     * @param responseType 响应类型
     * @param <T> 响应类型参数
     * @return 响应对象
     * @throws TopstackException 当请求失败时
     */
    public <T> T get(String url, Object body, Class<T> responseType) throws TopstackException {
        return sendRequest("GET", url, body, responseType);
    }
    
    /**
     * 发送 PUT 请求
     * 
     * @param url 请求路径
     * @param body 请求体
     * @param responseType 响应类型
     * @param <T> 响应类型参数
     * @return 响应对象
     * @throws TopstackException 当请求失败时
     */
    public <T> T put(String url, Object body, Class<T> responseType) throws TopstackException {
        return sendRequest("PUT", url, body, responseType);
    }
    
    /**
     * 发送 DELETE 请求
     * 
     * @param url 请求路径
     * @param body 请求体
     * @param responseType 响应类型
     * @param <T> 响应类型参数
     * @return 响应对象
     * @throws TopstackException 当请求失败时
     */
    public <T> T delete(String url, Object body, Class<T> responseType) throws TopstackException {
        return sendRequest("DELETE", url, body, responseType);
    }

    /**
     * 关闭 HTTP 客户端，释放资源
     * 
     * <p>关闭 OkHttpClient 的连接池和线程池，释放相关资源。
     * 在不再使用客户端时应该调用此方法。</p>
     */
    public void close() {
        if (httpClient != null) {
            httpClient.dispatcher().executorService().shutdown();
            httpClient.connectionPool().evictAll();
        }
    }
} 