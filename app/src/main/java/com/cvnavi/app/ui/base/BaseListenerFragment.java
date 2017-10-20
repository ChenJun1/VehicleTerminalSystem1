package com.cvnavi.app.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.commanage.IListener;
import com.cvnavi.app.commanage.ListenerManager;

/**
 * Created by wangshy on 17/7/6.
 */

public abstract class BaseListenerFragment extends BaseFragment implements IListener<BaseBean> {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //注册
        ListenerManager.getInstance().registerListtener(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //解注册
        ListenerManager.getInstance().unRegisterListener(this);
    }
}
