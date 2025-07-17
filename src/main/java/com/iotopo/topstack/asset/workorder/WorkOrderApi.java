package com.iotopo.topstack.asset.workorder;

import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

/**
 * 工单管理 API
 * 
 * <p>提供各种类型工单的查询和详情获取功能的 API 接口。</p>
 * 
 * <p>支持的工单类型：</p>
 * <ul>
 *   <li>告警工单（Alert Work Order）</li>
 *   <li>现场工单（Locale Work Order）</li>
 *   <li>维护工单（Maintenance Work Order）</li>
 *   <li>计划工单（Schedule Work Order）</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * TopstackClient client = new TopstackClient("http://localhost:8000", "api-key", "project-id");
 * 
 * // 查询告警工单
 * WorkOrderListRequest req = new WorkOrderListRequest();
 * req.setPageNum(1);
 * req.setPageSize(10);
 * WorkOrderListResponse response = WorkOrderApi.queryAlert(client, req);
 * 
 * // 获取工单详情
 * DetailRequest detailReq = new DetailRequest();
 * detailReq.setId("work-order-id");
 * DetailResponse detailResponse = WorkOrderApi.getAlertDetail(client, detailReq);
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class WorkOrderApi {
    
    /**
     * 查询告警工单列表
     * 
     * <p>根据查询条件分页获取告警工单列表。</p>
     * 
     * <p>API 路径：{@code GET /asset/open_api/v1/alert_work_order}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 查询请求，包含分页参数和筛选条件
     * @return 包含告警工单列表的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see WorkOrderListRequest
     * @see WorkOrderListResponse
     */
    public static WorkOrderListResponse queryAlert(TopstackClient client, WorkOrderListRequest request) throws TopstackException {
        return client.get("/asset/open_api/v1/alert_work_order", request, WorkOrderListResponse.class);
    }
    
    /**
     * 获取告警工单详情
     * 
     * <p>根据工单ID获取告警工单的详细信息。</p>
     * 
     * <p>API 路径：{@code GET /asset/open_api/v1/alert_work_order/{id}}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 详情请求，包含工单ID
     * @return 包含告警工单详细信息的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see DetailRequest
     * @see DetailResponse
     */
    public static DetailResponse getAlertDetail(TopstackClient client, DetailRequest request) throws TopstackException {
        return client.get("/asset/open_api/v1/alert_work_order/" + request.getId(), null, DetailResponse.class);
    }
    
    /**
     * 查询现场工单列表
     * 
     * <p>根据查询条件分页获取现场工单列表。</p>
     * 
     * <p>API 路径：{@code GET /asset/open_api/v1/locale_work_order}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 查询请求，包含分页参数和筛选条件
     * @return 包含现场工单列表的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see WorkOrderListRequest
     * @see WorkOrderListResponse
     */
    public static WorkOrderListResponse queryLocale(TopstackClient client, WorkOrderListRequest request) throws TopstackException {
        return client.get("/asset/open_api/v1/locale_work_order", request, WorkOrderListResponse.class);
    }
    
    /**
     * 获取现场工单详情
     * 
     * <p>根据工单ID获取现场工单的详细信息。</p>
     * 
     * <p>API 路径：{@code GET /asset/open_api/v1/locale_work_order/{id}}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 详情请求，包含工单ID
     * @return 包含现场工单详细信息的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see DetailRequest
     * @see DetailResponse
     */
    public static DetailResponse getLocaleDetail(TopstackClient client, DetailRequest request) throws TopstackException {
        return client.get("/asset/open_api/v1/locale_work_order/" + request.getId(), null, DetailResponse.class);
    }
    
    /**
     * 查询维护工单列表
     * 
     * <p>根据查询条件分页获取维护工单列表。</p>
     * 
     * <p>API 路径：{@code GET /asset/open_api/v1/maintenance_work_order}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 查询请求，包含分页参数和筛选条件
     * @return 包含维护工单列表的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see WorkOrderListRequest
     * @see WorkOrderListResponse
     */
    public static WorkOrderListResponse queryMaintenance(TopstackClient client, WorkOrderListRequest request) throws TopstackException {
        return client.get("/asset/open_api/v1/maintenance_work_order", request, WorkOrderListResponse.class);
    }
    
    /**
     * 获取维护工单详情
     * 
     * <p>根据工单ID获取维护工单的详细信息。</p>
     * 
     * <p>API 路径：{@code GET /asset/open_api/v1/maintenance_work_order/{id}}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 详情请求，包含工单ID
     * @return 包含维护工单详细信息的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see DetailRequest
     * @see DetailResponse
     */
    public static DetailResponse getMaintenanceDetail(TopstackClient client, DetailRequest request) throws TopstackException {
        return client.get("/asset/open_api/v1/maintenance_work_order/" + request.getId(), null, DetailResponse.class);
    }
    
    /**
     * 查询计划工单列表
     * 
     * <p>根据查询条件分页获取计划工单列表。</p>
     * 
     * <p>API 路径：{@code GET /asset/open_api/v1/schedule_work_order}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 查询请求，包含分页参数和筛选条件
     * @return 包含计划工单列表的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see WorkOrderListRequest
     * @see WorkOrderListResponse
     */
    public static WorkOrderListResponse querySchedule(TopstackClient client, WorkOrderListRequest request) throws TopstackException {
        return client.get("/asset/open_api/v1/schedule_work_order", request, WorkOrderListResponse.class);
    }
    
    /**
     * 获取计划工单详情
     * 
     * <p>根据工单ID获取计划工单的详细信息。</p>
     * 
     * <p>API 路径：{@code GET /asset/open_api/v1/schedule_work_order/{id}}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 详情请求，包含工单ID
     * @return 包含计划工单详细信息的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see DetailRequest
     * @see DetailResponse
     */
    public static DetailResponse getScheduleDetail(TopstackClient client, DetailRequest request) throws TopstackException {
        return client.get("/asset/open_api/v1/schedule_work_order/" + request.getId(), null, DetailResponse.class);
    }
} 