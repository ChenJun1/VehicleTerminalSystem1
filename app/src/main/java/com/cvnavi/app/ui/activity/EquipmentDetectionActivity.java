package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.MyFragmentPagerAdapter;
import com.cvnavi.app.ui.fragment.BusDetectionFragment;
import com.cvnavi.app.ui.fragment.TirePessureFragment;
import com.cvnavi.app.ui.fragment.VehicleSignalStatusFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.cvnavi.app.R.id.tablayout;
import static com.cvnavi.app.R.id.viewpager;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/31 09:25
 * version: 1.0
 * Depict:设备检测
 */

public class EquipmentDetectionActivity extends ToolbarActivity {


    @BindView(viewpager)
    ViewPager mViewpager;
    @BindView(tablayout)
    TabLayout mTablayout;
    @BindView(R.id.toolbar_layuot)
    LinearLayout mToolbarLayuot;
    private List<String> titles;

    public static void start(Context context) {
        Intent starter = new Intent(context, EquipmentDetectionActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment_detecion);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        setTitle("设备检测");
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getFragmentList());
        mViewpager.setAdapter(adapter);
        mViewpager.setOffscreenPageLimit(2);

        mTablayout.setupWithViewPager(mViewpager);
        titles = new ArrayList<>();
        titles.add("车辆信号状态");
        titles.add("TPMS胎压检测");
        titles.add("CAN总线监测");
        for (int i = 0; i < mTablayout.getTabCount(); i++) {
            TabLayout.Tab tab = mTablayout.getTabAt(i);
            tab.setCustomView(getTabView(i));
        }
    }

    private List<Fragment> getFragmentList() {
        List<Fragment> listFragment = new ArrayList<>();
        listFragment.add(new VehicleSignalStatusFragment());
        listFragment.add(new TirePessureFragment());
        listFragment.add(new BusDetectionFragment());
        return listFragment;
    }

    public View getTabView(int position) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_equipment_detection_tab, null);
        TextView txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_title.setText(titles.get(position));
        return view;
    }
}
