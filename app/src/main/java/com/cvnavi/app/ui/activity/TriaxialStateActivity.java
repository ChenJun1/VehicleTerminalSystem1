package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.MyFragmentPagerAdapter;
import com.cvnavi.app.ui.fragment.EquipmentTestingFragment;
import com.cvnavi.app.ui.fragment.InitializationFrament;
import com.cvnavi.app.ui.fragment.TriaxialStateFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 设备管理工程菜单
 */
public class TriaxialStateActivity extends ToolbarActivity {
    public static void onStar(Context context) {
        context.startActivity(new Intent(context, TriaxialStateActivity.class));
    }

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager_view)
    ViewPager viewpagerView;
    private List<String> list = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_triaxial_state);
    }

    @Override
    protected void initView() {
        setTitle("工程菜单");
        if (null == list)
            list = new ArrayList<>();
        list.add("初始化项");
        list.add("设备测试");
        list.add("三轴设备");
        MyFragmentPagerAdapter adapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), getFragmentList());
        viewpagerView.setAdapter(adapter);
        tablayout.setupWithViewPager(viewpagerView);
        for (int i = 0; i < tablayout.getTabCount(); i++) {
            TabLayout.Tab tab = tablayout.getTabAt(i);
            tab.setCustomView(getView(i));
        }
    }

    private View getView(int index) {
        TextView view = new TextView(this);
        view.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        view.setTextSize(18f);
        view.setTextColor(getResources().getColorStateList(R.color.selector_tab_color));
        view.setGravity(Gravity.CENTER);
        view.setText(list.get(index));
        return view;
    }

    public List<Fragment> getFragmentList() {
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(new InitializationFrament());
        fragmentList.add(new EquipmentTestingFragment());
        fragmentList.add(new TriaxialStateFragment());
        return fragmentList;
    }
}
