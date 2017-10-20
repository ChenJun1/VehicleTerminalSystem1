package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.PrintThePage;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/9/6 14:23
 * version:
 * Depict:打印页面
 */

public class PrintThePageAnalysisData extends AnalysisUiData {

    private static PrintThePageAnalysisData sPrintThePageAnalysisData;
    private static PrintThePage sPrintThePage = new PrintThePage();
    private static BaseBean baseBean = new BaseBean();

    private PrintThePageAnalysisData(byte[] datas) {
        super(datas);
    }

    public static PrintThePageAnalysisData getInstance(byte[] datas) {
        if (sPrintThePageAnalysisData == null) {
            sPrintThePageAnalysisData = new PrintThePageAnalysisData(datas);
        }
        sPrintThePageAnalysisData.setDatas(datas);
        return sPrintThePageAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }


    public void sendUi() {

        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_54;
        //远程升级
        short length = TextTransformationUtils.getShort(datas, 3);
        int start = 5;
        //打印内容
        int serverAddressSize = datas[start + 1];
        int serverAddressStart = start + 2;
        String content = decode(getGbkValue(value, serverAddressStart, serverAddressSize));
        sPrintThePage.setContent(content);

        baseBean.setModel(sPrintThePage);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
