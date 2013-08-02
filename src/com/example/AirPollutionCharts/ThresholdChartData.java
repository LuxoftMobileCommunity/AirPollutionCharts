package com.example.AirPollutionCharts;

import java.io.Serializable;

public class ThresholdChartData implements Serializable {
    private Double value;
    private int color;
    private int areaColor;

    public ThresholdChartData(Double value, int color, int areaColor) {
        this.value = value;
        this.color = color;
        this.areaColor = areaColor;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getAreaColor() {
        return areaColor;
    }

    public void setAreaColor(int areaColor) {
        this.areaColor = areaColor;
    }
}
