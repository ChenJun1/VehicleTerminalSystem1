package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.PositioningStatusBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

/**
 * Created by wangshy on 17/8/2.
 */

public class PositioningStatusAnalysisData extends AnalysisUiData {

    public PositioningStatusAnalysisData(byte[] datas) {
        super(datas);
    }

    private static PositioningStatusAnalysisData data;
    private static BaseBean baseBean = new BaseBean();

    public static PositioningStatusAnalysisData getInstance(byte[] bytes) {
        if (null == data)
            data = new PositioningStatusAnalysisData(bytes);
        data.setDatas(bytes);
        return data;
    }

    private void setDatas(byte[] bytes) {
        this.datas = bytes;
    }

    public void sendUi() {
        PositioningStatusBean bean = new PositioningStatusBean();
        String code = AgreementUtils.agreement_40;
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        bean.setTime(value[6] + ":" + value[7] + ":" + value[8]);
        bean.setDataTime("20" + value[9] + "-" + value[10] + "-" + value[11]);
        bean.setPositioningStatus(TextTransformationUtils.decode(value[12]));
        bean.setLatitude(datas[13] + "." + (int) Long.parseLong(value[14] + value[15] + value[16], 16));
        bean.setLatitudeDirection(TextTransformationUtils.decode(value[17]));
        bean.setOngitude(datas[18] + "." + (int) Long.parseLong(value[19] + value[20] + value[21],16));
        bean.setOngitudeDirection(TextTransformationUtils.decode(value[22]));
        bean.setNumberOfSatellites(datas[23] + "");
        bean.setHeight(TextTransformationUtils.getShort(datas, 24) + "");
        bean.setGroundSpeed(datas[26] + "");
        bean.setGroundCourse(TextTransformationUtils.getShort(datas,27)+"");
        bean.setModeIndication(TextTransformationUtils.decode(value[29]));
        baseBean.setModel(bean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
