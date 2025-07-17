package com.iotopo.topstack.alert.alertlevel;

public class UpdateRequest {
    private String id;
    private Integer value;
    private String color;
    private String label;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public Integer getValue() { return value; }
    public void setValue(Integer value) { this.value = value; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
} 