package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.BottomMessageBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/17.
 * 底部弹出提醒
 */

public class BottomMessageAnalysisData extends AnalysisUiData {

    private static BottomMessageAnalysisData bottomMessageAnalysisData;
    private static BottomMessageBean bottomMessageBean = new BottomMessageBean();
    private static BaseBean baseBean = new BaseBean();

    private BottomMessageAnalysisData(byte[] datas) {
        super(datas);
    }

    public static BottomMessageAnalysisData getInstance(byte[] datas) {
        if (bottomMessageAnalysisData == null) {
            bottomMessageAnalysisData = new BottomMessageAnalysisData(datas);
        }
        bottomMessageAnalysisData.setDatas(datas);
        return bottomMessageAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }


    public void sendUi() {
        //// TODO: 2017/8/18 测试,待删除
//        String test="557A4400140001000000020000000BB2D9D7F7D2D1CDEAB3C92144";
//        datas=TextTransformationUtils.hexStringToByte(test);


        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_44;
        //底部弹出提醒
        short length = TextTransformationUtils.getShort(datas, 3);
        int style=datas[6];
        bottomMessageBean.setStyle(style);
        //消息显示时间
        int time = TextTransformationUtils.getInt(datas,7);
        bottomMessageBean.setTime(time);
        //消息长度
         int contentLength=TextTransformationUtils.getInt(datas,11);
        //消息内容
        String content=decode(getGbkValue(value, 15, contentLength));
        bottomMessageBean.setContent(content);
        baseBean.setModel(bottomMessageBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
