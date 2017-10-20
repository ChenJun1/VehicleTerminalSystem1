package com.cvnavi.app.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by wangshy on 17/7/6.
 */

public abstract class BaseFragment extends Fragment {
    Unbinder unbinder;


    /** Fragment当前状态是否可见 */
    protected boolean isVisible = false;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutID(), container, false);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public abstract int getLayoutID();

    public abstract void initView();

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
//        if (isVisible) { //已经加载过
//            return;
//        }
        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /** 可见 */
    protected void onVisible() {
        lazyLoad();
    }

    /**不可见*/
    protected void onInvisible() {

    }

    /**延迟加载    子类必须重写此方法 */
    protected abstract void lazyLoad();

}
