package com.example.AirPollutionCharts;

import java.io.Serializable;

public class ThresholdData implements Serializable {
    private Double value;
    private int color;

    public ThresholdData(Double value, int color) {
        this.value = value;
        this.color = color;
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

}
