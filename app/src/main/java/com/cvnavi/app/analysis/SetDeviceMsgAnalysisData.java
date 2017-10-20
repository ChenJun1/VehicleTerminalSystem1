package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.SetDeviceMsgBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.getInt;
import static com.cvnavi.app.utils.TextTransformationUtils.getShort;

/**
 * Created by zww on 2017/8/7.
 */

public class SetDeviceMsgAnalysisData extends AnalysisUiData {

    private static SetDeviceMsgAnalysisData setDeviceMsgAnalysisData;
    private static SetDeviceMsgBean setDeviceMsgBean = new SetDeviceMsgBean();
    private static BaseBean baseBean = new BaseBean();

    private SetDeviceMsgAnalysisData(byte[] datas) {
        super(datas);
    }

    public static SetDeviceMsgAnalysisData getInstance(byte[] datas) {
        if (setDeviceMsgAnalysisData == null) {
            setDeviceMsgAnalysisData = new SetDeviceMsgAnalysisData(datas);
        }
        setDeviceMsgAnalysisData.setDatas(datas);
        return setDeviceMsgAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_4E;
        short length = TextTransformationUtils.getShort(datas, 3);
        int pulseCoefficient = getInt(datas, 9);
        setDeviceMsgBean.setPulseCoefficient(pulseCoefficient + "");

        int accumulated = getInt(datas, 16);
        setDeviceMsgBean.setAccumulatedileage(accumulated + "");

        int fatigueDrivingTime = getInt(datas, 23);
        setDeviceMsgBean.setFatigueDriving(fatigueDrivingTime + "");

        int speedingValue = getInt(datas, 9);
        setDeviceMsgBean.setSpeedingValue(speedingValue + "");

        int warning = getInt(datas, 9);
        setDeviceMsgBean.setWarning(warning + "");

        int gnssGps = datas[9];
        setDeviceMsgBean.setGnssGps(gnssGps + "");

        short ttsVoice = getShort(datas, 9);
        setDeviceMsgBean.setTtsVoice(ttsVoice + "");

        int sleepType = datas[9];
        setDeviceMsgBean.setSleepType(sleepType + "");

        short sleepWaitTime = getShort(datas, 9);
        setDeviceMsgBean.setSleepWaitTime(sleepWaitTime + "");

        short sleepWakeTime = getShort(datas, 9);
        setDeviceMsgBean.setSleepWakeTime(sleepWakeTime + "");
        baseBean.setModel(setDeviceMsgBean);
        ListenerManager.getInstance().
                sendBroadCast(baseBean, code);
    }
}
