package com.cvnavi.app.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SetUpTheDeviceActivity extends ToolbarActivity {

    @BindView(R.id.number_plate_view)
    TextView numberPlateView;
    @BindView(R.id.car_parameter_view)
    TextView carParameterView;
    @BindView(R.id.sleep_mode_view)
    TextView sleepModeView;
    @BindView(R.id.driving_time_limit_view)
    TextView drivingTimeLimitView;
    @BindView(R.id.coefficient_view)
    TextView coefficientView;
    @BindView(R.id.alarm_speed_view)
    TextView alarmSpeedView;
    @BindView(R.id.radio_Boot_dormancy_view)
    RadioButton radioBootDormancyView;
    @BindView(R.id.radio_Shut_down_view)
    RadioButton radioShutDownView;
    @BindView(R.id.TTSvoice_view)
    RadioButton TTSvoiceView;
    @BindView(R.id.radio_buzzer_view)
    RadioButton radioBuzzerView;
    @BindView(R.id.radio_Mixed_positioning_view)
    RadioButton radioMixedPositioningView;
    @BindView(R.id.radio_GPS_positioning_view)
    RadioButton radioGPSPositioningView;
    @BindView(R.id.radio_Beidou_positioning_view)
    RadioButton radioBeidouPositioningView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_up_the_device);
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.radio_Boot_dormancy_view, R.id.radio_Shut_down_view, R.id.TTSvoice_view, R.id.radio_buzzer_view, R.id.radio_Mixed_positioning_view, R.id.radio_GPS_positioning_view, R.id.radio_Beidou_positioning_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.radio_Boot_dormancy_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4E(0x019A, 1, 0));
                break;
            case R.id.radio_Shut_down_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4E(0x019A, 1, 1));
                break;
            case R.id.TTSvoice_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4E(0x0197, 1, 4));
                break;
            case R.id.radio_buzzer_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4E(0x0197, 2, 4));
                break;
            case R.id.radio_Mixed_positioning_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4E(0x0198, 1, 1));
                break;
            case R.id.radio_GPS_positioning_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4E(0x0198, 2, 1));
                break;
            case R.id.radio_Beidou_positioning_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4E(0x0198, 3, 1));
                break;
        }
    }
}
