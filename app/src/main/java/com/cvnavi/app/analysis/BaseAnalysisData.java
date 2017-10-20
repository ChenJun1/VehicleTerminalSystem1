package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

/**
 * Created by zww on 2017/7/31.
 * 导航栏条目
 */

public class BaseAnalysisData extends AnalysisUiData {

    private static BaseAnalysisData baseAnalysisData;
    private static BaseBean baseBean = new BaseBean();

    private BaseAnalysisData(byte[] datas) {
        super(datas);
    }

    public static BaseAnalysisData getInstance(byte[] datas) {
        if (baseAnalysisData == null) {
            baseAnalysisData = new BaseAnalysisData(datas);
        }
        baseAnalysisData.setDatas(datas);
        return baseAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi()
    {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_47;
        //主页导航栏
        short allTopSize =TextTransformationUtils.getShort(datas, 3);
        //平台1图标显示
        baseBean.setIconDisplay1(value[6]);
        //平台1是否连接
        baseBean.setIsConnnect1(value[7]);
        //平台1信号强度
        baseBean.setSignanItensity1((int) Long.parseLong(value[8], 16));
        //平台2图标显示
        baseBean.setIconDisplay2(value[9]);
        //平台2是否连接
        baseBean.setIsConnnect2(value[10]);
        //平台2信号强度
        baseBean.setSignanItensity2((int) Long.parseLong(value[11], 16));
        //卫星定位状态
        baseBean.setGprsState(value[12]);
        //视野内卫星数
        baseBean.setSatelliteNo((int) Long.parseLong(value[13], 16));
        //警告标识
        baseBean.setWarning((int) Long.parseLong(value[14], 16));
        //短消息标识
        baseBean.setMessage((int) Long.parseLong(value[15], 16));
        //司机卡属性
        baseBean.setCard(value[16]);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }

}
