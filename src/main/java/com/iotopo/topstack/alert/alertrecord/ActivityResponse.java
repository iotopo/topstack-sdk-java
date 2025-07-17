package com.iotopo.topstack.alert.alertrecord;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ActivityResponse {
    private List<ActivityItem> items;
    private Integer total;

    public List<ActivityItem> getItems() { return items; }
    public void setItems(List<ActivityItem> items) { this.items = items; }
    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }
} 