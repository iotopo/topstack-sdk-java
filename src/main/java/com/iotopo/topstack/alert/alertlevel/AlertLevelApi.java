package com.iotopo.topstack.alert.alertlevel;

import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

/**
 * 告警等级管理 API
 * 
 * <p>提供告警等级的查询、创建、更新、删除等功能的 API 接口。</p>
 * 
 * <p>主要功能：</p>
 * <ul>
 *   <li>查询所有告警等级</li>
 *   <li>创建新的告警等级</li>
 *   <li>更新现有告警等级</li>
 *   <li>删除告警等级</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * TopstackClient client = new TopstackClient("http://localhost:8000", "api-key", "project-id");
 * 
 * // 查询所有告警等级
 * AlertLevelListRequest req = new AlertLevelListRequest();
 * AlertLevelListResponse response = AlertLevelApi.query(client, req);
 * 
 * // 创建告警等级
 * CreateRequest createReq = new CreateRequest();
 * createReq.setValue(1);
 * createReq.setColor("#FF0000");
 * createReq.setLabel("严重");
 * CreateResponse createResponse = AlertLevelApi.create(client, createReq);
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class AlertLevelApi {
    
    /**
     * 查询所有告警等级
     * 
     * <p>获取当前项目下的所有告警等级信息。</p>
     * 
     * <p>API 路径：{@code GET /alert/open_api/v1/alert_level}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 查询请求
     * @return 包含告警等级列表的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see AlertLevelListRequest
     * @see AlertLevelListResponse
     */
    public static AlertLevelListResponse query(TopstackClient client, AlertLevelListRequest request) throws TopstackException {
        return client.get("/alert/open_api/v1/alert_level", request, AlertLevelListResponse.class);
    }
    
    /**
     * 创建告警等级
     * 
     * <p>创建新的告警等级。</p>
     * 
     * <p>API 路径：{@code POST /alert/open_api/v1/alert_level}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 创建请求，包含告警等级值、颜色和标签
     * @return 创建结果响应
     * @throws TopstackException 当请求失败时
     * 
     * @see CreateRequest
     * @see CreateResponse
     */
    public static CreateResponse create(TopstackClient client, CreateRequest request) throws TopstackException {
        return client.post("/alert/open_api/v1/alert_level", request, CreateResponse.class);
    }
    
    /**
     * 更新告警等级
     * 
     * <p>更新现有告警等级的信息。</p>
     * 
     * <p>API 路径：{@code PUT /alert/open_api/v1/alert_level}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 更新请求，包含告警等级ID和要更新的信息
     * @return 更新结果响应
     * @throws TopstackException 当请求失败时
     * 
     * @see UpdateRequest
     * @see CreateResponse
     */
    public static CreateResponse update(TopstackClient client, UpdateRequest request) throws TopstackException {
        return client.put("/alert/open_api/v1/alert_level", request, CreateResponse.class);
    }
    
    /**
     * 删除告警等级
     * 
     * <p>删除指定的告警等级。</p>
     * 
     * <p>API 路径：{@code DELETE /alert/open_api/v1/alert_level}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 删除请求，包含要删除的告警等级值
     * @return 删除结果响应
     * @throws TopstackException 当请求失败时
     * 
     * @see DeleteRequest
     * @see CreateResponse
     */
    public static CreateResponse delete(TopstackClient client, DeleteRequest request) throws TopstackException {
        return client.delete("/alert/open_api/v1/alert_level", request, CreateResponse.class);
    }
} 