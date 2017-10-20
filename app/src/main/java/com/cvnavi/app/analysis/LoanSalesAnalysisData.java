package com.cvnavi.app.analysis;

import com.cvnavi.app.bean.BaseBean;
import com.cvnavi.app.bean.LoanSalesBean;
import com.cvnavi.app.commanage.ListenerManager;
import com.cvnavi.app.utils.AgreementUtils;
import com.cvnavi.app.utils.TextTransformationUtils;

import static com.cvnavi.app.utils.TextTransformationUtils.decode;
import static com.cvnavi.app.utils.TextTransformationUtils.getGbkValue;
import static com.cvnavi.app.utils.TextTransformationUtils.getInt;
import static com.cvnavi.app.utils.TextTransformationUtils.getShort;

/**
 * Created by zww on 2017/8/22.
 * 销贷信息
 */

public class LoanSalesAnalysisData extends AnalysisUiData {

    private static LoanSalesAnalysisData loanSalesAnalysisData;
    private static LoanSalesBean loanSalesBean = new LoanSalesBean();
    private static BaseBean baseBean = new BaseBean();

    private LoanSalesAnalysisData(byte[] datas) {
        super(datas);
    }

    public static LoanSalesAnalysisData getInstance(byte[] datas) {
        if (loanSalesAnalysisData == null) {
            loanSalesAnalysisData = new LoanSalesAnalysisData(datas);
        }
        loanSalesAnalysisData.setDatas(datas);
        return loanSalesAnalysisData;
    }

    private void setDatas(byte[] datas) {
        this.datas = datas;
    }

    public void sendUi() {
        String[] value = TextTransformationUtils.bytesToHexStrings(datas);
        String code = AgreementUtils.agreement_53;
        short length = TextTransformationUtils.getShort(datas, 3);

        int vcuState = datas[9];
        loanSalesBean.setVcuState(vcuState);
        int amtState=datas[10];
        loanSalesBean.setAmtState(amtState);
        int bingingState=datas[11];
        loanSalesBean.setBingingState(bingingState);
        int controlState=datas[12];
        loanSalesBean.setControlState(controlState);

        String canReturnFrequency = getShort(datas,16)+"";
        loanSalesBean.setCanReturnFrequency(canReturnFrequency);

        String gisReturnFrequency = getShort(datas,21)+"";
        loanSalesBean.setGisReturnFrequency(gisReturnFrequency);

        int onLineState = getShort(datas,25);
        loanSalesBean.setOnLineState(onLineState);

        String terminalId = decode(getGbkValue(value, 30, datas[29]));
        int terminalIdEnd=29+datas[29];
        loanSalesBean.setTerminalId(terminalId);

        String ipAddress = decode(getGbkValue(value, terminalIdEnd+4, datas[terminalIdEnd+3]));
        int ipAddressEnd=terminalIdEnd+3+datas[terminalIdEnd+3];
        loanSalesBean.setIpAddress(ipAddress);

        String port = getInt(datas,ipAddressEnd+4)+"";
        int portEnd=ipAddressEnd+3+datas[ipAddressEnd+3];
        loanSalesBean.setPort(port);

        String models = decode(getGbkValue(value, portEnd+4, datas[portEnd+3]));
        int modelsEnd=portEnd+3+datas[portEnd+3];
        loanSalesBean.setModels(models);

        String loanSalesVersion = decode(getGbkValue(value, modelsEnd+4, datas[modelsEnd+3]));
        int loanSalesVersionEnd=modelsEnd+3+datas[modelsEnd+3];
        loanSalesBean.setLoanSalesVersion(loanSalesVersion);

        String engineType = decode(getGbkValue(value, loanSalesVersionEnd+4,
                datas[loanSalesVersionEnd+3]));
        int engineTypeEnd=loanSalesVersionEnd+3+datas[loanSalesVersionEnd+3];
        loanSalesBean.setEngineType(engineType);

        String engineId = decode(getGbkValue(value, engineTypeEnd+4, datas[engineTypeEnd+3]));
        int engineIdEnd=engineTypeEnd+3+datas[engineTypeEnd+3];
        loanSalesBean.setEngineId(engineId);

        String lockStyle = decode(getGbkValue(value, engineIdEnd+4, datas[engineIdEnd+3]));
        int lockStyleEnd=engineIdEnd+3+datas[engineIdEnd+3];
        loanSalesBean.setLockStyle(lockStyle);

        String repaymentDate = decode(getGbkValue(value, lockStyleEnd+4, datas[lockStyleEnd+3]));
        int repaymentDateEnd=lockStyleEnd+3+datas[lockStyleEnd+3];
        loanSalesBean.setRepaymentDate(repaymentDate);

        String overdueDays = getShort(datas,repaymentDateEnd+4)+"";
        int overdueDaysEnd=repaymentDateEnd+3+datas[repaymentDateEnd+3];
        loanSalesBean.setOverdueDays(overdueDays);

        String maturityDate = decode(getGbkValue(value, overdueDaysEnd+4, datas[overdueDaysEnd+3]));
        int maturityDateEnd=overdueDaysEnd+3+datas[overdueDaysEnd+3];
        loanSalesBean.setMaturityDate(maturityDate);

        String boundEngineId = decode(getGbkValue(value, maturityDateEnd+4,
                datas[maturityDateEnd+3]));
        loanSalesBean.setBoundEngineId(boundEngineId);

        switch ((value[6] + value[7]).toUpperCase()) {
            case "0001":

                break;
            case "0002":

                break;
            case "0003":

                break;
            case "0004":

                break;
            case "0005":

                break;
            case "0006":

                break;
            case "0007":

                break;
            case "0008":

                break;
            case "0009":

                break;
            case "000A":

                break;
            case "000B":

                break;
            case "000C":

                break;
            case "000D":

                break;
            case "000E":

                break;
            case "000F":

                break;
            case "0010":

                break;

        }
        baseBean.setModel(loanSalesBean);
        ListenerManager.getInstance().sendBroadCast(baseBean, code);
    }


}
