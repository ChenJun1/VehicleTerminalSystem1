package com.cvnavi.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.FatigueDrivingBean;

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

public class TravelRecordFragment2Adapter extends BaseAdapter {

    private List<FatigueDrivingBean.FatigueDrivingItem> mBeanList;
    private LayoutInflater inflater;

    public TravelRecordFragment2Adapter(Context context, @NonNull List<FatigueDrivingBean.FatigueDrivingItem> list) {
        this.mBeanList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mBeanList != null ? mBeanList.size() : 0;
    }

    @Override
    public FatigueDrivingBean.FatigueDrivingItem getItem(int i) {
        return mBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void UpdaListData(List<FatigueDrivingBean.FatigueDrivingItem> BeanList){
        if( mBeanList!=null) {
            mBeanList.clear();
            mBeanList.addAll(BeanList);
            this.notifyDataSetChanged();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_travel_record_2, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (mBeanList.get(position) != null) {
            viewHolder.mIndexTv.setText(position + 1 + "");
            viewHolder.mLicenseNoTv.setText(mBeanList.get(position).getLicenseNo());
            viewHolder.mBeginTimeTv.setText(mBeanList.get(position).getBeginTime());
            viewHolder.mEndTimeTv.setText(mBeanList.get(position).getEndTime());
        }
        return convertView;
    }


    static class ViewHolder {
        @BindView(R.id.index_tv)
        TextView mIndexTv;
        @BindView(R.id.licenseNo_tv)
        TextView mLicenseNoTv;
        @BindView(R.id.begin_time_tv)
        TextView mBeginTimeTv;
        @BindView(R.id.endTime_tv)
        TextView mEndTimeTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
