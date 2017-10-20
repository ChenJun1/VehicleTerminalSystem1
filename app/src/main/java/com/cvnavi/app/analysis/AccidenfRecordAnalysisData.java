package com.cvnavi.app.analysis;

import android.os.Handler;
import android.os.Message;

import com.apkfuns.logutils.LogUtils;
import com.cvnavi.app.ThreadManager;
import com.cvnavi.app.bean.AccidentRecordBean;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zww on 2017/7/31.
 * 事故疑点
 */

public class AccidenfRecordAnalysisData extends AnalysisUiData {

    private static AccidenfRecordAnalysisData accidenfRecordAnalysisData;
    private static AccidentRecordBean accidentRecordBean = new AccidentRecordBean();
    private static BaseBean baseBean = new BaseBean();
    private static DecimalFormat format = new DecimalFormat("0.000000");

    private AccidenfRecordAnalysisData(byte[] datas) {
        super(datas);
    }

    public static AccidenfRecordAnalysisData getInstance(byte[] datas) {
        if (accidenfRecordAnalysisData == null) {
            accidenfRecordAnalysisData = new AccidenfRecordAnalysisData(datas);
        }
        accidenfRecordAnalysisData.setDatas(datas);
        return accidenfRecordAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                String code = AgreementUtils.agreement_10;
                ListenerManager.getInstance().sendBroadCast(baseBean, code);
            }
        }
    };

    private Runnable handleMsg = new Runnable() {
        @Override
        public void run() {
            String[] value = TextTransformationUtils.bytesToHexStrings(datas);

            //事故疑点
            short aLength = TextTransformationUtils.getShort(datas, 3);
            List<AccidentRecordBean.AccidentRecordItem> accidentRecordItems = new
                    ArrayList<AccidentRecordBean.AccidentRecordItem>();
            LogUtils.i(new Date() + "timebgin");
            int size=aLength/234;
            for (int i = 0; i < size; i++) {
                AccidentRecordBean.AccidentRecordItem accidentRecordItem = new
                        AccidentRecordBean.AccidentRecordItem();
                String endTime = "20" + value[6 + 234 * i] + "-" + value[7 + 234 * i] + "-" +
                        value[8 + 234 * i] + " " + value[9 + 234 * i] + ":" + value[10 +
                        234 * i] + ":" + value[11 + 234 * i];
                accidentRecordItem.setEndTime(endTime);
                String licenseNo10 = TextTransformationUtils.decode(TextTransformationUtils.getGbkValue
                        (value, 12 + 234 * i, 18));
                accidentRecordItem.setLicenseNo(licenseNo10);
                if (TextTransformationUtils.getGbkValue(value, 230 + 234 * i, 4).equalsIgnoreCase("7FFFFFFF")) {
                    String longitude = "--";
                    accidentRecordItem.setLongitude(longitude);
                } else {
                    String longitude = format.format(new BigDecimal((TextTransformationUtils.getInt(datas,
                            230 + 234 * i) * 0.0001) / 60 + ""));
                    accidentRecordItem.setLongitude(longitude);
                }
                if (TextTransformationUtils.getGbkValue(value, 234 + 234 * i, 4).equalsIgnoreCase("7FFFFFFF")) {
                    String latitude = "--";
                    accidentRecordItem.setLatitude(latitude);
                } else {
                    String latitude = format.format(new BigDecimal((TextTransformationUtils.getInt(datas,
                            234 + 234 * i) * 0.0001) / 60 + ""));
                    accidentRecordItem.setLatitude(latitude);
                }
                if (TextTransformationUtils.getGbkValue(value, 238 + 234 * i, 2).equalsIgnoreCase("7FFF")) {
                    String altitude = "--";
                    accidentRecordItem.setAltitude(altitude);
                } else {
                    String altitude = Math.abs(TextTransformationUtils.getShort(datas, 238
                            + 234 * i)) + "";
                    accidentRecordItem.setAltitude(altitude);
                }
                int[] speed = new int[100];
                //                int[] d0 = new int[100];
                //                int[] d1 = new int[100];
                //                int[] d2 = new int[100];
                //                int[] d3 = new int[100];
                //                int[] d4 = new int[100];
                //                int[] d5 = new int[100];
                //                int[] d6 = new int[100];
                //                int[] d7 = new int[100];
                String[] state = new String[100];
                for (int m = 0; m < 100; m = m + 1) {
                    speed[99 - m] = datas[30 + 2 * m + 234 * i];
                    state[99 - m] = value[31 + 2 * m + 234 * i];
                    //                    d0[m] =TextTransformationUtils.binaryToArray(TextTransformationUtils.hexString2binaryString
                    //                            (value[31 + 2 * m + 234 * i]).toUpperCase())[7];
                    //                    d1[m] =TextTransformationUtils.binaryToArray(TextTransformationUtils.hexString2binaryString
                    //                            (value[31 + 2 * m + 234 * i]).toUpperCase())[6];
                    //                    d2[m] =TextTransformationUtils.binaryToArray(TextTransformationUtils.hexString2binaryString
                    //                            (value[31 + 2 * m + 234 * i]).toUpperCase())[5];
                    //                    d3[m] =TextTransformationUtils.binaryToArray(TextTransformationUtils.hexString2binaryString
                    //                            (value[31 + 2 * m + 234 * i]).toUpperCase())[4];
                    //                    d4[m] =TextTransformationUtils.binaryToArray(TextTransformationUtils.hexString2binaryString
                    //                            (value[31 + 2 * m + 234 * i]).toUpperCase())[3];
                    //                    d5[m] =TextTransformationUtils.binaryToArray(TextTransformationUtils.hexString2binaryString
                    //                            (value[31 + 2 * m + 234 * i]).toUpperCase())[2];
                    //                    d6[m] =TextTransformationUtils.binaryToArray(TextTransformationUtils.hexString2binaryString
                    //                            (value[31 + 2 * m + 234 * i]).toUpperCase())[1];
                    //                    d7[m] =TextTransformationUtils.binaryToArray(TextTransformationUtils.hexString2binaryString
                    //                            (value[31 + 2 * m + 234 * i]).toUpperCase())[0];
                }
                accidentRecordItem.setSpeed(speed);
                accidentRecordItem.setState(state);
                //                accidentRecordItem.setD0(d0);
                //                accidentRecordItem.setD1(d1);
                //                accidentRecordItem.setD2(d2);
                //                accidentRecordItem.setD3(d3);
                //                accidentRecordItem.setD4(d4);
                //                accidentRecordItem.setD5(d5);
                //                accidentRecordItem.setD6(d6);
                //                accidentRecordItem.setD7(d7);
                accidentRecordItems.add(accidentRecordItem);
            }
            LogUtils.i(new Date() + "timeend");
            accidentRecordBean.setRecords(accidentRecordItems);
            baseBean.setModel(accidentRecordBean);
            handler.sendEmptyMessage(0);
        }
    };

    public void sendUi() {
        ThreadManager.execute(handleMsg);
    }


}
