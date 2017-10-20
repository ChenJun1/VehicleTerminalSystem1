package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BadDrivingBean;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zww on 2017/8/22.
 * 不良驾驶
 */

public class BadDrivingAnalysisData extends AnalysisUiData {

    private static BadDrivingAnalysisData badDrivingAnalysisData;
    private static BadDrivingBean badDrivingBean = new BadDrivingBean();
    private static BaseBean baseBean = new BaseBean();

    private BadDrivingAnalysisData(byte[] datas) {
        super(datas);
    }

    public static BadDrivingAnalysisData getInstance(byte[] datas) {
        if (badDrivingAnalysisData == null) {
            badDrivingAnalysisData = new BadDrivingAnalysisData(datas);
        }
        badDrivingAnalysisData.setDatas(datas);
        return badDrivingAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        //不良驾驶
        String code = AgreementUtils.agreement_28;
        short fLength = TextTransformationUtils.getShort(datas, 3);
        List<BadDrivingBean.BadDrivingItem> badDrivingItems = new
                ArrayList<BadDrivingBean.BadDrivingItem>();
        int size=fLength / 34;
        for (int i = 0; i < size; i++) {
            BadDrivingBean.BadDrivingItem badDrivingItem = new
                    BadDrivingBean.BadDrivingItem();
            String licenseNo = TextTransformationUtils.getGbkValue(value, 6 + 34 *
                    i, 18);
            badDrivingItem.setLicenseNo(licenseNo);
            String beginTime = "20" + value[24 + 34 * i] + "-" + value[25 + 34 * i] + "-" +
                    value[26 + 34 * i] + " " + value[27 + 34 * i] + ":" + value[28 +
                    34 * i] + ":" + value[29 + 34 * i];
            badDrivingItem.setBeginTime(beginTime);
            String endTime = "20" + value[30 + 34 * i] + "-" + value[31 + 34 * i] + "-" +
                    value[32 + 34 * i] + " " + value[33 + 34 * i] + ":" + value[34 +
                    34 * i] + ":" + value[35 + 34 * i];
            badDrivingItem.setEndTime(endTime);
            String turnOverNumber=datas[36+34*i]+"";
            badDrivingItem.setTurnOverNumber(turnOverNumber);

            String speedingNumber=datas[37+34*i]+"";
            badDrivingItem.setSpeedingNumber(speedingNumber);

            String spare1=datas[38+34*i]+"";
            badDrivingItem.setSpare1(spare1);

            String spare2=datas[39+34*i]+"";
            badDrivingItem.setSpare2(spare2);

            badDrivingItems.add(badDrivingItem);
        }
        badDrivingBean.setRecords(badDrivingItems);
        baseBean.setModel(badDrivingBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }



}
