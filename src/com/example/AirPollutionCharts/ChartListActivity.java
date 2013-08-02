package com.example.AirPollutionCharts;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class ChartListActivity extends Activity {

    private static final String TAG = "ChartListActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chartlist);

        init();
    }

    private void init() {
        final LinearLayout layout = (LinearLayout) findViewById(R.id.chart);

        for (int i = 0; i < 10; i++) {
            final PollutionChartView chart = new PollutionChartView(this);
            chart.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, 200));
            chart.setChartTitle("Factor: " + i);
            chart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Log.d(TAG, "clicked " + ((PollutionChartView) v).getChartTitle());
                    Intent detailedChartIntent = new Intent(v.getContext(), DetailedChartActivity.class);
                    detailedChartIntent.putExtra("chartData", ((PollutionChartView) v).getDataList());
                    detailedChartIntent.putExtra("thresholdValues", ((PollutionChartView) v).getThresholdValues());
                    startActivityForResult(detailedChartIntent, 0);
                }
            });

            ArrayList<PollutionChartData> data = createMockData("Factor " + i);
            ArrayList<ThresholdChartData> thresholdValues = createMockThresholds();

            chart.setThresholdValues(thresholdValues);
            chart.setDataList(data);
            layout.addView(chart);

        }
    }


    private ArrayList<PollutionChartData> createMockData(String factor) {
        ArrayList<Measurement> measurements = new ArrayList<Measurement>();
        measurements.add(new Measurement(new Date(2013, 7, 1, 10, 0), randomWithinRange(0, 40)));
        measurements.add(new Measurement(new Date(2013, 7, 1, 11, 0), randomWithinRange(0, 40)));
        measurements.add(new Measurement(new Date(2013, 7, 1, 12, 0), randomWithinRange(0, 40)));
        measurements.add(new Measurement(new Date(2013, 7, 1, 13, 0), randomWithinRange(0, 40)));
        measurements.add(new Measurement(new Date(2013, 7, 1, 14, 0), randomWithinRange(0, 40)));
        measurements.add(new Measurement(new Date(2013, 7, 1, 15, 0), randomWithinRange(0, 40)));
        measurements.add(new Measurement(new Date(2013, 7, 1, 16, 0), randomWithinRange(0, 40)));
        measurements.add(new Measurement(new Date(2013, 7, 1, 17, 0), randomWithinRange(0, 40)));

        ArrayList<PollutionChartData> data = new ArrayList<PollutionChartData>();
        data.add(new PollutionChartData(factor, measurements));

        return data;
    }

    private ArrayList<ThresholdChartData> createMockThresholds() {
        ArrayList<ThresholdChartData> thresholdValues = new ArrayList<ThresholdChartData>();
        thresholdValues.add(new ThresholdChartData((double)randomWithinRange(20, 30), Color.RED, Color.argb(60, 0, 255, 0)));
        return thresholdValues;
    }

    private int randomWithinRange(int min, int max) {
        return new Random().nextInt(max - min + 1) + min;
    }

}
