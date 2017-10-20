package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.SimulationBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/14.
 */

public class SimulationAnalysisData extends AnalysisUiData {

    private static SimulationAnalysisData simulationAnalysisData;
    private static SimulationBean simulationBean = new SimulationBean();
    private static BaseBean baseBean = new BaseBean();

    private SimulationAnalysisData(byte[] datas) {
        super(datas);
    }

    public static SimulationAnalysisData getInstance(byte[] datas) {
        if (simulationAnalysisData == null) {
            simulationAnalysisData = new SimulationAnalysisData(datas);
        }
        simulationAnalysisData.setDatas(datas);
        return simulationAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_3D;
        short length = TextTransformationUtils.getShort(datas, 3);
        String first=decode(getGbkValue(value, 16, datas[5]));
        simulationBean.setFirst(first);
        String second=decode(getGbkValue(value, 16, datas[21]));
        simulationBean.setSecond(second);
        baseBean.setModel(simulationBean);
        ListenerManager.getInstance().
                sendBroadCast(baseBean, code);
    }
}
