package com.iotopo.topstack.iot.devicetype;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PointQueryResponse {
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Point {
        private String pointID;
        private String name;
        private String type;
        private String accessMode;
        private Integer orderNumber;
        private String description;
        private String group;
        private String unit;
        private String format;
        private Boolean edge;
        private Boolean isArray;
        private String generator;

        public String getPointID() { return pointID; }
        public void setPointID(String pointID) { this.pointID = pointID; }
        
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        
        public String getType() { return type; }
        public void setType(String type) { this.type = type; }
        
        public String getAccessMode() { return accessMode; }
        public void setAccessMode(String accessMode) { this.accessMode = accessMode; }
        
        public Integer getOrderNumber() { return orderNumber; }
        public void setOrderNumber(Integer orderNumber) { this.orderNumber = orderNumber; }
        
        public String getDescription() { return description; }
        public void setDescription(String description) { this.description = description; }
        
        public String getGroup() { return group; }
        public void setGroup(String group) { this.group = group; }
        
        public String getUnit() { return unit; }
        public void setUnit(String unit) { this.unit = unit; }
        
        public String getFormat() { return format; }
        public void setFormat(String format) { this.format = format; }
        
        public Boolean getEdge() { return edge; }
        public void setEdge(Boolean edge) { this.edge = edge; }
        
        public Boolean getIsArray() { return isArray; }
        public void setIsArray(Boolean isArray) { this.isArray = isArray; }
        
        public String getGenerator() { return generator; }
        public void setGenerator(String generator) { this.generator = generator; }
    }

    private Long total;
    private List<Point> items;

    public Long getTotal() { return total; }
    public void setTotal(Long total) { this.total = total; }
    
    public List<Point> getItems() { return items; }
    public void setItems(List<Point> items) { this.items = items; }
} 