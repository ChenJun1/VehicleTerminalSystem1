package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bigkoo.pickerview.TimePickerView;
import com.cvnavi.app.R;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.DateUtils;

import java.util.Calendar;
import java.util.Date;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/25 09:33
 * version: 1.0
 * Depict:时间设置
 */

public class TimeSetActivity extends ToolbarActivity {

    @BindView(R.id.year_tv)
    TextView mYearTv;
    @BindView(R.id.month_tv)
    TextView mMonthTv;
    @BindView(R.id.dd_tv)
    TextView mDdTv;
    @BindView(R.id.hh_tv)
    TextView mHhTv;
    @BindView(R.id.mm_tv)
    TextView mMmTv;
    @BindView(R.id.ss_tv)
    TextView mSsTv;
    @BindView(R.id.sjsz_rl)
    RelativeLayout mSjszRl;

    public static void start(Context context) {
        Intent starter = new Intent(context, TimeSetActivity.class);
        context.startActivity(starter);
    }


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_set);
    }

    @Override
    protected void initView() {
        setTitle("时间设置");
        showTimePickerDialog();
    }

    Calendar c;

    @Override
    protected void initData() {
        super.initData();
        c = Calendar.getInstance();
        if (!TextUtils.isEmpty(DateUtils.getDataTime())) {
            c.setTime(DateUtils.strToData(DateUtils.getDataTime(), DateUtils.dateFormat_1));
        }
        setViewData();
    }

    private void setViewData() {
        mYearTv.setText(c.get(Calendar.YEAR) + "");
        mMonthTv.setText((c.get(Calendar.MONTH) + 1) + "");
        mDdTv.setText(c.get(Calendar.DATE) + "");

        if (c.get(Calendar.HOUR_OF_DAY) < 10) {
            mHhTv.setText("0" + c.get(Calendar.HOUR_OF_DAY));
        } else {
            mHhTv.setText(c.get(Calendar.HOUR_OF_DAY) + "");
        }

        if (c.get(Calendar.MINUTE) < 10) {
            mMmTv.setText("0" + c.get(Calendar.MINUTE));
        } else {
            mMmTv.setText(c.get(Calendar.MINUTE) + "");
        }
        if (c.get(Calendar.SECOND) < 10) {
            mSsTv.setText("0" + c.get(Calendar.SECOND));
        } else {
            mSsTv.setText(c.get(Calendar.SECOND) + "");
        }

    }

    TimePickerView pvTime;

    private void showTimePickerDialog() {
        //时间选择器

        pvTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                c = DateUtils.dateToCalendar(date);
                ruquest(RequestDataManage.getInstance().getMain_02(ContentUtils.getDateTimeArry(c)));
                setViewData();
//                TimeSetActivity.this.finish();
            }

        }).setTitleText("时间设置")
                .isCyclic(true)
                .gravity(Gravity.TOP)
                .setContentSize(22)//滚轮文字大小
                .setTitleSize(24)
                .build();//标题文字大小.build();

        //注：根据需求来决定是否使用该方法（一般是精确到秒的情况），此项可以在弹出选择器的时候重新设置当前时间，
        // 避免在初始化之后由于时间已经设定，导致选中时间与当前时间不匹配的问题。
    }

    /**
     * 发送请求
     *
     * @param bytes
     */
    private void ruquest(byte[] bytes) {
        UIMessageManager.getInstance().send(bytes);
    }


    @OnClick(R.id.sjsz_rl)
    public void onViewClicked() {
        pvTime.setDate(c);
        pvTime.show();
    }

}
