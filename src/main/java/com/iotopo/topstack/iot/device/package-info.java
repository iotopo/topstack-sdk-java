/**
 * TopStack SDK IoT 设备管理模块
 * 
 * <p>该包提供了 IoT 设备管理相关的功能，包括：</p>
 * <ul>
 *   <li>设备列表查询</li>
 *   <li>设备测点查询</li>
 *   <li>设备属性查询</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * // 查询设备列表
 * DeviceListResponse devices = DeviceApi.list(client, new DeviceListRequest());
 * 
 * // 查询设备测点
 * PointQueryResponse points = DeviceApi.queryPoints(client, new PointQueryRequest());
 * 
 * // 查询设备属性
 * PropsQueryResponse props = DeviceApi.queryProps(client, new PropsQueryRequest());
 * }</pre>
 * 
 * @see com.iotopo.topstack.iot.device.DeviceApi
 * @since 1.0.0
 */
package com.iotopo.topstack.iot.device; 