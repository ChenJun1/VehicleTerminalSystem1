package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.MyFragmentPagerAdapter;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.customize.DoubleDatePickerDialog;
import com.cvnavi.app.ui.fragment.DrivingScoreFragment1;
import com.cvnavi.app.ui.fragment.DrivingScoreFragment2;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.DateUtils;
import com.cvnavi.app.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/18 09:39
 * version: 1.0
 * Depict:优秀驾驶
 */

public class DrivingScoreActivity extends ToolbarActivity {

    @BindView(R.id.viewpager)
    ViewPager mViewpager;
    @BindView(R.id.real_time_rb)
    RadioButton mRealTimeRb;
    @BindView(R.id.inquire_rb)
    RadioButton mInquireRb;
    @BindView(R.id.rg)
    RadioGroup mRg;

    List<Fragment> listFragment;

    public static void start(Context context) {
        Intent starter = new Intent(context, DrivingScoreActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driving_score);
        listFragment = new ArrayList<>();
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getFragmentList());
        mViewpager.setAdapter(adapter);
    }

    private List<Fragment> getFragmentList() {

        listFragment.add(new DrivingScoreFragment1());
        listFragment.add(new DrivingScoreFragment2());
        return listFragment;
    }

    @Override
    protected void initView() {
        setTitle("优秀驾驶");
        mViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                RadioButton rb = (RadioButton) mRg.getChildAt(position);
                rb.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

    }

    /**
     * 日期选择器
     */
    private void showDatePickerDialog() {
        Calendar c = Calendar.getInstance();
        if (!TextUtils.isEmpty(DateUtils.getDataTime()))
            c.setTime(DateUtils.strToData(DateUtils.getDataTime(), DateUtils.dateFormat_1));
        // 最后一个false表示不显示日期，如果要显示日期，最后参数可以是true或者不用输入
        new DoubleDatePickerDialog(DrivingScoreActivity.this, 0, new DoubleDatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker startDatePicker, int startYear, int startMonthOfYear,
                                  int startDayOfMonth, DatePicker endDatePicker, int endYear, int endMonthOfYear,
                                  int endDayOfMonth) {

                boolean isflag = ContentUtils.isComparison(startYear, startMonthOfYear + 1, startDayOfMonth, endYear, endMonthOfYear + 1, endDayOfMonth);
                if (isflag) {
                    int[] data = {startYear, startMonthOfYear + 1, startDayOfMonth, endYear, endMonthOfYear + 1, endDayOfMonth};
                    //发送数据请求
                    ruquest(RequestDataManage.getInstance().getMain_57_01(data));
                } else {
                    ToastUtils.showToast("开始时间不能大于结束时间");
                }
            }
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DATE), true).show();
    }

    /**
     * 发送请求
     *
     * @param bytes
     */
    private void ruquest(byte[] bytes) {
        UIMessageManager.getInstance().send(bytes);
    }


    @Override
    public void sendMsg() {
        super.sendMsg();
    }

    long lastClick;

    @OnClick({R.id.real_time_rb, R.id.inquire_rb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.real_time_rb:
                mViewpager.setCurrentItem(0);
                break;
            case R.id.inquire_rb:
                mViewpager.setCurrentItem(1);
                if (System.currentTimeMillis() - lastClick <= 1000)
                    break;
                showDatePickerDialog();
                lastClick = System.currentTimeMillis();
                break;
        }
    }
}
