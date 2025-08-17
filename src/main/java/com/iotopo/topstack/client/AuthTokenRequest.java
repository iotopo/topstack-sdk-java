package com.iotopo.topstack.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 认证令牌请求模型
 * 
 * <p>用于发送获取访问令牌接口的请求数据。</p>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class AuthTokenRequest {
    
    @JsonProperty("app_id")
    private String appId;
    
    @JsonProperty("app_secret")
    private String appSecret;
    
    public AuthTokenRequest() {}
    
    public AuthTokenRequest(String appId, String appSecret) {
        this.appId = appId;
        this.appSecret = appSecret;
    }
    
    public String getAppId() {
        return appId;
    }
    
    public void setAppId(String appId) {
        this.appId = appId;
    }
    
    public String getAppSecret() {
        return appSecret;
    }
    
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }
    
    @Override
    public String toString() {
        return "AuthTokenRequest{" +
                "appId='" + appId + '\'' +
                ", appSecret='" + appSecret + '\'' +
                '}';
    }
}
