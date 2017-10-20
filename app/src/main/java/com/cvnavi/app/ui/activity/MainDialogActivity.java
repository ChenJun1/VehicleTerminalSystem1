package com.cvnavi.app.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.cvnavi.app.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 版权所有 上海势航网络科技
 * Created:  ChenJun
 * Email:  791954958@qq.com
 * Phone:
 * CreatedTime:  2017/7/13 10:18
 * version: 1.0
 * Depict:
 */

public class MainDialogActivity extends Activity {

    @BindView(R.id.close_iv)
    ImageView mCloseIv;
    @BindView(R.id.kongzai_rb)
    RadioButton mKongzaiRb;
    @BindView(R.id.banzai_rb)
    RadioButton mBanzaiRb;
    @BindView(R.id.manzai_rb)
    RadioButton mManzaiRb;
    @BindView(R.id.zzzt_rg)
    RadioGroup mZzztRg;
    @BindView(R.id.close_ll)
    LinearLayout mCloseLl;


    public static void start(Context context) {
        Intent starter = new Intent(context, MainDialogActivity.class);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.dialog_activity_load_status);
        ButterKnife.bind(this);
        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        String status = "";
        if (!TextUtils.isEmpty(getIntent().getStringExtra("status"))) {
            status = getIntent().getStringExtra("status");
        }
        init(status);
    }


    private void init(String status) {
        switch (status) {
            case "空载":
                mKongzaiRb.setChecked(true);
                break;
            case "半载":
                mBanzaiRb.setChecked(true);
                break;
            case "满载":
                mManzaiRb.setChecked(true);
                break;
            default:
                break;
        }
    }

    @OnClick({R.id.close_ll, R.id.kongzai_rb, R.id.banzai_rb, R.id.manzai_rb})
    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.close_ll:
                this.finish();
                break;
            case R.id.kongzai_rb:
                intent = new Intent();
                intent.putExtra("status", "1");
                setResult(RESULT_OK, intent);
                this.finish();
                break;
            case R.id.banzai_rb:
                intent = new Intent();
                intent.putExtra("status", "2");
                setResult(RESULT_OK, intent);
                this.finish();
                break;
            case R.id.manzai_rb:
                intent = new Intent();
                intent.putExtra("status", "3");
                setResult(RESULT_OK, intent);
                this.finish();
                break;
        }
    }
}
