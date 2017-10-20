package com.cvnavi.app.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.AccidentRecordBean;

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

public class TravelRecordFragment1Adapter extends BaseAdapter {

    private List<AccidentRecordBean.AccidentRecordItem> mBeanList;
    private LayoutInflater inflater;

    public TravelRecordFragment1Adapter(Context context, @NonNull List<AccidentRecordBean.AccidentRecordItem> list) {
        this.mBeanList = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mBeanList != null ? mBeanList.size() : 0;
    }

    @Override
    public AccidentRecordBean.AccidentRecordItem getItem(int i) {
        return mBeanList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void UpdaListData(List<AccidentRecordBean.AccidentRecordItem> BeanList){
       if( mBeanList!=null) {
           mBeanList.clear();
           mBeanList.addAll(BeanList);
           this.notifyDataSetChanged();
       }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        ViewHolder viewHolder;

        if (null == convertView) {
            convertView = inflater.inflate(R.layout.item_travel_record_1, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if(mBeanList.get(position)!=null) {
            viewHolder.mIndexTv.setText(position + 1 + "");
            viewHolder.mEndTimeTv.setText(mBeanList.get(position).getEndTime());
            viewHolder.mLicenseNoTv.setText(mBeanList.get(position).getLicenseNo());
            viewHolder.mLongitudeTv.setText(mBeanList.get(position).getLongitude());
            viewHolder.mLatitudeTv.setText(mBeanList.get(position).getLatitude());
            viewHolder.mAltitudeTv.setText(mBeanList.get(position).getAltitude());
        }
        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.index_tv)
        TextView mIndexTv;
        @BindView(R.id.endTime_tv)
        TextView mEndTimeTv;
        @BindView(R.id.licenseNo_tv)
        TextView mLicenseNoTv;
        @BindView(R.id.longitude_tv)
        TextView mLongitudeTv;
        @BindView(R.id.latitude_tv)
        TextView mLatitudeTv;
        @BindView(R.id.altitude_tv)
        TextView mAltitudeTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
