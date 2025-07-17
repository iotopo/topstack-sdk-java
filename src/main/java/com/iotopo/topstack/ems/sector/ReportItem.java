package com.iotopo.topstack.ems.sector;

import java.util.List;

public class ReportItem {
    private String timestamp;
    private Double totalValue;
    private List<EnergyTypeValue> energyTypes;

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Double totalValue) {
        this.totalValue = totalValue;
    }

    public List<EnergyTypeValue> getEnergyTypes() {
        return energyTypes;
    }

    public void setEnergyTypes(List<EnergyTypeValue> energyTypes) {
        this.energyTypes = energyTypes;
    }
} 