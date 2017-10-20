package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.FaultAlarmBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.binaryToArray;

/**
 * Created by zww on 2017/8/21.
 * 故障报警数据
 */

public class FaultAlarmAnalysisData extends AnalysisUiData {

    private static FaultAlarmAnalysisData faultAlarmAnalysisData;
    private static FaultAlarmBean faultAlarmBean = new FaultAlarmBean();
    private static BaseBean baseBean = new BaseBean();

    private FaultAlarmAnalysisData(byte[] datas) {
        super(datas);
    }

    public static FaultAlarmAnalysisData getInstance(byte[] datas) {
        if (faultAlarmAnalysisData == null) {
            faultAlarmAnalysisData = new FaultAlarmAnalysisData(datas);
        }
        faultAlarmAnalysisData.setDatas(datas);
        return faultAlarmAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_27;
        short allWarnSize = TextTransformationUtils.getShort(datas, 3);
        String dWord1 = TextTransformationUtils.hexString2binaryString(value[11]);
        faultAlarmBean.setAlarmForRetarder(binaryToArray(dWord1)[6]);
        faultAlarmBean.setStorehouseTemperatureAlarm(binaryToArray(dWord1)[5]);
        faultAlarmBean.setOilTemperatureAlarm(binaryToArray(dWord1)[2]);

        String dWord2 = TextTransformationUtils.hexString2binaryString(value[10]);
        faultAlarmBean.setFuelWarning(binaryToArray(dWord2)[7]);

        String dWord3 = TextTransformationUtils.hexString2binaryString(value[9]);
        faultAlarmBean.setSeriousFault(binaryToArray(dWord3)[7]);
        faultAlarmBean.setBrakeAirPressureAlarm(binaryToArray(dWord3)[6]);
        faultAlarmBean.setOilPressureAlarm(binaryToArray(dWord3)[5]);
        faultAlarmBean.setLowWaterLevelAlarm(binaryToArray(dWord3)[3]);
        faultAlarmBean.setBrakeShoeAlarm(binaryToArray(dWord3)[2]);
        faultAlarmBean.setAirFilterBlockingAlarm(binaryToArray(dWord3)[1]);

        String dWord4 = TextTransformationUtils.hexString2binaryString(value[8]);

        baseBean.setModel(faultAlarmBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
