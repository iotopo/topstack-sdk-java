package com.iotopo.topstack.alert.alerttype;

import com.iotopo.topstack.client.RequestData;

public class CreateRequest extends RequestData {
    private String name;
    private String description;
    private Integer level;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
} 