package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/7/19.
 */

public class HomeFragBean {

    /**
     * 驾驶员
     */
    private String driverNo;
    /**
     * 驾驶证号码
     */
    private String licenseNo;
    /**
     * 速度
     */
    private String speed;
    /**
     * 当前时间(年月日)
     */
    private String time1;
    /**
     * 当前时间(时分秒)
     */
    private String time2;
    /**
     * 星期
     */
    private String time3;
    /**
     * 驾驶时间
     */
    private String driveTime;
    /**
     * 休息时间
     */
    private String restTime;
    /**
     * 休息满
     */
    private String isFullRest;
    /**
     * 累计里程
     */
    private String accumulatedileage;
    /**
     * 行驶状态
     */
    private String runningState;

    /**
     * 举升传感器状态
     */
    private String liftState;

    /**
     * 顶盖传感器状态
     */
    private String coverState;

    /**
     * 载重状态
     */
    private String loadState;

    /**
     * 载重百分比
     */
    private String loadPercent;

    /**
     * 限速状态
     */
    private String speedLimit;

    /**
     * 车辆所在区域
     */
    private String carLocation;

    public String getDriverNo() {
        return driverNo;
    }

    public void setDriverNo(String driverNo) {
        this.driverNo = driverNo;
    }

    public String getLicenseNo() {
        return licenseNo;
    }

    public void setLicenseNo(String licenseNo) {
        this.licenseNo = licenseNo;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getDriveTime() {
        return driveTime;
    }

    public void setDriveTime(String driveTime) {
        this.driveTime = driveTime;
    }

    public String getRestTime() {
        return restTime;
    }

    public void setRestTime(String restTime) {
        this.restTime = restTime;
    }

    public String getIsFullRest() {
        return isFullRest;
    }

    public void setIsFullRest(String isFullRest) {
        this.isFullRest = isFullRest;
    }

    public String getAccumulatedileage() {
        return accumulatedileage;
    }

    public void setAccumulatedileage(String accumulatedileage) {
        this.accumulatedileage = accumulatedileage;
    }

    public String getRunningState() {
        return runningState;
    }

    public void setRunningState(String runningState) {
        this.runningState = runningState;
    }

    public String getLoadState() {
        return loadState;
    }

    public void setLoadState(String loadState) {
        this.loadState = loadState;
    }

    public String getLiftState() {
        return liftState;
    }

    public void setLiftState(String liftState) {
        this.liftState = liftState;
    }

    public String getCoverState() {
        return coverState;
    }

    public void setCoverState(String coverState) {
        this.coverState = coverState;
    }

    public String getLoadPercent() {
        return loadPercent;
    }

    public void setLoadPercent(String loadPercent) {
        this.loadPercent = loadPercent;
    }

    public String getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(String speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }
}
