package com.iotopo.topstack.ems.meter;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MeterItem {
    private String id;
    private String name;
    private String code;
    private String description;
    private String sectorId;
    private String sectorName;
    private String subentryId;
    private String subentryName;
    private String energyTypeId;
    private String energyTypeName;
    private String createTime;
    private String updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSectorId() {
        return sectorId;
    }

    public void setSectorId(String sectorId) {
        this.sectorId = sectorId;
    }

    public String getSectorName() {
        return sectorName;
    }

    public void setSectorName(String sectorName) {
        this.sectorName = sectorName;
    }

    public String getSubentryId() {
        return subentryId;
    }

    public void setSubentryId(String subentryId) {
        this.subentryId = subentryId;
    }

    public String getSubentryName() {
        return subentryName;
    }

    public void setSubentryName(String subentryName) {
        this.subentryName = subentryName;
    }

    public String getEnergyTypeId() {
        return energyTypeId;
    }

    public void setEnergyTypeId(String energyTypeId) {
        this.energyTypeId = energyTypeId;
    }

    public String getEnergyTypeName() {
        return energyTypeName;
    }

    public void setEnergyTypeName(String energyTypeName) {
        this.energyTypeName = energyTypeName;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
} 