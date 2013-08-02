package com.example.AirPollutionCharts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DetailedChartActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailedchart);

        init();
    }

    private void init() {
        final LinearLayout detailedChartContainer = (LinearLayout) findViewById(R.id.detailedChart);
        final LinearLayout chartLegendContainer = (LinearLayout) findViewById(R.id.chartLegend);

        Intent intent = getIntent();
        ArrayList<PollutionChartData> data = (ArrayList<PollutionChartData>) intent.getSerializableExtra("chartData");
        ArrayList<Double> thresholdValues = (ArrayList<Double>) intent.getSerializableExtra("thresholdValues");

        final PollutionChartView detailedChart = new PollutionChartView(this);
        detailedChart.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        detailedChart.setChartTitle(data.get(0).getFactor());
        detailedChart.setThresholdValues(thresholdValues);
        detailedChart.setDataList(data);
        detailedChartContainer.addView(detailedChart);

        final PollutionChartView chartLegend = new PollutionChartView(this);
        chartLegend.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        chartLegend.setChartTitle("Chart Legend");
        chartLegend.setThresholdValues(thresholdValues);
        chartLegend.setDataList(data);
        chartLegendContainer.addView(chartLegend);
    }
}