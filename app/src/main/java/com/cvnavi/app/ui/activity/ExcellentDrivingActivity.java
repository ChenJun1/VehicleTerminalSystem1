package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cvnavi.app.R;

public class ExcellentDrivingActivity extends ToolbarActivity {
    public static void onStar(Context context) {
        context.startActivity(new Intent(context, ExcellentDrivingActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_excellent_driving);
    }

    @Override
    protected void initView() {

    }
}
