package com.cvnavi.app.ui.fragment;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.TravelRecordFragment1Adapter;
import com.cvnavi.app.bean.AccidentRecordBean;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.ui.activity.AccidentGraphActivity;
import com.cvnavi.app.ui.activity.TravelRecordActivity;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.DialogUtils;

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
 * Depict:  事故疑点
 */

public class TravelRecordFragment1 extends BaseListenerFragment {


    @BindView(R.id.lv)
    ListView mLv;

    List<AccidentRecordBean.AccidentRecordItem> mList = new ArrayList<>();
    TravelRecordFragment1Adapter adapter;

    @Override
    public int getLayoutID() {
        return R.layout.fram_travel_record_1;
    }

    TravelRecordActivity activity;
    boolean first=false;
    @Override
    public void initView() {
        activity = (TravelRecordActivity) getActivity();
        activity.send_10();
        first=true;
        DialogUtils.showSweetAlertDialog(activity);
        adapter = new TravelRecordFragment1Adapter(activity, mList);
        mLv.setAdapter(adapter);
        mLv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AccidentGraphActivity.start(getContext(),mList.get(position));
            }
        });
    }

    @Override
    protected void lazyLoad() {
        if(first)
        activity.send_10();
    }

    AccidentRecordBean mRecord;

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        if (!AgreementUtils.agreement_10.equals(code)) {
            return;
        }
        DialogUtils.hideSweetAlertDialog();

        if (null == baseBean) {
            return;
        }

        if (null == baseBean.getModel()) {
            return;
        }
        mRecord = (AccidentRecordBean) baseBean.getModel();
        mList=mRecord.getRecords();
        adapter.UpdaListData(mRecord.getRecords());

    }

    @Override
    public void sendMsg() {

    }


}
