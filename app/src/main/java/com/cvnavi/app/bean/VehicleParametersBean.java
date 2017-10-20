package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/1.
 */

public class VehicleParametersBean extends Entity {

    /**
     * 车牌号码
     */
    private String vehicleNo;

    /**
     * 车牌分类
     */
    private String licenseCatalog;

    /**
     * 车辆vin
     */
    private String vin;

    /**
     * 脉冲系数
     */
    private String pulseCoefficient;

    /**
     * 超速阀值
     */
    private String speedingValue;

    /**
     * 休息时间时限
     */
    private String restTime;

    /**
     * 超时预警差值
     */
    private String timeoutWran;

    /**
     * 超时驾驶限时
     */
    private String timeoutDriving;

    /**
     * 当天驾驶限时
     */
    private String dayDriving;

    /**
     * 报警车速
     */
    private String speedingWarn;

    /**
     * 休眠模式
     */
    private String sleepMode;

    /**
     * 休眠等待时间
     */
    private String sleepTime;

    /**
     * 当前ic卡权限
     */
    private String icCardRight;

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getLicenseCatalog() {
        return licenseCatalog;
    }

    public void setLicenseCatalog(String licenseCatalog) {
        this.licenseCatalog = licenseCatalog;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getPulseCoefficient() {
        return pulseCoefficient;
    }

    public void setPulseCoefficient(String pulseCoefficient) {
        this.pulseCoefficient = pulseCoefficient;
    }

    public String getSpeedingValue() {
        return speedingValue;
    }

    public void setSpeedingValue(String speedingValue) {
        this.speedingValue = speedingValue;
    }

    public String getRestTime() {
        return restTime;
    }

    public void setRestTime(String restTime) {
        this.restTime = restTime;
    }

    public String getTimeoutWran() {
        return timeoutWran;
    }

    public void setTimeoutWran(String timeoutWran) {
        this.timeoutWran = timeoutWran;
    }

    public String getTimeoutDriving() {
        return timeoutDriving;
    }

    public void setTimeoutDriving(String timeoutDriving) {
        this.timeoutDriving = timeoutDriving;
    }

    public String getDayDriving() {
        return dayDriving;
    }

    public void setDayDriving(String dayDriving) {
        this.dayDriving = dayDriving;
    }

    public String getSpeedingWarn() {
        return speedingWarn;
    }

    public void setSpeedingWarn(String speedingWarn) {
        this.speedingWarn = speedingWarn;
    }

    public String getSleepMode() {
        return sleepMode;
    }

    public void setSleepMode(String sleepMode) {
        this.sleepMode = sleepMode;
    }

    public String getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(String sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getIcCardRight() {
        return icCardRight;
    }

    public void setIcCardRight(String icCardRight) {
        this.icCardRight = icCardRight;
    }
}
