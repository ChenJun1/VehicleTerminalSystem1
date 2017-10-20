package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.CanBusMonitorBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/3.
 * Can总线监测
 */

public class CanBusMonitorAnalysisData extends AnalysisUiData {

    private static CanBusMonitorAnalysisData canBusMonitorAnalysisData;
    private static CanBusMonitorBean canBusMonitorBean = new CanBusMonitorBean();
    private static BaseBean baseBean = new BaseBean();

    private CanBusMonitorAnalysisData(byte[] datas) {
        super(datas);
    }

    public static CanBusMonitorAnalysisData getInstance(byte[] datas) {
        if (canBusMonitorAnalysisData == null) {
            canBusMonitorAnalysisData = new CanBusMonitorAnalysisData(datas);
        }
        canBusMonitorAnalysisData.setDatas(datas);
        return canBusMonitorAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_52;
        short length = TextTransformationUtils.getShort(datas, 3);
        int start=5;
        int sensorOilSize = datas[start + 3];
        int sensorOilStart = start + 4;
        int sensorOilEnd = start + 3 + sensorOilSize;
        String sensorOil = decode(getGbkValue(value, sensorOilStart, sensorOilSize));
        canBusMonitorBean.setSensorOil(sensorOil);

        int engineSpeedSize = datas[sensorOilEnd + 3];
        int engineSpeedStart = sensorOilEnd + 4;
        int engineSpeedEnd = sensorOilEnd + 3 + engineSpeedSize;
        String engineSpeed = decode(getGbkValue(value, engineSpeedStart, engineSpeedSize));
        canBusMonitorBean.setEngineSpeed(engineSpeed);

        int oilConsumptionSize = datas[engineSpeedEnd + 3];
        int oilConsumptionStart = engineSpeedEnd + 4;
        int oilConsumptionEnd = engineSpeedEnd + 3 + oilConsumptionSize;
        String oilConsumption = decode(getGbkValue(value, oilConsumptionStart, oilConsumptionSize));
        canBusMonitorBean.setOilConsumption(oilConsumption);

        int engineTorqueSize = datas[oilConsumptionEnd + 3];
        int engineTorqueStart = oilConsumptionEnd + 4;
        int engineTorqueEnd = oilConsumptionEnd + 3 + engineTorqueSize;
        String engineTorque = decode(getGbkValue(value, engineTorqueStart, engineTorqueSize));
        canBusMonitorBean.setEngineTorque(engineTorque);

        int pedalPositionSize = datas[engineTorqueEnd + 3];
        int pedalPositionStart = engineTorqueEnd + 4;
        int pedalPositionEnd = engineTorqueEnd + 3 + pedalPositionSize;
        String pedalPosition = decode(getGbkValue(value, pedalPositionStart, pedalPositionSize));
        canBusMonitorBean.setPedalPosition(pedalPosition);

        int allConsumptionSize = datas[pedalPositionEnd + 3];
        int allConsumptionStart = pedalPositionEnd + 4;
        int allConsumptionEnd = pedalPositionEnd + 3 + allConsumptionSize;
        String allConsumption = decode(getGbkValue(value, allConsumptionStart, allConsumptionSize));
        canBusMonitorBean.setAllConsumption(allConsumption);

        int meterOilConsumptionSize = datas[allConsumptionEnd + 3];
        int meterOilConsumptionStart = allConsumptionEnd + 4;
        int meterOilConsumptionEnd = allConsumptionEnd + 3 + meterOilConsumptionSize;
        String meterOilConsumption = decode(getGbkValue(value, meterOilConsumptionStart, meterOilConsumptionSize));
        canBusMonitorBean.setMeterOilConsumption(meterOilConsumption);

        int totalTimeSize = datas[meterOilConsumptionEnd + 3];
        int totalTimeStart = meterOilConsumptionEnd + 4;
        int totalTimeEnd = meterOilConsumptionEnd + 3 + totalTimeSize;
        String totalTime = decode(getGbkValue(value, totalTimeStart, totalTimeSize));
        canBusMonitorBean.setTotalTime(totalTime);

        int waterTemperatureSize = datas[totalTimeEnd + 3];
        int waterTemperatureStart = totalTimeEnd + 4;
        int waterTemperatureEnd = totalTimeEnd + 3 + waterTemperatureSize;
        String waterTemperature = decode(getGbkValue(value, waterTemperatureStart, waterTemperatureSize));
        canBusMonitorBean.setWaterTemperature(waterTemperature);

        int engineOilTemperatureSize = datas[waterTemperatureEnd + 3];
        int engineOilTemperatureStart = waterTemperatureEnd + 4;
        int engineOilTemperatureEnd = waterTemperatureEnd + 3 + engineOilTemperatureSize;
        String engineOilTemperature = decode(getGbkValue(value, engineOilTemperatureStart, engineOilTemperatureSize));
        canBusMonitorBean.setEngineOilTemperature(engineOilTemperature);

        int intakeTemperatureSize = datas[engineOilTemperatureEnd + 3];
        int intakeTemperatureStart = engineOilTemperatureEnd + 4;
        int intakeTemperatureEnd = engineOilTemperatureEnd + 3 + intakeTemperatureSize;
        String intakeTemperature = decode(getGbkValue(value, intakeTemperatureStart, intakeTemperatureSize));
        canBusMonitorBean.setIntakeTemperature(intakeTemperature);

        int oilPressureSize = datas[intakeTemperatureEnd + 3];
        int oilPressureStart = intakeTemperatureEnd + 4;
        int oilPressureEnd = intakeTemperatureEnd + 3 + oilPressureSize;
        String oilPressure = decode(getGbkValue(value, oilPressureStart, oilPressureSize));
        canBusMonitorBean.setOilPressure(oilPressure);

        int atmosphericPressureSize = datas[oilPressureEnd + 3];
        int atmosphericPressureStart = oilPressureEnd + 4;
        int atmosphericPressureEnd = oilPressureEnd + 3 + atmosphericPressureSize;
        String atmosphericPressure = decode(getGbkValue(value, atmosphericPressureStart, atmosphericPressureSize));
        canBusMonitorBean.setAtmosphericPressure(atmosphericPressure);

        int frictionalTorqueSize = datas[atmosphericPressureEnd + 3];
        int frictionalTorqueStart = atmosphericPressureEnd + 4;
        int frictionalTorqueEnd = atmosphericPressureEnd + 3 + frictionalTorqueSize;
        String frictionalTorque = decode(getGbkValue(value, frictionalTorqueStart, frictionalTorqueSize));
        canBusMonitorBean.setFrictionalTorque(frictionalTorque);

        int stallSize = datas[frictionalTorqueEnd + 3];
        int stallStart = frictionalTorqueEnd + 4;
        int stallEnd = frictionalTorqueEnd + 3 + stallSize;
        String stall = decode(getGbkValue(value, stallStart, stallSize));
        canBusMonitorBean.setStall(stall);

        int gasConsumptionSize = datas[stallEnd + 3];
        int gasConsumptionStart = stallEnd + 4;
        int gasConsumptionEnd = stallEnd + 3 + gasConsumptionSize;
        String gasConsumption = decode(getGbkValue(value, gasConsumptionStart, gasConsumptionSize));
        canBusMonitorBean.setGasConsumption(gasConsumption);

        int instantGasConsumptionSize = datas[gasConsumptionEnd + 3];
        int instantGasConsumptionStart = gasConsumptionEnd + 4;
        int instantGasConsumptionEnd = gasConsumptionEnd + 3 + instantGasConsumptionSize;
        String instantGasConsumption = decode(getGbkValue(value, instantGasConsumptionStart, instantGasConsumptionSize));
        canBusMonitorBean.setInstantgasConsumption(instantGasConsumption);
//        switch ((value[6]+value[7]).toUpperCase())
//        {
//            case "019D":
//                String sensorOil=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setSensorOil(sensorOil);
//                break;
//            case "019E":
//                String engineSpeed=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setEngineSpeed(engineSpeed);
//                break;
//            case "019F":
//                String oilConsumption=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setOilConsumption(oilConsumption);
//                break;
//            case "01A0":
//                String engineTorque=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setEngineTorque(engineTorque);
//                break;
//            case "01A1":
//                String pedalPosition=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setPedalPosition(pedalPosition);
//                break;
//            case "01A2":
//                String allConsumption=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setAllConsumption(allConsumption);
//                break;
//            case "01A3":
//                String meterOilConsumption=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setMeterOilConsumption(meterOilConsumption);
//                break;
//            case "01A4":
//                String totalTime=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setTotalTime(totalTime);
//                break;
//            case "01A5":
//                String waterTemperature=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setWaterTemperature(waterTemperature);
//                break;
//            case "01A6":
//                String engineOilTemperature=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setEngineOilTemperature(engineOilTemperature);
//                break;
//            case "01A7":
//                String intakeTemperature=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setIntakeTemperature(intakeTemperature);
//                break;
//            case "01A8":
//                String oilPressure=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setOilPressure(oilPressure);
//                break;
//            case "01A9":
//                String atmosphericPressure=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setAtmosphericPressure(atmosphericPressure);
//                break;
//            case "01AA":
//                String frictionalTorque=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setFrictionalTorque(frictionalTorque);
//                break;
//            case "01AB":
//                String stall=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setStall(stall);
//                break;
//            case "01AC":
//                String gasConsumption=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setGasConsumption(gasConsumption);
//                break;
//            case "01AD":
//                String instantGasConsumption=decode(getGbkValue(value, 6, datas[5]));
//                canBusMonitorBean.setInstantgasConsumption(instantGasConsumption);
//                break;
//            case "0190":
//
//                break;
//
//        }
        baseBean.setModel(canBusMonitorBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }



}
