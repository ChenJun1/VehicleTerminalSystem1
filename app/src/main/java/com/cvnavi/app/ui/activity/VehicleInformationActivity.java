package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.VehicleInformationBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * Created by wangshy on 17/8/14.
 * 车辆基本信息
 */
public class VehicleInformationActivity extends ToolbarActivity {

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle_information);
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
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_26());
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
        if (!AgreementUtils.agreement_26.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;
        VehicleInformationBean bean = (VehicleInformationBean) baseBean.getModel();
        if (null == bean)
            return;
        numberPlateView.setText(bean.getId());
        carParameterView.setText(bean.getVin());
        sleepModeView.setText(bean.getSim());
        drivingTimeLimitView.setText(bean.getVehicleNo());
        breakTimeView.setText(bean.getEngineNumber());
        ICAuthority.setText(bean.getModels());
    }

    public static void star(Context activity) {
        activity.startActivity(new Intent(activity, VehicleInformationActivity.class));
    }
}
