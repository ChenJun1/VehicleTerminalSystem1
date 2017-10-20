package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.PositioningStatusBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * 采集北斗位置数据
 */

public class PositioningStatusActivity extends ToolbarActivity {
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
    @BindView(R.id.mode_indication_view)
    TextView modeIndicationView;

    public static void star(Context context) {
        context.startActivity(new Intent(context, PositioningStatusActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_positioning_status);
    }

    @Override
    protected void initView() {
        UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_40());
    }

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        super.notifyAllActivity(code, baseBean);
        if (!AgreementUtils.agreement_40.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;
        PositioningStatusBean bean = (PositioningStatusBean) baseBean.getModel();
        if (null == bean)
            return;
        numberPlateView.setText(bean.getTime());
        carParameterView.setText(bean.getDataTime());
        if ("A".equals(bean.getPositioningStatus()))
            sleepModeView.setText("有效");
        else if ("V".equals(bean.getPositioningStatus()))
            sleepModeView.setText("无效");
        drivingTimeLimitView.setText(bean.getLatitude());
        if ("N".equals(bean.getLatitudeDirection()))
            breakTimeView.setText("北纬");
        else if ("S".equals(bean.getLatitudeDirection()))
            breakTimeView.setText("南纬");
        ICAuthority.setText(bean.getOngitude());
        if ("E".equals(bean.getOngitudeDirection()))
            carVINNumber.setText("东经");
        else if ("W".equals(bean.getOngitudeDirection()))
            carVINNumber.setText("西经");
        coefficientView.setText(bean.getNumberOfSatellites());
        alarmSpeedView.setText(bean.getHeight());
        timeoutDrivingTimeView.setText(bean.getGroundSpeed());
        warningDifferenceView.setText(bean.getGroundCourse());
        if ("A".equals(bean.getModeIndication()))
            modeIndicationView.setText("自主定位");
        else if ("D".equals(bean.getModeIndication()))
            modeIndicationView.setText("差分");
        else if ("E".equals(bean.getModeIndication()))
            modeIndicationView.setText("估算");
        else if ("N".equals(bean.getModeIndication()))
            modeIndicationView.setText("数据无效¬");
    }
}
