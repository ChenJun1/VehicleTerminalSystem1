package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.VehicleParametersBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * 车辆参数
 */
public class VehicleParametersActivity extends ToolbarActivity {

    @BindView(R.id.number_plate_view)
    TextView numberPlateView;
    @BindView(R.id.car_parameter_view)
    TextView carParameterView;
    @BindView(R.id.sleep_mode_view)
    TextView sleepModeView;
    @BindView(R.id.driving_time_limit_view)
    TextView drivingTimeLimitView;
    @BindView(R.id.break_time_view)
    TextView breakTimeView;
    @BindView(R.id.IC_authority)
    TextView ICAuthority;
    @BindView(R.id.car_VIN_number)
    TextView carVINNumber;
    @BindView(R.id.coefficient_view)
    TextView coefficientView;
    @BindView(R.id.alarm_speed_view)
    TextView alarmSpeedView;
    @BindView(R.id.timeout_driving_time_view)
    TextView timeoutDrivingTimeView;
    @BindView(R.id.warning_difference_view)
    TextView warningDifferenceView;

    public static void stat(Context context) {
        context.startActivity(new Intent(context, VehicleParametersActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_parameters);
    }

    @Override
    protected void initView() {
        setTitle("车辆参数");
        flg = true;
        ThreadManager.execute(mRunnable);
    }

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        super.notifyAllActivity(code, baseBean);
        if (!AgreementUtils.agreement_42.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;
        VehicleParametersBean bean = (VehicleParametersBean) baseBean.getModel();
        if (null == bean)
            return;
        numberPlateView.setText(bean.getVehicleNo());
        carParameterView.setText(bean.getLicenseCatalog());
        sleepModeView.setText(bean.getSleepMode());
        drivingTimeLimitView.setText(bean.getDayDriving());
        breakTimeView.setText(bean.getSleepTime());
        ICAuthority.setText(bean.getIcCardRight());
        carVINNumber.setText(bean.getVin());
        coefficientView.setText(bean.getPulseCoefficient());
        alarmSpeedView.setText(bean.getSpeedingWarn());
        timeoutDrivingTimeView.setText(bean.getTimeoutDriving());
        warningDifferenceView.setText(bean.getTimeoutWran());
    }

    private boolean flg = true;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (flg) {
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_42());
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
        flg = false;
        ThreadManager.cancel(mRunnable);
        super.onDestroy();
    }
}
