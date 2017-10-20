package com.cvnavi.app.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.BadDrivingBean;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/22 10:09
 * version:
 * Depict:
 */

public class BadDrivingRecordAdapter extends BaseAdapter {
    private List<BadDrivingBean.BadDrivingItem> mList;
    private LayoutInflater mInflater;

    public BadDrivingRecordAdapter(Context context, List<BadDrivingBean.BadDrivingItem> list) {
        this.mInflater = LayoutInflater.from(context);
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList == null ? 0 : mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void UpdaListData(List<BadDrivingBean.BadDrivingItem> BeanList){
        if( mList!=null) {
            mList.clear();
            mList.addAll(BeanList);
            this.notifyDataSetChanged();
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        BadDrivingBean.BadDrivingItem bean = mList.get(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_bad_driving_record, parent);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        if (bean != null) {
            viewHolder.mIndexTv.setText(position+1);
            if (!TextUtils.isEmpty(bean.getLicenseNo())) {
                viewHolder.mLicenseNoTv.setText(bean.getLicenseNo());
            }
            if (!TextUtils.isEmpty(bean.getBeginTime())) {
                viewHolder.mBeginTimeTv.setText(bean.getBeginTime());
            }
            if (!TextUtils.isEmpty(bean.getEndTime())) {
                viewHolder.mEndTimeTv.setText(bean.getEndTime());
            }
            if (!TextUtils.isEmpty(bean.getTurnOverNumber())) {
                viewHolder.mTurnOverNumberTv.setText(bean.getTurnOverNumber());
            }
            if (!TextUtils.isEmpty(bean.getSpeedingNumber())) {
                viewHolder.mSpeedingNumberTv.setText(bean.getSpeedingNumber());
            }
        }

        return convertView;
    }

    static class ViewHolder {
        @BindView(R.id.licenseNo_tv)
        TextView mLicenseNoTv;
        @BindView(R.id.index_tv)
        TextView mIndexTv;
        @BindView(R.id.beginTime_tv)
        TextView mBeginTimeTv;
        @BindView(R.id.endTime_tv)
        TextView mEndTimeTv;
        @BindView(R.id.turnOverNumber_tv)
        TextView mTurnOverNumberTv;
        @BindView(R.id.speedingNumber_tv)
        TextView mSpeedingNumberTv;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
