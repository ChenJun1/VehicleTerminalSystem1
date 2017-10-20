package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.AccidentRecordBean;
import com.cvnavi.app.utils.TextTransformationUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/1 11:17
 * version:
 * Depict:事故疑点曲线图
 */

public class AccidentGraphActivity extends ToolbarActivity {


    @BindView(R.id.endTime_tv)
    TextView mEndTimeTv;
    @BindView(R.id.longitude_tv)
    TextView mLongitudeTv;
    @BindView(R.id.latitude_tv)
    TextView mLatitudeTv;
    @BindView(R.id.altitude_tv)
    TextView mAltitudeTv;

    public static void start(Context context, AccidentRecordBean.AccidentRecordItem item) {
        Intent starter = new Intent(context, AccidentGraphActivity.class);
        starter.putExtra("bean", item);
        context.startActivity(starter);
    }

    @BindView(R.id.lineChart)
    LineChart mLineChart;
    AccidentRecordBean.AccidentRecordItem mRecordItem;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accident_graph);

    }

    @Override
    protected void initView() {
        setTitle("事故疑点曲线图");
        if (getIntent().getParcelableExtra("bean") != null) {
            mRecordItem = getIntent().getParcelableExtra("bean");
        }
        if (null == mRecordItem)
            return;

        if (!TextUtils.isEmpty(mRecordItem.getEndTime())) {
            mEndTimeTv.setText(mRecordItem.getEndTime().replace(" ", "\n"));
        }
        if (!TextUtils.isEmpty(mRecordItem.getLongitude()))
            mLongitudeTv.setText(mRecordItem.getLongitude());
        if (!TextUtils.isEmpty(mRecordItem.getLatitude()))
            mLatitudeTv.setText(mRecordItem.getLatitude());
        if (!TextUtils.isEmpty(mRecordItem.getAltitude()))
            mAltitudeTv.setText(mRecordItem.getAltitude() + "米");

        mLineChart.getAxisLeft().setAxisMaximum(180f);
        mLineChart.getAxisLeft().setAxisMinimum(0f);
        mLineChart.getAxisLeft().setDrawGridLines(false);
        mLineChart.getXAxis().setDrawGridLines(true);
        initChart(mLineChart);
        notifyDataSetChanged1(mLineChart, getData());
    }

    int[] d0 = new int[100];
    int[] d1 = new int[100];
    int[] d2 = new int[100];
    int[] d3 = new int[100];
    int[] d4 = new int[100];
    int[] d5 = new int[100];
    int[] d6 = new int[100];
    int[] d7 = new int[100];

    private List<List<Entry>> getData() {
        List<List<Entry>> dataList = new ArrayList<>();
        List<Entry> speedList = new ArrayList<>();
        int[] speed = mRecordItem.getSpeed();
        if(null==speed||speed.length<1)
            return null;

        for (int i = 0; i < speed.length; i++) {
            speedList.add(new Entry((float) 0.2 * i, speed[i]));
        }
        dataList.add(speedList);

        String[] state = mRecordItem.getState();
        if (null != state && state.length > 0) {
            String str;
            for (int i = 0; i < state.length; i++) {
                str = TextTransformationUtils.hexString2binaryString(state[i]);
                d0[i] = TextTransformationUtils.binaryToArray
                        (str)[7];
                d1[i] = TextTransformationUtils.binaryToArray
                        (str)[6];
                d2[i] = TextTransformationUtils.binaryToArray
                        (str)[5];
                d3[i] = TextTransformationUtils.binaryToArray
                        (str)[4];
                d4[i] = TextTransformationUtils.binaryToArray
                        (str)[3];
                d5[i] = TextTransformationUtils.binaryToArray
                        (str)[2];
                d6[i] = TextTransformationUtils.binaryToArray
                        (str)[1];
                d7[i] = TextTransformationUtils.binaryToArray
                        (str)[0];

            }
            List<Entry> d0List = new ArrayList<>();
            List<Entry> d1List = new ArrayList<>();
            List<Entry> d2List = new ArrayList<>();
            List<Entry> d3List = new ArrayList<>();
            List<Entry> d4List = new ArrayList<>();
            List<Entry> d5List = new ArrayList<>();
            List<Entry> d6List = new ArrayList<>();
            List<Entry> d7List = new ArrayList<>();
            for (int i = 0; i < d0.length; i++) {
                if (d0[i] == 1) {
                    d0List.add(new Entry((float) 0.2 * i, 180));
                } else {
                    if (d0List.size() > 0) {
                        dataList.add(d0List);
                        d0List = null;
                        d0List = new ArrayList<>();
                    }
                }

                if (d1[i] == 1) {
                    d1List.add(new Entry((float) 0.2 * i, 170));
                } else {
                    if (d1List.size() > 0) {
                        dataList.add(d1List);
                        d1List = null;
                        d1List = new ArrayList<>();
                    }
                }

                if (d2[i] == 1) {
                    d2List.add(new Entry((float) 0.2 * i, 160));
                } else {
                    if (d2List.size() > 0) {
                        dataList.add(d2List);
                        d2List = null;
                        d2List = new ArrayList<>();
                    }
                }

                if (d3[i] == 1) {
                    d3List.add(new Entry((float) 0.2 * i, 150));
                } else {
                    if (d3List.size() > 0) {
                        dataList.add(d3List);
                        d3List = null;
                        d3List = new ArrayList<>();
                    }
                }

                if (d4[i] == 1) {
                    d4List.add(new Entry((float) 0.2 * i, 140));
                } else {
                    if (d4List.size() > 0) {
                        dataList.add(d4List);
                        d4List = null;
                        d4List = new ArrayList<>();
                    }
                }

                if (d5[i] == 1) {
                    d5List.add(new Entry((float) 0.2 * i, 130));
                } else {
                    if (d5List.size() > 0) {
                        dataList.add(d5List);
                        d5List = null;
                        d5List = new ArrayList<>();
                    }
                }

                if (d6[i] == 1) {
                    d6List.add(new Entry((float) 0.2 * i, 120));
                } else {
                    if (d6List.size() > 0) {
                        dataList.add(d6List);
                        d6List = null;
                        d6List = new ArrayList<>();
                    }
                }

                if (d7[i] == 1) {
                    d7List.add(new Entry((float) 0.2 * i, 110));
                } else {
                    if (d7List.size() > 0) {
                        dataList.add(d7List);
                        d7List = null;
                        d7List = new ArrayList<>();
                    }
                }
            }
            if (d0List != null && d0List.size() > 0)
                dataList.add(d0List);
            if (d1List != null && d1List.size() > 0)
                dataList.add(d1List);
            if (d2List != null && d2List.size() > 0)
                dataList.add(d2List);
            if (d3List != null && d3List.size() > 0)
                dataList.add(d3List);
            if (d4List != null && d4List.size() > 0)
                dataList.add(d4List);
            if (d5List != null && d5List.size() > 0)
                dataList.add(d5List);
            if (d6List != null && d6List.size() > 0)
                dataList.add(d6List);
            if (d7List != null && d7List.size() > 0)
                dataList.add(d7List);
        }

        return dataList;
    }

    /**
     * 初始化图表
     *
     * @param chart 原始图表
     * @return 初始化后的图表
     */
    public LineChart initChart(LineChart chart) {
        // 不显示数据描述
        chart.getDescription().setEnabled(true);
        // 没有数据的时候，显示“暂无数据”
        chart.setNoDataText("暂无数据");
        // 不显示表格颜色
        chart.setDrawGridBackground(false);
        // 不可以缩放
        chart.setScaleEnabled(false);
        // 不显示y轴右边的值
        chart.getAxisRight().setEnabled(false);
        // 不显示图例
        Legend legend = chart.getLegend();
        legend.setEnabled(false);
        // 向左偏移15dp，抵消y轴向右偏移的30dp
        chart.setExtraLeftOffset(-15);

        XAxis xAxis = chart.getXAxis();
        // 不显示x轴
        xAxis.setDrawAxisLine(true);
        // 设置x轴数据的位置
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM_INSIDE);
        xAxis.setTextColor(Color.WHITE);
        xAxis.setTextSize(18f);
        xAxis.setGridColor(Color.parseColor("#30FFFFFF"));
        // 设置x轴数据偏移量
        xAxis.setYOffset(-10);

        xAxis.setLabelCount(5, true);
        xAxis.setAxisMinimum(0);
        xAxis.setAxisMaximum(20);
        YAxis yAxis = chart.getAxisLeft();
        //Y轴显示数量
        yAxis.setLabelCount(18);
        // 不显示y轴
        yAxis.setDrawAxisLine(false);
        // 设置y轴数据的位置
        yAxis.setPosition(YAxis.YAxisLabelPosition.OUTSIDE_CHART);
        // 不从y轴发出横向直线
        yAxis.setDrawGridLines(false);
        yAxis.setTextColor(Color.WHITE);
        yAxis.setTextSize(18f);
        // 设置y轴数据偏移量
        yAxis.setXOffset(20);
        yAxis.setYOffset(-3);


//        yAxis.setAxisMinimum(0);
        //Matrix matrix = new Matrix();
        // x轴缩放1.5倍
        //matrix.postScale(1.5f, 1f);
        // 在图表动画显示之前进行缩放
        //chart.getViewPortHandler().refresh(matrix, chart, false);
        // x轴执行动画
//        chart.animateX(2000);
        chart.invalidate();
        return chart;
    }


    /**
     * 设置图表数据
     *
     * @param chart  图表
     * @param values 数据
     */
    public void setChartData2(LineChart chart, List<List<Entry>> values) {
        LineDataSet lineDataSet;
        if(null==values)
            return;
        List<ILineDataSet> li = new ArrayList<>();
        for (List<Entry> value : values) {
            lineDataSet = new LineDataSet(value, "a");
            // 设置曲线颜色
            lineDataSet.setColor(Color.parseColor("#FFFFFF"));
            // 设置平滑曲线
            lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
            // 不显示坐标点的小圆点
            lineDataSet.setDrawCircles(false);
            //设置画圆孔
//            lineDataSet.setDrawCircleHole(true);
            // 不显示坐标点的数据
            lineDataSet.setDrawValues(false);
            lineDataSet.setValueTextColor(Color.parseColor("#FFFFFF"));
            // 不显示定位线
            lineDataSet.setHighlightEnabled(true);
            //曲线宽度
            lineDataSet.setLineWidth(2f);
            li.add(lineDataSet);
        }

        LineData data = new LineData(li);
        chart.setData(data);
        chart.invalidate();
    }


    /**
     * 更新图表
     *
     * @param chart  图表
     * @param values 数据
     * @param
     */
    public void notifyDataSetChanged1(LineChart chart, List<List<Entry>> values) {
        chart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return xValuesProcess()[(int) value / 5];
            }
        });
        chart.getAxisLeft().setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                if (value > 100) {
                    return YValuesProcess()[(int) value % 110 / 10];
                } else if (value == 100) {
                    return "速度(km/h)" + 100;
                } else {
                    return (int) value + "";
                }
            }
        });

        chart.invalidate();
        setChartData2(chart, values);
    }

    /**
     * x轴数据处理
     *
     * @param
     * @return x轴数据
     */
    private String[] xValuesProcess() {
        String[] week = {"0", "5", "10", "15", "20"};
        return week;
    }

    /**
     * Y轴数据处理
     *
     * @param
     * @return x轴数据
     */
    private String[] YValuesProcess() {
        String[] week = {"制动(D7)", "左转向(D6)", "右转向(D5)", "远光(D4)", "近光(D3)", "信号(D2)", "信号(D1)", "信号(D0)"};

        return week;
    }


}
