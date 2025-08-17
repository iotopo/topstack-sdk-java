package com.iotopo.topstack.client;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;

import java.io.IOException;
import java.time.Instant;
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
 *   <li>自动添加认证头部（Bearer 令牌）</li>
 *   <li>支持 Java 8 时间类型（ISO-8601 格式）</li>
 *   <li>连接超时和读取超时配置</li>
 *   <li>自动令牌管理和刷新</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * TopstackClient client = new TopstackClient("http://localhost:8000", "your-app-id", "your-app-secret");
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
    private final String appId;
    private final String appSecret;
    private final ObjectMapper objectMapper;
    
    private String accessToken;
    private Instant expiresAt;

    /**
     * 构造函数
     * 
     * <p>创建一个新的 TopStack 客户端实例，使用 AppID/AppSecret 认证方式。</p>
     * 
     * @param baseUrl TopStack 平台的基础 URL，例如 "http://localhost:8000"
     * @param appId 应用ID
     * @param appSecret 应用密钥
     * 
     * @throws IllegalArgumentException 如果 baseUrl、appId 或 appSecret 为 null 或空
     */
    public TopstackClient(String baseUrl, String appId, String appSecret) {
        if (baseUrl == null || baseUrl.trim().isEmpty()) {
            throw new IllegalArgumentException("baseUrl cannot be null or empty");
        }
        if (appId == null || appId.trim().isEmpty()) {
            throw new IllegalArgumentException("appId cannot be null or empty");
        }
        if (appSecret == null || appSecret.trim().isEmpty()) {
            throw new IllegalArgumentException("appSecret cannot be null or empty");
        }
        
        this.baseUrl = baseUrl;
        this.appId = appId;
        this.appSecret = appSecret;
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
     * 获取访问令牌
     * 
     * <p>使用 AppID 和 AppSecret 获取访问令牌，并缓存令牌信息。</p>
     * 
     * @throws TopstackException 当获取令牌失败时
     */
    private void getAccessToken() throws TopstackException {
        // 检查令牌是否还有效（提前5分钟过期）
        if (accessToken != null && expiresAt != null && Instant.now().isBefore(expiresAt)) {
            return;
        }
        
        try {
            AuthTokenRequest request = new AuthTokenRequest(appId, appSecret);
            String json = objectMapper.writeValueAsString(request);
            RequestBody requestBody = RequestBody.create(json, MediaType.parse("application/json"));
            
            Request tokenRequest = new Request.Builder()
                    .url(baseUrl + "/open_api/v1/auth/access_token")
                    .post(requestBody)
                    .addHeader("Content-Type", "application/json")
                    .build();
            
            try (Response response = httpClient.newCall(tokenRequest).execute()) {
                String respBody = response.body() != null ? response.body().string() : "";
                if (!response.isSuccessful()) {
                    throw new TopstackException(response.code(), "获取访问令牌失败: " + respBody);
                }
                
                AuthTokenResponse tokenResp = objectMapper.readValue(respBody, AuthTokenResponse.class);
                if (tokenResp.getCode() != null && !tokenResp.getCode().isEmpty()) {
                    throw new TopstackException(-1, "获取访问令牌失败: " + tokenResp.getCode() + ", " + tokenResp.getMsg());
                }
                
                this.accessToken = tokenResp.getAccessToken();
                // 提前5分钟过期
                this.expiresAt = Instant.now().plusSeconds(tokenResp.getExpire() - 300);
            }
        } catch (IOException e) {
            throw new TopstackException(-1, "获取访问令牌失败: " + e.getMessage());
        }
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
            // 获取访问令牌
            getAccessToken();
            
            RequestBody requestBody = null;
            if (body != null) {
                String json = objectMapper.writeValueAsString(body);
                requestBody = RequestBody.create(json, MediaType.parse("application/json"));
            }
            Request.Builder builder = new Request.Builder()
                    .url(baseUrl + url)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + accessToken);
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
            // 获取访问令牌
            getAccessToken();
            
            RequestBody requestBody = null;
            if (body != null) {
                String json = objectMapper.writeValueAsString(body);
                requestBody = RequestBody.create(json, MediaType.parse("application/json"));
            }
            Request.Builder builder = new Request.Builder()
                    .url(baseUrl + url)
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + accessToken);
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
     * 获取基础 URL
     * 
     * @return 基础 URL
     */
    public String getBaseUrl() {
        return baseUrl;
    }
    
    /**
     * 获取应用 ID
     * 
     * @return 应用 ID
     */
    public String getAppId() {
        return appId;
    }
    
    /**
     * 获取应用密钥
     * 
     * @return 应用密钥
     */
    public String getAppSecret() {
        return appSecret;
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