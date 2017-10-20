package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/21.
 */

public class RealTimeBean {

    /**
     * 引擎转速
     */
    private String engineSpeed;

    /**
     * 电池电压
     */
    private String cellVoltage;

    /**
     * 外部电压
     */
    private String externalVoltage;

    /**
     * 累计油耗
     */
    private String cumulativeFuelConsumption;

    /**
     * 发动机水温
     */
    private String temperature;

    /**
     * 机油压力
     */
    private String oilPressure;

    /**
     * 瞬时油耗
     */
    private String instantaneousFuelConsumption;

    /**
     * 发动机扭矩
     */
    private String engineTorque;


    public String getEngineSpeed() {
        return engineSpeed;
    }

    public void setEngineSpeed(String engineSpeed) {
        this.engineSpeed = engineSpeed;
    }

    public String getCellVoltage() {
        return cellVoltage;
    }

    public void setCellVoltage(String cellVoltage) {
        this.cellVoltage = cellVoltage;
    }

    public String getExternalVoltage() {
        return externalVoltage;
    }

    public void setExternalVoltage(String externalVoltage) {
        this.externalVoltage = externalVoltage;
    }

    public String getCumulativeFuelConsumption() {
        return cumulativeFuelConsumption;
    }

    public void setCumulativeFuelConsumption(String cumulativeFuelConsumption) {
        this.cumulativeFuelConsumption = cumulativeFuelConsumption;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getOilPressure() {
        return oilPressure;
    }

    public void setOilPressure(String oilPressure) {
        this.oilPressure = oilPressure;
    }

    public String getInstantaneousFuelConsumption() {
        return instantaneousFuelConsumption;
    }

    public void setInstantaneousFuelConsumption(String instantaneousFuelConsumption) {
        this.instantaneousFuelConsumption = instantaneousFuelConsumption;
    }

    public String getEngineTorque() {
        return engineTorque;
    }

    public void setEngineTorque(String engineTorque) {
        this.engineTorque = engineTorque;
    }
}
