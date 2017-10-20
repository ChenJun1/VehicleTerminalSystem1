package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.AlertMessageBean;
import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/17.
 * 弹出提醒
 */

public class AlertMessageAnalysisData extends AnalysisUiData {

    private static AlertMessageAnalysisData alertMessageAnalysisData;
    private static AlertMessageBean alertMessageBean = new AlertMessageBean();
    private static BaseBean baseBean = new BaseBean();

    private AlertMessageAnalysisData(byte[] datas) {
        super(datas);
    }

    public static AlertMessageAnalysisData getInstance(byte[] datas) {
        if (alertMessageAnalysisData == null) {
            alertMessageAnalysisData = new AlertMessageAnalysisData(datas);
        }
        alertMessageAnalysisData.setDatas(datas);
        return alertMessageAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }


    public void sendUi() {
        //// TODO: 2017/8/18 测试,待删除
//        String test="557A45001300000000020000000BB2D9D7F7D2D1CDEAB3C92144";
//        datas=TextTransformationUtils.hexStringToByte(test);


        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_45;
        //弹出提醒
        short length = TextTransformationUtils.getShort(datas, 3);
        //消息显示时间
        int time = TextTransformationUtils.getInt(datas,6);
        alertMessageBean.setTime(time);
        //消息长度
         int contentLength=TextTransformationUtils.getInt(datas,10);
        //消息内容
        String content=decode(getGbkValue(value, 14, contentLength));
        alertMessageBean.setContent(content);
        baseBean.setModel(alertMessageBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
