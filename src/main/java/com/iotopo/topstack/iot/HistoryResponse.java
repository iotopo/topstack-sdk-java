package com.iotopo.topstack.iot;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import java.util.List;

/**
 * 历史数据查询响应
 * 
 * <p>包含指定时间范围内指定设备测点的历史数据。</p>
 * 
 * <p>响应结构：</p>
 * <ul>
 *   <li>{@code results}：查询结果列表，每个结果包含一个测点的历史数据</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * HistoryRequest req = new HistoryRequest();
 * // 设置查询参数...
 * ResponseData<HistoryResponse> response = iotApi.queryHistory(req);
 * if (response.getSuccess()) {
 *     HistoryResponse data = response.getData();
 *     for (HistoryResponse.Result result : data.getResults()) {
 *         System.out.println("设备: " + result.getDeviceID());
 *         System.out.println("测点: " + result.getPointID());
 *         for (HistoryResponse.Value value : result.getValues()) {
 *             System.out.println("时间: " + value.getTime() + ", 值: " + value.getValue());
 *         }
 *     }
 * }
 * }</pre>
 * 
 * @author TopStack SDK Team
 * @version 1.0.0
 * @since 1.0.0
 * @see IotApi#queryHistory(HistoryRequest)
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class HistoryResponse {
    
    /**
     * 历史数据查询结果
     * 
     * <p>表示一个测点的历史数据查询结果。</p>
     * 
     * <p>字段说明：</p>
     * <ul>
     *   <li>{@code deviceID}：设备标识</li>
     *   <li>{@code pointID}：测点标识</li>
     *   <li>{@code values}：历史数据值列表</li>
     * </ul>
     * 
     * @author TopStack SDK Team
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Result {
        private String deviceID;
        private String pointID;
        private List<Value> values;

        /**
         * 获取设备标识
         * 
         * @return 设备标识
         */
        public String getDeviceID() { return deviceID; }
        
        /**
         * 设置设备标识
         * 
         * @param deviceID 设备标识
         */
        public void setDeviceID(String deviceID) { this.deviceID = deviceID; }
        
        /**
         * 获取测点标识
         * 
         * @return 测点标识
         */
        public String getPointID() { return pointID; }
        
        /**
         * 设置测点标识
         * 
         * @param pointID 测点标识
         */
        public void setPointID(String pointID) { this.pointID = pointID; }
        
        /**
         * 获取历史数据值列表
         * 
         * @return 历史数据值列表
         */
        public List<Value> getValues() { return values; }
        
        /**
         * 设置历史数据值列表
         * 
         * @param values 历史数据值列表
         */
        public void setValues(List<Value> values) { this.values = values; }
    }
    
    /**
     * 历史数据值
     * 
     * <p>表示一个时间点的历史数据值，包含原始值和各种聚合值。</p>
     * 
     * <p>字段说明：</p>
     * <ul>
     *   <li>{@code value}：原始值或聚合值</li>
     *   <li>{@code first}：第一个值（聚合时）</li>
     *   <li>{@code last}：最后一个值（聚合时）</li>
     *   <li>{@code max}：最大值（聚合时）</li>
     *   <li>{@code min}：最小值（聚合时）</li>
     *   <li>{@code mean}：平均值（聚合时）</li>
     *   <li>{@code median}：中位数（聚合时）</li>
     *   <li>{@code sum}：总和（聚合时）</li>
     *   <li>{@code count}：数量（聚合时）</li>
     *   <li>{@code spread}：范围（聚合时）</li>
     *   <li>{@code stddev}：标准差（聚合时）</li>
     *   <li>{@code time}：时间戳，ISO 8601格式</li>
     * </ul>
     * 
     * @author TopStack SDK Team
     * @version 1.0.0
     * @since 1.0.0
     */
    public static class Value {
        private Object value;
        private Object first;
        private Object last;
        private Object max;
        private Object min;
        private Object mean;
        private Object median;
        private Object sum;
        private Object count;
        private Object spread;
        private Object stddev;
        private OffsetDateTime time;

        /**
         * 获取值
         * 
         * @return 原始值或聚合值
         */
        public Object getValue() { return value; }
        
        /**
         * 设置值
         * 
         * @param value 原始值或聚合值
         */
        public void setValue(Object value) { this.value = value; }
        
        /**
         * 获取第一个值
         * 
         * @return 第一个值（聚合时）
         */
        public Object getFirst() { return first; }
        
        /**
         * 设置第一个值
         * 
         * @param first 第一个值
         */
        public void setFirst(Object first) { this.first = first; }
        
        /**
         * 获取最后一个值
         * 
         * @return 最后一个值（聚合时）
         */
        public Object getLast() { return last; }
        
        /**
         * 设置最后一个值
         * 
         * @param last 最后一个值
         */
        public void setLast(Object last) { this.last = last; }
        
        /**
         * 获取最大值
         * 
         * @return 最大值（聚合时）
         */
        public Object getMax() { return max; }
        
        /**
         * 设置最大值
         * 
         * @param max 最大值
         */
        public void setMax(Object max) { this.max = max; }
        
        /**
         * 获取最小值
         * 
         * @return 最小值（聚合时）
         */
        public Object getMin() { return min; }
        
        /**
         * 设置最小值
         * 
         * @param min 最小值
         */
        public void setMin(Object min) { this.min = min; }
        
        /**
         * 获取平均值
         * 
         * @return 平均值（聚合时）
         */
        public Object getMean() { return mean; }
        
        /**
         * 设置平均值
         * 
         * @param mean 平均值
         */
        public void setMean(Object mean) { this.mean = mean; }
        
        /**
         * 获取中位数
         * 
         * @return 中位数（聚合时）
         */
        public Object getMedian() { return median; }
        
        /**
         * 设置中位数
         * 
         * @param median 中位数
         */
        public void setMedian(Object median) { this.median = median; }
        
        /**
         * 获取总和
         * 
         * @return 总和（聚合时）
         */
        public Object getSum() { return sum; }
        
        /**
         * 设置总和
         * 
         * @param sum 总和
         */
        public void setSum(Object sum) { this.sum = sum; }
        
        /**
         * 获取数量
         * 
         * @return 数量（聚合时）
         */
        public Object getCount() { return count; }
        
        /**
         * 设置数量
         * 
         * @param count 数量
         */
        public void setCount(Object count) { this.count = count; }
        
        /**
         * 获取范围
         * 
         * @return 范围（聚合时）
         */
        public Object getSpread() { return spread; }
        
        /**
         * 设置范围
         * 
         * @param spread 范围
         */
        public void setSpread(Object spread) { this.spread = spread; }
        
        /**
         * 获取标准差
         * 
         * @return 标准差（聚合时）
         */
        public Object getStddev() { return stddev; }
        
        /**
         * 设置标准差
         * 
         * @param stddev 标准差
         */
        public void setStddev(Object stddev) { this.stddev = stddev; }
        
        /**
         * 获取时间戳
         * 
         * @return 时间戳，ISO 8601格式
         */
        public OffsetDateTime getTime() { return time; }
        
        /**
         * 设置时间戳
         * 
         * @param time 时间戳
         */
        public void setTime(OffsetDateTime time) { this.time = time; }
    }
    
    private List<Result> results;
    
    /**
     * 获取查询结果列表
     * 
     * @return 查询结果列表
     */
    public List<Result> getResults() { return results; }
    
    /**
     * 设置查询结果列表
     * 
     * @param results 查询结果列表
     */
    public void setResults(List<Result> results) { this.results = results; }
} 