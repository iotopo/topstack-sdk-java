package com.iotopo.topstack.iot;

import java.util.List;

/**
 * 历史数据查询请求
 * 
 * <p>用于查询指定时间范围内指定设备测点的历史数据。</p>
 * 
 * <p>请求参数：</p>
 * <ul>
 *   <li>{@code points}：测点列表，必填</li>
 *   <li>{@code start}：起始时间，ISO 8601格式，必填</li>
 *   <li>{@code end}：结束时间，ISO 8601格式，必填</li>
 *   <li>{@code aggregation}：聚合方式，可选（first、last、avg、min、max、sum、count）</li>
 *   <li>{@code interval}：时间间隔，可选（如 "5s"、"1m"、"1h"、"1d"）</li>
 *   <li>{@code fill}：空值填充方式，可选</li>
 *   <li>{@code offset}：偏移量，可选</li>
 *   <li>{@code limit}：限制返回数量，可选</li>
 *   <li>{@code order}：排序方式，可选（asc、desc）</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * List<Point> points = Arrays.asList(
 *     new Point("device001", "temperature"),
 *     new Point("device001", "humidity")
 * );
 * 
 * HistoryRequest req = new HistoryRequest();
 * req.setPoints(points);
 * req.setStart("2024-01-01T00:00:00Z");
 * req.setEnd("2024-01-02T00:00:00Z");
 * req.setAggregation("avg");
 * req.setInterval("1h");
 * 
 * ResponseData<HistoryResponse> response = iotApi.queryHistory(req);
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 * @see IotApi#queryHistory(HistoryRequest)
 * @see Point
 */
public class HistoryRequest {
    private List<Point> points;
    private String start;
    private String end;
    private String aggregation;
    private String interval;
    private String fill;
    private Integer offset;
    private Integer limit;
    private String order;

    /**
     * 获取测点列表
     * 
     * @return 测点列表
     */
    public List<Point> getPoints() {
        return points;
    }

    /**
     * 设置测点列表
     * 
     * @param points 测点列表
     */
    public void setPoints(List<Point> points) {
        this.points = points;
    }

    /**
     * 获取起始时间
     * 
     * <p>ISO 8601格式的时间字符串，例如 "2024-01-01T00:00:00Z"</p>
     * 
     * @return 起始时间
     */
    public String getStart() {
        return start;
    }

    /**
     * 设置起始时间
     * 
     * @param start 起始时间，ISO 8601格式
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * 获取结束时间
     * 
     * <p>ISO 8601格式的时间字符串，例如 "2024-01-02T00:00:00Z"</p>
     * 
     * @return 结束时间
     */
    public String getEnd() {
        return end;
    }

    /**
     * 设置结束时间
     * 
     * @param end 结束时间，ISO 8601格式
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * 获取聚合方式
     * 
     * <p>可选值：first、last、avg、min、max、sum、count</p>
     * 
     * @return 聚合方式
     */
    public String getAggregation() {
        return aggregation;
    }

    /**
     * 设置聚合方式
     * 
     * @param aggregation 聚合方式
     */
    public void setAggregation(String aggregation) {
        this.aggregation = aggregation;
    }

    /**
     * 获取时间间隔
     * 
     * <p>时间间隔字符串，例如 "5s"、"1m"、"1h"、"1d"</p>
     * 
     * @return 时间间隔
     */
    public String getInterval() {
        return interval;
    }

    /**
     * 设置时间间隔
     * 
     * @param interval 时间间隔
     */
    public void setInterval(String interval) {
        this.interval = interval;
    }

    /**
     * 获取空值填充方式
     * 
     * @return 空值填充方式
     */
    public String getFill() {
        return fill;
    }

    /**
     * 设置空值填充方式
     * 
     * @param fill 空值填充方式
     */
    public void setFill(String fill) {
        this.fill = fill;
    }

    /**
     * 获取偏移量
     * 
     * @return 偏移量
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 设置偏移量
     * 
     * @param offset 偏移量
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 获取限制返回数量
     * 
     * @return 限制返回数量
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * 设置限制返回数量
     * 
     * @param limit 限制返回数量
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * 获取排序方式
     * 
     * <p>可选值：asc（升序）、desc（降序）</p>
     * 
     * @return 排序方式
     */
    public String getOrder() {
        return order;
    }

    /**
     * 设置排序方式
     * 
     * @param order 排序方式
     */
    public void setOrder(String order) {
        this.order = order;
    }
} 