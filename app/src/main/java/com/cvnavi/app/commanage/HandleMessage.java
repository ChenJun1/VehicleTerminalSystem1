package com.cvnavi.app.commanage;

import com.apkfuns.logutils.LogUtils;
import com.cvnavi.app.analysis.AccidenfRecordAnalysisData;
import com.cvnavi.app.analysis.AlertMessageAnalysisData;
import com.cvnavi.app.analysis.BadDrivingAnalysisData;
import com.cvnavi.app.analysis.BaseAnalysisData;
import com.cvnavi.app.analysis.BottomMessageAnalysisData;
import com.cvnavi.app.analysis.DeviceMsgAnalysisData;
import com.cvnavi.app.analysis.DeviceTestAnalysisData;
import com.cvnavi.app.analysis.DrivingBehaviorAnalysisData;
import com.cvnavi.app.analysis.EfficiencyAnalysisAnalysisData;
import com.cvnavi.app.analysis.FatigueDrivingAnalysisData;
import com.cvnavi.app.analysis.FaultAlarmAnalysisData;
import com.cvnavi.app.analysis.HomeAnalysisData;
import com.cvnavi.app.analysis.InitializationAnalysisData;
import com.cvnavi.app.analysis.LoanSalesAnalysisData;
import com.cvnavi.app.analysis.MessageAnalysisData;
import com.cvnavi.app.analysis.OperatingLicenseAnalysisData;
import com.cvnavi.app.analysis.PositioningStatusAnalysisData;
import com.cvnavi.app.analysis.PrintThePageAnalysisData;
import com.cvnavi.app.analysis.QueryTerminalAnalysisData;
import com.cvnavi.app.analysis.RealTimeAnalysisData;
import com.cvnavi.app.analysis.RoutineRegisterAnalysisData;
import com.cvnavi.app.analysis.SettingTerminalAnalysisData;
import com.cvnavi.app.analysis.SignalStatusAnalysisData;
import com.cvnavi.app.analysis.TTSBroadcastTipsAnalysisData;
import com.cvnavi.app.analysis.ThreeAxleAnalysisData;
import com.cvnavi.app.analysis.UpgradeAnalysisData;
import com.cvnavi.app.analysis.VehicleInformationAnalysisData;
import com.cvnavi.app.analysis.VehicleParametersAnalysisData;
import com.cvnavi.app.analysis.WarningAnalysisData;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import java.util.Arrays;


/**
 * Created by zww on 2017/7/7.
 */

class HandleMessage {

    static void getMsg(byte[] msg) {
        //  if(true){
        if (ContentUtils.getByte(msg, msg[msg.length - 1])) {
            String[] value = TextTransformationUtils.bytesToHexStrings(msg);
            LogUtils.i("协议接收--" + Arrays.toString(value));
            if (AgreementUtils.agreement_55.equals(value[0]) && AgreementUtils.agreement_7A
                    .equalsIgnoreCase(value[1])) {
                switch (value[2].toUpperCase()) {
                    //获取驾驶员姓名和驾驶证号码
                    case AgreementUtils.agreement_01:
                        break;
                    //时钟信息
                    case AgreementUtils.agreement_02:
                        HomeAnalysisData.getInstance(msg).sendTimeUi();
                        break;
                    //事故疑点
                    case AgreementUtils.agreement_10:
                        AccidenfRecordAnalysisData.getInstance(msg).sendUi();
                        break;
                    //疲劳驾驶
                    case AgreementUtils.agreement_11:
                        FatigueDrivingAnalysisData.getInstance(msg).sendUi();
                        break;
                    //实时数据信息
                    case AgreementUtils.agreement_20:
                        RealTimeAnalysisData.getInstance(msg).sendUi();
                        break;
                    //短消息
                    case AgreementUtils.agreement_23:
                        MessageAnalysisData.getInstance(msg).sendUi();
                        break;
                    //车辆基本信息
                    case AgreementUtils.agreement_26:
                        VehicleInformationAnalysisData.getInstance(msg).sendUi();
                        break;
                    //故障报警
                    case AgreementUtils.agreement_27:
                        FaultAlarmAnalysisData.getInstance(msg).sendUi();
                        break;
                    //不良驾驶记录
                    case AgreementUtils.agreement_28:
                        BadDrivingAnalysisData.getInstance(msg).sendUi();
                        break;
                    //采集能效分析数据
                    case AgreementUtils.agreement_34:
                        EfficiencyAnalysisAnalysisData.getInstance(msg).sendUi();
                        break;
                    //定位状态
                    case AgreementUtils.agreement_40:
                        PositioningStatusAnalysisData.getInstance(msg).sendUi();
                        break;
                    //主页信息
                    case AgreementUtils.agreement_41:
                        HomeAnalysisData.getInstance(msg).sendUi();
                        break;
                    //车辆参数
                    case AgreementUtils.agreement_42:
                        VehicleParametersAnalysisData.getInstance(msg).sendUi();
                        break;
                    //打印页面
                    case AgreementUtils.agreement_43:
                        PrintThePageAnalysisData.getInstance(msg).sendUi();
                        break;
                    //底部消息提醒
                    case AgreementUtils.agreement_44:
                        BottomMessageAnalysisData.getInstance(msg).sendUi();
                        break;
                    //弹出提醒
                    case AgreementUtils.agreement_45:
                        AlertMessageAnalysisData.getInstance(msg).sendUi();
                        break;
                    //弹出提醒
                    case AgreementUtils.agreement_46:
                        TTSBroadcastTipsAnalysisData.getInstance(msg).sendUi();
                        break;
                    //主页导航栏
                    case AgreementUtils.agreement_47:
                        BaseAnalysisData.getInstance(msg).sendUi();
                        break;
                    //车辆信号状态
                    case AgreementUtils.agreement_48:
                        SignalStatusAnalysisData.getInstance(msg).sendUi();
                        break;
                    //报警信息
                    case AgreementUtils.agreement_49:
                        WarningAnalysisData.getInstance(msg).sendUi();
                        break;
                    //工程菜单——设备测试
                    case AgreementUtils.agreement_50:
                        DeviceTestAnalysisData.getInstance(msg).sendUi();
                        break;
                    //工程菜单——三轴设备
                    case AgreementUtils.agreement_51:
                        ThreeAxleAnalysisData.getInstance(msg).sendUi();
                        break;
                    //销贷信息
                    case AgreementUtils.agreement_53:
                        LoanSalesAnalysisData.getInstance(msg).sendUi();
                        break;
                    //远程升级
                    case AgreementUtils.agreement_54:
                        UpgradeAnalysisData.getInstance(msg).sendUi();
                        break;
                    //驾驶行为评分
                    case AgreementUtils.agreement_57:
                        DrivingBehaviorAnalysisData.getInstance(msg).sendUi();
                        break;
                    //设置终端参数指令
                    case AgreementUtils.agreement_3A:
                        SettingTerminalAnalysisData.getInstance(msg).sendUi();
                        break;
                    //查询车载终端是否锁定
                    case AgreementUtils.agreement_3B:
                        QueryTerminalAnalysisData.getInstance(msg).sendUi();
                        break;
                    // 渣土车电子运营证页面
                    case AgreementUtils.agreement_3F:
                        OperatingLicenseAnalysisData.getInstance(msg).sendUi();
                        break;
                    //常规注册
                    case AgreementUtils.agreement_4B:
                        RoutineRegisterAnalysisData.getInstance(msg).sendUi();
                        break;
                    //设备参数
                    case AgreementUtils.agreement_4C:
                        DeviceMsgAnalysisData.getInstance(msg).sendUi();
                        break;
                    //工程菜单——初始化项
                    case AgreementUtils.agreement_4F:
                        InitializationAnalysisData.getInstance(msg).sendUi();
                        break;
                    //渣土车实时信息
                    case AgreementUtils.agreement_5A:
                        HomeAnalysisData.getInstance(msg).send5AUi();
                        break;
                    default:
                }
            }
        } else {
            LogUtils.i("校验错误————————————");
        }
    }


}
