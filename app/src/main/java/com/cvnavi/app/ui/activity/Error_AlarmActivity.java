package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cvnavi.app.R;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.FaultAlarmBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.customize.AlarmTextView;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * Created by wangshy on 17/8/14.
 * 故障报警信息
 */
public class Error_AlarmActivity extends ToolbarActivity {
    public static void star(Context context) {
        context.startActivity(new Intent(context, Error_AlarmActivity.class));
    }


    @BindView(R.id.Serious_Failure_View)
    AlarmTextView SeriousFailureView;
    @BindView(R.id.Brake_air_pressure_alarm_view)
    AlarmTextView BrakeAirPressureAlarmView;
    @BindView(R.id.Hydraulic_alarm_view)
    AlarmTextView HydraulicAlarmView;
    @BindView(R.id.Low_water_level_alarm_view)
    AlarmTextView LowWaterLevelAlarmView;
    @BindView(R.id.Brake_shoe_warning_view)
    AlarmTextView BrakeShoeWarningView;
    @BindView(R.id.Air_filter_block_alarm_view)
    AlarmTextView AirFilterBlockAlarmView;
    @BindView(R.id.Fuel_alarm_view)
    AlarmTextView FuelAlarmView;
    @BindView(R.id.Retarder_high_temperature_alarm_view)
    AlarmTextView RetarderHighTemperatureAlarmView;
    @BindView(R.id.Warehouse_temperature_alarm_view)
    AlarmTextView WarehouseTemperatureAlarmView;
    @BindView(R.id.Oil_temperature_alarm_view)
    AlarmTextView OilTemperatureAlarmView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error_alarm);
    }

    @Override
    protected void initView() {
        flg = true;
        ThreadManager.execute(mRunnable);
    }

    private boolean flg = true;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (flg) {
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_27());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        flg = false;
        ThreadManager.cancel(mRunnable);
    }

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        super.notifyAllActivity(code, baseBean);
        if (!AgreementUtils.agreement_27.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;
        FaultAlarmBean bean = (FaultAlarmBean) baseBean.getModel();
        if (null == bean)
            return;
        SeriousFailureView.setmTextDrawableLift(bean.getSeriousFault());
        BrakeAirPressureAlarmView.setmTextDrawableLift(bean.getBrakeAirPressureAlarm());
        HydraulicAlarmView.setmTextDrawableLift(bean.getOilPressureAlarm());
        LowWaterLevelAlarmView.setmTextDrawableLift(bean.getLowWaterLevelAlarm());
        BrakeShoeWarningView.setmTextDrawableLift(bean.getBrakeShoeAlarm());
        AirFilterBlockAlarmView.setmTextDrawableLift(bean.getAirFilterBlockingAlarm());
        FuelAlarmView.setmTextDrawableLift(bean.getFuelWarning());
        RetarderHighTemperatureAlarmView.setmTextDrawableLift(bean.getAlarmForRetarder());
        WarehouseTemperatureAlarmView.setmTextDrawableLift(bean.getStorehouseTemperatureAlarm());
        OilTemperatureAlarmView.setmTextDrawableLift(bean.getOilTemperatureAlarm());
    }
}
