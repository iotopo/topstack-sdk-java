/**
 * TopStack SDK 告警管理模块
 * 
 * <p>该包提供了告警管理相关的功能，包括：</p>
 * <ul>
 *   <li>告警级别管理 (alertlevel)</li>
 *   <li>告警类型管理 (alerttype)</li>
 *   <li>告警记录管理 (alertrecord)</li>
 * </ul>
 * 
 * <p>使用示例：</p>
 * <pre>{@code
 * // 查询告警级别列表
 * AlertLevelListResponse levels = AlertLevelApi.list(client, new AlertLevelListRequest());
 * 
 * // 查询告警类型列表
 * AlertTypeListResponse types = AlertTypeApi.list(client, new AlertTypeListRequest());
 * 
 * // 查询告警记录列表
 * AlertRecordListResponse records = AlertRecordApi.list(client, new AlertRecordListRequest());
 * }</pre>
 * 
 * @see com.iotopo.topstack.alert.alertlevel.AlertLevelApi
 * @see com.iotopo.topstack.alert.alerttype.AlertTypeApi
 * @see com.iotopo.topstack.alert.alertrecord.AlertRecordApi
 * @since 1.0.0
 */
package com.iotopo.topstack.alert; 