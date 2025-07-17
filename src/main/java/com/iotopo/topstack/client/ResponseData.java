package com.iotopo.topstack.client;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * TopStack API 响应数据包装类
 * 
 * <p>TopStack 平台所有 API 响应的统一包装格式，包含状态码、消息、数据和成功标志。</p>
 * 
 * <p>响应结构：</p>
 * <ul>
 *   <li>{@code code}：响应状态码，成功时通常为空字符串</li>
 *   <li>{@code msg}：响应消息，成功时通常为空字符串</li>
 *   <li>{@code data}：实际响应数据，类型由泛型参数 T 指定</li>
 *   <li>{@code success}：操作是否成功</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * ResponseData<DeviceListResponse> response = client.get("/iot/open_api/v1/device/query", null, DeviceListResponse.class);
 * if (response.getSuccess()) {
 *     DeviceListResponse data = response.getData();
 *     // 处理数据
 * } else {
 *     System.err.println("请求失败: " + response.getMsg());
 * }
 * }</pre>
 * 
 * @param <T> 响应数据类型
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ResponseData<T> {
    private String code;
    private String msg;
    private T data;
    private Boolean success;

    /**
     * 获取响应状态码
     * 
     * @return 响应状态码，成功时通常为空字符串
     */
    public String getCode() {
        return code;
    }

    /**
     * 设置响应状态码
     * 
     * @param code 响应状态码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 获取响应消息
     * 
     * @return 响应消息，成功时通常为空字符串
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置响应消息
     * 
     * @param msg 响应消息
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * 获取响应数据
     * 
     * @return 实际响应数据
     */
    public T getData() {
        return data;
    }

    /**
     * 设置响应数据
     * 
     * @param data 响应数据
     */
    public void setData(T data) {
        this.data = data;
    }

    /**
     * 获取操作成功标志
     * 
     * @return 操作是否成功
     */
    public Boolean getSuccess() {
        return success;
    }

    /**
     * 设置操作成功标志
     * 
     * @param success 操作是否成功
     */
    public void setSuccess(Boolean success) {
        this.success = success;
    }
} 