package com.example.AirPollutionCharts;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.LinearLayout;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.TimeSeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class PollutionChartView extends LinearLayout {

    private List<PollutionChartData> data;
    private List<Double> thresholdValues;

    private GraphicalView mChart;

    private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();

    private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();
    private XYSeriesRenderer mDataSeriesRenderer = new XYSeriesRenderer();
    private XYSeriesRenderer mTresholdSeriesRenderer = new XYSeriesRenderer();

    private TimeSeries mCurrentSeries;
    private TimeSeries mTreshold1Series;

    private String chartTitle;
    private String xTitle;
    private String yTitle;

    private double treshold1 = 4;

    public PollutionChartView(Context context) {
        super(context);
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
        renderer.setInScroll(true);
        renderer.setClickEnabled(true);
        renderer.setPanEnabled(false, false);
        renderer.setShowLegend(false);
        renderer.setZoomButtonsVisible(false);

        return renderer;
    }

    private void addSampleData() {

        if (thresholdValues != null) {
            Iterator<Double> thresholdIterator = thresholdValues.iterator();
            Double value;
            while (thresholdIterator.hasNext()) {
                value = thresholdIterator.next();
                for (int i = 0; i < 24; i++) {
                    mTreshold1Series.add(getTodayWithHours(i), value);
                }
            }
        }

        for (int i = 0; i < 24; i++) {
            mCurrentSeries.add(getTodayWithHours(i), i / 3);
        }

//        mCurrentSeries.add(getTodayWithHours(12), 2);
//        mCurrentSeries.add(getTodayWithHours(13), 3);
//        mCurrentSeries.add(getTodayWithHours(14), 4);
//        mCurrentSeries.add(getTodayWithHours(15), 5);
//        mCurrentSeries.add(getTodayWithHours(16), 6);
//
//        mTreshold1Series.add(getTodayWithHours(12), treshold1);
//        mTreshold1Series.add(getTodayWithHours(13), treshold1);
//        mTreshold1Series.add(getTodayWithHours(14), treshold1);
//        mTreshold1Series.add(getTodayWithHours(15), treshold1);
//        mTreshold1Series.add(getTodayWithHours(16), treshold1);
    }

    private Date getTodayWithHours(int hours) {
        Date date = new Date(2013, 6, 25, hours, 0, 0);
        return date;
    }

    private void initChart() {

        mTreshold1Series = new TimeSeries("Treshold 1");
        mCurrentSeries = new TimeSeries("Factor 1");

        mDataset.addSeries(mTreshold1Series);
        mDataset.addSeries(mCurrentSeries);

        mRenderer = getRenderer();
        mRenderer.setChartTitle(this.chartTitle);

        mTresholdSeriesRenderer = new XYSeriesRenderer();
        mTresholdSeriesRenderer.setColor(Color.argb(200, 255, 0, 0));
        mRenderer.addSeriesRenderer(mTresholdSeriesRenderer);

        mDataSeriesRenderer = new XYSeriesRenderer();
        mDataSeriesRenderer.setColor(Color.WHITE);
        mRenderer.addSeriesRenderer(mDataSeriesRenderer);

    }

    public String getChartTitle() {
        return chartTitle;
    }

    public void setChartTitle(String chartTitle) {
        this.chartTitle = chartTitle;
        mRenderer.setChartTitle(this.chartTitle);
    }

    public String getXTitle() {
        return xTitle;
    }

    public void setXTitle(String xTitle) {
        this.xTitle = xTitle;
        mRenderer.setXTitle(this.xTitle);
    }

    public String getYTitle() {
        return yTitle;
    }

    public void setYTitle(String yTitle) {
        this.yTitle = yTitle;
        mRenderer.setYTitle(this.yTitle);
    }

    public double getTreshold1() {
        return treshold1;
    }

    public void setTreshold1(double treshold1) {
        this.treshold1 = treshold1;
    }

    public List<PollutionChartData> getData() {
        return data;
    }

    public void setData(List<PollutionChartData> data) {
        this.data = data;
        init();
    }

    private void init() {
        if (mChart != null) {
            removeView(mChart);
        }

        initChart();
        addSampleData();
        mChart = ChartFactory.getTimeChartView(this.getContext(), mDataset, mRenderer, "HH" + ":00:00");
        addView(mChart);
    }

    public List<Double> getThresholdValues() {
        return thresholdValues;
    }

    public void setThresholdValues(List<Double> thresholdValues) {
        this.thresholdValues = thresholdValues;
    }
}
