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

import java.util.ArrayList;

public class PollutionChartView extends LinearLayout {

    private ArrayList<PollutionChartData> dataList;
    private ArrayList<Double> thresholdValues;

    private GraphicalView mChart;

    private XYMultipleSeriesDataset mDataset = new XYMultipleSeriesDataset();

    private XYMultipleSeriesRenderer mRenderer = new XYMultipleSeriesRenderer();

    private String chartTitle;
    private String xTitle;
    private String yTitle;

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

    private void initChart() {

        mRenderer = getRenderer();
        mRenderer.setChartTitle(this.chartTitle);

        XYSeriesRenderer mTresholdSeriesRenderer;
        XYSeriesRenderer mDataSeriesRenderer;

        //init thresholds
        if (thresholdValues != null) {
            for (Double value : thresholdValues) {
                for (PollutionChartData data : dataList) {
                    TimeSeries thresholdSeries = new TimeSeries(data.getFactor() + " Threshold " + value);
                    for (Measurement measurement : data.getMeasurements()) {
                        thresholdSeries.add(measurement.getTime(), value);
                    }
                    mDataset.addSeries(thresholdSeries);
                    mTresholdSeriesRenderer = new XYSeriesRenderer();
                    mTresholdSeriesRenderer.setColor(Color.argb(200, 255, 0, 0));
                    mRenderer.addSeriesRenderer(mTresholdSeriesRenderer);
                }
            }
        }

        //init data
        TimeSeries dataSeries;
        for (PollutionChartData data : dataList) {
            dataSeries = new TimeSeries(data.getFactor());
            for (Measurement measurement : data.getMeasurements()) {
                dataSeries.add(measurement.getTime(), measurement.getValue());
            }
            mDataset.addSeries(dataSeries);
            mDataSeriesRenderer = new XYSeriesRenderer();
            mDataSeriesRenderer.setColor(Color.WHITE);
            mRenderer.addSeriesRenderer(mDataSeriesRenderer);
        }

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

    public ArrayList<PollutionChartData> getDataList() {
        return dataList;
    }

    public void setDataList(ArrayList<PollutionChartData> dataList) {
        this.dataList = dataList;
        init();
    }

    private void init() {
        if (mChart != null) {
            removeView(mChart);
        }

        initChart();
        mChart = ChartFactory.getTimeChartView(this.getContext(), mDataset, mRenderer, "HH" + ":00:00");
        addView(mChart);
    }

    public ArrayList<Double> getThresholdValues() {
        return thresholdValues;
    }

    public void setThresholdValues(ArrayList<Double> thresholdValues) {
        this.thresholdValues = thresholdValues;
    }
}
