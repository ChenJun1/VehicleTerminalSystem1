package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.apkfuns.logutils.LogUtils;
import com.cvnavi.app.R;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.DeviceMsgBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * 设备信息
 */
public class Device_InformationActivity extends ToolbarActivity {
    public static void star(Context context) {
        context.startActivity(new Intent(context, Device_InformationActivity.class));
    }
    @BindView(R.id.firmware_version_view)
    TextView firmwareVersionView;
    @BindView(R.id.hardware_version_view)
    TextView hardwareVersionView;
    @BindView(R.id.communication_module_type_view)
    TextView communicationModuleTypeView;
    @BindView(R.id.communication_module_version_view)
    TextView communicationModuleVersionView;
    @BindView(R.id.positioning_module_type_view)
    TextView positioningModuleTypeView;
    @BindView(R.id.positioning_module_version_view)
    TextView positioningModuleVersionView;
    @BindView(R.id.serial_number_view)
    TextView serialNumberView;
    @BindView(R.id.product_number_view)
    TextView productNumberView;
    @BindView(R.id.time_view)
    TextView timeView;
    @BindView(R.id.authentication_code_view)
    TextView authenticationCodeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device__information);
        setTitle("设备信息");
    }

    @Override
    protected void initView() {
        flg = true;
        ThreadManager.execute(mRunnable);
    }
    @Override
    protected void onDestroy() {
        flg = false;
        ThreadManager.cancel(mRunnable);
        super.onDestroy();
    }
    private boolean flg = true;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (flg) {
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_4C());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };
    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        super.notifyAllActivity(code, baseBean);
        LogUtils.e("---------调用父类之后");
        if (!AgreementUtils.agreement_4C.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;
        LogUtils.e("---------baseBean 不为kong");
        DeviceMsgBean bean = (DeviceMsgBean) baseBean.getModel();
        if (null == bean)
            return;
        LogUtils.e("---------bean 不为kong");
        firmwareVersionView.setText(bean.getFirmwareVersion());
        hardwareVersionView.setText(bean.getHardwareVersion());
        communicationModuleTypeView.setText(bean.getComType());
        communicationModuleVersionView.setText(bean.getComVersion());
        positioningModuleTypeView.setText(bean.getLocType());
        positioningModuleVersionView.setText(bean.getLocVersion());
        serialNumberView.setText(bean.getSerialNumber());
        productNumberView.setText(bean.getType());
        timeView.setText(bean.getManufactureDate());
        authenticationCodeView.setText(bean.getCode());
    }
}
