package com.cvnavi.app.ui.fragment;

import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.InitializationBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.DialogUtils;
import com.cvnavi.app.utils.ToastUtils;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/14 16:07
 * version:
 * Depict:工程菜单---初始化项
 */

public class InitializationFrament extends BaseListenerFragment {
    @BindView(R.id.initialization_bt)
    Button mInitializationBt;
    @BindView(R.id.emptied_1_bt)
    Button mEmptied1Bt;
    @BindView(R.id.alarm_release_bt)
    Button mAlarmReleaseBt;
    @BindView(R.id.emptied_2_bt)
    Button mEmptied2Bt;
    @BindView(R.id.terminal_reset_bt)
    Button mTerminalResetBt;
    @BindView(R.id.reset_bt)
    Button mResetBt;
    @BindView(R.id.center_1_tv)
    TextView mCenter1Tv;
    @BindView(R.id.center_2_tv)
    TextView mCenter2Tv;

    InitializationBean mBean;

    @Override
    public void notifyAllActivity(String code, BaseBean modelBean) {
        if (!AgreementUtils.agreement_4F.equals(code))
            return;
        if (null == mInitializationBt)
            return;

        if (null == modelBean)
            return;

        if (null == modelBean.getModel())
            return;

        mBean = (InitializationBean) modelBean.getModel();
        //中心优先级
        if (mBean.getSetPriority() == 1) {
            SetPriority2();
        } else {
            SetPriority1();
        }

        //开关初始化量
        if (mBean.getSwitchInitial() == 1) {
            ToastUtils.showToast("开关初始化量成功");
        }

        //手动报警解除
        if (mBean.getWarn() == 1) {
            ToastUtils.showToast("手动报警解除成功");
        }

        //终端复位
        if (mBean.getTerminal() == 1) {
            ToastUtils.showToast("终端复位成功");
        }

        //恢复出厂设置
        if (mBean.getRestoreFactory() == 1) {
            ToastUtils.showToast("恢复出厂设置成功");
        }

        //清空C1鉴权
        if (mBean.getClearC1() == 1) {
            ToastUtils.showToast("清空C1鉴权成功");
        }

        //清空C2鉴权
        if (mBean.getClearC2() == 1) {
            ToastUtils.showToast("清空C2鉴权成功");
        }

    }

    @Override
    public void sendMsg() {

    }

    @Override
    public int getLayoutID() {
        return R.layout.fram_initialization;
    }

    @Override
    public void initView() {
        ruquest(RequestDataManage.getInstance().getMain_4F_00());
    }

    @Override
    protected void lazyLoad() {
    }

    @OnClick({R.id.initialization_bt, R.id.emptied_1_bt, R.id.alarm_release_bt, R.id.emptied_2_bt, R.id.terminal_reset_bt, R.id.reset_bt, R.id.center_1_tv, R.id.center_2_tv})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.initialization_bt:
                showDialog((byte) 0x01, "确认开关量初始化");
                break;
            case R.id.emptied_1_bt:
                showDialog((byte) 0x05, "确认清空C1鉴权");
                break;
            case R.id.alarm_release_bt:
                showDialog((byte) 0x02, "确认手动解除报警");
                break;
            case R.id.emptied_2_bt:
                showDialog((byte) 0x06, "确认清空C2鉴权");
                break;
            case R.id.terminal_reset_bt:
                showDialog((byte) 0x03, "确认终端复位");
                break;
            case R.id.reset_bt:
                showDialog((byte) 0x04, "确认恢复出厂设置");
                break;
            case R.id.center_1_tv:
                SetPriority1();
                break;
            case R.id.center_2_tv:
                SetPriority2();
                break;
        }
    }

    //设置中心优先级1
    private void SetPriority1() {
        mCenter1Tv.setTextColor(0xff000000);
        mCenter2Tv.setTextColor(0xffD3EE1D);
        mCenter1Tv.setBackground(getResources().getDrawable(R.drawable.vehicle_parameters_bg3));
        mCenter2Tv.setBackground(getResources().getDrawable(R.drawable.vehicle_parameters_bg1));
        ruquest(RequestDataManage.getInstance().getMain_4F_07((byte) 0x00));
    }

    //设置中心优先级2
    private void SetPriority2() {
        mCenter2Tv.setTextColor(0xff000000);
        mCenter1Tv.setTextColor(0xffD3EE1D);
        mCenter2Tv.setBackground(getResources().getDrawable(R.drawable.vehicle_parameters_bg3));
        mCenter1Tv.setBackground(getResources().getDrawable(R.drawable.vehicle_parameters_bg1));
        ruquest(RequestDataManage.getInstance().getMain_4F_07((byte) 0x01));
    }

    private void showDialog(final byte id, String str) {
        DialogUtils.showConfirmDialog(getActivity(), str, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                ruquest(RequestDataManage.getInstance().getMain_4F_0x(id));
            }
        });
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
