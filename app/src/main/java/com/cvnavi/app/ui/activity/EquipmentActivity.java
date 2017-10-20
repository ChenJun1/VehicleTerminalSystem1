package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cvnavi.app.R;

/**
 * 设备管理
 */
public class EquipmentActivity extends ToolbarActivity {
    public static void star(Context context) {
        context.startActivity(new Intent(context, EquipmentActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_equipment);
    }

    @Override
    protected void initView() {
        setTitle("设备管理");
    }

    /**
     * 平台注册
     *
     * @param view
     */
    public void onRegistered(View view) {
        PlatformRegistrationActivity.start(this);
    }

    /**
     * 定位状态
     *
     * @param view
     */
    public void onPositioning(View view) {
        PositioningStatusActivity.star(this);
    }

    /**
     * 设备参数
     *
     * @param view
     */
    public void onEquipment(View view) {
        SetDeviceParametersActivity.start(this);
    }

    /**
     * 工程菜单
     *
     * @param view
     */
    public void onEngineering(View view) {
        TriaxialStateActivity.onStar(this);
    }

    /**
     * 定位状态
     *
     * @param view
     */
    public void onInformation(View view) {

    }

    /**
     * 设备参数
     *
     * @param view
     */
    public void onSystem(View view) {

    }
}
