package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.MessageBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/17.
 * 短消息
 */

public class MessageAnalysisData extends AnalysisUiData {

    private static MessageAnalysisData messageAnalysisData;
    private static MessageBean messageBean = new MessageBean();
    private static BaseBean baseBean = new BaseBean();

    private MessageAnalysisData(byte[] datas) {
        super(datas);
    }

    public static MessageAnalysisData getInstance(byte[] datas) {
        if (messageAnalysisData == null) {
            messageAnalysisData = new MessageAnalysisData(datas);
        }
        messageAnalysisData.setDatas(datas);
        return messageAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }


    public void sendUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_23;
        //短消息
        short length = TextTransformationUtils.getShort(datas, 3);
        //消息时间
        String time = "20" + value[6] + "-" + value[7] + "-" +
                value[8] + " " + value[9] + ":" + value[10] + ":" + value[11];
        messageBean.setTime(time);
        //消息类别
        String type=decode(getGbkValue(value, 12, 10));
        messageBean.setType(type);
        //消息来源
        String source=decode(getGbkValue(value, 22, 10));
        messageBean.setSource(source);
        //消息内容
        String content=decode(getGbkValue(value, 32, 254));
        messageBean.setContent(content);
        baseBean.setModel(messageBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
