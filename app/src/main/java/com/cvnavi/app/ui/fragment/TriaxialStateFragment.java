package com.cvnavi.app.ui.fragment;

import android.text.TextUtils;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.ThreeAxleBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by wangshy on 17/8/14.
 * 工程菜单——三轴设备
 */

public class TriaxialStateFragment extends BaseListenerFragment {
    @BindView(R.id.angle_x_view)
    TextView angleXView;
    @BindView(R.id.angle_y_viwe)
    TextView angleYViwe;
    @BindView(R.id.angle_z_view)
    TextView angleZView;
    @BindView(R.id.acceleration_x_view)
    TextView accelerationXView;
    @BindView(R.id.acceleration_y_view)
    TextView accelerationYView;
    @BindView(R.id.acceleration_z_view)
    TextView accelerationZView;
    @BindView(R.id.device_status_view)
    TextView deviceStatusView;
    @BindView(R.id.open_view)
    RadioButton openView;
    @BindView(R.id.shut_down_view)
    RadioButton shutDownView;

    @Override
    public void notifyAllActivity(String code, BaseBean modelBean) {
        if (!AgreementUtils.agreement_51.equals(code)) {
            return;
        }
        if (null == modelBean)
            return;
        ThreeAxleBean bean = (ThreeAxleBean) modelBean.getModel();
        if (null == bean)
            return;
        angleXView.setText(bean.getAngleX());
        angleYViwe.setText(bean.getAngleY());
        angleZView.setText(bean.getAngleZ());
        accelerationXView.setText(bean.getAccelerationX());
        accelerationYView.setText(bean.getAccelerationY());
        accelerationZView.setText(bean.getAccelerationZ());
        deviceStatusView.setText(bean.getDeviceState());
        if (!TextUtils.isEmpty(bean.getDeviceState()) && "1".equals(bean.getDeviceState())) {
            openView.setChecked(true);
        } else
            shutDownView.setChecked(true);
    }

    @Override
    public void sendMsg() {

    }
    private boolean flg = true;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (flg) {
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_51());
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

    @Override
    public int getLayoutID() {
        return R.layout.triaxial_state_layout;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void lazyLoad() {
        flg = true;
        ThreadManager.execute(mRunnable);
    }

    @OnClick({R.id.open_view, R.id.shut_down_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.open_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_51_01(0));
                break;
            case R.id.shut_down_view:
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_51_01(1));
                break;
        }
    }
}
