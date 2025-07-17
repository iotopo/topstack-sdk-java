/**
 * TopStack SDK IoT 设备类型管理模块
 * 
 * <p>该包提供了 IoT 设备类型管理相关的功能，包括：</p>
 * <ul>
 *   <li>设备类型列表查询</li>
 *   <li>设备类型测点查询</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * // 查询设备类型列表
 * DeviceTypeListResponse types = DeviceTypeApi.list(client, new DeviceTypeListRequest());
 * 
 * // 查询设备类型测点
 * PointQueryResponse points = DeviceTypeApi.queryPoints(client, new PointQueryRequest());
 * }</pre>
 * 
 * @see com.iotopo.topstack.iot.devicetype.DeviceTypeApi
 * @since 1.0.0
 */
package com.iotopo.topstack.iot.devicetype; 