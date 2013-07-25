package com.example.AirPollutionCharts;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.Date;

public class PollutionChartView extends LinearLayout {

    private GraphicalView mChart;

    private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();

    private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();

    private TimeSeries mCurrentSeries;

    public PollutionChartView(Context context) {
        super(context);
        initChart();
        addSampleData();
        mChart = ChartFactory.getTimeChartView(context, mDataset, mRenderer, "HH" + ":00:00");
        addView(mChart);
    }

    private XYMultipleSeriesRenderer getRenderer() {
        XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
        renderer.setApplyBackgroundColor(true);
        renderer.setBackgroundColor(Color.BLACK);
        renderer.setXLabelsColor(Color.YELLOW);
        renderer.setShowGrid(true);
        renderer.setYLabelsAlign(Paint.Align.LEFT);
        renderer.setChartTitle("Factor 1");
        renderer.setXTitle("Time");
        renderer.setYTitle("Pollution");
        renderer.setShowLegend(false);
        renderer.setZoomButtonsVisible(false);

        XYSeriesRenderer r = new XYSeriesRenderer();
        r.setColor(Color.WHITE);
        renderer.addSeriesRenderer(r);

        return renderer;
    }

    private void addSampleData() {
        mCurrentSeries.add(getTodayWithHours(12), 2);
        mCurrentSeries.add(getTodayWithHours(13), 3);
        mCurrentSeries.add(getTodayWithHours(14), 2);
        mCurrentSeries.add(getTodayWithHours(15), 5);
        mCurrentSeries.add(getTodayWithHours(16), 4);
    }

    private Date getTodayWithHours(int hours) {
        Date date = new Date(2013, 6, 25, hours, 0, 0);
        return date;
    }

    private void initChart() {

        mCurrentSeries = new TimeSeries("Factor 1");
        mDataset.addSeries(mCurrentSeries);

        mRenderer = getRenderer();
    }
}
