package com.iotopo.topstack.iot.gateway;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GatewayListResponse {
    private Long total;
    private List<GatewayItem> items;

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }
    
    public List<GatewayItem> getItems() { return items; }
    public void setItems(List<GatewayItem> items) { this.items = items; }
} 