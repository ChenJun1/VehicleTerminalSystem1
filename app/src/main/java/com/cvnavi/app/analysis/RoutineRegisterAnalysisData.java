package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.RoutineRegisterBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;
import static com.cvnavi.app.utils.TextTransformationUtils.getInt;
import static com.cvnavi.app.utils.TextTransformationUtils.getShort;

/**
 * Created by zww on 2017/8/23.
 * 常规注册信息
 */

public class RoutineRegisterAnalysisData extends AnalysisUiData {

    private static RoutineRegisterAnalysisData routineRegisterAnalysisData;
    private static RoutineRegisterBean routineRegisterBean = new RoutineRegisterBean();
    private static BaseBean baseBean = new BaseBean();

    private RoutineRegisterAnalysisData(byte[] datas) {
        super(datas);
    }

    public static RoutineRegisterAnalysisData getInstance(byte[] datas) {
        if (routineRegisterAnalysisData == null) {
            routineRegisterAnalysisData = new RoutineRegisterAnalysisData(datas);
        }
        routineRegisterAnalysisData.setDatas(datas);
        return routineRegisterAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_4B;
        short length =TextTransformationUtils.getShort(datas, 3);
        int type=datas[6];
        routineRegisterBean.setType(type);
        int start = 6;
        switch (type)
        {
            case 1:
                break;
            case 2:
                //终端机型号
                int terminalModelSize = datas[start + 3];
                int terminalModelStart = start + 4;
                int terminalModelEnd = start + 3 + terminalModelSize;
                String terminalModel = decode(getGbkValue(value, terminalModelStart, terminalModelSize));
                routineRegisterBean.setTerminalModel(terminalModel);
                //制造商id
                int manufacturerIdSize = datas[terminalModelEnd + 3];
                int manufacturerIdStart = terminalModelEnd + 4;
                int manufacturerIdEnd = terminalModelEnd + 3 + manufacturerIdSize;
                String manufacturerId = decode(getGbkValue(value, manufacturerIdStart, manufacturerIdSize));
                routineRegisterBean.setManufacturerId(manufacturerId);
                //终端id
                int terminalIdSize = datas[manufacturerIdEnd + 3];
                int terminalIdStart = manufacturerIdEnd + 4;
                int terminalIdEnd = manufacturerIdEnd + 3 + terminalIdSize;
                String terminalId = decode(getGbkValue(value, terminalIdStart, terminalIdSize));
                routineRegisterBean.setTerminalId(terminalId);
                //车牌号码
                int vehicleNoSize = datas[terminalIdEnd + 3];
                int vehicleNoStart = terminalIdEnd + 4;
                int vehicleNoEnd = terminalIdEnd + 3 + vehicleNoSize;
                String vehicleNo = decode(getGbkValue(value, vehicleNoStart, vehicleNoSize));
                routineRegisterBean.setVehicleNo(vehicleNo);

                //车牌颜色
                String vehicleColor=datas[vehicleNoEnd+4]+"";
                int vehicleColorEnd=vehicleNoEnd+4;
                routineRegisterBean.setVehicleColor(vehicleColor);

                //vin
                int vinSize = datas[vehicleColorEnd + 3];
                int vinStart = vehicleColorEnd + 4;
                int vinEnd = vehicleColorEnd + 3 + vinSize;
                String vin = decode(getGbkValue(value, vinStart, vinSize));
                routineRegisterBean.setVin(vin);

                //省域id
                int provinceIdSize = datas[vinEnd + 3];
                int provinceIdStart = vinEnd + 4;
                int provinceIdEnd = vinEnd + 3 + provinceIdSize;
                String provinceId = getShort(datas,provinceIdStart)+"";
                routineRegisterBean.setProvinceId(provinceId);

                //省域id
                int cityIdSize = datas[provinceIdEnd + 3];
                int cityIdStart = provinceIdEnd + 4;
                int cityIdEnd = provinceIdEnd + 3 + cityIdSize;
                String cityId = getShort(datas,cityIdStart)+"";
                routineRegisterBean.setCityId(cityId);

                //终端手机号
                int terminalPhoneSize = datas[cityIdEnd + 3];
                int terminalPhoneStart = cityIdEnd + 4;
                int terminalPhoneEnd = cityIdEnd + 3 + terminalPhoneSize;
                String terminalPhone = getGbkValue(value, terminalPhoneStart, terminalPhoneSize).substring(1,10);
                routineRegisterBean.setTerminalPhone(terminalPhone);

                //apn
                int apnSize = datas[terminalPhoneEnd + 3];
                int apnStart = terminalPhoneEnd + 4;
                int apnEnd = terminalPhoneEnd + 3 + apnSize;
                String apn = getGbkValue(value, apnStart, apnSize);
                routineRegisterBean.setApn(apn);

                //第一中心ip
                int firstIpSize = datas[apnEnd + 3];
                int firstIpStart = apnEnd + 4;
                int firstIpEnd = apnEnd + 3 + firstIpSize;
                String firstIp = decode(getGbkValue(value, firstIpStart, firstIpSize));
                routineRegisterBean.setFirstIp(firstIp);

                //第一中心port
                int firstPortSize = datas[firstIpEnd + 3];
                int firstPortStart = firstIpEnd + 4;
                int firstPortEnd = firstIpEnd + 3 + firstPortSize;
                String firstPort =getInt(datas,firstPortStart)+"";
                routineRegisterBean.setFirstPort(firstPort);

                //第一中心终端协议
                int firstAgreementSize = datas[firstPortEnd + 3];
                int firstAgreementStart = firstPortEnd + 4;
                int firstAgreementEnd = firstPortEnd + 3 + firstAgreementSize;
                String firstAgreement =datas[firstAgreementStart]+"";
                routineRegisterBean.setFirstAgreement(firstAgreement);

                //第二中心ip
                int secondIpSize = datas[firstAgreementEnd + 3];
                int secondIpStart = firstAgreementEnd + 4;
                int secondIpEnd = firstAgreementEnd + 3 + secondIpSize;
                String secondIp = decode(getGbkValue(value, secondIpStart, secondIpSize));
                routineRegisterBean.setSecondIp(secondIp);

                //第二中心port
                int secondPortSize = datas[secondIpEnd + 3];
                int secondPortStart = secondIpEnd + 4;
                int secondPortEnd = secondIpEnd + 3 + secondPortSize;
                String secondPort =getInt(datas,secondPortStart)+"";
                routineRegisterBean.setSecondPort(secondPort);

                //第二中心终端协议
                int secondAgreementSize = datas[secondPortEnd + 3];
                int secondAgreementStart = secondPortEnd + 4;
                int secondAgreementEnd = secondPortEnd + 3 + secondAgreementSize;
                String secondAgreement =datas[secondAgreementStart]+"";
                routineRegisterBean.setSecondAgreement(secondAgreement);
                break;
            case 3:
                int firstButton=datas[8];
                routineRegisterBean.setFirstButton(firstButton);
                int secondButton=datas[9];
                routineRegisterBean.setSecondButton(secondButton);
                break;
            case 4:
                //第一中心通讯状态
                int firstStateSize = datas[start + 3];
                int firstStateStart = start + 4;
                int firstStateEnd = start + 3 + firstStateSize;
                String firstState = decode(getGbkValue(value, firstStateStart, firstStateSize));
                routineRegisterBean.setFirstState(firstState);
                //第二中心通讯状态
                int secondStateSize = datas[firstStateEnd + 3];
                int secondStateStart = firstStateEnd + 4;
                int secondStateEnd = firstStateEnd + 3 + secondStateSize;
                String secondState = decode(getGbkValue(value, secondStateStart, secondStateSize));
                routineRegisterBean.setSecondState(secondState);
                break;
        }


        baseBean.setModel(routineRegisterBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
