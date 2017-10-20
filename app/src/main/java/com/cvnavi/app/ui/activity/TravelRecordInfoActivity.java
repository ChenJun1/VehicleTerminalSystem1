package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.FatigueDrivingBean;
import com.cvnavi.app.ui.fragment.TravelRecordInfoFragment;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * 超时行驶记录
 */
public class TravelRecordInfoActivity extends ToolbarActivity {
    @BindView(R.id.traverecoreinfo_viewpager)
    ViewPager traverecoreinfoViewpager;
    @BindView(R.id.serial_number_view)
    TextView serialNumberView;
    @BindView(R.id.lift_imag_view)
    ImageView liftImagView;
    @BindView(R.id.right_imag_view)
    ImageView rightImagView;

    private FatigueDrivingBean bean = null;

//    @SuppressLint("NewApi")
//   public static void start(Context context, FatigueDrivingBean bean) {
//        Bundle bundle = new Bundle();
//        bundle.putParcelable("CLZZ", bean);
//        context.startActivity(new Intent(context, TravelRecordInfoActivity.class), bundle);
//   }
   public static void start(Context context,FatigueDrivingBean bean) {
       Intent starter = new Intent(context, TravelRecordInfoActivity.class);
       starter.putExtra("CLZZ", (Parcelable) bean);
       context.startActivity(starter);
   }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel_record_info);
        setTitle("超时行驶记录");
        bean =getIntent().getParcelableExtra("CLZZ");
        traverecoreinfoViewpager.setAdapter(new SimpleFragmentAdapter(getSupportFragmentManager()));
        traverecoreinfoViewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    setAnimationInVisible(liftImagView);
                    liftImagView.setVisibility(View.INVISIBLE);
                } else {
                    if (liftImagView.getVisibility() != View.VISIBLE) {
                        setAnimationVisible(liftImagView);
                        liftImagView.setVisibility(View.VISIBLE);
                    }
                }
                if (null == bean || null == bean.getRecords()) {
                    return;
                }
                if (position == bean.getRecords().size() - 1) {
                    setAnimationInVisible(rightImagView);
                    rightImagView.setVisibility(View.INVISIBLE);
                } else {
                    if (rightImagView.getVisibility() != View.VISIBLE) {
                        setAnimationVisible(rightImagView);
                        rightImagView.setVisibility(View.VISIBLE);
                    }
                }
                serialNumberView.setText(position + 1 + "");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    protected void initView() {

    }

    @OnClick({R.id.lift_imag_view, R.id.right_imag_view})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.lift_imag_view:
                if (traverecoreinfoViewpager.getCurrentItem() == 0)
                    return;
                traverecoreinfoViewpager.setCurrentItem(traverecoreinfoViewpager.getCurrentItem() - 1);
                break;
            case R.id.right_imag_view:
                if ((null == bean || null == bean.getRecords()))
                    return;
                if (traverecoreinfoViewpager.getCurrentItem() == bean.getRecords().size())
                    return;
                traverecoreinfoViewpager.setCurrentItem(traverecoreinfoViewpager.getCurrentItem() + 1);
                break;
        }
    }

    public class SimpleFragmentAdapter extends FragmentPagerAdapter {

        public SimpleFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            TravelRecordInfoFragment fragment = TravelRecordInfoFragment.getTravelRecordInforFragment(bean.getRecords().get(position));
            return fragment;
        }

        @Override
        public int getCount() {
            return null == bean || null == bean.getRecords() ? 0 : bean.getRecords().size();
        }
    }

    private void setAnimationVisible(View v) {
        AlphaAnimation animtion = new AlphaAnimation(0, 1);
        animtion.setDuration(500);
        v.startAnimation(animtion);
    }

    private void setAnimationInVisible(View v) {
        AlphaAnimation animtion = new AlphaAnimation(1, 0);
        animtion.setDuration(500);
        v.startAnimation(animtion);
    }
}
