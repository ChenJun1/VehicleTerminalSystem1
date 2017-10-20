package com.cvnavi.app.bean;


public class BaseBean extends Entity {

    /**
     * 平台1图标显示
     */
    private String iconDisplay1;
    /**
     * 平台1是否连接
     */
    private String isConnnect1;
    /**
     * 平台1信号强度
     */
    private int signanItensity1;

    /**
     * 平台2图标显示
     */
    private String iconDisplay2;
    /**
     * 平台2是否连接
     */
    private String isConnnect2;
    /**
     * 平台2信号强度
     */
    private int signanItensity2;
    /**
     * GPRS信号
     */
    private String gprsState;
    /**
     * 卫星数量
     */
    private int satelliteNo;

    /**
     * 警告标识
     */
    private int warning;
    /**
     * 短消息提示
     */
    private int message;
    /**
     * 司机卡属性
     */
    private String card;


    //实体类对象
    private Object model;


    public Object getModel() {
        return model;
    }

    public void setModel(Object model) {
        this.model = model;
    }


    public String getGprsState() {
        return gprsState;
    }

    public void setGprsState(String gprsState) {
        this.gprsState = gprsState;
    }

    public int getSatelliteNo() {
        return satelliteNo;
    }

    public void setSatelliteNo(int satelliteNo) {
        this.satelliteNo = satelliteNo;
    }

    public String getIconDisplay1() {
        return iconDisplay1;
    }

    public void setIconDisplay1(String iconDisplay1) {
        this.iconDisplay1 = iconDisplay1;
    }

    public String getIsConnnect1() {
        return isConnnect1;
    }

    public void setIsConnnect1(String isConnnect1) {
        this.isConnnect1 = isConnnect1;
    }

    public int getSignanItensity1() {
        return signanItensity1;
    }

    public void setSignanItensity1(int signanItensity1) {
        this.signanItensity1 = signanItensity1;
    }

    public String getIconDisplay2() {
        return iconDisplay2;
    }

    public void setIconDisplay2(String iconDisplay2) {
        this.iconDisplay2 = iconDisplay2;
    }

    public String getIsConnnect2() {
        return isConnnect2;
    }

    public void setIsConnnect2(String isConnnect2) {
        this.isConnnect2 = isConnnect2;
    }

    public int getSignanItensity2() {
        return signanItensity2;
    }

    public void setSignanItensity2(int signanItensity2) {
        this.signanItensity2 = signanItensity2;
    }

    public int getWarning() {
        return warning;
    }

    public void setWarning(int warning) {
        this.warning = warning;
    }

    public int getMessage() {
        return message;
    }

    public void setMessage(int message) {
        this.message = message;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }
}
