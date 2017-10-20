package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.RealTimeBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/21 14:41
 * version:
 * Depict:
 */

public class RealTimeInformationActivity extends ToolbarActivity {

    @BindView(R.id.engineSpeed_tv)
    TextView mEngineSpeedTv;
    @BindView(R.id.cellVoltage_tv)
    TextView mCellVoltageTv;
    @BindView(R.id.externalVoltage_tv)
    TextView mExternalVoltageTv;
    @BindView(R.id.cumulativeFuelConsumption_tv)
    TextView mCumulativeFuelConsumptionTv;
    @BindView(R.id.temperature_tv)
    TextView mTemperatureTv;
    @BindView(R.id.oilPressure_tv)
    TextView mOilPressureTv;
    @BindView(R.id.instantaneousFuelConsumption_tv)
    TextView mInstantaneousFuelConsumptionTv;
    @BindView(R.id.engineTorque_tv)
    TextView mEngineTorqueTv;

    public static void start(Context context) {
        Intent starter = new Intent(context, RealTimeInformationActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fram_realtime_data_information_layout);
    }

    @Override
    protected void initView() {
        setTitle("实时数据信息");
        UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_20());
    }

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        super.notifyAllActivity(code, baseBean);
        if (!AgreementUtils.agreement_20.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;

        if (null == mEngineTorqueTv)
            return;

        RealTimeBean bean = (RealTimeBean) baseBean.getModel();
        if (null == bean)
            return;

        //引擎转速
        if (!TextUtils.isEmpty(bean.getEngineSpeed())) {
            mEngineSpeedTv.setText(bean.getEngineSpeed());
        }
        //电池电压
        if (!TextUtils.isEmpty(bean.getCellVoltage())) {
            mCellVoltageTv.setText(bean.getCellVoltage());
        }
        //外部电压
        if (!TextUtils.isEmpty(bean.getExternalVoltage())) {
            mExternalVoltageTv.setText(bean.getExternalVoltage());
        }
        //累计油耗
        if (!TextUtils.isEmpty(bean.getCumulativeFuelConsumption())) {
            mCumulativeFuelConsumptionTv.setText(bean.getCumulativeFuelConsumption());
        }
        //发动机水温
        if (!TextUtils.isEmpty(bean.getTemperature())) {
            mTemperatureTv.setText(bean.getTemperature());
        }
        //机油压力
        if (!TextUtils.isEmpty(bean.getOilPressure())) {
            mOilPressureTv.setText(bean.getOilPressure());
        }
        //瞬时油耗
        if (!TextUtils.isEmpty(bean.getInstantaneousFuelConsumption())) {
            mInstantaneousFuelConsumptionTv.setText(bean.getInstantaneousFuelConsumption());
        }
        //发动机扭矩
        if (!TextUtils.isEmpty(bean.getEngineTorque())) {
            mEngineTorqueTv.setText(bean.getEngineTorque());
        }
    }
}
