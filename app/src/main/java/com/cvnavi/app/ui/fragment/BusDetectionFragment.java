package com.cvnavi.app.ui.fragment;

import android.text.TextUtils;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.CanBusMonitorBean;
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
 * CreatedTime:  2017/7/31 11:51
 * version: 1.0
 * Depict: CAN 总线监测
 */

public class BusDetectionFragment extends BaseListenerFragment {
    @BindView(R.id.sensorOil_tv)
    TextView mSensorOilTv;
    @BindView(R.id.engineSpeed_tv)
    TextView mEngineSpeedTv;
    @BindView(R.id.oilConsumption_tv)
    TextView mOilConsumptionTv;
    @BindView(R.id.engineTorque_tv)
    TextView mEngineTorqueTv;
    @BindView(R.id.pedalPosition_tv)
    TextView mPedalPositionTv;
    @BindView(R.id.allConsumption_tv)
    TextView mAllConsumptionTv;
    @BindView(R.id.meterOilConsumption_tv)
    TextView mMeterOilConsumptionTv;
    @BindView(R.id.totalTime_tv)
    TextView mTotalTimeTv;
    @BindView(R.id.waterTemperature_tv)
    TextView mWaterTemperatureTv;
    @BindView(R.id.engineOilTemperature_tv)
    TextView mEngineOilTemperatureTv;
    @BindView(R.id.intakeTemperature_tv)
    TextView mIntakeTemperatureTv;
    @BindView(R.id.oilPressure_tv)
    TextView mOilPressureTv;
    @BindView(R.id.atmosphericPressure_tv)
    TextView mAtmosphericPressureTv;

    CanBusMonitorBean mBean;

    @Override
    public void notifyAllActivity(String code, BaseBean modelBean) {
        if (!AgreementUtils.agreement_10.equals(code))
            return;

        if (null == modelBean)
            return;

        if (null == modelBean.getModel())
            return;

        if (null == mSensorOilTv)
            return;
        mBean = (CanBusMonitorBean) modelBean.getModel();

        //传感器油量
        if (!TextUtils.isEmpty(mBean.getSensorOil()))
            mSensorOilTv.setText(mBean.getSensorOil());

        //引擎转速
        if (!TextUtils.isEmpty(mBean.getEngineSpeed()))
            mEngineSpeedTv.setText(mBean.getEngineSpeed());

        //瞬时油耗
        if (!TextUtils.isEmpty(mBean.getOilConsumption()))
            mOilConsumptionTv.setText(mBean.getOilConsumption());

        //发动机扭矩
        if (!TextUtils.isEmpty(mBean.getEngineTorque()))
            mEngineTorqueTv.setText(mBean.getEngineTorque());

        //油门踏板位置
        if (!TextUtils.isEmpty(mBean.getPedalPosition()))
            mPedalPositionTv.setText(mBean.getPedalPosition());

        //累计油耗
        if (!TextUtils.isEmpty(mBean.getAllConsumption()))
            mAllConsumptionTv.setText(mBean.getAllConsumption());

        //计量仪油耗
        if (!TextUtils.isEmpty(mBean.getMeterOilConsumption()))
            mMeterOilConsumptionTv.setText(mBean.getMeterOilConsumption());

        //引擎运行总时长
        if (!TextUtils.isEmpty(mBean.getTotalTime()))
            mTotalTimeTv.setText(mBean.getTotalTime());

        //发动机水温
        if (!TextUtils.isEmpty(mBean.getWaterTemperature()))
            mWaterTemperatureTv.setText(mBean.getWaterTemperature());

        //机油温度
        if (!TextUtils.isEmpty(mBean.getEngineOilTemperature()))
            mEngineOilTemperatureTv.setText(mBean.getEngineOilTemperature());

        //进气温度
        if (!TextUtils.isEmpty(mBean.getIntakeTemperature()))
            mIntakeTemperatureTv.setText(mBean.getIntakeTemperature());

        //机油压力
        if (!TextUtils.isEmpty(mBean.getOilPressure()))
            mOilPressureTv.setText(mBean.getOilPressure());

        //大气压力
        if (!TextUtils.isEmpty(mBean.getAtmosphericPressure()))
            mAtmosphericPressureTv.setText(mBean.getAtmosphericPressure());
    }

    @Override
    public void sendMsg() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fram_bus_detection_layout;
    }

    @Override
    public void initView() {
        ruquest(RequestDataManage.getInstance().getMain_52());
    }

    @Override
    protected void lazyLoad() {

    }
    /**
     * 发送请求
     *
     * @param bytes
     */
    private void ruquest(byte[] bytes) {
        UIMessageManager.getInstance().send(bytes);
    }
}
