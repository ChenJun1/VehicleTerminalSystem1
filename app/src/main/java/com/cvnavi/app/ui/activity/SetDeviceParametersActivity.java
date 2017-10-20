package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.cvnavi.app.R;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/9/7 14:52
 * version:
 * Depict: 设置设备参数 4E 协议
 */

public class SetDeviceParametersActivity extends ToolbarActivity {
    public static void start(Context context) {
        Intent starter = new Intent(context, SetDeviceParametersActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_device_parameters);
    }
}
