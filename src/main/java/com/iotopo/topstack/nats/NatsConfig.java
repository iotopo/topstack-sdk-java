package com.iotopo.topstack.nats;

/**
 * NATS 配置类
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class NatsConfig {
    
    private String addr;
    private String token;
    private String username;
    private String password;
    
    // Constructors
    public NatsConfig() {}
    
    public NatsConfig(String addr, String token, String username, String password) {
        this.addr = addr;
        this.token = token;
        this.username = username;
        this.password = password;
    }
    
    // Getters and Setters
    public String getAddr() {
        return addr;
    }
    
    public void setAddr(String addr) {
        this.addr = addr;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String token) {
        this.token = token;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return "NatsConfig{" +
                "addr='" + addr + '\'' +
                ", token='" + (token != null ? "***" : null) + '\'' +
                ", username='" + username + '\'' +
                ", password='" + (password != null ? "***" : null) + '\'' +
                '}';
    }
} 