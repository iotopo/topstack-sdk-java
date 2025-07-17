package com.iotopo.topstack.ems.meter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeterListResponse {
    private Long total;
    private List<MeterItem> items;

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }
    
    public List<MeterItem> getItems() { return items; }
    public void setItems(List<MeterItem> items) { this.items = items; }
} 