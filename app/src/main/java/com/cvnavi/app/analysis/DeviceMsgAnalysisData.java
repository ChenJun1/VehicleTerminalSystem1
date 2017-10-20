package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.DeviceMsgBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/1.
 * 设备信息
 */

public class DeviceMsgAnalysisData extends AnalysisUiData {

    private static DeviceMsgAnalysisData deviceMsgAnalysisData;
    private static DeviceMsgBean deviceMsgBean = new DeviceMsgBean();
    private static BaseBean baseBean = new BaseBean();

    private DeviceMsgAnalysisData(byte[] datas) {
        super(datas);
    }

    public static DeviceMsgAnalysisData getInstance(byte[] datas) {
        if (deviceMsgAnalysisData == null) {
            deviceMsgAnalysisData = new DeviceMsgAnalysisData(datas);
        }
        deviceMsgAnalysisData.setDatas(datas);
        return deviceMsgAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_4C;
        short length =TextTransformationUtils.getShort(datas, 3);
        int start = 5;
        //固件版本
        int firmwareVersionSize = (int) Long.parseLong(value[start + 1], 16);
        int firmwareVersionStart = start + 2;
        int firmwareVersionEnd = start + 1 + firmwareVersionSize;
        String firmwareVersion = decode(getGbkValue(value, firmwareVersionStart, firmwareVersionSize));
        deviceMsgBean.setFirmwareVersion(firmwareVersion);
        //硬件版本
        int hardwareVersionSize = (int) Long.parseLong(value[firmwareVersionEnd + 1], 16);
        int hardwareVersionStart = firmwareVersionEnd + 2;
        int hardwareVersionEnd = firmwareVersionEnd + 1 + hardwareVersionSize;
        String hardwareVersion = decode(getGbkValue(value, hardwareVersionStart, hardwareVersionSize));
        deviceMsgBean.setHardwareVersion(hardwareVersion);
        //通讯模块类型
        int comTypeSize = (int) Long.parseLong(value[hardwareVersionEnd + 1], 16);
        int comTypeStart = hardwareVersionEnd + 2;
        int comTypeEnd = hardwareVersionEnd + 1 + comTypeSize;
        String comType = decode(getGbkValue(value, comTypeStart, comTypeSize));
        deviceMsgBean.setComType(comType);
        //通讯模块版本
        int comVersionSize = (int) Long.parseLong(value[comTypeEnd + 1], 16);
        int comVersionStart = comTypeEnd + 2;
        int comVersionEnd = comTypeEnd + 1 + comVersionSize;
        String comVersion = decode(getGbkValue(value, comVersionStart, comVersionSize));
        deviceMsgBean.setComVersion(comVersion);

        //定位模块类型
        int locTypeSize = (int) Long.parseLong(value[comVersionEnd + 1], 16);
        int locTypeStart = comVersionEnd + 2;
        int locTypeEnd = comVersionEnd + 1 + locTypeSize;
        String locType = decode(getGbkValue(value, locTypeStart, locTypeSize));
        deviceMsgBean.setLocType(locType);
        //定位模块版本
        int locVersionSize = (int) Long.parseLong(value[locTypeEnd + 1], 16);
        int locVersionStart = locTypeEnd + 2;
        int locVersionEnd = locTypeEnd + 1 + locVersionSize;
        String locVersion = decode(getGbkValue(value, locVersionStart, locVersionSize));
        deviceMsgBean.setLocVersion(locVersion);
        //产品生产流水号
        int serialNumberSize = (int) Long.parseLong(value[locVersionEnd + 1], 16);
        int serialNumberStart = locVersionEnd + 2;
        int serialNumberEnd = locVersionEnd + 1 + serialNumberSize;
        String serialNumber = decode(getGbkValue(value, serialNumberStart, serialNumberSize));
        deviceMsgBean.setSerialNumber(serialNumber);

        //产品型号
        int typeSize = (int) Long.parseLong(value[serialNumberEnd + 1], 16);
        int typeStart = serialNumberEnd + 2;
        int typeEnd = serialNumberEnd + 1 + typeSize;
        String type = decode(getGbkValue(value, typeStart, typeSize));
        deviceMsgBean.setType(type);

        //生产日期
        int manufactureDateSize = (int) Long.parseLong(value[typeEnd + 1], 16);
        int manufactureDateStart = typeEnd + 2;
        int manufactureDateEnd = typeEnd + 1 + manufactureDateSize;
        String manufactureDate = decode(getGbkValue(value, manufactureDateStart, manufactureDateSize));
        deviceMsgBean.setManufactureDate(manufactureDate);

        //CCC认证码
        int codeSize = (int) Long.parseLong(value[manufactureDateEnd + 1], 16);
        int codeStart = manufactureDateEnd + 2;
        int codeEnd = manufactureDateEnd + 1 + codeSize;
        String tcode = decode(getGbkValue(value, codeStart, codeSize));
        deviceMsgBean.setCode(tcode);

        baseBean.setModel(deviceMsgBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
