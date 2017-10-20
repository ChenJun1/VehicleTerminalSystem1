package com.cvnavi.app.ui.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.bean.AlertMessageBean;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.BottomMessageBean;
import com.cvnavi.app.bean.MessageBean;
import com.cvnavi.app.commanage.IListener;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.db.MessageDao;
import com.cvnavi.app.ui.base.BaseActivity;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by wangshy on 17/7/13.
 */

public abstract class ToolbarActivity extends BaseActivity implements View.OnClickListener,
        IListener<BaseBean> {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.framelayout_lift_home)
    FrameLayout framelayoutLiftHome;
    @BindView(R.id.ImageView_lift)
    ImageView ImageViewLift; //信号1
    @BindView(R.id.lift_imagtwo)
    ImageView liftImagtwo;  //信号2
    @BindView(R.id.tv_local_music)
    TextView tvLocalMusic;
    @BindView(R.id.toolbar_back_text)
    ImageView toolbarBackText;
    @BindView(R.id.iv_search)
    ImageView ivSearch;
    @BindView(R.id.imagview_lift_home)
    ImageView imagviewLiftHome;
    @BindView(R.id.framelayout)
    FrameLayout framelayout;
    @BindView(R.id.toolbar_back_layout)
    FrameLayout toolbarBackLayout;
    @BindView(R.id.framelayout_right)
    FrameLayout framelayoutRight;
    @BindView(R.id.toolbar_gpstext)
    TextView toolbargpstext;
    @BindView(R.id.toolbar_dangertext)
    TextView toolbarDangertext;
    @BindView(R.id.toolbar_newstext)
    TextView toolbarNewstext;
    @BindView(R.id.toolbar_gps_layout)
    LinearLayout toolbarGpsLayout;
    @BindView(R.id.weixing)
    ImageView weixing;

    public void setToolbarRightBack(int back) {
        if (null != toolbarBackText) {
            toolbarBackText.setVisibility(back);
        }
    }

    public void setTitle(String title) {
        if (null != tvLocalMusic) {
            tvLocalMusic.setText(title);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.framelayout_lift_home:
            case R.id.imagview_lift_home:
                Intent home = new Intent(Intent.ACTION_MAIN);
                home.addCategory(Intent.CATEGORY_HOME);
                startActivity(home);
                break;
            case R.id.toolbar_back_text:
            case R.id.toolbar_back_layout:
                finish();
                break;
            case R.id.framelayout:

                break;
            case R.id.framelayout_right:
//                startActivity(new Intent(this, AlarmInformationFragment.class));
                break;
        }
    }

    @Override
    protected void initData() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        if (mToolbar == null) {
            throw new IllegalStateException("Layout is required to include a Toolbar with id 'toolbar'");
        }
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        ButterKnife.bind(this);
        ListenerManager.getInstance().registerListtener(this); //注册监听


    }

    @Override
    public void initListener() {
        super.initListener();
        if (null != framelayoutLiftHome)
            framelayoutLiftHome.setOnClickListener(this);
        if (null != toolbarBackText)
            toolbarBackText.setOnClickListener(this);
        if (null != imagviewLiftHome)
            imagviewLiftHome.setOnClickListener(this);
        if (null != toolbarBackLayout)
            toolbarBackLayout.setOnClickListener(this);
        if (null != framelayout) {
            framelayout.setOnClickListener(this);
        }
        if (null != framelayoutRight) {
            framelayoutRight.setOnClickListener(this);
        }
    }

    public void sendMsg() {
        UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_22());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ListenerManager.getInstance().unRegisterListener(this); //反注册、、、、
    }

    TextView title;
    TextView conten;
    TextView form;
    TextView date;
    Button button;

    /**
     * 短信提示框
     */
    public void showTextInformationPop(MessageBean bean) {
        View contentView = LayoutInflater.from(this).inflate(R.layout.layout_text_information_pop, null);
        title = (TextView) contentView.findViewById(R.id.pop_title_tv);
        conten = (TextView) contentView.findViewById(R.id.pop_content_tv);
        form = (TextView) contentView.findViewById(R.id.pop_form_tv);
        date = (TextView) contentView.findViewById(R.id.pop_date_tv);
        button = (Button) contentView.findViewById(R.id.pop_determine_bt);
        if (!TextUtils.isEmpty(bean.getContent()))
            conten.setText(bean.getContent());
        if (!TextUtils.isEmpty(bean.getSource()))
            form.setText("来源：" + bean.getSource());
        if (!TextUtils.isEmpty(bean.getTime()))
            date.setText(bean.getTime());

        final PopupWindow popupWindow = new PopupWindow(contentView);
        popupWindow.setWidth(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(false);
        popupWindow.setTouchable(true);
        popupWindow.setOutsideTouchable(false);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });
        popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
    }

    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            // handle message
            if (SeppAlarmpopup.isShowing())
                SeppAlarmpopup.dismiss();
        }
    };
    PopupWindow SeppAlarmpopup;

    /**
     * 超速报警弹窗
     */
    private void showSeppAlarmPop(AlertMessageBean bean) {
        View contentView = LayoutInflater.from(this).inflate(R.layout.layout_speeding_alarm_dialog, null);
        TextView content = (TextView) contentView.findViewById(R.id.content_tv);
        if (!TextUtils.isEmpty(bean.getContent()))
            content.setText(bean.getContent());

        SeppAlarmpopup = new PopupWindow(contentView);
        SeppAlarmpopup.setWidth(350);
        SeppAlarmpopup.setHeight(100);
        SeppAlarmpopup.setTouchable(true);
        SeppAlarmpopup.setFocusable(false);
        SeppAlarmpopup.setOutsideTouchable(true);
        SeppAlarmpopup.setBackgroundDrawable(new BitmapDrawable());
        if (bean.getTime() > 0) {
            SeppAlarmpopup.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
            handler.sendEmptyMessageDelayed(1, bean.getTime() * 1000);
        }
    }

    /**
     * show底部信息
     * @param bean
     */
    private void showBottomMessage(BottomMessageBean bean) {
        if (!TextUtils.isEmpty(bean.getContent()) && bean.getTime() > 0)
            ToastUtils.showTimeToast(bean.getContent(), bean.getTime() * 1000);
    }


    @SuppressLint("SetTextI18n")
    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        if (!AgreementUtils.agreement_47.equals(code) &&
                !AgreementUtils.agreement_23.equals(code) &&
                !AgreementUtils.agreement_45.equals(code) &&
                !AgreementUtils.agreement_44.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;

        //短信弹窗提示
        if (AgreementUtils.agreement_23.equals(code)) {
            MessageBean bean = (MessageBean) baseBean.getModel();
            if (bean != null) {
                MessageDao messageDao = new MessageDao(this);
                messageDao.insert(bean);
                showTextInformationPop(bean);
            }
        }
        //弹窗报警
        if (AgreementUtils.agreement_45.equals(code)) {
            AlertMessageBean bean = (AlertMessageBean) baseBean.getModel();
            if (bean != null)
                showSeppAlarmPop(bean);
        }
        //底部通知条
        if (AgreementUtils.agreement_44.equals(code)) {
            BottomMessageBean bean = (BottomMessageBean) baseBean.getModel();
            if (bean != null)
                showBottomMessage(bean);
        }

        //危险报警数量
//        if (0 >= homeBean.getMessage()) {
//            toolbarNewstext.setVisibility(View.GONE);
//        } else {
//            toolbarNewstext.setVisibility(View.VISIBLE);
//        toolbarDangertext.setText(baseBean.getWarning() + "");
//        }

        //消息数量
//        if (0 >= homeBean.getWarning()) {
//            toolbarDangertext.setVisibility(View.GONE);
//        } else {
//        toolbarNewstext.setText(baseBean.getMessage() + "");
//            toolbarDangertext.setVisibility(View.VISIBLE);
//        }
        //卫星定位
        if (null != baseBean.getGprsState() && baseBean.getGprsState().equals("00")) {
            toolbarGpsLayout.setVisibility(View.VISIBLE);
            weixing.setImageResource(R.mipmap.leida);
            toolbargpstext.setVisibility(View.GONE);
        } else if (null != baseBean.getGprsState() && baseBean.getGprsState().equals("01")) {
            toolbarGpsLayout.setVisibility(View.VISIBLE);
            toolbargpstext.setVisibility(View.VISIBLE);
            weixing.setImageResource(R.mipmap.leida2);
            toolbargpstext.setText(baseBean.getSatelliteNo() + "");
        } else if (null != baseBean.getGprsState() && baseBean.getGprsState().equals("02")) {
            toolbargpstext.setVisibility(View.GONE);
            weixing.setImageResource(R.mipmap.leida_wu);
        }

        // 信号1
        if (null != baseBean.getIconDisplay1() && baseBean.getIconDisplay1().equals("00")) {//不显示
            ImageViewLift.setVisibility(View.GONE);
        } else if (null != baseBean.getIconDisplay1() && baseBean.getIconDisplay1().equals("01")) { //显示 的同时 再进行判断连接 断开 和未连接
            ImageViewLift.setVisibility(View.VISIBLE);
            if (null != baseBean.getIsConnnect1() && baseBean.getIsConnnect1().equals("00")) { //未连接
                ImageViewLift.setImageResource(R.mipmap.toolbar_signal1);
            } else if (null != baseBean.getIsConnnect1() && baseBean.getIsConnnect1().equals("01")) { //已连接  //同时判断显示几格信号
                switch (baseBean.getSignanItensity1()) {
                    case 0:
                        ImageViewLift.setImageResource(R.mipmap.toolbar_signal1_0);
                        break;
                    case 1:
                        ImageViewLift.setImageResource(R.mipmap.toolbar_signal1_1);
                        break;
                    case 2:
                        ImageViewLift.setImageResource(R.mipmap.toolbar_signal1_2);
                        break;
                    case 3:
                        ImageViewLift.setImageResource(R.mipmap.toolbar_signal1_3);
                        break;
                    case 4:
                        ImageViewLift.setImageResource(R.mipmap.toolbar_signal1_4);
                        break;
                    case 5:
                        ImageViewLift.setImageResource(R.mipmap.toolbar_signal1_5);
                        break;
                }
            } else if (null != baseBean.getIsConnnect1() && baseBean.getIsConnnect1().equals("02")) { //已断开
                ImageViewLift.setImageResource(R.mipmap.toolbar_signal1_wu);
            }
        }
        //信号2
        if (null != baseBean.getIconDisplay2() && baseBean.getIconDisplay2().equals("00")) {
            liftImagtwo.setVisibility(View.GONE);
        } else if (null != baseBean.getIconDisplay2() && baseBean.getIconDisplay1().equals("01")) {
            liftImagtwo.setVisibility(View.VISIBLE);
            if (null != baseBean.getIsConnnect2() && baseBean.getIsConnnect2().equals("00")) { //未连接
                liftImagtwo.setImageResource(R.mipmap.toolbar_signal2);
            } else if (null != baseBean.getIsConnnect2() && baseBean.getIsConnnect2().equals("01")) { //已连接  //同时判断显示几格信号
                switch (baseBean.getSignanItensity2()) {
                    case 0:
                        liftImagtwo.setImageResource(R.mipmap.toolbar_signal2_0);
                        break;
                    case 1:
                        liftImagtwo.setImageResource(R.mipmap.toolbar_signal2_1);
                        break;
                    case 2:
                        liftImagtwo.setImageResource(R.mipmap.toolbar_signal2_2);
                        break;
                    case 3:
                        liftImagtwo.setImageResource(R.mipmap.toolbar_signal2_3);
                        break;
                    case 4:
                        liftImagtwo.setImageResource(R.mipmap.toolbar_signal2_4);
                        break;
                    case 5:
                        liftImagtwo.setImageResource(R.mipmap.toolbar_signal2_5);
                        break;
                }
            } else if (null != baseBean.getIsConnnect2() && baseBean.getIsConnnect2().equals("02")) { //已断开
                liftImagtwo.setImageResource(R.mipmap.toolbar_signal2_wu);
            }
        }
    }

}
