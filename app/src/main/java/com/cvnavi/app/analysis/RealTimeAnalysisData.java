package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.RealTimeBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

/**
 * Created by zww on 2017/8/21.
 * 实时数据信息
 */

public class RealTimeAnalysisData extends AnalysisUiData {

    private static RealTimeAnalysisData realTimeAnalysisData;
    private static RealTimeBean realTimeBean = new RealTimeBean();
    private static BaseBean baseBean = new BaseBean();

    private RealTimeAnalysisData(byte[] datas) {
        super(datas);
    }

    public static RealTimeAnalysisData getInstance(byte[] datas) {
        if (realTimeAnalysisData == null) {
            realTimeAnalysisData = new RealTimeAnalysisData(datas);
        }
        realTimeAnalysisData.setDatas(datas);
        return realTimeAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }


    public void sendUi() {

        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_20;
        //实时数据信息
        short length = TextTransformationUtils.getShort(datas, 3);
        //引擎转速
        String engineSpeed = TextTransformationUtils.getShort(datas,6)+"";
        realTimeBean.setEngineSpeed(engineSpeed);
        //电池电压
        String cellVoltage=datas[8]+"";
        realTimeBean.setCellVoltage(cellVoltage);
        //外部电压
        String externalVoltage=TextTransformationUtils.getShort(datas,9)+"";
        realTimeBean.setExternalVoltage(externalVoltage);
        //累计油耗
        String cumulativeFuelConsumption=TextTransformationUtils.getInt(datas,11)+"";
        realTimeBean.setCumulativeFuelConsumption(cumulativeFuelConsumption);
        //发动机水温
        String temperature=datas[15]+"";
        realTimeBean.setTemperature(temperature);
        //机油压力
        String oilPressure=datas[16]+"";
        realTimeBean.setOilPressure(oilPressure);
        //瞬时油耗
        String instantaneousFuelConsumption=datas[17]+"";
        realTimeBean.setInstantaneousFuelConsumption(instantaneousFuelConsumption);
        //发动机扭矩
        String engineTorque=datas[18]+"";
        realTimeBean.setEngineTorque(engineTorque);
        baseBean.setModel(realTimeBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
