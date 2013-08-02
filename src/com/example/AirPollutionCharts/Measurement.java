package com.example.AirPollutionCharts;

import java.io.Serializable;
import java.util.Date;

public class Measurement implements Serializable {
    private Date time;
    private Double value;

    public Measurement(Date time, double value) {
        this.time = time;
        this.value = value;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

}
