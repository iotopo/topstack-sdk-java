package com.iotopo.topstack.ems.subentry;

public class EnergyTypeValue {
    private String energyTypeId;
    private String energyTypeName;
    private Double value;

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

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
} 