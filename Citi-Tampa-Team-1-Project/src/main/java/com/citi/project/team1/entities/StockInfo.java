package com.citi.project.team1.entities;

public class StockInfo {
    String name;
    Double value;

    public StockInfo(){}

    public StockInfo(String name, Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }
}

