package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.TirePressureBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import java.util.ArrayList;
import java.util.List;

import static com.cvnavi.app.utils.TextTransformationUtils.binaryToStringArray;


/**
 * Created by zww on 2017/10/16.
 * 胎压监测
 */

public class TirePressureAnalysisData extends AnalysisUiData {

    private static TirePressureAnalysisData tirePressureAnalysisData;
    private static TirePressureBean tirePressureBean = new TirePressureBean();
    private static BaseBean baseBean = new BaseBean();

    private TirePressureAnalysisData(byte[] datas) {
        super(datas);
    }

    public static TirePressureAnalysisData getInstance(byte[] datas) {
        if (tirePressureAnalysisData == null) {
            tirePressureAnalysisData = new TirePressureAnalysisData(datas);
        }
        tirePressureAnalysisData.setDatas(datas);
        return tirePressureAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        //胎压
        String code = AgreementUtils.agreement_39;
        short fLength = TextTransformationUtils.getShort(datas, 3);
        tirePressureBean.setType(datas[6]);
        List<TirePressureBean.PressureBeanItem> pressureBeanItems = new
                ArrayList<TirePressureBean.PressureBeanItem>();
        int size=fLength / 8;
        for (int i = 0; i < size; i++) {
            TirePressureBean.PressureBeanItem pressureBeanItem = new
                    TirePressureBean.PressureBeanItem();
            String location = TextTransformationUtils.hexString2binaryString(value[7+8*i]);
            pressureBeanItem.setTirePosition(location.substring(0,4));
            pressureBeanItem.setAxlePosition(location.substring(4,8));
            pressureBeanItem.setTirePressure(datas[8+8*i]+"");
            pressureBeanItem.setTireTemperature(TextTransformationUtils.getShort(datas, 9+9*i)+"");
            String state=TextTransformationUtils.hexString2binaryString(value[11+11*i]);
            pressureBeanItem.setSensorState(binaryToStringArray(state)[6]+binaryToStringArray
                    (state)[7]);
            pressureBeanItem.setLeakState(binaryToStringArray(state)[4]+binaryToStringArray
                    (state)[5]);
            pressureBeanItem.setTemperatureWarn(binaryToStringArray(state)[3]);
            pressureBeanItem.setSignalState(binaryToStringArray(state)[2]);
            pressureBeanItem.setNo(TextTransformationUtils.getShort(datas, 12+12*i)+"");
            String pressure=TextTransformationUtils.hexString2binaryString(value[14+14*i]);
            pressureBeanItem.setPressureTest(binaryToStringArray(pressure)[0]+binaryToStringArray
                    (pressure)[1]+binaryToStringArray(pressure)[2]);
            pressureBeanItems.add(pressureBeanItem);
        }
        tirePressureBean.setRecords(pressureBeanItems);
        baseBean.setModel(tirePressureBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }



}
