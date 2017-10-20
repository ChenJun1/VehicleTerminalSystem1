package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.EfficiencyAnalysisBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/9/6 14:23
 * version:
 * Depict:实时数据信息
 */

public class EfficiencyAnalysisAnalysisData extends AnalysisUiData {

    private static EfficiencyAnalysisAnalysisData realTimeAnalysisData;
    private static EfficiencyAnalysisBean sEfficiencyAnalysisBean = new EfficiencyAnalysisBean();
    private static BaseBean baseBean = new BaseBean();

    private EfficiencyAnalysisAnalysisData(byte[] datas) {
        super(datas);
    }

    public static EfficiencyAnalysisAnalysisData getInstance(byte[] datas) {
        if (realTimeAnalysisData == null) {
            realTimeAnalysisData = new EfficiencyAnalysisAnalysisData(datas);
        }
        realTimeAnalysisData.setDatas(datas);
        return realTimeAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }


    public void sendUi() {

        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_34;
        //采集能效分析数据
        short length = TextTransformationUtils.getShort(datas, 3);

        //百公里油耗
        String fuelConsumption = TextTransformationUtils.getShort(datas, 6) + "";
        sEfficiencyAnalysisBean.setFuelConsumption(fuelConsumption);

        //瞬时油耗
        String instantaneousFuelConsumption = TextTransformationUtils.getShort(datas, 8) + "";
        sEfficiencyAnalysisBean.setInstantaneousFuelConsumption(instantaneousFuelConsumption);
        //累计油耗
        String accumulatedFuelConsumption = TextTransformationUtils.getInt(datas, 10) + "";
        sEfficiencyAnalysisBean.setAccumulatedFuelConsumption(accumulatedFuelConsumption);

        //总里程
        String totalMileage = TextTransformationUtils.getInt(datas, 14) + "";
        sEfficiencyAnalysisBean.setTotalMileage(totalMileage);

        //开始时间
        String startingTime = TextTransformationUtils.getDateTime(value, 13, 18);
        sEfficiencyAnalysisBean.setStartingTime(startingTime);

        //百公里油耗 小计油耗/小计里程
        String fuelConsumption2 = TextTransformationUtils.getShort(datas, 19) + "";
        sEfficiencyAnalysisBean.setFuelConsumption2(fuelConsumption2);

        //小计油耗
        String subtotalFuelConsumption = TextTransformationUtils.getShort(datas, 21) + "";
        sEfficiencyAnalysisBean.setSubtotalFuelConsumption(subtotalFuelConsumption);

        //小计里程
        String subtotalMileage = TextTransformationUtils.getShort(datas, 23) + "";
        sEfficiencyAnalysisBean.setSubtotalMileage(subtotalMileage);

        //驾驶时长小时
        String whenDrivingHours = String.valueOf(datas[25]);
        sEfficiencyAnalysisBean.setWhenDrivingHours(whenDrivingHours);

        //驾驶时长分钟
        String drivingTime = String.valueOf(datas[26]);
        sEfficiencyAnalysisBean.setDrivingTime(drivingTime);
        baseBean.setModel(sEfficiencyAnalysisBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
