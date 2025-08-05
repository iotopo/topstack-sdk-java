package com.iotopo.topstack.nats;

/**
 * NATS 订阅者接口
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public interface Subscriber {
    
    /**
     * 取消订阅
     * 
     * @throws Exception 取消订阅失败时抛出异常
     */
    void unsubscribe() throws Exception;
} 