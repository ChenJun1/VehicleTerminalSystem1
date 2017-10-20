package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.FatigueDrivingBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zww on 2017/7/31.
 * 疲劳驾驶
 */

public class FatigueDrivingAnalysisData extends AnalysisUiData {

    private static FatigueDrivingAnalysisData fatigueDrivingAnalysisData;
    private static FatigueDrivingBean fatigueDrivingBean = new FatigueDrivingBean();
    private static BaseBean baseBean = new BaseBean();
    private static DecimalFormat format = new DecimalFormat("0.000000");

    private FatigueDrivingAnalysisData(byte[] datas) {
        super(datas);
    }

    public static FatigueDrivingAnalysisData getInstance(byte[] datas) {
        if (fatigueDrivingAnalysisData == null) {
            fatigueDrivingAnalysisData = new FatigueDrivingAnalysisData(datas);
        }
        fatigueDrivingAnalysisData.setDatas(datas);
        return fatigueDrivingAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        //疲劳驾驶
        String code = AgreementUtils.agreement_11;
        short fLength = TextTransformationUtils.getShort(datas, 3);
        List<FatigueDrivingBean.FatigueDrivingItem> fatigueDrivingItems = new
                ArrayList<FatigueDrivingBean.FatigueDrivingItem>();
        int size=fLength / 50;
        for (int i = 0; i < size; i++) {
            FatigueDrivingBean.FatigueDrivingItem fatigueDrivingItem=new
                    FatigueDrivingBean.FatigueDrivingItem();
            String licenseNo11=TextTransformationUtils.decode(TextTransformationUtils.getGbkValue(value, 6
                    + 50 * i, 18));
            fatigueDrivingItem.setLicenseNo(licenseNo11);
            String beginTime11="20" + value[24 + 50 * i] + "-" + value[25 + 50 * i] + "-" +
                    value[26 + 50 * i] + " " + value[27 + 50 * i] + ":" + value[28 +
                    50 * i] + ":" + value[29 + 50 * i];
            fatigueDrivingItem.setBeginTime(beginTime11);
            String endTime11="20" + value[30 + 50 * i] + "-" + value[31 + 50 * i] + "-" +
                    value[32 + 50 * i] + " " + value[33 + 50 * i] + ":" + value[34 +
                    50 * i] + ":" + value[35 + 50 * i];
            fatigueDrivingItem.setEndTime(endTime11);
            //开始经度
            if(TextTransformationUtils.getGbkValue(value,36+50*i,4).equalsIgnoreCase("7FFFFFFF"))
            {
                String beginLongitude="--";
                fatigueDrivingItem.setBeginLongitude(beginLongitude);
            }
            else
            {
                String beginLongitude=format.format(new BigDecimal(
                        (TextTransformationUtils.getInt(datas, 36 + 50 * i)*0.0001)/60+""));
                fatigueDrivingItem.setBeginLongitude(beginLongitude);
            }
            //开始纬度
            if(TextTransformationUtils.getGbkValue(value,40+50*i,4).equalsIgnoreCase("7FFFFFFF"))
            {
                String beginLatitude="--";
                fatigueDrivingItem.setBeginLatitude(beginLatitude);
            }
            else {
                String beginLatitude = format.format(new BigDecimal(
                        (TextTransformationUtils.getInt(datas, 40 + 50 * i) * 0.0001) / 60 + ""));
                fatigueDrivingItem.setBeginLatitude(beginLatitude);
            }
            //开始海拔
            if(TextTransformationUtils.getGbkValue(value,44+50*i,2).equalsIgnoreCase("7FFF"))
            {
                String beginAltitude="--";
                fatigueDrivingItem.setBeginAltitude(beginAltitude);
            }
            else {
                String beginAltitude = Math.abs(TextTransformationUtils.getShort(datas, 44
                        + 50 * i)) + "";
                fatigueDrivingItem.setBeginAltitude(beginAltitude);
            }
            //结束经度
            if(TextTransformationUtils.getGbkValue(value,46+50*i,4).equalsIgnoreCase("7FFFFFFF")) {
                String endLongitude = "--";
                fatigueDrivingItem.setEndLongitude(endLongitude);
            }
            else
            {
                String endLongitude = format.format(new BigDecimal(
                        (TextTransformationUtils.getInt(datas, 46 + 50 * i) * 0.0001) / 60 + ""));
                fatigueDrivingItem.setEndLongitude(endLongitude);
            }
            //结束纬度
            if(TextTransformationUtils.getGbkValue(value,50+50*i,4).equalsIgnoreCase("7FFFFFFF"))
            {
                String endLatitude = "--";
                fatigueDrivingItem.setEndLatitude(endLatitude);
            }
            else {
                String endLatitude = format.format(new BigDecimal(
                        (TextTransformationUtils.getInt(datas, 50 + 50 * i) * 0.0001) / 60 + ""));
                fatigueDrivingItem.setEndLatitude(endLatitude);
            }
            //结束海拔
            if(TextTransformationUtils.getGbkValue(value,54+50*i,2).equalsIgnoreCase("7FFF")) {
                String endAltitude ="--";
                fatigueDrivingItem.setEndAltitude(endAltitude);
            }
            else
            {
                String endAltitude = Math.abs(TextTransformationUtils.getShort(datas, 54
                        + 50 * i)) + "";
                fatigueDrivingItem.setEndAltitude(endAltitude);
            }
            fatigueDrivingItems.add(fatigueDrivingItem);
        }
        fatigueDrivingBean.setRecords(fatigueDrivingItems);
        baseBean.setModel(fatigueDrivingBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }



}
