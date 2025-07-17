package com.iotopo.topstack.iot.devicetype;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DeviceTypeListResponse {
    private Long total;
    private List<DeviceTypeItem> items;

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }
    
    public List<DeviceTypeItem> getItems() { return items; }
    public void setItems(List<DeviceTypeItem> items) { this.items = items; }
} 