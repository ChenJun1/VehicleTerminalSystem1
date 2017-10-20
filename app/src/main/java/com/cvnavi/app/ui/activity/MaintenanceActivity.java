package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cvnavi.app.R;

public class MaintenanceActivity extends ToolbarActivity {
    public static void onStar(Context context) {
        context.startActivity(new Intent(context, MaintenanceActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintenance);
    }

    @Override
    protected void initView() {

    }

    public void onExcellentDriving(View view) {
        ExcellentDrivingActivity.onStar(this);
    }

    public void onSalesInformation(View view) {
        SellCreditActivity.onStar(this);
    }
}
