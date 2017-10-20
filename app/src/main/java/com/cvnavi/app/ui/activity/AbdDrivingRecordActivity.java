package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.ListView;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.BadDrivingRecordAdapter;
import com.cvnavi.app.bean.BadDrivingBean;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.DateUtils;

import java.util.List;

import butterknife.BindView;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/22 10:05
 * version:
 * Depict: 不良驾驶记录
 */

public class AbdDrivingRecordActivity extends ToolbarActivity {

    @BindView(R.id.lv)
    ListView mLv;
    BadDrivingRecordAdapter mAdapter;
    List<BadDrivingBean.BadDrivingItem> mItemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bad_driving_record);
    }

    @Override
    protected void initView() {
        setTitle("不良驾驶记录");
        mAdapter = new BadDrivingRecordAdapter(this, mItemList);
        mLv.setAdapter(mAdapter);
    }

    @Override
    protected void initData() {
        super.initData();

        //当前时间
        int[] nowDateTimeArry = ContentUtils.getDateTimeArry(
                DateUtils.dateToCalendar(
                        DateUtils.strToData(DateUtils.getDataTime(), DateUtils.dateFormat_1)));
        if(nowDateTimeArry!=null) {
            int[] dateTime = new int[]{nowDateTimeArry[0],
                    nowDateTimeArry[1],
                    nowDateTimeArry[2],
                    0, 0, 0,
                    nowDateTimeArry[0],
                    nowDateTimeArry[1],
                    nowDateTimeArry[2],
                    23, 59, 59};
            byte[] bytes = RequestDataManage.getInstance().getMain_28(dateTime);
            ruquest(bytes);
        }
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
    public void notifyAllActivity(String code, BaseBean baseBean) {
        super.notifyAllActivity(code, baseBean);

        if (!AgreementUtils.agreement_28.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;

        BadDrivingBean bean = (BadDrivingBean) baseBean.getModel();
        if (null == bean)
            return;

        //更新数据
        if (bean.getRecords() != null) {
            mAdapter.UpdaListData(bean.getRecords());
        }
    }

    public static void star(Context activity) {
        activity.startActivity(new Intent(activity, AbdDrivingRecordActivity.class));
    }
}
