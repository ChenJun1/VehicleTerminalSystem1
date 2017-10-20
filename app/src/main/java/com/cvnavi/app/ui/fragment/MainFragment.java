package com.cvnavi.app.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.cvnavi.app.R;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.HomeFragBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.activity.DrivingScoreActivity;
import com.cvnavi.app.ui.activity.MainDialogActivity;
import com.cvnavi.app.ui.activity.TimeSetActivity;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.ui.customize.CustomCircleBar;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.DateUtils;
import com.cvnavi.app.utils.TimeRefreshUtils;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/6 14:58
 * version: 1.0
 * Depict: 首页
 */

public class MainFragment extends BaseListenerFragment {
    private static final String TAG = "MainFragment";

    @BindView(R.id.jsy)
    TextView mJsy;
    @BindView(R.id.driver_tv)
    TextView mDriverTv;
    @BindView(R.id.jszj)
    TextView mJszj;
    @BindView(R.id.document_number_tv)
    TextView mDocumentNumberTv;
    @BindView(R.id.jspf)
    TextView mJspf;
    @BindView(R.id.jspf_rl)
    RelativeLayout mJspfRl;
    @BindView(R.id.cycle_tv)
    TextView mCycleTv;
    @BindView(R.id.date_tv)
    TextView mDateTv;
    @BindView(R.id.time_tv)
    TextView mTimeTv;
    @BindView(R.id.ddata_time_rl)
    RelativeLayout mDdataTimeRl;
    @BindView(R.id.custom_circle_bar)
    CustomCircleBar mCustomCircleBar;
    @BindView(R.id.xszt_1)
    TextView mXszt1;
    @BindView(R.id.driving_status_tv)
    TextView mDrivingStatusTv;
    @BindView(R.id.jssj)
    TextView mJssj;
    @BindView(R.id.drive_time_tv)
    TextView mDriveTimeTv;
    @BindView(R.id.yh)
    TextView mYh;
    @BindView(R.id.consumption_tv)
    TextView mConsumptionTv;
    @BindView(R.id.xxsj)
    TextView mXxsj;
    @BindView(R.id.rest_time_tv)
    TextView mRestTimeTv;
    @BindView(R.id.rest_statu_iv)
    ImageView mRestStatuIv;
    @BindView(R.id.rest_statu_tv)
    TextView mRestStatuTv;
    @BindView(R.id.sczt)
    TextView mSczt;
    @BindView(R.id.lock_car_status_tv)
    TextView mLockCarStatusTv;
    @BindView(R.id.wd)
    TextView mWd;
    @BindView(R.id.temperature_1_tv)
    TextView mTemperature1Tv;
    @BindView(R.id.jszt)
    TextView mJszt;
    @BindView(R.id.lift_up_tv)
    TextView mLiftUpTv;
    @BindView(R.id.pbzt)
    TextView mPbzt;
    @BindView(R.id.cover_tv)
    TextView mCoverTv;
    @BindView(R.id.zzbfv)
    TextView mZzbfv;
    @BindView(R.id.load_state_tv)
    TextView mLoadStateTv;
    @BindView(R.id.load_state_iv)
    ImageView mLoadStateIv;
    @BindView(R.id.zzzt_rl)
    RelativeLayout mZzztRl;
    @BindView(R.id.round_corner_progress_bar)
    RoundCornerProgressBar mRoundCornerProgressBar;
    @BindView(R.id.round_corner_progress_number)
    TextView mRoundCornerProgressNumber;
    @BindView(R.id.progressll)
    LinearLayout mProgressll;
    @BindView(R.id.szqy)
    TextView mSzqy;
    @BindView(R.id.area_tv)
    TextView mAreaTv;
    @BindView(R.id.xszt_2)
    TextView mXszt2;
    @BindView(R.id.speed_limit_tv)
    TextView mSpeedLimitTv;

    boolean LoadStateFlag = true;
    private List<byte[]> bytes;
    RequestDataManage requestManage;

    @Override
    public int getLayoutID() {
        return R.layout.fram_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TimeRefreshUtils.getINSTANCE().RefreshTime();
        TimeRefreshUtils.getINSTANCE().onStart();
        sendMsg();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (1==1){
//                    UIMessageManager.getInstance().send(requestManage.getMain_4B());
//                    try {
//                        Thread.sleep(30000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
    }

    @Override
    public void initView() {}

    @Override
    public void onDestroy() {
        super.onDestroy();
        TimeRefreshUtils.getINSTANCE().onCancel();
    }
    @Override
    protected void lazyLoad() {}

    /**
     * 初始化请求数据
     *
     * @return
     */
    private List<byte[]> initRequestData() {
        bytes = new ArrayList<>();
        bytes.add(requestManage.getMain_41());
        bytes.add(requestManage.getMain_47());
        return bytes;
    }

    /**
     * 发送请求
     *
     * @param byteList
     */
    private void ruquest(List<byte[]> byteList) {
        for (byte[] bytes : byteList) {
            UIMessageManager.getInstance().send(bytes);
        }
    }

    @Override
    public void sendMsg() {
        requestManage = RequestDataManage.getInstance();
        ruquest(initRequestData());
    }


    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        // TODO: 2017/7/6
        HomeFragBean homeBean;
        if (!AgreementUtils.agreement_02.equals(code) && !AgreementUtils.agreement_41.equals(code)&&!AgreementUtils.agreement_5A.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;

        if (null == mDriverTv)
            return;
        if (null == baseBean.getModel())
            return;

        homeBean = (HomeFragBean) baseBean.getModel();
        // 判断是否更新时间协议
        if (AgreementUtils.agreement_02.equals(code)) {
            //当前时间(年月日)
            if (!TextUtils.isEmpty(homeBean.getTime1())) {
                mDateTv.setText(homeBean.getTime1());
            }
            //当前时间(时分秒)
            if (!TextUtils.isEmpty(homeBean.getTime2())) {
                TimeRefreshUtils.getINSTANCE().setTime(homeBean.getTime2());
                TimeRefreshUtils.getINSTANCE().setTextView(mTimeTv);
            }
            //保存时间
            if (!TextUtils.isEmpty(homeBean.getTime1()) && !TextUtils.isEmpty(homeBean.getTime2())) {
                DateUtils.setDate(homeBean.getTime1());
                DateUtils.setTime(homeBean.getTime2());
            }

            //当前时间(周日)
            if (!TextUtils.isEmpty(homeBean.getTime3())) {
                mCycleTv.setText(homeBean.getTime3());
            }
        } else if (AgreementUtils.agreement_41.equals(code)) {
            inSetData_41(homeBean);

        } else if (AgreementUtils.agreement_5A.equals(code)) {
            inSetData_5A(homeBean);
        }

    }

    private void inSetData_41(HomeFragBean homeBean) {
        //驾驶员
        if (!TextUtils.isEmpty(homeBean.getDriverNo())) {
            mDriverTv.setText(homeBean.getDriverNo());
        }
        //证件号
        if (!TextUtils.isEmpty(homeBean.getLicenseNo())) {
            mDocumentNumberTv.setText(homeBean.getLicenseNo());
        }
        //速度
        if (!TextUtils.isEmpty(homeBean.getSpeed())) {
            mCustomCircleBar.setPercent(Integer.valueOf(homeBean.getSpeed()));
        }

        //驾驶时间
        if (!TextUtils.isEmpty(homeBean.getDriveTime())) {
            mDriveTimeTv.setText(ContentUtils.resetTimeString(homeBean.getDriveTime().trim()));
        }

        //休息时间
        if (!TextUtils.isEmpty(homeBean.getRestTime())) {
            mRestTimeTv.setText(ContentUtils.resetTimeString(homeBean.getRestTime().trim()));
        }
        //休息时间状态
        if (!TextUtils.isEmpty(homeBean.getIsFullRest())) {
            mRestStatuIv.setVisibility(View.VISIBLE);
            mRestStatuTv.setVisibility(View.VISIBLE);
        } else {
            mRestStatuIv.setVisibility(View.GONE);
            mRestStatuTv.setVisibility(View.GONE);
        }
        //行驶状态
        if (!TextUtils.isEmpty(homeBean.getRunningState())) {
            mDrivingStatusTv.setText(homeBean.getRunningState());
        }
    }

    private void inSetData_5A(HomeFragBean homeBean) {
        //举升传感器状态
        if (!TextUtils.isEmpty(homeBean.getLiftState())) {
            if (homeBean.getLiftState().equals("0"))
                mLiftUpTv.setText("未举升");
            else if (homeBean.getLiftState().equals("1"))
                mLiftUpTv.setText("举升");
        }
        //顶盖状态
        if (!TextUtils.isEmpty(homeBean.getCoverState())) {
            if (homeBean.getCoverState().equals("0"))
                mCoverTv.setText("未密闭");
            else if (homeBean.getCoverState().equals("1"))
                mCoverTv.setText("密闭");
        }
        //载重状态
//            if (!TextUtils.isEmpty(homeBean.getLoadState())) {
//                setLoadState(homeBean.getRunningState());
//            }
        //载重百分比
        if (!TextUtils.isEmpty(homeBean.getLoadPercent())) {
            //当百分比无效数据的情况
            if (homeBean.getLoadPercent().equals("-1")) {
                LoadStateFlag = true;

                //载重状态
                if (!TextUtils.isEmpty(homeBean.getLoadState())) {
                    setLoadState(homeBean.getLoadState());
                }
            } else { //当百分比有效数据的情况
                LoadStateFlag = false;
                float progress = 0;
                try {
                    progress = Float.valueOf(homeBean.getLoadPercent());
                } catch (Exception e) {
                    e.printStackTrace();
                }
                mRoundCornerProgressBar.setProgress(progress);
                mRoundCornerProgressNumber.setText(progress + "%");
                //根据百分比设置装载状态
                if (progress >= 30 && progress < 60) {
                    setLoadState("2");
                } else if (progress >=60) {
                    setLoadState("3");
                } else {
                    setLoadState("1");
                }
            }
        }
        //限速状态
        if (!TextUtils.isEmpty(homeBean.getSpeedLimit())) {
            if (homeBean.getSpeedLimit().equals("0"))
                mSpeedLimitTv.setText("未限速");
            else {
                mSpeedLimitTv.setText("限速" + homeBean.getSpeedLimit() + "km/h");
            }

        }
        //车辆所在区域
        if (!TextUtils.isEmpty(homeBean.getCarLocation())) {
            if (homeBean.getCarLocation().equals("0"))
                mAreaTv.setText("无区域");
            else if (homeBean.getCarLocation().equals("1"))
                mAreaTv.setText("禁区");
            else if (homeBean.getCarLocation().equals("2"))
                mAreaTv.setText("装货区");
            else if (homeBean.getCarLocation().equals("3"))
                mAreaTv.setText("卸货区");
            else if (homeBean.getCarLocation().equals("4"))
                mAreaTv.setText("卸货圈");
            else if (homeBean.getCarLocation().equals("5"))
                mAreaTv.setText("停车场");
        }
    }


    private void setLoadState(String status) {
        switch (status) {
            case "1":
                mLoadStateIv.setImageResource(R.mipmap.koangzai);
                mLoadStateTv.setText("空载");
                if (LoadStateFlag) {
                    mRoundCornerProgressBar.setProgress(0);
                    mRoundCornerProgressNumber.setText(0 + "%");
                }
                break;
            case "2":
                mLoadStateIv.setImageResource(R.mipmap.banzai);
                mLoadStateTv.setText("半载");
                if (LoadStateFlag) {
                    mRoundCornerProgressBar.setProgress(50);
                    mRoundCornerProgressNumber.setText(50 + "%");
                }
                break;
            case "3":
                mLoadStateIv.setImageResource(R.mipmap.manzai);
                mLoadStateTv.setText("满载");
                if (LoadStateFlag) {
                    mRoundCornerProgressBar.setProgress(100);
                    mRoundCornerProgressNumber.setText(100 + "%");
                }
                break;
            default:
                mLoadStateIv.setImageResource(R.mipmap.koangzai);
                mLoadStateTv.setText("轻载");
                if (LoadStateFlag) {
                    mRoundCornerProgressBar.setProgress(0);
                    mRoundCornerProgressNumber.setText(0 + "%");
                }
                break;
        }
    }


    @OnClick({R.id.jspf_rl, R.id.zzzt_rl, R.id.ddata_time_rl})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.jspf_rl:
                DrivingScoreActivity.start(this.getContext());
                break;
            case R.id.zzzt_rl:
                if (!LoadStateFlag)
                    break;
                intent = new Intent(this.getContext(), MainDialogActivity.class);
                if (!TextUtils.isEmpty(mLoadStateTv.getText())) {
                    intent.putExtra("status", mLoadStateTv.getText().toString());
                }
                startActivityForResult(intent, 0);
                break;
            case R.id.ddata_time_rl:
                TimeSetActivity.start(this.getContext());
//                intent = new Intent(this.getContext(), TimeSetActivity.class);
//                startActivityForResult(intent, 0);
//                EquipmentDetectionActivity.start(this.getContext());
//                AccidentGraphActivity.start(this.getContext(),null);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == 0) {
                String statu = data.getStringExtra("status");
                mLoadStateTv.setText(statu);
                setLoadState(statu);
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_3c(statu));
            }
        }
    }

}
