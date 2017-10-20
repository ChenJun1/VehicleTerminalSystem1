package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.DeviceTestBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;

/**
 * Created by zww on 2017/8/14.
 */

public class DeviceTestAnalysisData extends AnalysisUiData {

    private static DeviceTestAnalysisData deviceTestAnalysisData;
    private static DeviceTestBean deviceTestBean = new DeviceTestBean();
    private static BaseBean baseBean = new BaseBean();

    private DeviceTestAnalysisData(byte[] datas) {
        super(datas);
    }

    public static DeviceTestAnalysisData getInstance(byte[] datas) {
        if (deviceTestAnalysisData == null) {
            deviceTestAnalysisData = new DeviceTestAnalysisData(datas);
        }
        deviceTestAnalysisData.setDatas(datas);
        return deviceTestAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_50;
        short length =TextTransformationUtils.getShort(datas, 3);
        switch (value[6]+value[7])
        {
            case "0000":
                //摄像头1状态
                int start=7;
                int cameraState1Size = datas[8];
                int cameraState1SizeStart = start + 2;
                int cameraState1SizeEnd = start + 1 + cameraState1Size;
                String cameraState1 = decode(TextTransformationUtils.getGbkValue(value,
                        cameraState1SizeStart, cameraState1Size));
                deviceTestBean.setCameraState1(cameraState1);

                //摄像头2状态
                int cameraState2Size = datas[cameraState1SizeEnd+1];
                int cameraState2SizeStart = cameraState1SizeEnd + 2;
                int cameraState2SizeEnd = cameraState1SizeEnd + 1 + cameraState1Size;
                String cameraState2 = decode(TextTransformationUtils.getGbkValue(value,
                        cameraState2SizeStart, cameraState2Size));
                deviceTestBean.setCameraState2(cameraState2);

                //摄像头3状态
                int cameraState3Size = datas[cameraState2SizeEnd+1];
                int cameraState3SizeStart = cameraState2SizeEnd + 2;
                int cameraState3SizeEnd = cameraState2SizeEnd + 1 + cameraState2Size;
                String cameraState3 = decode(TextTransformationUtils.getGbkValue(value,
                        cameraState3SizeStart, cameraState3Size));
                deviceTestBean.setCameraState3(cameraState3);

                //摄像头4状态
                int cameraState4Size = datas[cameraState3SizeEnd+1];
                int cameraState4SizeStart = cameraState3SizeEnd + 2;
                int cameraState4SizeEnd = cameraState3SizeEnd + 1 + cameraState3Size;
                String cameraState4 = decode(TextTransformationUtils.getGbkValue(value,
                        cameraState4SizeStart, cameraState4Size));
                deviceTestBean.setCameraState4(cameraState4);

                //cpu使用率
                int cpuUtilizationRateSize = datas[cameraState4SizeEnd+1];
                int cpuUtilizationRateSizeStart = cameraState4SizeEnd + 2;
                int cpuUtilizationRateSizeEnd = cameraState4SizeEnd + 1 + cpuUtilizationRateSize;
                String cpuUtilizationRate = decode(TextTransformationUtils.getGbkValue(value,
                        cpuUtilizationRateSizeStart, cpuUtilizationRateSize));
                deviceTestBean.setCpuUtilizationRate(cpuUtilizationRate);

                //核心温度
                int coreTemperatureSize = datas[cpuUtilizationRateSizeEnd+1];
                int coreTemperatureSizeStart = cpuUtilizationRateSizeEnd + 2;
                int coreTemperatureSizeEnd = cpuUtilizationRateSizeEnd + 1 + coreTemperatureSize;
                String coreTemperature = decode(TextTransformationUtils.getGbkValue(value,
                        coreTemperatureSizeStart, coreTemperatureSize));
                deviceTestBean.setCoreTemperature(coreTemperature);

                //外部电压
                int externalVoltageSize = datas[coreTemperatureSizeEnd+1];
                int externalVoltageSizeStart = coreTemperatureSizeEnd + 2;
                int externalVoltageSizeEnd = coreTemperatureSizeEnd + 1 + externalVoltageSize;
                String externalVoltage = decode(TextTransformationUtils.getGbkValue(value,
                        externalVoltageSizeStart, externalVoltageSize));
                deviceTestBean.setExternalVoltage(externalVoltage);

                //锂电电压
                int batteryVoltageSize = datas[externalVoltageSizeEnd+1];
                int batteryVoltageSizeStart = externalVoltageSizeEnd + 2;
                int batteryVoltageSizeEnd = externalVoltageSizeEnd + 1 + batteryVoltageSize;
                String batteryVoltage = decode(TextTransformationUtils.getGbkValue(value,
                        batteryVoltageSizeStart, batteryVoltageSize));
                deviceTestBean.setBatteryVoltage(batteryVoltage);

                //容量
                int capacitySize = datas[batteryVoltageSizeEnd+1];
                int capacitySizeStart = batteryVoltageSizeEnd + 2;
                int capacitySizeEnd = batteryVoltageSizeEnd + 1 + capacitySize;
                String capacity = decode(TextTransformationUtils.getGbkValue(value,
                        capacitySizeStart, capacitySize));
                deviceTestBean.setCapacity(capacity);

                //可用
                int isAbleSize = datas[capacitySizeEnd+1];
                int isAbleSizeStart = capacitySizeEnd + 2;
                int isAbleSizeEnd = capacitySizeEnd + 1 + isAbleSize;
                String isAble = decode(TextTransformationUtils.getGbkValue(value,
                        isAbleSizeStart, isAbleSize));
                deviceTestBean.setIsAble(isAble);

                //存贮卡速率
                int sdRateSize = datas[isAbleSizeEnd+1];
                int sdRateSizeStart = isAbleSizeEnd + 2;
                int sdRateSizeEnd = isAbleSizeEnd + 1 + sdRateSize;
                String sdRate = decode(TextTransformationUtils.getGbkValue(value,
                        sdRateSizeStart, sdRateSize));
                deviceTestBean.setSdRate(sdRate);

                //主机总线速率
                int hostBusRateSize = datas[sdRateSizeEnd+1];
                int hostBusRateSizeStart = sdRateSizeEnd + 2;
                int hostBusRateSizeEnd = sdRateSizeEnd + 1 + hostBusRateSize;
                String hostBusRate = decode(TextTransformationUtils.getGbkValue(value,
                        hostBusRateSizeStart, hostBusRateSize));
                deviceTestBean.setHostBusRate(hostBusRate);

                //属性
                int attributeSize = datas[hostBusRateSizeEnd+1];
                int attributeSizeStart = hostBusRateSizeEnd + 2;
                int attributeSizeEnd = hostBusRateSizeEnd + 1 + attributeSize;
                String attribute = decode(TextTransformationUtils.getGbkValue(value,
                        attributeSizeStart, attributeSize));
                deviceTestBean.setHostBusRate(attribute);
                break;
            case "0001":
                break;
            case "0002":
                break;
            case "0003":
                break;
            case "0004":
                break;
            case "0005":
                break;
            case "0006":
                break;
            case "0007":
                break;
        }
        baseBean.setModel(deviceTestBean);
        ListenerManager.getInstance().
                sendBroadCast(baseBean, code);
    }
}
