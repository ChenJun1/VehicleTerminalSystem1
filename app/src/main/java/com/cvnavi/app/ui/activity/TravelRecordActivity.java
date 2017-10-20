package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.MyFragmentPagerAdapter;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.fragment.TravelRecordFragment1;
import com.cvnavi.app.ui.fragment.TravelRecordFragment2;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.DateUtils;

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
 * Depict:　行驶记录
 */

public class TravelRecordActivity extends ToolbarActivity {

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
        Intent starter = new Intent(context, TravelRecordActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__travel_record);
        listFragment = new ArrayList<>();
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getFragmentList());
        mViewpager.setAdapter(adapter);
    }

    private List<Fragment> getFragmentList() {

        listFragment.add(new TravelRecordFragment1());
        listFragment.add(new TravelRecordFragment2());
        return listFragment;
    }

    @Override
    protected void initView() {
        setTitle("行驶记录");
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
                if (System.currentTimeMillis() - lastClick <= 1000)
                    break;
                lastClick = System.currentTimeMillis();

//                send_10();
                break;
            case R.id.inquire_rb:
                mViewpager.setCurrentItem(1);
                if (System.currentTimeMillis() - lastClick <= 1000)
                    break;
                lastClick = System.currentTimeMillis();

//                send_11();
                break;
        }
    }

    public void send_10() {
        ruquest(RequestDataManage.getInstance().getMain_10(getDateTime()));
    }

    public void send_11() {
        ruquest(RequestDataManage.getInstance().getMain_11(getDateTime()));
    }

    private int[] getDateTime() {
        //前两天
        int[] beforeDateTimeArry = ContentUtils.getDateTimeArry(
                DateUtils.dateToCalendar(
                        DateUtils.strToData(DateUtils.getDataTime(), DateUtils.dateFormat_1), Calendar.DATE, -1));
        //当前时间
        int[] nowDateTimeArry = ContentUtils.getDateTimeArry(
                DateUtils.dateToCalendar(
                        DateUtils.strToData(DateUtils.getDataTime(), DateUtils.dateFormat_1)));
        return ContentUtils.contact(beforeDateTimeArry, nowDateTimeArry);

    }

}
