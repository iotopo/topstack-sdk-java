package com.iotopo.topstack.ems.meter;

import com.fasterxml.jackson.databind.JavaType;
import com.iotopo.topstack.client.ResponseData;
import com.iotopo.topstack.client.TopstackClient;
import com.iotopo.topstack.client.TopstackException;

/**
 * 仪表管理 API
 * 
 * <p>提供仪表查询、详情获取、报表查询等功能的 API 接口。</p>
 * 
 * <p>主要功能：</p>
 * <ul>
 *   <li>分页查询仪表列表</li>
 *   <li>获取仪表详细信息</li>
 *   <li>查询仪表报表数据</li>
 *   <li>查询仪表逐时能耗数据</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * TopstackClient client = new TopstackClient("http://localhost:8000", "api-key", "project-id");
 * 
 * // 查询仪表列表
 * MeterListRequest req = new MeterListRequest();
 * req.setPageNum(1);
 * req.setPageSize(10);
 * ResponseData<MeterListResponse> response = MeterApi.query(client, req);
 * 
 * // 查询仪表逐时能耗
 * ReportRequest reportReq = new ReportRequest();
 * reportReq.setStart("2024-01-01T00:00:00Z");
 * reportReq.setEnd("2024-01-02T00:00:00Z");
 * HourlyReportResponse reportResponse = MeterApi.getHourlyReport(client, reportReq);
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 */
public class MeterApi {
    
    /**
     * 分页查询仪表列表
     * 
     * <p>根据查询条件分页获取仪表列表。</p>
     * 
     * <p>API 路径：{@code GET /ems/open_api/v1/meter}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 查询请求，包含分页参数和筛选条件
     * @return 包含仪表列表的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see MeterListRequest
     * @see MeterListResponse
     */
    public static ResponseData<MeterListResponse> query(TopstackClient client, MeterListRequest request) throws TopstackException {
        JavaType type = client.getObjectMapper().getTypeFactory().constructParametricType(ResponseData.class, MeterListResponse.class);
        return client.sendRequest("GET", "/ems/open_api/v1/meter", request, type);
    }
    
    /**
     * 获取仪表详细信息
     * 
     * <p>根据仪表ID获取仪表的详细信息。</p>
     * 
     * <p>API 路径：{@code GET /ems/open_api/v1/meter/{id}}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 详情请求，包含仪表ID
     * @return 包含仪表详细信息的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see DetailRequest
     * @see DetailResponse
     */
    public static DetailResponse getDetail(TopstackClient client, DetailRequest request) throws TopstackException {
        return client.get("/ems/open_api/v1/meter/" + request.getId(), null, DetailResponse.class);
    }
    
    /**
     * 查询仪表报表数据
     * 
     * <p>查询指定时间范围内的仪表报表数据。</p>
     * 
     * <p>API 路径：{@code POST /ems/open_api/v1/report/meter/hourly}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 报表请求，包含时间范围和仪表信息
     * @return 包含报表数据的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see ReportRequest
     * @see ReportResponse
     */
    public static ReportResponse getReport(TopstackClient client, ReportRequest request) throws TopstackException {
        return client.post("/ems/open_api/v1/report/meter/hourly", request, ReportResponse.class);
    }
    
    /**
     * 查询仪表逐时能耗数据
     * 
     * <p>查询指定时间范围内每小时的仪表能耗数据。</p>
     * 
     * <p>API 路径：{@code GET /ems/open_api/v1/report/meters/hourly}</p>
     * 
     * @param client TopStack 客户端实例
     * @param request 报表请求，包含时间范围和仪表信息
     * @return 包含逐时能耗数据的响应
     * @throws TopstackException 当请求失败时
     * 
     * @see ReportRequest
     * @see HourlyReportResponse
     */
    public static HourlyReportResponse getHourlyReport(TopstackClient client, ReportRequest request) throws TopstackException {
        return client.get("/ems/open_api/v1/report/meters/hourly", request, HourlyReportResponse.class);
    }
} 