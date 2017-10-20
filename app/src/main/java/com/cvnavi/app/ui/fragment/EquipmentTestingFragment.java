package com.cvnavi.app.ui.fragment;

import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.DeviceTestBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.DialogUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/15 15:31
 * version:
 * Depict: 工程菜单  设备测试
 */

public class EquipmentTestingFragment extends BaseListenerFragment {
    @BindView(R.id.ttsTest_tv)
    TextView mTtsTestTv;
    @BindView(R.id.loopTest_tv)
    TextView mLoopTestTv;
    @BindView(R.id.recordTest_tv)
    TextView mRecordTestTv;
    @BindView(R.id.playBackTest_tv)
    TextView mPlayBackTestTv;
    @BindView(R.id.grsPort_tv)
    TextView mGrsPortTv;
    @BindView(R.id.gprsPort_tv)
    TextView mGprsPortTv;
    @BindView(R.id.cameraState1_tv)
    TextView mCameraState1Tv;
    @BindView(R.id.cameraState2_tv)
    TextView mCameraState2Tv;
    @BindView(R.id.cameraState3_tv)
    TextView mCameraState3Tv;
    @BindView(R.id.cameraState4_tv)
    TextView mCameraState4Tv;
    @BindView(R.id.cpuUtilizationRate_tv)
    TextView mCpuUtilizationRateTv;
    @BindView(R.id.coreTemperature_tv)
    TextView mCoreTemperatureTv;
    @BindView(R.id.externalVoltage_tv)
    TextView mExternalVoltageTv;
    @BindView(R.id.batteryVoltage_tv)
    TextView mBatteryVoltageTv;
    @BindView(R.id.capacity_tv)
    TextView mCapacityTv;
    @BindView(R.id.isAble_tv)
    TextView mIsAbleTv;
    @BindView(R.id.sdRate_tv)
    TextView mSdRateTv;
    @BindView(R.id.hostBusRate_tv)
    TextView mHostBusRateTv;
    @BindView(R.id.format_tv)
    TextView mFormatTv;

    DeviceTestBean bean;

    @Override
    public void notifyAllActivity(String code, BaseBean modelBean) {

        if (!AgreementUtils.agreement_50.equals(code))
            return;

        if (null == mFormatTv)
            return;

        if (null == modelBean)
            return;

        if (null == modelBean.getModel())
            return;

        bean = (DeviceTestBean) modelBean.getModel();

        //摄像头1
        if (TextUtils.isEmpty(bean.getCameraState1())) {
            mCameraState1Tv.setText(bean.getCameraState1());
        }
        //摄像头2
        if (TextUtils.isEmpty(bean.getCameraState2())) {
            mCameraState2Tv.setText(bean.getCameraState2());
        }
        //摄像头3
        if (TextUtils.isEmpty(bean.getCameraState3())) {
            mCameraState3Tv.setText(bean.getCameraState3());
        }
        //摄像头4
        if (TextUtils.isEmpty(bean.getCameraState4())) {
            mCameraState4Tv.setText(bean.getCameraState4());
        }

        //CUP使用率
        if (TextUtils.isEmpty(bean.getCpuUtilizationRate())) {
            mCpuUtilizationRateTv.setText(bean.getCpuUtilizationRate());
        }
        //核心温度
        if (TextUtils.isEmpty(bean.getCoreTemperature())) {
            mCoreTemperatureTv.setText(bean.getCoreTemperature());
        }
        //外部电压
        if (TextUtils.isEmpty(bean.getExternalVoltage())) {
            mExternalVoltageTv.setText(bean.getExternalVoltage());
        }
        //锂电电压
        if (TextUtils.isEmpty(bean.getBatteryVoltage())) {
            mBatteryVoltageTv.setText(bean.getBatteryVoltage());
        }
        //容量
        if (TextUtils.isEmpty(bean.getCapacity())) {
            mCapacityTv.setText(bean.getCapacity());
        }
        //可用
        if (TextUtils.isEmpty(bean.getIsAble())) {
            mIsAbleTv.setText(bean.getIsAble());
        }
        //储存卡速率
        if (TextUtils.isEmpty(bean.getSdRate())) {
            mSdRateTv.setText(bean.getSdRate());
        }
        //主机总线速率
        if (TextUtils.isEmpty(bean.getHostBusRate())) {
            mHostBusRateTv.setText(bean.getHostBusRate());
        }

    }

    @Override
    public void sendMsg() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fram_equipment_testing;
    }

    @Override
    public void initView() {

    }

    @Override
    protected void lazyLoad() {
        ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x00,(byte) 0x00));
    }

    /**
     * 发送请求
     *
     * @param bytes
     */
    private void ruquest(byte[] bytes) {
        UIMessageManager.getInstance().send(bytes);
    }

    @OnClick({R.id.ttsTest_tv, R.id.loopTest_tv, R.id.recordTest_tv, R.id.playBackTest_tv, R.id.grsPort_tv, R.id.gprsPort_tv, R.id.format_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ttsTest_tv:
                if (mTtsTestTv.getText().equals("开始")) {
                    mTtsTestTv.setText("关闭");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x01,(byte) 0x01));
                }else {
                    mTtsTestTv.setText("开始");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x01,(byte) 0x00));
                }
                break;
            case R.id.loopTest_tv:
                if (mLoopTestTv.getText().equals("开启")) {
                    mLoopTestTv.setText("关闭");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x02,(byte) 0x01));
                }else {
                    mLoopTestTv.setText("开启");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x02,(byte) 0x00));
                }
                break;
            case R.id.recordTest_tv:
                if (mRecordTestTv.getText().equals("开始录音")) {
                    mRecordTestTv.setText("结束录音");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x03,(byte) 0x01));
                }else {
                    mRecordTestTv.setText("开始录音");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x03,(byte) 0x00));
                }
                break;
            case R.id.playBackTest_tv:
                if (mPlayBackTestTv.getText().equals("开始放音")) {
                    mPlayBackTestTv.setText("结束放音");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x04,(byte) 0x01));
                }else {
                    mPlayBackTestTv.setText("开始放音");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x04,(byte) 0x00));
                }
                break;
            case R.id.grsPort_tv:
                if (mGrsPortTv.getText().equals("开启")) {
                    mGrsPortTv.setText("关闭");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x05,(byte) 0x01));
                }else {
                    mGrsPortTv.setText("开启");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x05,(byte) 0x00));
                }
                break;
            case R.id.gprsPort_tv:
                if(mGrsPortTv.getText().equals("开启")) {
                    mGprsPortTv.setText("关闭");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x06,(byte) 0x01));
                }else {
                    mGprsPortTv.setText("开启");
                    ruquest(RequestDataManage.getInstance().getMain_50((byte) 0x06,(byte) 0x00));
                }
                break;
            case R.id.format_tv:
                showDialog((byte) 0x07, (byte) 0x00, "格式化");
                break;
        }
    }

    private void showDialog(final byte id, final byte type, String str) {
        DialogUtils.showConfirmDialog(getActivity(), str, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ruquest(RequestDataManage.getInstance().getMain_50(id, type));
            }

        });
    }
}
