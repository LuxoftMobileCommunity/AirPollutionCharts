package com.example.AirPollutionCharts;

import java.util.Date;
import java.util.List;

public class PollutionChartData {

    private Date time;
    private Double value;

    public PollutionChartData(Date time, double value) {
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
