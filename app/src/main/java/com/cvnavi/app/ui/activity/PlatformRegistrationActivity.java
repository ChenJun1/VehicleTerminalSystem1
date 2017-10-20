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
import com.cvnavi.app.ui.fragment.QuickRegistrationFragment;
import com.cvnavi.app.ui.fragment.RegularRegistrationFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/23 15:52
 * version:
 * Depict:
 */

public class PlatformRegistrationActivity extends ToolbarActivity {
    @BindView(R.id.conventional_time_rb)
    RadioButton mConventionalTimeRb;
    @BindView(R.id.fast_time_rb)
    RadioButton mFastTimeRb;
    @BindView(R.id.rg)
    RadioGroup mRg;
    @BindView(R.id.viewpager)
    ViewPager mViewpager;

    List<Fragment> mFragmentList;

    public static void start(Context context) {
        Intent starter = new Intent(context, PlatformRegistrationActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initView() {
        mFragmentList=new ArrayList<>();
        MyFragmentPagerAdapter adapter=new MyFragmentPagerAdapter(getSupportFragmentManager(),getFragmentList());
        mViewpager.setAdapter(adapter);

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

    private List<Fragment> getFragmentList() {
        mFragmentList.add(new RegularRegistrationFragment());
        mFragmentList.add(new QuickRegistrationFragment());
        return mFragmentList;

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_platform_registration);
    }

    @OnClick({R.id.conventional_time_rb, R.id.fast_time_rb})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.conventional_time_rb:
                mViewpager.setCurrentItem(0);
                break;
            case R.id.fast_time_rb:
                mViewpager.setCurrentItem(1);
                break;
        }
    }
}
