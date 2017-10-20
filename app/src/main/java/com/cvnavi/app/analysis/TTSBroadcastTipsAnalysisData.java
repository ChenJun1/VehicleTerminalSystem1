package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.TTSBroadcastTipsBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/9/6 14:23
 * version:
 * Depict:播报提示
 */

public class TTSBroadcastTipsAnalysisData extends AnalysisUiData {

    private static TTSBroadcastTipsAnalysisData sTTSBroadcastTipsAnalysisData;
    private static TTSBroadcastTipsBean sTTSBroadcastTipsBean = new TTSBroadcastTipsBean();
    private static BaseBean baseBean = new BaseBean();

    private TTSBroadcastTipsAnalysisData(byte[] datas) {
        super(datas);
    }

    public static TTSBroadcastTipsAnalysisData getInstance(byte[] datas) {
        if (sTTSBroadcastTipsAnalysisData == null) {
            sTTSBroadcastTipsAnalysisData = new TTSBroadcastTipsAnalysisData(datas);
        }
        sTTSBroadcastTipsAnalysisData.setDatas(datas);
        return sTTSBroadcastTipsAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }


    public void sendUi() {

        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_46;
        //播报提示
        short length = TextTransformationUtils.getShort(datas, 3);
        //服务器地址
        int time = TextTransformationUtils.getInt(datas,6);
        sTTSBroadcastTipsBean.setTime(time);

        baseBean.setModel(sTTSBroadcastTipsBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
