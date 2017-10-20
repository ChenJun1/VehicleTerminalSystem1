package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.UpgradeBean;
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
 * Depict:远程升级
 */

public class UpgradeAnalysisData extends AnalysisUiData {

    private static UpgradeAnalysisData sUpgradeAnalysisData;
    private static UpgradeBean upgradeBean = new UpgradeBean();
    private static BaseBean baseBean = new BaseBean();

    private UpgradeAnalysisData(byte[] datas) {
        super(datas);
    }

    public static UpgradeAnalysisData getInstance(byte[] datas) {
        if (sUpgradeAnalysisData == null) {
            sUpgradeAnalysisData = new UpgradeAnalysisData(datas);
        }
        sUpgradeAnalysisData.setDatas(datas);
        return sUpgradeAnalysisData;
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
        //服务器地址
        int serverAddressSize = datas[start + 3];
        int serverAddressStart = start + 4;
        int serverAddressEnd = start + 3 + serverAddressSize;
        String serverAddress = decode(getGbkValue(value, serverAddressStart, serverAddressSize));
        upgradeBean.setServerAddress(serverAddress);

        //服务器端口
        int ServerPortSize = datas[serverAddressEnd + 3];
        int ServerPortStart = serverAddressEnd + 4;
        int ServerPortEnd = serverAddressEnd + 3 + ServerPortSize;
        String ServerPort = TextTransformationUtils.getInt(datas, ServerPortStart) + "";
        upgradeBean.setServerPort(ServerPort);

        //账号名
        int accountameSize = datas[ServerPortEnd + 3];
        int accountameStart = ServerPortEnd + 4;
        int accountameEnd = ServerPortEnd + 3 + accountameSize;
        String Accountame = decode(getGbkValue(value, accountameStart, accountameSize));
        upgradeBean.setAccountame(Accountame);

        //服务器APN
        int ServerAPNSize = datas[accountameEnd + 3];
        int ServerAPNStart = accountameEnd + 4;
        int ServerAPNEnd = accountameEnd + 3 + ServerAPNSize;
        String ServerAPN = decode(getGbkValue(value, ServerAPNStart, ServerAPNSize));
        upgradeBean.setServerAPN(ServerAPN);

        //下载状态
        int DownloadStatusSize = datas[ServerAPNEnd + 3];
        int DownloadStatusStart = ServerAPNEnd + 4;
        String DownloadStatus = decode(getGbkValue(value, DownloadStatusStart, DownloadStatusSize));
        upgradeBean.setServerAPN(DownloadStatus);

        baseBean.setModel(upgradeBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }
}
