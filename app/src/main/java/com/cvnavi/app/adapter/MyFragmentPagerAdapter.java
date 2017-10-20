package com.cvnavi.app.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;


public class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {
    private List<Fragment> fragmentsList;

    /**
     * 这个构造方法把ArrayList<Fragment>传过来
     *
     * @param fm
     * @param fragments
     */
    public MyFragmentPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.fragmentsList = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentsList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentsList == null ? 0 : fragmentsList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return super.getPageTitle(position);
    }
}
