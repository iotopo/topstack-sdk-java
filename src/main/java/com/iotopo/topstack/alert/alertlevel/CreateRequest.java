package com.iotopo.topstack.alert.alertlevel;

public class CreateRequest {
    private Integer value;
    private String color;
    private String label;

    public Integer getValue() { return value; }
    public void setValue(Integer value) { this.value = value; }
    public String getColor() { return color; }
    public void setColor(String color) { this.color = color; }
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }
} 