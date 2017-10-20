package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.SignalStatusBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.binaryToArray;
import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/1.
 * 车辆信号状态数据
 */

public class SignalStatusAnalysisData extends AnalysisUiData {

    private static SignalStatusAnalysisData signalStatusAnalysisData;
    private static SignalStatusBean signalStatusBean = new SignalStatusBean();
    private static BaseBean baseBean = new BaseBean();

    private SignalStatusAnalysisData(byte[] datas) {
        super(datas);
    }

    public static SignalStatusAnalysisData getInstance(byte[] datas) {
        if (signalStatusAnalysisData == null) {
            signalStatusAnalysisData = new SignalStatusAnalysisData(datas);
        }
        signalStatusAnalysisData.setDatas(datas);
        return signalStatusAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_48;
        short length = TextTransformationUtils.getShort(datas, 3);
        int start=5;
        int d0NoSize = (int) Long.parseLong(value[start+1], 16);
        int d0NoSizeStart = start+2;
        int d0NoSizeEnd = start + 1 + d0NoSize;
        String d0No = decode(getGbkValue(value, d0NoSizeStart, d0NoSize));
        signalStatusBean.setD0Name(d0No);

        int d1NoSize = (int) Long.parseLong(value[d0NoSizeEnd+1], 16);
        int d1NoSizeStart = d0NoSizeEnd+2;
        int d1NoSizeEnd = d0NoSizeEnd + 1 + d1NoSize;
        String d1No = decode(getGbkValue(value, d1NoSizeStart, d1NoSize));
        signalStatusBean.setD1Name(d1No);

        int d2NoSize = (int) Long.parseLong(value[d1NoSizeEnd+1], 16);
        int d2NoSizeStart = d1NoSizeEnd+2;
        int d2NoSizeEnd = d1NoSizeEnd + 1 + d2NoSize;
        String d2No = decode(getGbkValue(value, d2NoSizeStart, d2NoSize));
        signalStatusBean.setD2Name(d2No);

        int d3NoSize = (int) Long.parseLong(value[d2NoSizeEnd+1], 16);
        int d3NoSizeStart = d2NoSizeEnd+2;
        int d3NoSizeEnd = d2NoSizeEnd + 1 + d3NoSize;
        String d3No = decode(getGbkValue(value, d3NoSizeStart, d3NoSize));
        signalStatusBean.setD3Name(d3No);

        int d4NoSize = (int) Long.parseLong(value[d3NoSizeEnd+1], 16);
        int d4NoSizeStart = d3NoSizeEnd+2;
        int d4NoSizeEnd = d3NoSizeEnd + 1 + d4NoSize;
        String d4No = decode(getGbkValue(value, d4NoSizeStart, d4NoSize));
        signalStatusBean.setD4Name(d4No);

        int d5NoSize = (int) Long.parseLong(value[d4NoSizeEnd+1], 16);
        int d5NoSizeStart = d4NoSizeEnd+2;
        int d5NoSizeEnd = d4NoSizeEnd + 1 + d5NoSize;
        String d5No = decode(getGbkValue(value, d5NoSizeStart, d5NoSize));
        signalStatusBean.setD5Name(d5No);

        int d6NoSize = (int) Long.parseLong(value[d5NoSizeEnd+1], 16);
        int d6NoSizeStart = d5NoSizeEnd+2;
        int d6NoSizeEnd = d5NoSizeEnd + 1 + d6NoSize;
        String d6No = decode(getGbkValue(value, d6NoSizeStart, d6NoSize));
        signalStatusBean.setD6Name(d6No);

        int d7NoSize = (int) Long.parseLong(value[d6NoSizeEnd+1], 16);
        int d7NoSizeStart = d6NoSizeEnd+2;
        int d7NoSizeEnd = d6NoSizeEnd + 1 + d7NoSize;
        String d7No = decode(getGbkValue(value, d7NoSizeStart, d7NoSize));
        signalStatusBean.setD7Name(d7No);

        String dWord =TextTransformationUtils.hexString2binaryString(value[d7NoSizeEnd+1]);
        signalStatusBean.setD0State(binaryToArray(dWord)[7]);
        signalStatusBean.setD1State(binaryToArray(dWord)[6]);
        signalStatusBean.setD2State(binaryToArray(dWord)[5]);
        signalStatusBean.setD3State(binaryToArray(dWord)[4]);
        signalStatusBean.setD4State(binaryToArray(dWord)[3]);
        signalStatusBean.setD5State(binaryToArray(dWord)[2]);
        signalStatusBean.setD6State(binaryToArray(dWord)[1]);
        signalStatusBean.setD7State(binaryToArray(dWord)[0]);
        baseBean.setModel(signalStatusBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }



}
