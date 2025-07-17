package com.iotopo.topstack.alert.alertlevel;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.iotopo.topstack.client.RequestData;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AlertLevelListRequest extends RequestData {
    // 查询告警等级的请求参数
    // 这是一个空类，用于表示不需要参数的查询请求
} 