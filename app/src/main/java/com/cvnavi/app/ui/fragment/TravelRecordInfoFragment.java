package com.cvnavi.app.ui.fragment;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.FatigueDrivingBean;
import com.cvnavi.app.ui.base.BaseFragment;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

/**
 * Created by wangshy on 17/7/28.
 */

public class TravelRecordInfoFragment extends BaseFragment {
    @BindView(R.id.driving_time_view)
    TextView drivingTimeView;
    @BindView(R.id.start_time_view)
    TextView startTimeView;
    @BindView(R.id.star_longitude_view)
    TextView starLongitudeView;
    @BindView(R.id.star_latitude_view)
    TextView starLatitudeView;
    @BindView(R.id.star_altitude_view)
    TextView starAltitudeView;
    @BindView(R.id.drivers_license_number_view)
    TextView driversLicenseNumberView;
    @BindView(R.id.end_time_view)
    TextView endTimeView;
    @BindView(R.id.longitude_view)
    TextView longitudeView;
    @BindView(R.id.latitude_view)
    TextView latitudeView;
    @BindView(R.id.altitude_view)
    TextView altitudeView;

    private boolean b = false;

    public static TravelRecordInfoFragment getTravelRecordInforFragment(FatigueDrivingBean.FatigueDrivingItem position) {
        TravelRecordInfoFragment fragment = new TravelRecordInfoFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable("CLZZ", position);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getLayoutID() {
        return R.layout.layout_traverecoreinfo;
    }

    @Override
    public void initView() {
        if (b)
            return;
        FatigueDrivingBean.FatigueDrivingItem str = getArguments().getParcelable("CLZZ");
        if (null == str)
            return;
        if (!"--".equals(str.getEndTime()) && !"--".equals(str.getBeginTime()))
            drivingTimeView.setText(getData(str.getEndTime(), str.getBeginTime()));
        if (!"--".equals(str.getBeginTime()))
            startTimeView.setText(str.getBeginTime());
        if (!"--".equals(str.getBeginLongitude()))
            starLongitudeView.setText(str.getBeginLongitude() + "°");
        if (!"--".equals(str.getBeginLatitude()))
            starLatitudeView.setText(str.getBeginLatitude() + "°");
        if (!"--".equals(str.getBeginAltitude()))
            starAltitudeView.setText(str.getBeginAltitude() + "m");
        if (!"--".equals(str.getLicenseNo()))
            driversLicenseNumberView.setText(str.getLicenseNo());
        if (!"--".equals(str.getEndTime()))
            endTimeView.setText(str.getEndTime());
        if (!"--".equals(str.getEndLongitude()))
            longitudeView.setText(str.getEndLongitude() + "°");
        if (!"--".equals(str.getEndLatitude()))
            latitudeView.setText(str.getEndLatitude() + "°");
        if (!"--".equals(str.getEndAltitude()))
            altitudeView.setText(str.getEndAltitude() + "m");
        b = true;
    }

    @Override
    protected void lazyLoad() {
    }

    private String getData(String time, String time1) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d1 = df.parse(time);
            Date d2 = df.parse(time1);
            long diff = d1.getTime() - d2.getTime();
            long days = diff / (1000 * 60 * 60 * 24);
            long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
            long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
            if (days > 0)
                return days + "天" + hours + "小时" + minutes + "分";
            if (hours > 0)
                return hours + "小时" + minutes + "分";
            if (minutes > 0)
                return minutes + "分";
        } catch (Exception e) {
        }
        return "----";
    }
}
