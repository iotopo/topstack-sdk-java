package com.iotopo.topstack.iot.device;

import com.fasterxml.jackson.databind.JavaType;
import com.iotopo.topstack.client.ResponseData;
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

import java.util.List;

/**
 * 设备管理 API
 * 
 * <p>提供设备查询、设备属性查询等功能的 API 接口。</p>
 * 
 * <p>主要功能：</p>
 * <ul>
 *   <li>分页查询设备列表</li>
 *   <li>查询设备属性</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * TopstackClient client = new TopstackClient("http://localhost:8000", "api-key", "project-id");
 * DeviceApi deviceApi = new DeviceApi(client);
 * 
 * // 查询设备列表
 * DeviceListRequest req = new DeviceListRequest();
 * req.setPageNum(1);
 * req.setPageSize(10);
 * ResponseData<DeviceListResponse> response = deviceApi.query(req);
 * 
 * // 查询设备属性
 * ResponseData<List<PropsQueryResponse.Property>> propsResponse = deviceApi.queryProps("device001");
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class DeviceApi {
    private final TopstackClient client;

    /**
     * 构造函数
     * 
     * @param client TopStack 客户端实例
     */
    public DeviceApi(TopstackClient client) {
        this.client = client;
    }

    /**
     * 分页查询设备列表
     * 
     * <p>根据查询条件分页获取设备列表。</p>
     * 
     * <p>API 路径：{@code GET /iot/open_api/v1/device/query}</p>
     * 
     * @param request 查询请求，包含分页参数和搜索条件
     * @return 包含设备列表的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see DeviceListRequest
     * @see DeviceListResponse
     */
    public ResponseData<DeviceListResponse> query(DeviceListRequest request) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, DeviceListResponse.class);
        return client.sendRequest("GET", "/iot/open_api/v1/device/query", request, type);
    }

    /**
     * 查询设备属性
     * 
     * <p>获取指定设备的所有属性信息。</p>
     * 
     * <p>API 路径：{@code GET /iot/open_api/v1/device/{deviceID}/props}</p>
     * 
     * @param deviceID 设备标识
     * @return 包含设备属性列表的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see PropsQueryResponse.Property
     */
    public ResponseData<List<PropsQueryResponse.Property>> queryProps(String deviceID) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, 
            client.getObjectMapper().getTypeFactory().constructCollectionType(List.class, PropsQueryResponse.Property.class));
        return client.sendRequest("GET", "/iot/open_api/v1/device/" + deviceID + "/props", null, type);
    }
} 