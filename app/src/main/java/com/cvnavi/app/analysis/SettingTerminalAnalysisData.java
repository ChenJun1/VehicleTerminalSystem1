package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.SettingTerminalBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;
import static com.cvnavi.app.utils.TextTransformationUtils.getShort;

/**
 * Created by zww on 2017/8/23.
 * 快速注册
 */

public class SettingTerminalAnalysisData extends AnalysisUiData {

    private static SettingTerminalAnalysisData settingTerminalAnalysisData;
    private static SettingTerminalBean settingTerminalBean = new SettingTerminalBean();
    private static BaseBean baseBean = new BaseBean();

    private SettingTerminalAnalysisData(byte[] datas) {
        super(datas);
    }

    public static SettingTerminalAnalysisData getInstance(byte[] datas) {
        if (settingTerminalAnalysisData == null) {
            settingTerminalAnalysisData = new SettingTerminalAnalysisData(datas);
        }
        settingTerminalAnalysisData.setDatas(datas);
        return settingTerminalAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_3A;
        short length =TextTransformationUtils.getShort(datas, 3);
        int start = 5;
        //终端机型号
        int terminalModelSize = datas[start + 3];
        int terminalModelStart = start + 4;
        int terminalModelEnd = start + 3 + terminalModelSize;
        String terminalModel = decode(getGbkValue(value, terminalModelStart, terminalModelSize));
        settingTerminalBean.setTerminalModel(terminalModel);
        //制造商id
        int manufacturerIdSize = datas[terminalModelEnd + 3];
        int manufacturerIdStart = terminalModelEnd + 4;
        int manufacturerIdEnd = terminalModelEnd + 3 + manufacturerIdSize;
        String manufacturerId = decode(getGbkValue(value, manufacturerIdStart, manufacturerIdSize));
        settingTerminalBean.setManufacturerId(manufacturerId);
        //终端id
        int terminalIdSize = datas[manufacturerIdEnd + 3];
        int terminalIdStart = manufacturerIdEnd + 4;
        int terminalIdEnd = manufacturerIdEnd + 3 + terminalIdSize;
        String terminalId = decode(getGbkValue(value, terminalIdStart, terminalIdSize));
        settingTerminalBean.setTerminalId(terminalId);
        //车牌号码
        int vehicleNoSize = datas[terminalIdEnd + 3];
        int vehicleNoStart = terminalIdEnd + 4;
        int vehicleNoEnd = terminalIdEnd + 3 + vehicleNoSize;
        String vehicleNo = decode(getGbkValue(value, vehicleNoStart, vehicleNoSize));
        settingTerminalBean.setVehicleNo(vehicleNo);

        //车牌颜色
        int vehicleColor=datas[vehicleNoEnd+4];
        int vehicleColorEnd=vehicleNoEnd+4;
        settingTerminalBean.setVehicleColor(vehicleColor);

        //vin
        int vinSize = datas[vehicleColorEnd + 3];
        int vinStart = vehicleColorEnd + 4;
        int vinEnd = vehicleColorEnd + 3 + vinSize;
        String vin = decode(getGbkValue(value, vinStart, vinSize));
        settingTerminalBean.setVin(vin);

        //省域id
        int provinceIdSize = datas[vinEnd + 3];
        int provinceIdStart = vinEnd + 4;
        int provinceIdEnd = vinEnd + 3 + provinceIdSize;
        String provinceId = getShort(datas,provinceIdStart)+"";
        settingTerminalBean.setProvinceId(provinceId);

        //省域id
        int cityIdSize = datas[provinceIdEnd + 3];
        int cityIdStart = provinceIdEnd + 4;
        int cityIdEnd = provinceIdEnd + 3 + cityIdSize;
        String cityId = getShort(datas,cityIdStart)+"";
        settingTerminalBean.setCityId(cityId);

        //终端手机号
        int terminalPhoneSize = datas[cityIdEnd + 3];
        int terminalPhoneStart = cityIdEnd + 4;
        int terminalPhoneEnd = cityIdEnd + 3 + terminalPhoneSize;
        String terminalPhone = getGbkValue(value, terminalPhoneStart, terminalPhoneSize)
                .substring(1,12);;
        settingTerminalBean.setTerminalPhone(terminalPhone);

        //车主手机号
        int ownerPhoneSize = datas[terminalPhoneEnd + 3];
        int ownerPhoneStart = terminalPhoneEnd + 4;
        int ownerPhoneEnd = terminalPhoneEnd + 3 + ownerPhoneSize;
        String ownerPhone = getGbkValue(value, ownerPhoneStart, ownerPhoneSize).substring(1,12);;
        settingTerminalBean.setOwnerPhone(ownerPhone);

        //车主姓名
        int ownerNameSize = datas[ownerPhoneEnd + 3];
        int ownerNameStart = ownerPhoneEnd + 4;
        int ownerNameEnd = ownerPhoneEnd + 4 + ownerNameSize;
        String ownerName = decode(getGbkValue(value, ownerNameStart, ownerNameSize));
        settingTerminalBean.setOwnerName(ownerName);


        baseBean.setModel(settingTerminalBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
