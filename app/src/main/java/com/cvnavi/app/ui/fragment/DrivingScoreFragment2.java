package com.cvnavi.app.ui.fragment;

import android.text.TextUtils;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.DrivingScoreFragment2Adapter;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.DrivingBehaviorBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.ui.base.BaseListenerFragment;
import com.cvnavi.app.ui.customize.DoubleDatePickerDialog;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.ToastUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import butterknife.BindView;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/18 11:33
 * version: 1.0
 * Depict: 驾驶评分 查询
 */

public class DrivingScoreFragment2 extends BaseListenerFragment {

    @BindView(R.id.allTime_tv)
    TextView mAllTimeTv;
    @BindView(R.id.allMile_tv)
    TextView mAllMileTv;
    @BindView(R.id.allOilConsumption_tv)
    TextView mAllOilConsumptionTv;
    @BindView(R.id.averageOilConsumption2_tv)
    TextView mAverageOilConsumption2Tv;
    @BindView(R.id.averagescore_tv)
    TextView mAveragescoreTv;
    @BindView(R.id.lv)
    ListView mLv;

    List<DrivingBehaviorBean.DriveingRecordItem> mList = new ArrayList<>();
    DrivingScoreFragment2Adapter adapter;

    @Override
    public int getLayoutID() {
        return R.layout.fram_driving_score_2;
    }

    @Override
    public void initView() {
        adapter = new DrivingScoreFragment2Adapter(getActivity(), mList);
        mLv.setAdapter(adapter);
    }

    @Override
    protected void lazyLoad() {
//        showDatePickerDialog();
    }

    DrivingBehaviorBean behaviorBean;

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        if (!AgreementUtils.agreement_57_01.equals(code))
            return;

        if (null == mAllTimeTv)
            return;

        if (null == baseBean)
            return;

        if (null == baseBean.getModel())
            return;

        behaviorBean = (DrivingBehaviorBean) baseBean.getModel();
        //总时长
        if (!TextUtils.isEmpty(behaviorBean.getAllTime())) {
            mAllTimeTv.setText(behaviorBean.getAllTime());
        }

        //总里程
        if (!TextUtils.isEmpty(behaviorBean.getAllMile())) {
            mAllMileTv.setText(behaviorBean.getAllMile() + " KM");
        }

        //总油耗
        if (!TextUtils.isEmpty(behaviorBean.getAllOilConsumption())) {
            mAllOilConsumptionTv.setText(behaviorBean.getAllOilConsumption() + " L");
        }

        //平均油耗
        if (!TextUtils.isEmpty(behaviorBean.getAverageOilConsumption2())) {
            mAverageOilConsumption2Tv.setText(behaviorBean.getAverageOilConsumption2() + " L/KM");
        }

        //平均分数
        if (!TextUtils.isEmpty(behaviorBean.getAveragescore())) {
            mAveragescoreTv.setText(behaviorBean.getAveragescore());
        }
    }

    @Override
    public void sendMsg() {

    }


}
