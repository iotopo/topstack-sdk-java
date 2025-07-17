package com.iotopo.topstack.iot;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JavaType;
import com.iotopo.topstack.client.ResponseData;
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

import java.util.List;

/**
 * IoT 数据接口 API
 * 
 * <p>提供 IoT 设备数据查询和控制的 API 接口，包括实时数据查询、历史数据查询、数据下发等功能。</p>
 * 
 * <p>主要功能：</p>
 * <ul>
 *   <li>单点实时数据查询</li>
 *   <li>多点实时数据查询</li>
 *   <li>历史数据查询</li>
 *   <li>单点数据下发</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * TopstackClient client = new TopstackClient("http://localhost:8000", "api-key", "project-id");
 * IotApi iotApi = new IotApi(client);
 * 
 * // 查询单点实时数据
 * FindLastRequest req = new FindLastRequest("device001", "temperature");
 * ResponseData<FindLastResponse> response = iotApi.findLast(req);
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class IotApi {
    private final TopstackClient client;

    /**
     * 构造函数
     * 
     * @param client TopStack 客户端实例
     */
    public IotApi(TopstackClient client) {
        this.client = client;
    }

    /**
     * 单点实时数据查询
     * 
     * <p>查询指定设备的指定测点的最新实时数据。</p>
     * 
     * <p>API 路径：{@code POST /iot/open_api/v1/data/findLast}</p>
     * 
     * @param req 查询请求，包含设备标识和测点标识
     * @return 包含实时数据的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see FindLastRequest
     * @see FindLastResponse
     */
    public ResponseData<FindLastResponse> findLast(FindLastRequest req) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, FindLastResponse.class);
        return client.sendRequest("POST", "/iot/open_api/v1/data/findLast", req, type);
    }

    /**
     * 多点实时数据查询
     * 
     * <p>批量查询多个设备的多个测点的最新实时数据。数组最大个数为100。</p>
     * 
     * <p>API 路径：{@code POST /iot/open_api/v1/data/findLastBatch}</p>
     * 
     * @param reqs 查询请求列表，每个请求包含设备标识和测点标识
     * @return 包含多个实时数据的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see FindLastRequest
     * @see FindLastResponse
     */
    public ResponseData<List<FindLastResponse>> findLastBatch(List<FindLastRequest> reqs) throws TopstackException {
        JavaType listType = client.getObjectMapper().getTypeFactory().constructParametricType(List.class, FindLastResponse.class);
        JavaType respType = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, listType);
        return client.sendRequest("POST", "/iot/open_api/v1/data/findLastBatch", reqs, respType);
    }

    /**
     * 单点数据下发
     * 
     * <p>向指定设备的指定测点下发控制指令。</p>
     * 
     * <p>API 路径：{@code POST /iot/open_api/v1/data/setValue}</p>
     * 
     * @param req 下发请求，包含设备标识、测点标识和要下发的值
     * @return 下发结果响应
     * @throws TopstackException 当请求失败时
     * 
     * @see SetValueRequest
     */
    public ResponseData<Object> setValue(SetValueRequest req) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, Object.class);
        return client.sendRequest("POST", "/iot/open_api/v1/data/setValue", req, type);
    }

    /**
     * 历史数据查询
     * 
     * <p>查询指定时间范围内指定设备测点的历史数据。</p>
     * 
     * <p>API 路径：{@code POST /iot/open_api/v1/data/query}</p>
     * 
     * @param req 查询请求，包含测点列表、时间范围、聚合方式等参数
     * @return 包含历史数据的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see HistoryRequest
     * @see HistoryResponse
     */
    public ResponseData<HistoryResponse> queryHistory(HistoryRequest req) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, HistoryResponse.class);
        return client.sendRequest("POST", "/iot/open_api/v1/data/query", req, type);
    }
} 