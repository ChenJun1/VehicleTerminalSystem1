package com.cvnavi.app.bean;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/8/30 13:30
 * version:
 * Depict: 采集能效分析数据
 */

public class EfficiencyAnalysisBean {
    /***
     * 百公里油耗
     */
    private String fuelConsumption;

    /***
     * 瞬时油耗
     */
    private String instantaneousFuelConsumption;

    /***
     * 累计油耗
     */
    private String accumulatedFuelConsumption;

    /***
     * 总里程
     */
    private String totalMileage;

    /***
     * 开始时间
     */
    private String startingTime;

    /***
     * 百公里油耗 小计油耗/小计里程
     */
    private String fuelConsumption2;

    /***
     * 小计油耗
     */
    private String subtotalFuelConsumption;

    /***
     * 小计里程
     */
    private String subtotalMileage;

    /**
     * 驾驶时长小时
     */
    private String whenDrivingHours;

    /**
     * 驾驶时长分钟
     */
    private String drivingTime;

    public String getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(String fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getInstantaneousFuelConsumption() {
        return instantaneousFuelConsumption;
    }

    public void setInstantaneousFuelConsumption(String instantaneousFuelConsumption) {
        this.instantaneousFuelConsumption = instantaneousFuelConsumption;
    }

    public String getAccumulatedFuelConsumption() {
        return accumulatedFuelConsumption;
    }

    public void setAccumulatedFuelConsumption(String accumulatedFuelConsumption) {
        this.accumulatedFuelConsumption = accumulatedFuelConsumption;
    }

    public String getTotalMileage() {
        return totalMileage;
    }

    public void setTotalMileage(String totalMileage) {
        this.totalMileage = totalMileage;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getFuelConsumption2() {
        return fuelConsumption2;
    }

    public void setFuelConsumption2(String fuelConsumption2) {
        this.fuelConsumption2 = fuelConsumption2;
    }

    public String getSubtotalFuelConsumption() {
        return subtotalFuelConsumption;
    }

    public void setSubtotalFuelConsumption(String subtotalFuelConsumption) {
        this.subtotalFuelConsumption = subtotalFuelConsumption;
    }

    public String getSubtotalMileage() {
        return subtotalMileage;
    }

    public void setSubtotalMileage(String subtotalMileage) {
        this.subtotalMileage = subtotalMileage;
    }

    public String getWhenDrivingHours() {
        return whenDrivingHours;
    }

    public void setWhenDrivingHours(String whenDrivingHours) {
        this.whenDrivingHours = whenDrivingHours;
    }

    public String getDrivingTime() {
        return drivingTime;
    }

    public void setDrivingTime(String drivingTime) {
        this.drivingTime = drivingTime;
    }
}
