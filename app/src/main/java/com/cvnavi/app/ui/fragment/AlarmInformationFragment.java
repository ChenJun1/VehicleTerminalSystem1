package com.cvnavi.app.ui.fragment;

import android.annotation.SuppressLint;
import android.support.v7.widget.CardView;

import com.cvnavi.app.R;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.WarningBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.ui.customize.AlarmTextView;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * 报警
 */
public class AlarmInformationFragment extends BaseListenerFragment {
    @BindView(R.id.logintype_view)
    AlarmTextView logintypeView;
    @BindView(R.id.speedState_view)
    AlarmTextView speedStateView;
    @BindView(R.id.emergencyAlarm_view)
    AlarmTextView emergencyAlarmView;
    @BindView(R.id.speedAlarm_View)
    AlarmTextView speedAlarmView;
    @BindView(R.id.fatigueDriving_View)
    AlarmTextView fatigueDrivingView;
    @BindView(R.id.dangerSarning_View)
    AlarmTextView dangerSarningView;
    @BindView(R.id.GNSSModule_View)
    AlarmTextView GNSSModuleView;
    @BindView(R.id.GNSSNotConnected_View)
    AlarmTextView GNSSNotConnectedView;
    @BindView(R.id.GNSSShortCircuit_View)
    AlarmTextView GNSSShortCircuitView;
    @BindView(R.id.Undervoltage_View)
    AlarmTextView UndervoltageView;
    @BindView(R.id.powerDown_View)
    AlarmTextView powerDownView;
    @BindView(R.id.displayFailure_View)
    AlarmTextView displayFailureView;
    @BindView(R.id.TTSmalfunction_View)
    AlarmTextView TTSmalfunctionView;
    @BindView(R.id.CameraFailure_View)
    AlarmTextView CameraFailureView;
    @BindView(R.id.ICCarMalfunction_View)
    AlarmTextView ICCarMalfunctionView;
    @BindView(R.id.speedingWarning_View)
    AlarmTextView speedingWarningView;
    @BindView(R.id.drivingWarning_View)
    AlarmTextView drivingWarningView;
    @BindView(R.id.drivingOvertime_View)
    AlarmTextView drivingOvertimeView;
    @BindView(R.id.overtimeParking_View)
    AlarmTextView overtimeParkingView;
    @BindView(R.id.area_View)
    AlarmTextView areaView;
    @BindView(R.id.line_View)
    AlarmTextView lineView;
    @BindView(R.id.timeInsufficient_View)
    AlarmTextView timeInsufficientView;
    @BindView(R.id.deviationFromTheAlarm_View)
    AlarmTextView deviationFromTheAlarmView;
    @BindView(R.id.VSSmalfunction_View)
    AlarmTextView VSSmalfunctionView;
    @BindView(R.id.abnormalOil_View)
    AlarmTextView abnormalOilView;
    @BindView(R.id.stolen_View)
    AlarmTextView stolenView;
    @BindView(R.id.ignition_View)
    AlarmTextView ignitionView;
    @BindView(R.id.shift_View)
    AlarmTextView shiftView;
    @BindView(R.id.collisionWarning_View)
    AlarmTextView collisionWarningView;
    @BindView(R.id.rolloverWarning_View)
    AlarmTextView rolloverWarningView;
    @BindView(R.id.CallThePolice_View)
    AlarmTextView CallThePoliceView;
    @BindView(R.id.cardView)
    CardView cardView;

    @Override
    public int getLayoutID() {
        return R.layout.activity_alarm_information;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void lazyLoad() {
        flg = true;
        ThreadManager.execute(mRunnable);
    }


    private boolean flg = true;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (flg) {
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_49());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    @Override
    public void onDestroy() {
        super.onDestroy();
        flg = false;
        ThreadManager.cancel(mRunnable);
    }

    @SuppressLint("LongLogTag")
    @Override
    public void notifyAllActivity(String code, BaseBean homeBean) {
        if (!AgreementUtils.agreement_49.equals(code))
            return;
        if (null == homeBean)
            return;
        WarningBean bean = (WarningBean) homeBean.getModel();
        if (null == bean)
            return;
        logintypeView.setmTextDrawableLift(bean.getIsLogin()); //登录状态

        speedStateView.setmTextDrawableLift(bean.getSpeed()); //速度状态

        emergencyAlarmView.setmTextDrawableLift(bean.getEmergencyAlarm()); //紧急报警

        speedAlarmView.setmTextDrawableLift(bean.getSpeedAlarm()); //超速报警

        fatigueDrivingView.setmTextDrawableLift(bean.getFatigueDriving()); //疲劳驾驶

        dangerSarningView.setmTextDrawableLift(bean.getRiskWarning()); //危险预警

        GNSSModuleView.setmTextDrawableLift(bean.getModuleFailure()); //GNSS 模块发生故障

        GNSSNotConnectedView.setmTextDrawableLift(bean.getAntennaMissed()); //GNSS天线未连接

        GNSSShortCircuitView.setmTextDrawableLift(bean.getAntennaShort()); //Gnss天线短路

        UndervoltageView.setmTextDrawableLift(bean.getUndervoltage()); //终端主电源欠压

        powerDownView.setmTextDrawableLift(bean.getLeakage()); //终端主电源掉电

        displayFailureView.setmTextDrawableLift(bean.getFault());//终端显示器故障

        TTSmalfunctionView.setmTextDrawableLift(bean.getTtsFault()); //TTS模块故障

        CameraFailureView.setmTextDrawableLift(bean.getCameraFault()); //摄像头故障

        ICCarMalfunctionView.setmTextDrawableLift(bean.getIcFault()); //IC 卡故障

        speedingWarningView.setmTextDrawableLift(bean.getOverspeedWarning()); //超速预警

        drivingWarningView.setmTextDrawableLift(bean.getFatigueDrivingWarning()); //疲劳驾驶预警

        drivingOvertimeView.setmTextDrawableLift(bean.getOvertime()); //当天累计驾驶超时

        overtimeParkingView.setmTextDrawableLift(bean.getOvertimePark()); //超时停车

        areaView.setmTextDrawableLift(bean.getArea()); //进入区域

        lineView.setmTextDrawableLift(bean.getLine()); //进入线路

        timeInsufficientView.setmTextDrawableLift(bean.getTimeWarning()); //道路行驶时间不足/过长

        deviationFromTheAlarmView.setmTextDrawableLift(bean.getDeviate()); //线路偏离报警

        VSSmalfunctionView.setmTextDrawableLift(bean.getVssfault()); //车辆VSS故障

        abnormalOilView.setmTextDrawableLift(bean.getOilAbnormal()); //车辆油量异常

        stolenView.setmTextDrawableLift(bean.getStolenVehicles()); //车辆被盗

        ignitionView.setmTextDrawableLift(bean.getIllegalIgnition()); //车辆非法点火

        shiftView.setmTextDrawableLift(bean.getIllegalDisplacement()); //车辆非法移位

        collisionWarningView.setmTextDrawableLift(bean.getCollisionWarning()); //碰撞预警

        rolloverWarningView.setmTextDrawableLift(bean.getRolloverWarning()); //侧翻预警

        CallThePoliceView.setmTextDrawableLift(bean.getIllagelOpen()); //非法开门预警
    }

    @Override
    public void sendMsg() {

    }

    @Override
    protected void onInvisible() {
        super.onInvisible();
        flg = false;
        ThreadManager.cancel(mRunnable);
    }
}
