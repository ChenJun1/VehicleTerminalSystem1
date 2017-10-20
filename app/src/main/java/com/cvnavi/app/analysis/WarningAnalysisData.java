package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.WarningBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.binaryToArray;

/**
 * Created by zww on 2017/7/31.
 * 报警数据
 */

public class WarningAnalysisData extends AnalysisUiData {

    private static WarningAnalysisData warningAnalysisData;
    private static WarningBean warningBean = new WarningBean();
    private static BaseBean baseBean = new BaseBean();

    private WarningAnalysisData(byte[] datas) {
        super(datas);
    }

    public static WarningAnalysisData getInstance(byte[] datas) {
        if (warningAnalysisData == null) {
            warningAnalysisData = new WarningAnalysisData(datas);
        }
        warningAnalysisData.setDatas(datas);
        return warningAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_49;
        short allWarnSize = TextTransformationUtils.getShort(datas, 3);
        //驾驶员登录状态
        warningBean.setIsLogin((int) Long.parseLong(value[6], 16));
        //速度状态
        warningBean.setSpeed((int) Long.parseLong(value[7], 16));
        String dWord1 = TextTransformationUtils.hexString2binaryString(value[11]);
        warningBean.setEmergencyAlarm(binaryToArray(dWord1)[7]);
        warningBean.setSpeedAlarm(binaryToArray(dWord1)[6]);
        warningBean.setFatigueDriving(binaryToArray(dWord1)[5]);
        warningBean.setRiskWarning(binaryToArray(dWord1)[4]);
        warningBean.setModuleFailure(binaryToArray(dWord1)[3]);
        warningBean.setAntennaMissed(binaryToArray(dWord1)[2]);
        warningBean.setAntennaShort(binaryToArray(dWord1)[1]);
        warningBean.setUndervoltage(binaryToArray(dWord1)[0]);

        String dWord2 = TextTransformationUtils.hexString2binaryString(value[10]);
        warningBean.setLeakage(binaryToArray(dWord2)[7]);
        warningBean.setFault(binaryToArray(dWord2)[6]);
        warningBean.setTtsFault(binaryToArray(dWord2)[5]);
        warningBean.setCameraFault(binaryToArray(dWord2)[4]);
        warningBean.setIcFault(binaryToArray(dWord2)[3]);
        warningBean.setOverspeedWarning(binaryToArray(dWord2)[2]);
        warningBean.setFatigueDrivingWarning(binaryToArray(dWord2)[1]);

        String dWord3 = TextTransformationUtils.hexString2binaryString(value[9]);
        warningBean.setOvertime(binaryToArray(dWord3)[5]);
        warningBean.setOvertimePark(binaryToArray(dWord3)[4]);
        warningBean.setArea(binaryToArray(dWord3)[3]);
        warningBean.setLine(binaryToArray(dWord3)[2]);
        warningBean.setTimeWarning(binaryToArray(dWord3)[1]);
        warningBean.setDeviate(binaryToArray(dWord3)[0]);

        String dWord4 = TextTransformationUtils.hexString2binaryString(value[8]);
        warningBean.setVssfault(binaryToArray(dWord4)[7]);
        warningBean.setOilAbnormal(binaryToArray(dWord4)[6]);
        warningBean.setStolenVehicles(binaryToArray(dWord4)[5]);
        warningBean.setIllegalIgnition(binaryToArray(dWord4)[4]);
        warningBean.setIllegalDisplacement(binaryToArray(dWord4)[3]);
        warningBean.setCollisionWarning(binaryToArray(dWord4)[2]);
        warningBean.setRolloverWarning(binaryToArray(dWord4)[1]);
        warningBean.setIllagelOpen(binaryToArray(dWord4)[0]);
        baseBean.setModel(warningBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
