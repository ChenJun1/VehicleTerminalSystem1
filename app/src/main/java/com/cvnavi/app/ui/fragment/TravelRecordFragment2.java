package com.cvnavi.app.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.TravelRecordFragment2Adapter;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.FatigueDrivingBean;
import com.cvnavi.app.ui.activity.TravelRecordActivity;
import com.cvnavi.app.ui.activity.TravelRecordInfoActivity;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/18 11:33
 * version: 1.0
 * Depict:  超时驾驶记录
 */

public class TravelRecordFragment2 extends BaseListenerFragment{


    @BindView(R.id.lv)
    ListView mLv;

    List<FatigueDrivingBean.FatigueDrivingItem> mList = new ArrayList<>();
    TravelRecordFragment2Adapter adapter;

    @Override
    public int getLayoutID() {
        return R.layout.fram_travel_record_2;
    }

    TravelRecordActivity activity;
    boolean first=false;
    @Override
    public void initView() {
        activity = (TravelRecordActivity) getActivity();
        activity.send_11();
        first=true;
        adapter = new TravelRecordFragment2Adapter(getActivity(), mList);
        mLv.setAdapter(adapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TravelRecordInfoActivity.start(getActivity(), mFatigueDrivingBean);
            }
        });
    }

    @Override
    protected void lazyLoad() {
        if(first)
        activity.send_11();
    }

    FatigueDrivingBean mFatigueDrivingBean;

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        if (!AgreementUtils.agreement_11.equals(code))
            return;

        if (null == baseBean)
            return;

        if (null == baseBean.getModel())
            return;
        mFatigueDrivingBean = (FatigueDrivingBean) baseBean.getModel();
        adapter.UpdaListData(mFatigueDrivingBean.getRecords());
    }

    @Override
    public void sendMsg() {
    }


}
