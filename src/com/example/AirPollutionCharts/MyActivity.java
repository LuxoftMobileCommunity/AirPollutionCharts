package com.example.AirPollutionCharts;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MyActivity extends Activity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    protected void onResume() {
        super.onResume();
        LinearLayout layout = (LinearLayout) findViewById(R.id.chart);

        View chart = new PollutionChartView(this);
        chart.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, .80f));
        layout.addView(chart);

        View chart2 = new PollutionChartView(this);
        chart2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, .80f));
        layout.addView(chart2);

        View chart3 = new PollutionChartView(this);
        chart3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, .80f));
        layout.addView(chart3);

        View chart4 = new PollutionChartView(this);
        chart4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, .80f));
        layout.addView(chart4);

        View chart5 = new PollutionChartView(this);
        chart5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, .80f));
        layout.addView(chart5);


//        chart2.setVisibility(View.GONE);
//        chart3.setVisibility(View.GONE);
//        chart4.setVisibility(View.GONE);
//        chart5.setVisibility(View.GONE);
//
//        chart2.setVisibility(View.VISIBLE);


    }

}
