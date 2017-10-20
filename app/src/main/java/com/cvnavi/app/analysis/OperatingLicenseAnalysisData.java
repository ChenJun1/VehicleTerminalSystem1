package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.OperatingLicenseBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;
import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/9/8 14:18
 * version:
 * Depict: 渣土车电子运营证页面
 */

public class OperatingLicenseAnalysisData extends AnalysisUiData {

    private static OperatingLicenseAnalysisData sOperatingLicenseAnalysisData;
    private static OperatingLicenseBean sOperatingLicenseBean = new OperatingLicenseBean();
    private static BaseBean baseBean = new BaseBean();

    private OperatingLicenseAnalysisData(byte[] datas) {
        super(datas);
    }

    public static OperatingLicenseAnalysisData getInstance(byte[] datas) {
        if (sOperatingLicenseAnalysisData == null) {
            sOperatingLicenseAnalysisData = new OperatingLicenseAnalysisData(datas);
        }
        sOperatingLicenseAnalysisData.setDatas(datas);
        return sOperatingLicenseAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_3F;
        short length = TextTransformationUtils.getShort(datas, 3);
        // 开始小时
        String beginHour = datas[5] + "";
        sOperatingLicenseBean.setBeginHour(beginHour);
        //开始分钟
        String beginMinute = datas[6] + "";
        sOperatingLicenseBean.setBeginMinute(beginMinute);
        //当日 or 次日
        int dayType = datas[7];
        String day = getDayType(dayType);
        sOperatingLicenseBean.setDay(day);
        //  结束小时
        String endHour = datas[8] + "";
        sOperatingLicenseBean.setEndHour(endHour);
        //结束分钟
        String endMintue = datas[9] + "";
        sOperatingLicenseBean.setEndMinute(endMintue);

        // 有效日期  开始日
        String beginDataTime = value[10] + value[11] + "-" + value[12] + "-" + value[13];
        sOperatingLicenseBean.setBeginDataTime(beginDataTime);
        // 有效日期  结束日
        String endDataTime = value[14] + value[15] + "-" + value[16] + "-" + value[17];
        sOperatingLicenseBean.setEndDataTime(endDataTime);
        //工程名
        int  nameSize=datas[18];
        int nameStart=19;
        int nameEnd = nameStart + nameSize;
        String engineeringName=decode(getGbkValue(value,nameStart,nameSize));
        sOperatingLicenseBean.setEngineeringName(engineeringName);

        //公司车号
        int numberSize = datas[nameEnd];
        int numberStart=nameEnd+1;
        String numberPlate=decode(getGbkValue(value,numberStart,numberSize));
        sOperatingLicenseBean.setNumberPlate(numberPlate);

        baseBean.setModel(sOperatingLicenseBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }

    private String getDayType(int day) {
        switch (day) {
            case 1:
                return "次日";
            case 0:
                return "当日";
        }
        return "";
    }
}
