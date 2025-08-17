package com.iotopo.topstack.client;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 认证令牌响应模型
 * 
 * <p>用于解析获取访问令牌接口的响应数据。</p>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class AuthTokenResponse {
    
    @JsonProperty("code")
    private String code;
    
    @JsonProperty("msg")
    private String msg;
    
    @JsonProperty("access_token")
    private String accessToken;
    
    @JsonProperty("expire")
    private Integer expire;
    
    public AuthTokenResponse() {}
    
    public AuthTokenResponse(String code, String msg, String accessToken, Integer expire) {
        this.code = code;
        this.msg = msg;
        this.accessToken = accessToken;
        this.expire = expire;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getMsg() {
        return msg;
    }
    
    public void setMsg(String msg) {
        this.msg = msg;
    }
    
    public String getAccessToken() {
        return accessToken;
    }
    
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }
    
    public Integer getExpire() {
        return expire;
    }
    
    public void setExpire(Integer expire) {
        this.expire = expire;
    }
    
    @Override
    public String toString() {
        return "AuthTokenResponse{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", expire=" + expire +
                '}';
    }
}
