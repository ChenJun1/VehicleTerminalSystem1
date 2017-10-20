package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.HomeFragBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.ContentUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

/**
 * Created by zww on 2017/7/31.
 * 首页数据
 */

public class HomeAnalysisData extends AnalysisUiData {

    private static HomeAnalysisData homeAnalysisData;
    private static HomeFragBean homeBean = new HomeFragBean();
    private static BaseBean baseBean = new BaseBean();

    private HomeAnalysisData(byte[] datas) {
        super(datas);
    }

    public static HomeAnalysisData getInstance(byte[] datas) {
        if (homeAnalysisData == null) {
            homeAnalysisData = new HomeAnalysisData(datas);
        }
        homeAnalysisData.setDatas(datas);
        return homeAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        //主页信息
        String code = AgreementUtils.agreement_41;
        short allSize = TextTransformationUtils.getShort(datas, 3);
        //速度
        int speedEnd = 6;
        homeBean.setSpeed(String.valueOf(Long.parseLong(value[6], 16)));
        //驾驶证号码
        int licenseNoSize = (int) Long.parseLong(value[speedEnd + 1], 16);
        int licenseNoSizeStart = speedEnd + 2;
        int licenseNoSizeEnd = speedEnd + 1 + licenseNoSize;
        String licenseNo = TextTransformationUtils.decode(TextTransformationUtils.getGbkValue(value,
                licenseNoSizeStart, licenseNoSize));
        homeBean.setLicenseNo(licenseNo);

        //驾驶员
        int DriverNoSize = (int) Long.parseLong(value[licenseNoSizeEnd + 1], 16);
        int DriverNoSizeStart = licenseNoSizeEnd + 2;
        int DriverNoSizeEnd = licenseNoSizeEnd + 1 + DriverNoSize;
        String DriverNo = TextTransformationUtils.decode((TextTransformationUtils.getGbkValue(value,
                DriverNoSizeStart,
                DriverNoSize)));
        homeBean.setDriverNo(DriverNo);

        //驾驶时长
        int driveTimeSize = (int) Long.parseLong(value[DriverNoSizeEnd + 1], 16);
        int driveTimeSizeStart = DriverNoSizeEnd + 2;
        int driveTimeSizeEnd = DriverNoSizeEnd + 1 + driveTimeSize;
        String driveTime = TextTransformationUtils.decode((TextTransformationUtils.getGbkValue(value, driveTimeSizeStart, driveTimeSize)));
        homeBean.setDriveTime(driveTime);

        //休息时长
        int restTimeSize = (int) Long.parseLong(value[driveTimeSizeEnd + 1], 16);
        int restTimeSizeStart = driveTimeSizeEnd + 2;
        int restTimeSizeEnd = driveTimeSizeEnd + 1 + restTimeSize;
        String restTime = TextTransformationUtils.decode((TextTransformationUtils.getGbkValue(value, restTimeSizeStart, restTimeSize)));
        homeBean.setRestTime(restTime);

        homeBean.setIsFullRest("");
        //累计里程
        int accumulateSize = (int) Long.parseLong(value[restTimeSizeEnd + 1], 16);
        int accumulateSizeStart = restTimeSizeEnd + 2;
        int accumulateSizeEnd = restTimeSizeEnd + 1 + accumulateSize;
        String accumulatedileage = TextTransformationUtils.decode((TextTransformationUtils.getGbkValue(value,
                accumulateSizeStart, accumulateSize)));
        homeBean.setAccumulatedileage(accumulatedileage);
        //行驶状态
        int runningStateSize = (int) Long.parseLong(value[accumulateSizeEnd + 1], 16);
        int runningStateSizeStart = accumulateSizeEnd + 2;
        int runningStateSizeEnd = accumulateSizeEnd + 1 + runningStateSize;
        String runningState = TextTransformationUtils.decode((TextTransformationUtils.getGbkValue(value,
                runningStateSizeStart, runningStateSize)));
        homeBean.setRunningState(runningState);
        baseBean.setModel(homeBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }

    public void sendTimeUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_02;
        //获取时钟信息 55 7A 02 00 06 00 17 07 11 09 13 45 75\
        //年月日
        String time1 = "20" + value[6] + "-" + value[7] + "-" + value[8];
        homeBean.setTime1(time1);
        //时分秒
        String time2 = value[9] + ":" + value[10] + ":" + value[11];
        homeBean.setTime2(time2);
        //星期几
        String time3 = ContentUtils.getDayOfWeekByDate(time1);
        homeBean.setTime3(time3);
        baseBean.setModel(homeBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }

    public void send5AUi() {
        String code = AgreementUtils.agreement_5A;
        String liftState = datas[6] + "";
        homeBean.setLiftState(liftState);

        String coverState = datas[7] + "";
        homeBean.setCoverState(coverState);

        String loadState = datas[8] + "";
        homeBean.setLoadState(loadState);

        String loadPercent = datas[9] + "";
        homeBean.setLoadPercent(loadPercent);

        String speedLimit = datas[10] + "";
        homeBean.setSpeedLimit(speedLimit);

        String carLocation = datas[11] + "";
        homeBean.setCarLocation(carLocation);
        baseBean.setModel(homeBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }


}
