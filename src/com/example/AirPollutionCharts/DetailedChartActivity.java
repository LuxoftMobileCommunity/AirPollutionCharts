package com.example.AirPollutionCharts;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class DetailedChartActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailedchart);
    }

    protected void onResume() {
        super.onResume();
        final LinearLayout detailedChartContainer = (LinearLayout) findViewById(R.id.detailedChart);
        final LinearLayout chartLegendContainer = (LinearLayout) findViewById(R.id.chartLegend);

        final PollutionChartView detailedChart = new PollutionChartView(this);
        detailedChart.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        detailedChart.setChartTitle("Detailed Chart");
        detailedChart.setData(new ArrayList<PollutionChartData>());
        detailedChartContainer.addView(detailedChart);

        final PollutionChartView chartLegend = new PollutionChartView(this);
        chartLegend.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
        chartLegend.setChartTitle("Chart Legend");
        chartLegend.setData(new ArrayList<PollutionChartData>());
        chartLegendContainer.addView(chartLegend);


    }
}