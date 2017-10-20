package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/22.
 */

public class LoanSalesBean {

    /**
     * vcu状态
     */
    private int vcuState;

    /**
     * amt状态
     */
    private int amtState;

    /**
     * 绑定状态
     */
    private int bingingState;

    /**
     * 控制状态
     */
    private int controlState;

    /**
     * can回传频率
     */
    private String canReturnFrequency;

    /**
     * gis回传频率
     */
    private String gisReturnFrequency;

    /**
     * 在线状态
     */
    private int onLineState;

    /**
     *车厂终端id
     */
    private String terminalId;

    /**
     * ip地址
     */
    private String ipAddress;

    /**
     * 端口
     */
    private String port;

    /**
     * 车型
     */
    private String models;

    /**
     * 销贷版本
     */
    private String loanSalesVersion;

    /**
     * 发动机类型
     */
    private String engineType;

    /**
     * 当前发动机id
     */
    private String engineId;

    /**
     * 锁车方式
     */
    private String lockStyle;

    /**
     * 还款日期
     */
    private String repaymentDate;

    /**
     * 超期天数
     */
    private String overdueDays;

    /**
     * 到期日期
     */
    private String maturityDate;

    /**
     * 已绑定发动机id
     */
    private String boundEngineId;

    public int getVcuState() {
        return vcuState;
    }

    public void setVcuState(int vcuState) {
        this.vcuState = vcuState;
    }

    public int getAmtState() {
        return amtState;
    }

    public void setAmtState(int amtState) {
        this.amtState = amtState;
    }

    public int getBingingState() {
        return bingingState;
    }

    public void setBingingState(int bingingState) {
        this.bingingState = bingingState;
    }

    public int getControlState() {
        return controlState;
    }

    public void setControlState(int controlState) {
        this.controlState = controlState;
    }

    public String getCanReturnFrequency() {
        return canReturnFrequency;
    }

    public void setCanReturnFrequency(String canReturnFrequency) {
        this.canReturnFrequency = canReturnFrequency;
    }

    public String getGisReturnFrequency() {
        return gisReturnFrequency;
    }

    public void setGisReturnFrequency(String gisReturnFrequency) {
        this.gisReturnFrequency = gisReturnFrequency;
    }

    public int getOnLineState() {
        return onLineState;
    }

    public void setOnLineState(int onLineState) {
        this.onLineState = onLineState;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getLoanSalesVersion() {
        return loanSalesVersion;
    }

    public void setLoanSalesVersion(String loanSalesVersion) {
        this.loanSalesVersion = loanSalesVersion;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    public String getLockStyle() {
        return lockStyle;
    }

    public void setLockStyle(String lockStyle) {
        this.lockStyle = lockStyle;
    }

    public String getRepaymentDate() {
        return repaymentDate;
    }

    public void setRepaymentDate(String repaymentDate) {
        this.repaymentDate = repaymentDate;
    }

    public String getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(String overdueDays) {
        this.overdueDays = overdueDays;
    }

    public String getMaturityDate() {
        return maturityDate;
    }

    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

    public String getBoundEngineId() {
        return boundEngineId;
    }

    public void setBoundEngineId(String boundEngineId) {
        this.boundEngineId = boundEngineId;
    }
}
