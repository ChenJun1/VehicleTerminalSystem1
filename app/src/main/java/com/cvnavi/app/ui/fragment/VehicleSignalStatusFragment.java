package com.cvnavi.app.ui.fragment;

import android.text.TextUtils;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.SignalStatusBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/31 10:47
 * version: 1.0
 * Depict:
 */

public class VehicleSignalStatusFragment extends BaseListenerFragment {
    SignalStatusBean mSignalStatusBean;
    @BindView(R.id.d0_tv)
    TextView mD0Tv;
    @BindView(R.id.d0_switch_tv)
    TextView mD0SwitchTv;
    @BindView(R.id.d7_tv)
    TextView mD7Tv;
    @BindView(R.id.d7_switch_tv)
    TextView mD7SwitchTv;
    @BindView(R.id.d4_tv)
    TextView mD4Tv;
    @BindView(R.id.d4_switch_tv)
    TextView mD4SwitchTv;
    @BindView(R.id.d6_tv)
    TextView mD6Tv;
    @BindView(R.id.d6_switch_tv)
    TextView mD6SwitchTv;
    @BindView(R.id.d1_tv)
    TextView mD1Tv;
    @BindView(R.id.d1_switch_tv)
    TextView mD1SwitchTv;
    @BindView(R.id.d2_tv)
    TextView mD2Tv;
    @BindView(R.id.d2_switch_tv)
    TextView mD2SwitchTv;
    @BindView(R.id.d3_tv)
    TextView mD3Tv;
    @BindView(R.id.d3_switch_tv)
    TextView mD3SwitchTv;
    @BindView(R.id.d5_tv)
    TextView mD5Tv;
    @BindView(R.id.d5_switch_tv)
    TextView mD5SwitchTv;

    @Override
    public void notifyAllActivity(String code, BaseBean modelBean) {

        if (!AgreementUtils.agreement_48.equals(code))
            return;

        if (null == modelBean)
            return;

        if (null == modelBean.getModel())
            return;

        if (null == mD0Tv)
            return;

        mSignalStatusBean = (SignalStatusBean) modelBean.getModel();
        if (!TextUtils.isEmpty(mSignalStatusBean.getD0Name()))
            mD0Tv.setText(mSignalStatusBean.getD0Name());

        mD0SwitchTv.setText(mSignalStatusBean.getD0State() > 0 ? "开" : "关");

        if (!TextUtils.isEmpty(mSignalStatusBean.getD7Name()))
            mD7Tv.setText(mSignalStatusBean.getD7Name());

        mD7SwitchTv.setText(mSignalStatusBean.getD7State() > 0 ? "开" : "关");

        if (!TextUtils.isEmpty(mSignalStatusBean.getD4Name()))
            mD4Tv.setText(mSignalStatusBean.getD4Name());

        mD4SwitchTv.setText(mSignalStatusBean.getD4State() > 0 ? "开" : "关");

        if (!TextUtils.isEmpty(mSignalStatusBean.getD6Name()))
            mD6Tv.setText(mSignalStatusBean.getD6Name());

        mD6SwitchTv.setText(mSignalStatusBean.getD6State() > 0 ? "开" : "关");

        if (!TextUtils.isEmpty(mSignalStatusBean.getD1Name()))
            mD1Tv.setText(mSignalStatusBean.getD1Name());

        mD1SwitchTv.setText(mSignalStatusBean.getD1State() > 0 ? "开" : "关");

        if (!TextUtils.isEmpty(mSignalStatusBean.getD2Name()))
            mD2Tv.setText(mSignalStatusBean.getD2Name());

        mD2SwitchTv.setText(mSignalStatusBean.getD2State() > 0 ? "开" : "关");

        if (!TextUtils.isEmpty(mSignalStatusBean.getD3Name()))
            mD3Tv.setText(mSignalStatusBean.getD3Name());

        mD3SwitchTv.setText(mSignalStatusBean.getD3State() > 0 ? "开" : "关");

        if (!TextUtils.isEmpty(mSignalStatusBean.getD5Name()))
            mD5Tv.setText(mSignalStatusBean.getD5Name());

        mD5SwitchTv.setText(mSignalStatusBean.getD5State() > 0 ? "开" : "关");
    }

    @Override
    public void sendMsg() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fram_vehicle_signal_status;
    }

    @Override
    public void initView() {
        ruquest(RequestDataManage.getInstance().getMain_48());
    }


    /**
     * 发送请求
     *
     * @param bytes
     */
    private void ruquest(byte[] bytes) {
        UIMessageManager.getInstance().send(bytes);
    }

    @Override
    protected void lazyLoad() {

    }

}
