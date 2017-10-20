package com.cvnavi.app.ui.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cvnavi.app.R;
import com.cvnavi.app.adapter.MoreFragmentAdapter;
import com.cvnavi.app.bean.MoreFragmentBean;
import com.cvnavi.app.ui.activity.AbdDrivingRecordActivity;
import com.cvnavi.app.ui.activity.Device_InformationActivity;
import com.cvnavi.app.ui.activity.EquipmentActivity;
import com.cvnavi.app.ui.activity.EquipmentDetectionActivity;
import com.cvnavi.app.ui.activity.Error_AlarmActivity;
import com.cvnavi.app.ui.activity.MaintenanceActivity;
import com.cvnavi.app.ui.activity.RealTimeInformationActivity;
import com.cvnavi.app.ui.activity.TravelRecordActivity;
import com.cvnavi.app.ui.activity.VehicleInformationActivity;
import com.cvnavi.app.ui.activity.VehicleParametersActivity;
import com.cvnavi.app.ui.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by wangshy on 17/7/27.
 */

public class MoreFragment extends BaseFragment {
    @BindView(R.id.fram_more_layou_rv)
    RecyclerView framMoreLayouRv;
//    @BindView(R.id.travel_record)
//    TextView travelRecord;
//    @BindView(R.id.Vehicle_Parameters)
//    TextView VehicleParameters;
//    @BindView(R.id.Equipment_Detection)
//    TextView EquipmentDetection;
//    @BindView(R.id.EquipmentManagement)
//    TextView EquipmentManagement;
//    @BindView(R.id.RealTimeInformationActivity)
//    TextView RealTimeInformation;
//    @BindView(R.id.Error_AlarmActivity)
//    TextView Error_Alarm;
//    @BindView(R.id.VehicleInformationActivity)
//    TextView VehicleInformation;
//    @BindView(R.id.AbdDrivingRecordActivity)
//    TextView AbdDrivingRecord;
//    @BindView(R.id.MaintenanceActivity)
//    TextView Maintenance;
//    @BindView(R.id.device_information_tv)
//    TextView DeviceInformationTv;

    @Override
    public int getLayoutID() {
        return R.layout.fram_more_layout;
    }

    @Override
    public void initView() {
        List<MoreFragmentBean> bean = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
        bean.add(new MoreFragmentBean(R.mipmap.travel_record1, R.mipmap.travel_record2, "行驶记录"));
        bean.add(new MoreFragmentBean(R.mipmap.vehicle_parameters1, R.mipmap.vehicle_parameters2, "车辆参数"));
        bean.add(new MoreFragmentBean(R.mipmap.equipment_detectio_1, R.mipmap.equipment_detectio_2n, "设备检测"));
        bean.add(new MoreFragmentBean(R.mipmap.equipment_management1, R.mipmap.equipment_management2, "设备管理"));
        bean.add(new MoreFragmentBean(R.mipmap.rea_time_data_1, R.mipmap.rea_time_data_2, "实时数据"));
        bean.add(new MoreFragmentBean(R.mipmap.basic_information1, R.mipmap.basic_information2, "基本信息"));
        bean.add(new MoreFragmentBean(R.mipmap.error_alarm1, R.mipmap.error_alarm2, "故障报警"));
        bean.add(new MoreFragmentBean(R.mipmap.bad_driving_record_1, R.mipmap.bad_driving_record_2, "不良驾驶记录"));
        bean.add(new MoreFragmentBean(R.mipmap.sales_management1, R.mipmap.sales_management2, "销贷管理"));
        bean.add(new MoreFragmentBean(R.mipmap.device_information1, R.mipmap.device_information2, "设备信息"));
//        }
        framMoreLayouRv.setLayoutManager(new GridLayoutManager(getActivity(), 5));
        MoreFragmentAdapter adapter = new MoreFragmentAdapter(bean);
        framMoreLayouRv.setAdapter(adapter);
        adapter.setClickListener(new MoreFragmentAdapter.OnClickListener() {
            @Override
            public void onClick(int p) {
                onClicked(p);
            }
        });

    }

    @Override
    protected void lazyLoad() {

    }


    public void onClicked(int p) {
        switch (p) {
            case 0:
                TravelRecordActivity.start(getActivity());
                break;
            case 1:
                VehicleParametersActivity.stat(getActivity());
                break;
            case 2:
                EquipmentDetectionActivity.start(getActivity());
                break;
            case 3:
                EquipmentActivity.star(getActivity());
                break;
            case 4:
                RealTimeInformationActivity.start(getActivity());
                break;
            case 5:
                Error_AlarmActivity.star(getActivity());
                break;
            case 6:
                VehicleInformationActivity.star(getActivity());
                break;
            case 7:
                AbdDrivingRecordActivity.star(getActivity());
                break;
            case 8:
                MaintenanceActivity.onStar(getActivity());
                break;
            case 9:
                Device_InformationActivity.star(getActivity());
                break;
        }
    }
}
