package com.cvnavi.app.ui.fragment;

import android.text.TextUtils;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.DrivingBehaviorBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/18 11:33
 * version: 1.0
 * Depict: 驾驶评分 实时分值显示 
 */

public class DrivingScoreFragment1 extends BaseListenerFragment {
    @BindView(R.id.mileage_tv)
    TextView mMileageTv;
    @BindView(R.id.oilConsumption_tv)
    TextView mOilConsumptionTv;
    @BindView(R.id.averageOilConsumption_tv)
    TextView mAverageOilConsumptionTv;
    @BindView(R.id.averagescore_tv)
    TextView mAveragescoreTv;
    @BindView(R.id.speedX_tv)
    TextView mSpeedXTv;
    @BindView(R.id.percent_tv)
    TextView mPercentTv;
    @BindView(R.id.fraction_tv)
    TextView mFractionTv;

    boolean flg=false;
    @Override
    public int getLayoutID() {
        return R.layout.fram_driving_score_1;
    }

    @Override
    public void initView() {
    }

    private Runnable mRunnable=new Runnable() {
        @Override
        public void run() {
            while (flg) {
                ruquest(RequestDataManage.getInstance().getMain_57_00());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    protected void lazyLoad() {
        flg=true;
        ThreadManager.execute(mRunnable);
    }

    @Override
    protected void onInvisible() {
        super.onInvisible();
        flg=false;
        ThreadManager.cancel(mRunnable);
    }

    @Override
    public void onPause() {
        super.onPause();
        flg=false;
        ThreadManager.cancel(mRunnable);
    }

    /**
     * 发送请求
     *
     * @param bytes
     */
    private void ruquest(byte[] bytes) {
        UIMessageManager.getInstance().send(bytes);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ListenerManager.getInstance().unRegisterListener(DrivingScoreFragment1.this);
    }

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        DrivingBehaviorBean drivingBehaviorBean;
        if (!AgreementUtils.agreement_57_00.equals(code))
            return;
        if (null == baseBean)
            return;
        if (null == baseBean.getModel())
            return;
        if (null == mMileageTv)
            return;

        drivingBehaviorBean = (DrivingBehaviorBean) baseBean.getModel();

        //本次里程
        if (!TextUtils.isEmpty(drivingBehaviorBean.getMileage())) {
            mMileageTv.setText(drivingBehaviorBean.getMileage()+" KM");
        }

        //本次油耗
        if (!TextUtils.isEmpty(drivingBehaviorBean.getOilConsumption())) {
            mOilConsumptionTv.setText(drivingBehaviorBean.getOilConsumption()+" L");
        }

        //平均油耗
        if (!TextUtils.isEmpty(drivingBehaviorBean.getAverageOilConsumption())) {
            mAverageOilConsumptionTv.setText(drivingBehaviorBean.getAverageOilConsumption()+" L/KM");
        }

        //平均分数
        if (!TextUtils.isEmpty(drivingBehaviorBean.getAveragescore())) {
            mAveragescoreTv.setText(drivingBehaviorBean.getAveragescore());
        }

        //当前转速X轴
        if (!TextUtils.isEmpty(drivingBehaviorBean.getSpeedX())) {
            mSpeedXTv.setText(drivingBehaviorBean.getSpeedX());
        }

        //当前扭矩百分比（Y轴）
        if (!TextUtils.isEmpty(drivingBehaviorBean.getPercent())) {
            mPercentTv.setText(drivingBehaviorBean.getPercent());
        }

        //当前分数
        if (!TextUtils.isEmpty(drivingBehaviorBean.getFraction())) {
            mFractionTv.setText(drivingBehaviorBean.getFraction());
        }

    }

    @Override
    public void sendMsg() {

    }

}
