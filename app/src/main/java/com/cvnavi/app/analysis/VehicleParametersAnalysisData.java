package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.VehicleParametersBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/1.
 * 车辆参数数据
 */

public class VehicleParametersAnalysisData extends AnalysisUiData {

    private static VehicleParametersAnalysisData vehicleParametersAnalysisData;
    private static VehicleParametersBean signalStatusBean = new VehicleParametersBean();
    private static BaseBean baseBean = new BaseBean();

    private VehicleParametersAnalysisData(byte[] datas) {
        super(datas);
    }

    public static VehicleParametersAnalysisData getInstance(byte[] datas) {
        if (vehicleParametersAnalysisData == null) {
            vehicleParametersAnalysisData = new VehicleParametersAnalysisData(datas);
        }
        vehicleParametersAnalysisData.setDatas(datas);
        return vehicleParametersAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_42;
        short length = TextTransformationUtils.getShort(datas, 3);
        int start = 5;
        //车牌号码
        int vehicleNoSize = (int) Long.parseLong(value[start + 1], 16);
        int vehicleNoSizeStart = start + 2;
        int vehicleNoSizeEnd = start + 1 + vehicleNoSize;
        String vehicleNo = decode(getGbkValue(value, vehicleNoSizeStart, vehicleNoSize));
        signalStatusBean.setVehicleNo(vehicleNo);
        //车牌分类
        int licenseCatalogSize = (int) Long.parseLong(value[vehicleNoSizeEnd + 1], 16);
        int licenseCatalogStart = vehicleNoSizeEnd + 2;
        int licenseCatalogEnd = vehicleNoSizeEnd + 1 + licenseCatalogSize;
        String licenseCatalog = decode(getGbkValue(value, licenseCatalogStart, licenseCatalogSize));
        signalStatusBean.setLicenseCatalog(licenseCatalog);
        //车辆VIN
        int vinSize = (int) Long.parseLong(value[licenseCatalogEnd + 1], 16);
        int vinStart = licenseCatalogEnd + 2;
        int vinEnd = licenseCatalogEnd + 1 + vinSize;
        String vin = decode(getGbkValue(value, vinStart, vinSize));
        signalStatusBean.setVin(vin);
        //脉冲系数
        int pulseSize = (int) Long.parseLong(value[vinEnd + 1], 16);
        int pulseStart = vinEnd + 2;
        int pulseEnd = vinEnd + 1 + pulseSize;
        String pulseCoefficient = decode(getGbkValue(value, pulseStart, pulseSize));
        signalStatusBean.setPulseCoefficient(pulseCoefficient);

        //超速阀值
        int speedingValueSize = (int) Long.parseLong(value[pulseEnd + 1], 16);
        int speedingValueStart = pulseEnd + 2;
        int speedingValueEnd = pulseEnd + 1 + speedingValueSize;
        String speedingValue = decode(getGbkValue(value, speedingValueStart, speedingValueSize));
        signalStatusBean.setSpeedingValue(speedingValue);
        //休息时间时限
        int restTimeSize = (int) Long.parseLong(value[speedingValueEnd + 1], 16);
        int restTimeStart = speedingValueEnd + 2;
        int restTimeEnd = speedingValueEnd + 1 + restTimeSize;
        String restTime = decode(getGbkValue(value, restTimeStart, restTimeSize));
        signalStatusBean.setRestTime(restTime);
        //超时预警差值
        int timeoutWranSize = (int) Long.parseLong(value[restTimeEnd + 1], 16);
        int timeoutWranStart = restTimeEnd + 2;
        int timeoutWranEnd = restTimeEnd + 1 + timeoutWranSize;
        String timeoutWran = decode(getGbkValue(value, timeoutWranStart, timeoutWranSize));
        signalStatusBean.setTimeoutWran(timeoutWran);

        //超时驾驶限时
        int timeoutDrivingSize = (int) Long.parseLong(value[timeoutWranEnd + 1], 16);
        int timeoutDrivingStart = timeoutWranEnd + 2;
        int timeoutDrivingEnd = timeoutWranEnd + 1 + timeoutDrivingSize;
        String timeoutDriving = decode(getGbkValue(value, timeoutDrivingStart, timeoutDrivingSize));
        signalStatusBean.setTimeoutDriving(timeoutDriving);

        //当天驾驶限时
        int dayDrivingSize = (int) Long.parseLong(value[timeoutDrivingEnd + 1], 16);
        int dayDrivingStart = timeoutDrivingEnd + 2;
        int dayDrivingEnd = timeoutDrivingEnd + 1 + dayDrivingSize;
        String dayDriving = decode(getGbkValue(value, dayDrivingStart, dayDrivingSize));
        signalStatusBean.setDayDriving(dayDriving);

        //报警车速
        int speedingWarnSize = (int) Long.parseLong(value[dayDrivingEnd + 1], 16);
        int speedingWarnStart = dayDrivingEnd + 2;
        int speedingWarnEnd = dayDrivingEnd + 1 + speedingWarnSize;
        String speedingWarn = decode(getGbkValue(value, speedingWarnStart, speedingWarnSize));
        signalStatusBean.setSpeedingWarn(speedingWarn);

        //休眠模式
        int sleepModeSize = (int) Long.parseLong(value[speedingWarnEnd + 1], 16);
        int sleepModeStart = speedingWarnEnd + 2;
        int sleepModeEnd = speedingWarnEnd + 1 + sleepModeSize;
        String sleepMode = decode(getGbkValue(value, sleepModeStart, sleepModeSize));
        signalStatusBean.setSleepMode(sleepMode);

        //休眠等待时间
        int sleepTimeSize = (int) Long.parseLong(value[sleepModeEnd + 1], 16);
        int sleepTimeStart = sleepModeEnd + 2;
        int sleepTimeEnd = sleepModeEnd + 1 + sleepTimeSize;
        String sleepTime = decode(getGbkValue(value, sleepTimeStart, sleepTimeSize));
        signalStatusBean.setSleepTime(sleepTime);

        //当前ic卡权限
        int icCardRightSize = (int) Long.parseLong(value[sleepTimeEnd + 1], 16);
        int icCardRightStart = sleepTimeEnd + 2;
        int icCardRightEnd = sleepTimeEnd + 1 + icCardRightSize;
        String icCardRight = decode(getGbkValue(value, icCardRightStart, icCardRightSize));
        signalStatusBean.setIcCardRight(icCardRight);

        baseBean.setModel(signalStatusBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }



}
