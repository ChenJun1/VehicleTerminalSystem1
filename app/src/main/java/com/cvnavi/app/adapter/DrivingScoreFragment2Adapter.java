package com.cvnavi.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.DrivingBehaviorBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/18 11:48
 * version: 1.0
 * Depict:
 */

public class DrivingScoreFragment2Adapter extends BaseAdapter {

    private List<DrivingBehaviorBean.DriveingRecordItem> mBeanList;
    private LayoutInflater inflater;

    public DrivingScoreFragment2Adapter(Context context, @NonNull List<DrivingBehaviorBean.DriveingRecordItem> list) {
        this.mBeanList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mBeanList != null ? mBeanList.size() : 0;
    }

    @Override
    public DrivingBehaviorBean.DriveingRecordItem getItem(int i) {
        return mBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (null==convertView) {
            convertView = inflater.inflate(R.layout.item_driving_score_2, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.mSerialNumberTv.setText(position + 1+"");
        viewHolder.mBeginTimeTv.setText(mBeanList.get(position).getBegin()+"/"+mBeanList.get(position).getEnd());
        viewHolder.mMileageTv.setText(mBeanList.get(position).getMileage());
        viewHolder.mOilConsumptionTv.setText(mBeanList.get(position).getOilConsumption());
        viewHolder.mAverageOilConsumptionTv.setText(mBeanList.get(position).getAverageOilConsumption());
        viewHolder.mAveragescoreTv.setText(mBeanList.get(position).getAveragescore());
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.serial_number_tv)
        TextView mSerialNumberTv;
        @BindView(R.id.begin_time_tv)
        TextView mBeginTimeTv;
        @BindView(R.id.mileage_tv)
        TextView mMileageTv;
        @BindView(R.id.oilConsumption_tv)
        TextView mOilConsumptionTv;
        @BindView(R.id.averageOilConsumption_tv)
        TextView mAverageOilConsumptionTv;
        @BindView(R.id.averagescore_tv)
        TextView mAveragescoreTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
