package com.example.AirPollutionCharts;

import java.io.Serializable;
import java.util.ArrayList;

public class PollutionChartData implements Serializable {

    private String factor;
    private ArrayList<Measurement> measurements;

    public PollutionChartData(String factor, ArrayList<Measurement> measurements) {
        this.factor = factor;
        this.measurements = measurements;
    }

    public String getFactor() {
        return factor;
    }

    public void setFactor(String factor) {
        this.factor = factor;
    }

    public ArrayList<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(ArrayList<Measurement> measurements) {
        this.measurements = measurements;
    }
}
