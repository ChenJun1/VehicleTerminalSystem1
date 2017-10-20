package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.InitializationBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

/**
 * Created by zww on 2017/8/14.
 */

public class InitializationAnalysisData extends AnalysisUiData {

    private static InitializationAnalysisData initializationAnalysisData;
    private static BaseBean baseBean = new BaseBean();
    private static InitializationBean initializationBean = new InitializationBean();

    private InitializationAnalysisData(byte[] datas) {
        super(datas);
    }

    public static InitializationAnalysisData getInstance(byte[] datas) {
        if (initializationAnalysisData == null) {
            initializationAnalysisData = new InitializationAnalysisData(datas);
        }
        initializationAnalysisData.setDatas(datas);
        return initializationAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_4F;
        short length = TextTransformationUtils.getShort(datas, 3);
        switch (value[6]+value[7])
        {
            case "0001":
                initializationBean.setSwitchInitial(1);
                initializationBean.setWarn(0);
                initializationBean.setTerminal(0);
                initializationBean.setRestoreFactory(0);
                initializationBean.setClearC1(0);
                initializationBean.setClearC2(0);
                break;
            case "0002":
                initializationBean.setSwitchInitial(0);
                initializationBean.setWarn(1);
                initializationBean.setTerminal(0);
                initializationBean.setRestoreFactory(0);
                initializationBean.setClearC1(0);
                initializationBean.setClearC2(0);
                break;
            case "0003":
                initializationBean.setSwitchInitial(0);
                initializationBean.setWarn(0);
                initializationBean.setTerminal(1);
                initializationBean.setRestoreFactory(0);
                initializationBean.setClearC1(0);
                initializationBean.setClearC2(0);
                break;
            case "0004":
                initializationBean.setSwitchInitial(0);
                initializationBean.setWarn(0);
                initializationBean.setTerminal(0);
                initializationBean.setRestoreFactory(1);
                initializationBean.setClearC1(0);
                initializationBean.setClearC2(0);
                break;
            case "0005":
                initializationBean.setSwitchInitial(0);
                initializationBean.setWarn(0);
                initializationBean.setTerminal(0);
                initializationBean.setRestoreFactory(0);
                initializationBean.setClearC1(1);
                initializationBean.setClearC2(0);
                break;
            case "0006":
                initializationBean.setSwitchInitial(0);
                initializationBean.setWarn(0);
                initializationBean.setTerminal(0);
                initializationBean.setRestoreFactory(0);
                initializationBean.setClearC1(0);
                initializationBean.setClearC2(1);
                break;
            case "0007":
                initializationBean.setSetPriority(datas[9]);
                break;
        }
        baseBean.setModel(initializationBean);
        ListenerManager.getInstance().
                sendBroadCast(baseBean, code);
    }
}
