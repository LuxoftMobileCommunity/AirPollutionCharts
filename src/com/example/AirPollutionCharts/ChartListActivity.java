package com.example.AirPollutionCharts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class ChartListActivity extends Activity {

    private static final String TAG = "ChartListActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chartlist);

    }

    protected void onResume() {
        super.onResume();
        final LinearLayout layout = (LinearLayout) findViewById(R.id.chart);

        for (int i = 0; i < 10; i++) {
            final PollutionChartView chart = new PollutionChartView(this);
            chart.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, 120));
            chart.setChartTitle("Factor: " + i);
            chart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked " + ((PollutionChartView) v).getChartTitle());
                    Intent detailedChartIntent = new Intent(v.getContext(), DetailedChartActivity.class);
                    startActivityForResult(detailedChartIntent, 0);
                }
            });

            List<PollutionChartData> data = new ArrayList<PollutionChartData>();
            List<Double> thresholdValues = new ArrayList<Double>();
            thresholdValues.add(6.0);
            thresholdValues.add(3.0);

            chart.setThresholdValues(thresholdValues);
            chart.setData(data);
            layout.addView(chart);

        }

    }

}
