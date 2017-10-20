package com.cvnavi.app;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.serialport.api.SerialPortDataHandler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cvnavi.app.adapter.MyFragmentPagerAdapter;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.service.CommService;
import com.cvnavi.app.ui.activity.ToolbarActivity;
import com.cvnavi.app.ui.fragment.AlarmInformationFragment;
import com.cvnavi.app.ui.fragment.MainFragment;
import com.cvnavi.app.ui.fragment.MoreFragment;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.DialogUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends ToolbarActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_local_music)
    TextView tvLocalMusic;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.lift_imagtwo)
    ImageView liftImagtwo;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;
    @BindView(R.id.toolbar_layuot)
    LinearLayout toolbarLayuot;
    @BindView(R.id.layout)
    LinearLayout layout;
    @BindView(R.id.button_frameLayout)
    FrameLayout buttonFrameLayout;
    @BindView(R.id.tablayout)
    TabLayout tablayout;

    private TextView toolbar_newstext;
    private TimeCount time;
    private View view;
    private long times = 10;
    private int[] tabIcons = {
            R.drawable.toolbar_vehicle_parameters,
            R.drawable.toolbar_alarminformation
            , R.drawable.toolbar_alarminformation
    };

    private List<String> titles;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void initData() {
        super.initData();
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getFragmentList());
        viewpager.setAdapter(adapter);
        viewpager.setOffscreenPageLimit(2);
        Intent serviceIntent = new Intent(MainActivity.this, CommService.class);
        startService(serviceIntent);
        tablayout.setupWithViewPager(viewpager);
        titles = new ArrayList<>();
        titles.add(getResources().getString(R.string.bottom_tabs_1));
        titles.add(getResources().getString(R.string.bottom_tabs_2));
        titles.add(getResources().getString(R.string.bottom_tabs_3));
        for (int i = 0; i < tablayout.getTabCount(); i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);
            tab.setCustomView(getTabView(i));
        }
//        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                RadioButton radioButton = (RadioButton) mainRadiogroup.getChildAt(position);
//                radioButton.setChecked(true);
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//        time = new TimeCount(times * 1000, 1000);
//        time.start();
    }

    @Override
    protected void initView() {
        setToolbarRightBack(View.GONE);

    }

    @Override
    protected void onDestroy() {
        SerialPortDataHandler.getInstance().close();
        super.onDestroy();
    }



//    /**
//     * @param event
//     * @return
//     */
//    @Override
//    public boolean dispatchTouchEvent(MotionEvent event) {
//        switch (event.getAction()) {
//            case MotionEvent.ACTION_UP:
//                if (toolbarLayuot.getVisibility() != View.VISIBLE) {
//                    toolbarLayuot.setVisibility(View.VISIBLE);
//                }
//                if (buttonFrameLayout.getVisibility() != View.GONE) {
//                    buttonFrameLayout.setVisibility(View.GONE);
//                }
//                if (null == time)
//                    time = new TimeCount(times * 1000, 1000);
//                time.cancel();
//                time.start();
//                break;
//        }
//        return super.dispatchTouchEvent(event);
//    }

    private List<Fragment> getFragmentList() {
        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(new MainFragment());
        listFragment.add(new AlarmInformationFragment());
        listFragment.add(new MoreFragment());
//        listFragment.add(new MainFragment());
//        listFragment.add(new MainFragment());
//        listFragment.add(new MainFragment());
//        listFragment.add(new MainFragment());
        return listFragment;
    }

//    @OnClick({R.id.framelayout})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.framelayout:
////                if (toolbarLayuot.getVisibility() != View.VISIBLE) {
////                    toolbarLayuot.setVisibility(View.VISIBLE);
////                }
////                if (buttonFrameLayout.getVisibility() != View.GONE) {
////                    buttonFrameLayout.setVisibility(View.GONE);
////                }
////                if (null == time)
////                    time = new TimeCount(times * 1000, 1000);
////                time.cancel();
////                time.start();
//                break;
//        }
//    }

//    @OnClick({R.id.radio_home, R.id.radio_alarm})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.radio_home:
//                viewpager.setCurrentItem(0);
//                break;MM
//            case R.id.radio_alarm:
//                viewpager.setCurrentItem(1);
//                break;
//        }
//    }

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        super.notifyAllActivity(code, baseBean);
//        toolbarDangertext.setText(baseBean.getWarning() + "");
        if (!AgreementUtils.agreement_47.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;
        if (null == view) {
            view = tablayout.getTabAt(1).getCustomView();
        }
        if (null == toolbar_newstext) {
            toolbar_newstext = (TextView) view.findViewById(R.id.toolbar_newstext);
        }
        if (null != toolbar_newstext) {
            if (baseBean.getWarning() > 0) {
                toolbar_newstext.setVisibility(View.VISIBLE);
                toolbar_newstext.setText(baseBean.getWarning() + "");
            } else {
                toolbar_newstext.setVisibility(View.GONE);
            }
        }
    }

    private class TimeCount extends CountDownTimer {
        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }

        @Override
        public void onFinish() {
            toolbarLayuot.setVisibility(View.GONE);
            buttonFrameLayout.setVisibility(View.VISIBLE);
//            mainRadiogroup.clearCheck();
        }
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setText(titles.get(position));
        ImageView img_title = (ImageView) view.findViewById(R.id.img_title);
        img_title.setImageResource(tabIcons[position]);
        return view;
    }

    @Override
    public void onBackPressed() {
        DialogUtils.showConfirmDialog(this, "是否退出程序?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                BaseApp.finishActivity();
            }
        });
    }
}

