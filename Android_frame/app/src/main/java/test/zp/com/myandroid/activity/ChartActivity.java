package test.zp.com.myandroid.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;
import java.util.List;

import test.zp.com.myandroid.R;
import test.zp.com.myandroid.base.BaseActivity;
import test.zp.com.myandroid.base.BasePresenter;
import test.zp.com.myandroid.view.ColumnView;

/**
 * Created by change on 2018/9/28.
 * 图表Activity
 */

public class ChartActivity extends BaseActivity {
    private LineChart mLineChart;
    private LineChart mLineChart2;
    private List<String> mList = new ArrayList<>();
    private Button start;//开始绘制
    private LinearLayout column;//柱状图绘制的地方

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        mLineChart = (LineChart) findViewById(R.id.lineChart);
        mLineChart2 = (LineChart) findViewById(R.id.lineChart2);
        start = (Button)findViewById(R.id.start);
        column = (LinearLayout) findViewById(R.id.column);
        /**
         * 曲线图测试
         */
        initLineChart1();

        /**
         * 折线图测试
         */

        List<Integer> mList = new ArrayList<>();
        mList.add(1);
        mList.add(2);
        mList.add(3);
        mList.add(4);
        mList.add(5);
        mList.add(6);
        mList.add(7);
        initLineChart2(mList);


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //这里调用绘制方法  （也可以直接调用显示的）
                barChart();
            }
        });
    }




    private void initLineChart2(final List<Integer> list) {
        //显示边界
        mLineChart2.setDrawBorders(false);
        mLineChart2.setBorderWidth(1);

        /*添加虚线*/
        LimitLine ll1 = new LimitLine(3f, "优秀");
        ll1.setLineWidth(4f);
        ll1.enableDashedLine(10f, 10f, 0f);
        ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
        ll1.setTextSize(10f);
        //设置数据
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            entries.add(new Entry(i, (float) list.get(i)));
        }
        //一个LineDataSet就是一条线
        LineDataSet lineDataSet = new LineDataSet(entries, "");
        //线颜色
        lineDataSet.setColor(Color.parseColor("#FE8085"));
        //曲线宽度
        lineDataSet.setLineWidth(1.6f);
        //不显示圆点
        lineDataSet.setDrawCircles(false);
        //线条平滑
        lineDataSet.setMode(LineDataSet.Mode.HORIZONTAL_BEZIER);
        //设置折线图填充
//        lineDataSet.setDrawFilled(true);
        LineData data = new LineData(lineDataSet);
        //无数据时显示的文字
        mLineChart2.setNoDataText("暂无数据");
        //折线图不显示数值
        data.setDrawValues(false);
        //得到X轴
        XAxis xAxis = mLineChart2.getXAxis();
        //设置X轴的位置（默认在上方)
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //设置X轴坐标之间的最小间隔
        xAxis.setGranularity(1f);
        //设置X轴的刻度数量，第二个参数为true,将会画出明确数量（带有小数点），但是可能值导致不均匀，默认（6，false）
       //  xAxis.setLabelCount(list.size() / 6, false);
        xAxis.setLabelCount(7,false);
        //设置X轴的值（最小值、最大值、然后会根据设置的刻度数量自动分配刻度显示）
        xAxis.setAxisMinimum(0f);
        xAxis.setAxisMaximum((float) list.size());
        //不显示网格线
        xAxis.setDrawGridLines(true);
        // 设置轴线颜色
        xAxis.setAxisLineColor(Color.RED);
        // 标签倾斜
        xAxis.setLabelRotationAngle(0);
        // 设置轴线宽度
        xAxis.setAxisLineWidth(2);
        //设置X轴值为字符串
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return "";
//                int IValue = (int) value;
//                CharSequence format = DateFormat.format("MM/dd",
//                        System.currentTimeMillis() - (long) (list.size() - IValue) * 24 * 60 * 60 * 1000);
//                return format.toString();
            }
        });
        //得到Y轴
        YAxis yAxis = mLineChart2.getAxisLeft();
        YAxis rightYAxis = mLineChart2.getAxisRight();
        //设置Y轴是否显示
        rightYAxis.setEnabled(false); //右侧Y轴不显示
        //设置y轴坐标之间的最小间隔
        //不显示网格线
        yAxis.setDrawGridLines(true);
        // 添加虚线
        yAxis.addLimitLine(ll1);
        //设置Y轴坐标之间的最小间隔
        yAxis.setGranularity(1);
        //设置y轴的刻度数量
        //+2：最大值n就有n+1个刻度，在加上y轴多一个单位长度，为了好看，so+2
      //  yAxis.setLabelCount(Collections.max(list) + 2, false);
        yAxis.setLabelCount(5, false);
        //设置从Y轴值
        yAxis.setAxisMinimum(0f);
        //+1:y轴多一个单位长度，为了好看
       // yAxis.setAxisMaximum(Collections.max(list));
        //设置轴线颜色
        yAxis.setAxisLineColor(Color.YELLOW);
        yAxis.setAxisLineWidth(2);
        yAxis.setGridColor(Color.RED);
        //y轴
        yAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int IValue = (int) value;
                return String.valueOf(IValue);
            }
        });
        //图例：得到Lengend
        Legend legend = mLineChart2.getLegend();
        //隐藏Lengend
        legend.setEnabled(false);
        //隐藏描述
        Description description = new Description();
        description.setEnabled(false);
        mLineChart2.setDescription(description);

//        2.设置描述内容
//        Description description = new Description();
//        description.setText("X轴描述");
//        description.setTextColor(Color.RED);
//        mLineChart.setDescription(description);


//        //折线图点的标记
//        MyMarkerView mv = new MyMarkerView(this);
//        lineChart.setMarker(mv);
        //设置数据
        mLineChart2.setData(data);


        //图标刷新
        mLineChart2.invalidate();

    }

    private void initLineChart1() {
//        mLineChart.setTouchEnabled(false);
        //显示边界
        mLineChart.setDrawBorders(false);
        //设置数据
        List<Entry> entries = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            entries.add(new Entry(i, (float) (Math.random()) * 40));
        }
        //一个LineDataSet就是一条线
        LineDataSet lineDataSet = new LineDataSet(entries, "温度");
        LineData data = new LineData(lineDataSet);
        mList.add("周一");
        mList.add("周二");
        mList.add("周三");

        mList.add("周四");
        mList.add("周五");
        mList.add("周六");
        mList.add("周日");

        //1.得到X轴
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setAxisMinimum(0f);// x轴最小刻度
       xAxis.setAxisMaximum(6f);// x轴最大刻度
        // 设置X轴的位置（默认在上方）：
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //3.设置X轴坐标之间的最小间隔（因为此图有缩放功能，X轴,Y轴可设置可缩放）
        xAxis.setGranularity(1f);
        xAxis.setLabelCount(7, false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mList.get((int) value); //mList为存有月份的集合
                //  xAxis.setAxisMaximum(6f) // 会受这个刻度最大值影响
            }
        });

        // Y轴设置
        YAxis leftYAxis = mLineChart.getAxisLeft(); // 获取左Y轴线
        YAxis rightYAxis = mLineChart.getAxisRight(); // 获取有Y轴线

        leftYAxis.setAxisMinimum(0f); // 设置Y轴线最小最大值
        leftYAxis.setAxisMaximum(100f);


        rightYAxis.setAxisMinimum(0f);
        rightYAxis.setAxisMaximum(100f);
        rightYAxis.setEnabled(true); //右侧Y轴不显示


        rightYAxis.setGranularity(1f); // 右侧间隔小坐标
        rightYAxis.setLabelCount(6,false);
        rightYAxis.setTextColor(Color.BLUE); //文字颜色
        rightYAxis.setGridColor(Color.RED); //网格线颜色
        rightYAxis.setAxisLineColor(Color.GREEN); //Y轴颜色 //todo 滑动才能显示颜色


        // 添加限制线
        LimitLine limitLine = new LimitLine(95,"高限制性"); //得到限制线
        limitLine.setLineWidth(4f); //宽度
        limitLine.setTextSize(10f);
        limitLine.setTextColor(Color.RED);  //颜色
        limitLine.setLineColor(Color.BLUE);
        rightYAxis.addLimitLine(limitLine); //Y轴添加限制线

      //  三.Legend(图例：即上图所示的曲线图下面的 温度)


        Legend legend = mLineChart.getLegend();
        legend.setTextColor(Color.RED); //设置Legend 文本颜色
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM); // 图例位置
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);  // 居中
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL); // 水平or数值



        //  设置Y轴线显示
        leftYAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return (int) value + "%";
            }
        });




        /*escription(描述)*/
        Description description = new Description();
        description.setEnabled(false);
        mLineChart.setDescription(description);
        mLineChart.setData(data);



        /**
         *  设置曲线的数值显示为整数
         *
         */
        lineDataSet.setValueFormatter(new IValueFormatter() {
            @Override
            public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                int IValue = (int) value;
                return String.valueOf(IValue);
            }
        });




        //第二个参数表示是否平均分配 如果为true则按比例分为12个点、如果为false则适配X刻度的值来分配点，可能没有12个点
//        xAxis.setEnabled(false);
//        xAxis.setLabelCount(12,false);
//        mLineChart.getDescription().setEnabled(false);
//        //显示边界
//        mLineChart.setDrawBorders(false);
//        xAxis.setEnabled(true);
//        //设置数据
//        List<Entry> entries = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            entries.add(new Entry(i, (float) (Math.random()) * 40));
//        }
//        //一个LineDataSet就是一条线
//        LineDataSet lineDataSet = new LineDataSet(entries, "");
//        lineDataSet.setHighLightColor(Color.YELLOW); // 设置高亮颜色
//        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
//        lineDataSet.setHighlightEnabled(false);
//        lineDataSet.setDrawCircles(false); // 小圆圈
//        lineDataSet.setDrawValues(false); // 数值
//        LineData data = new LineData(lineDataSet);
//
//        YAxis rightYAxis = mLineChart.getAxisRight();
//        //设置Y轴是否显示
//        rightYAxis.setEnabled(false); //右侧Y轴不显示
//        mLineChart.setData(data);
    }


    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void setOnClickLintener() {

    }

    @Override
    protected BasePresenter loadParesenter() {
        return null;
    }

    @Override
    public void onClick(View v) {

    }
    // 初始化柱状图数据（可以根据自己需要插入数据）
    private void barChart() {
        //第一个为空，它需要占一个位置
        String[] transverse = {"","周一","周二","周三","周四","周五","周六","周日"};
        String[] vertical = {"0", "2h", "4h", "8h", "10h"};
        //这里的数据是根据你横列有几个来设的，如上面的横列星期有周一到周日，所以这里设置七个数据
        int[] data = {420 , 380, 340, 300, 260, 220, 180};
        //这里的颜色就对应线条、文字和柱状图（可以根据自己的需要到color里设置）
        List<Integer> color = new ArrayList<>();
        color.add(R.color.colorAccent);
        color.add(R.color.colorPrimary);
        color.add(R.color.colorPrimaryDark);
        column.addView(new ColumnView(this, transverse, vertical, color, data));
    }


}
