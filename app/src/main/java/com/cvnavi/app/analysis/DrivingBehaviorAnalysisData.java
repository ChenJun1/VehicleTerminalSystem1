package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.DrivingBehaviorBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zww on 2017/7/31.
 * 驾驶行为评分
 */

public class DrivingBehaviorAnalysisData extends AnalysisUiData {

    private static DrivingBehaviorAnalysisData drivingBehaviorAnalysisData;
    private static DrivingBehaviorBean drivingBehaviorBean = new DrivingBehaviorBean();
    private static BaseBean baseBean = new BaseBean();
    private String code;

    private DrivingBehaviorAnalysisData(byte[] datas) {
        super(datas);
    }

    public static DrivingBehaviorAnalysisData getInstance(byte[] datas) {
        if (drivingBehaviorAnalysisData == null) {
            drivingBehaviorAnalysisData = new DrivingBehaviorAnalysisData(datas);
        }
        drivingBehaviorAnalysisData.setDatas(datas);
        return drivingBehaviorAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        //驾驶行为评分
        if (AgreementUtils.agreement_57_00.contains(value[5])) {
            code = AgreementUtils.agreement_57 + "00";
            short allDriveSize = TextTransformationUtils.getShort(datas, 3);
            String mileage = String.valueOf(TextTransformationUtils.getInt(datas, 8));
            drivingBehaviorBean.setMileage(mileage);
            String oilConsumption = String.valueOf(TextTransformationUtils.getInt
                    (datas, 12));
            drivingBehaviorBean.setOilConsumption(oilConsumption);
            String averageOil = String.valueOf(TextTransformationUtils.getShort
                    (datas, 16));
            drivingBehaviorBean.setAverageOilConsumption(averageOil);
            String averagescore = String.valueOf(TextTransformationUtils.getShort
                    (datas, 18));
            drivingBehaviorBean.setAveragescore(averagescore);
            String speedX = String.valueOf(TextTransformationUtils.getShort(datas,
                    20));
            drivingBehaviorBean.setSpeedX(speedX);
            String percent = String.valueOf(Long.parseLong(value[22], 16));
            drivingBehaviorBean.setPercent(percent);
            String fraction = String.valueOf(TextTransformationUtils.getShort
                    (datas, 23));
            drivingBehaviorBean.setFraction(fraction);
            String percent100 = String.valueOf(Long.parseLong(value[25], 16));
            drivingBehaviorBean.setPercent100(percent100);
            String percent80 = String.valueOf(Long.parseLong(value[26], 16));
            drivingBehaviorBean.setPercent100(percent80);
            String percent60 = String.valueOf(Long.parseLong(value[27], 16));
            drivingBehaviorBean.setPercent100(percent60);
            String percent20 = String.valueOf(Long.parseLong(value[28], 16));
            drivingBehaviorBean.setPercent100(percent20);
            baseBean.setModel(drivingBehaviorBean);
        }
        if (AgreementUtils.agreement_57_01.contains(value[5])) {
            code = AgreementUtils.agreement_57 + "01";
            int allDriveSize01 = (int) Long.parseLong(value[4], 16);
            int size = allDriveSize01 / 24;
            List<DrivingBehaviorBean.DriveingRecordItem> recordItemList = new
                    ArrayList<DrivingBehaviorBean.DriveingRecordItem>();
            for (int i = 0; i < size; i++) {
                DrivingBehaviorBean.DriveingRecordItem driveingRecordItem = new
                        DrivingBehaviorBean.DriveingRecordItem();
                String begin = "20" + value[8 + 24 * i] + "." + value[9 + 24 * i] + "." +
                        value[10 + 24 * i] + " " + value[11 + 24 * i] + ":" + value[12 + 24 * i];
                driveingRecordItem.setBegin(begin);
                String end = "20" + value[14 + 24 * i] + "." + value[15 + 24 * i] + "." +
                        value[16 + 24 * i] + " " + value[17 + 24 * i] + ":" + value[18 + 24 * i];
                driveingRecordItem.setEnd(end);
                String mileage = String.valueOf(TextTransformationUtils.getInt
                        (datas, 20 + 24 * i));
                driveingRecordItem.setMileage(mileage);
                String oilConsumption = String.valueOf(TextTransformationUtils
                        .getInt(datas, 24 + 24 * i));
                driveingRecordItem.setOilConsumption(oilConsumption);
                String averageOilConsumption = String.valueOf
                        (TextTransformationUtils.getShort(datas, 28 + 24 * i));
                driveingRecordItem.setAverageOilConsumption(averageOilConsumption);
                String averagescore = String.valueOf(TextTransformationUtils
                        .getShort(datas, 30 + 24 * i));
                driveingRecordItem.setAveragescore(averagescore);
                recordItemList.add(driveingRecordItem);
            }
            drivingBehaviorBean.setRecords(recordItemList);
            baseBean.setModel(drivingBehaviorBean);

        }
        if (AgreementUtils.agreement_57_02.contains(value[5])) {


        }
        if (AgreementUtils.agreement_57_03.contains(value[5])) {
            code = AgreementUtils.agreement_57 + "03";
            int allDriveSize03 = (int) Long.parseLong(value[4], 16);
            String allTime = String.valueOf(TextTransformationUtils.getInt(datas, 8));
            drivingBehaviorBean.setAllTime(allTime);
            String allMile = String.valueOf(TextTransformationUtils.getInt(datas, 12));
            drivingBehaviorBean.setAllMile(allMile);
            String allOilConsumption = String.valueOf(TextTransformationUtils
                    .getInt(datas, 16));
            drivingBehaviorBean.setAllOilConsumption(allOilConsumption);
            String averageOilConsumption2 = String.valueOf(TextTransformationUtils
                    .getInt(datas, 20));
            drivingBehaviorBean.setAverageOilConsumption2(averageOilConsumption2);
            String averagescore03 = String.valueOf(TextTransformationUtils.getInt
                    (datas, 24));
            drivingBehaviorBean.setAveragescore03(averagescore03);
            baseBean.setModel(drivingBehaviorBean);
        }
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }



}
