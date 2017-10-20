package com.cvnavi.app.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.cvnavi.app.R;
import com.cvnavi.app.ui.fragment.TextInformationFragment;

/**
 * 文本信息 Activity
 */
public class TextInformationActivity extends AppCompatActivity {

//    @BindView(R.id.viewpager)
//    ViewPager viewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_information);
        getSupportFragmentManager().beginTransaction().replace(R.id.linearlayout, new TextInformationFragment()).commit();
    }
}
