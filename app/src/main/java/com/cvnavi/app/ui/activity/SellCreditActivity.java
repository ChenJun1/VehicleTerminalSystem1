package com.cvnavi.app.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.cvnavi.app.R;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.LoanSalesBean;
import com.cvnavi.app.commanage.RequestDataManage;
import com.cvnavi.app.commanage.UIMessageManager;
import com.cvnavi.app.utils.AgreementUtils;

import butterknife.BindView;

public class SellCreditActivity extends ToolbarActivity {
    public static void onStar(Context context) {
        context.startActivity(new Intent(context, SellCreditActivity.class));
    }

    @BindView(R.id.online_status_view)
    TextView onlineStatusView;
    @BindView(R.id.Terminal_ID_view)
    TextView TerminalIDView;
    @BindView(R.id.IP_address_view)
    TextView IPAddressView;
    @BindView(R.id.port_view)
    TextView portView;
    @BindView(R.id.Models_view)
    TextView ModelsView;
    @BindView(R.id.Sales_version_view)
    TextView SalesVersionView;
    @BindView(R.id.Binding_status_view)
    TextView BindingStatusView;
    @BindView(R.id.Bind_engine_view)
    TextView BindEngineView;
    @BindView(R.id.Lock_direction_view)
    TextView LockDirectionView;
    @BindView(R.id.Control_state_view)
    TextView ControlStateView;
    @BindView(R.id.Repayment_date_view)
    TextView RepaymentDateView;
    @BindView(R.id.Expired_days_view)
    TextView ExpiredDaysView;
    @BindView(R.id.Date_of_Expiry_view)
    TextView DateOfExpiryView;
    @BindView(R.id.Engine_EUC_type_view)
    TextView EngineEUCTypeView;
    @BindView(R.id.Current_engine_ID_view)
    TextView CurrentEngineIDView;
    @BindView(R.id.can_view)
    TextView canView;
    @BindView(R.id.gis_view)
    TextView gisView;
    @BindView(R.id.vcn_view)
    TextView vcnView;
    @BindView(R.id.amt_view)
    TextView amtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_credit);
    }

    private boolean flg = true;
    private Runnable mRunnable = new Runnable() {
        @Override
        public void run() {
            while (flg) {
                UIMessageManager.getInstance().send(RequestDataManage.getInstance().getMain_51());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        flg = false;
        ThreadManager.cancel(mRunnable);
    }

    @Override
    protected void initView() {
        setTitle("销贷信息");
        flg = true;
        ThreadManager.execute(mRunnable);
    }

    @Override
    public void notifyAllActivity(String code, BaseBean baseBean) {
        super.notifyAllActivity(code, baseBean);
        if (!AgreementUtils.agreement_53.equals(code)) {
            return;
        }
        if (null == baseBean)
            return;
        LoanSalesBean bean = (LoanSalesBean) baseBean.getModel();
        if (null == bean)
            return;
        if (bean.getVcuState() == 1)                   // vcn 状态
            vcnView.setText("在线");
        else
            vcnView.setText("离线");
        if (bean.getAmtState() == 1)                   // amt 状态
            amtView.setText("在线");
        else
            amtView.setText("离线");
        if (bean.getBingingState() == 1)               // 绑定状态
            BindingStatusView.setText("在线");
        else
            BindingStatusView.setText("离线");
        canView.setText(bean.getCanReturnFrequency()); //can 数据回传频率
        gisView.setText(bean.getGisReturnFrequency()); //gis回传频率
        if (bean.getOnLineState() == 1)                //在线状态
            onlineStatusView.setText("在线");
        else
            onlineStatusView.setText("离线");
        TerminalIDView.setText(bean.getTerminalId()); //车厂终端ID
        IPAddressView.setText(bean.getIpAddress());   //IP地址
        portView.setText(bean.getPort());             //端口
        ModelsView.setText(bean.getModels());         //车型
        SalesVersionView.setText(bean.getLoanSalesVersion());//销贷版本
        EngineEUCTypeView.setText(bean.getEngineType());// 发动机类型
        CurrentEngineIDView.setText(bean.getEngineId());//发动机ID
        LockDirectionView.setText(bean.getLockStyle()); //车锁方向
        if (bean.getControlState() == 1)
            ControlStateView.setText("未控制");
        else
            ControlStateView.setText("已控制");
        RepaymentDateView.setText(bean.getRepaymentDate());//还款日期
        ExpiredDaysView.setText(bean.getOverdueDays());//超期天数
        DateOfExpiryView.setText(bean.getMaturityDate());//到期日期
        BindEngineView.setText(bean.getBoundEngineId()); //已绑定发动机ID
    }
}