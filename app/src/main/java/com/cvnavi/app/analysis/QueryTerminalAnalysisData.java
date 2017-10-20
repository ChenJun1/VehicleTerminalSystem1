package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.QueryTerminalBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;

/**
 * Created by zww on 2017/8/22.
 *
 */

public class QueryTerminalAnalysisData extends AnalysisUiData {

    private static QueryTerminalAnalysisData queryTerminalAnalysisData;
    private static QueryTerminalBean queryTerminalBean = new QueryTerminalBean();
    private static BaseBean baseBean = new BaseBean();

    private QueryTerminalAnalysisData(byte[] datas) {
        super(datas);
    }

    public static QueryTerminalAnalysisData getInstance(byte[] datas) {
        if (queryTerminalAnalysisData == null) {
            queryTerminalAnalysisData = new QueryTerminalAnalysisData(datas);
        }
        queryTerminalAnalysisData.setDatas(datas);
        return queryTerminalAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }


    public void sendUi() {


        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_3B;
        short length = TextTransformationUtils.getShort(datas, 3);
        int state = TextTransformationUtils.getInt(datas,6);
        queryTerminalBean.setState(state);
        String content=decode(getGbkValue(value, 7, 24));
        queryTerminalBean.setContent(content);
        baseBean.setModel(queryTerminalBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
