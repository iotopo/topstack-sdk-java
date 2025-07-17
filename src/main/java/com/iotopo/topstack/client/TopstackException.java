package com.iotopo.topstack.client;

/**
 * TopStack SDK 异常类
 * 
 * <p>表示 TopStack SDK 操作过程中发生的异常，包含错误码和错误消息。</p>
 * 
 * <p>错误码说明：</p>
 * <ul>
 *   <li>200-299：HTTP 成功状态码</li>
 *   <li>400-499：客户端错误（如参数错误、认证失败等）</li>
 *   <li>500-599：服务器错误</li>
 *   <li>-1：网络连接错误或其他系统错误</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * try {
 *     ResponseData<DeviceListResponse> response = client.get("/iot/open_api/v1/device/query", null, DeviceListResponse.class);
 * } catch (TopstackException e) {
 *     System.err.println("错误码: " + e.getCode());
 *     System.err.println("错误消息: " + e.getMessage());
 * }
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class TopstackException extends Exception {
    private final int code;
    private final String message;

    /**
     * 构造函数
     * 
     * @param code 错误码
     * @param message 错误消息
     */
    public TopstackException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    /**
     * 获取错误码
     * 
     * @return 错误码
     */
    public int getCode() {
        return code;
    }

    /**
     * 获取错误消息
     * 
     * @return 错误消息
     */
    @Override
    public String getMessage() {
        return message;
    }
} 