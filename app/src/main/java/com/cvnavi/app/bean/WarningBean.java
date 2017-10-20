package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/7/17.
 */

public class WarningBean extends Entity {
    //报警信息
    /**
     * 驾驶员登录状态
     */
    private int isLogin;
    /**
     * 速度状态
     */
    private int speed;

    /**
     * 紧急报警
     */
    private int emergencyAlarm;

    /**
     *  超速报警
     */
    private int speedAlarm;

    /**
     * 疲劳驾驶
     */

    private int fatigueDriving;

    /**
     * 危险预警
     */
    private int riskWarning;

    /**
     * GNSS 模块发生故障
     */
    private int moduleFailure;

    /**
     * GNSS 天线未接
     */
    private int antennaMissed;

    /**
     * GNSS 天线短路
     */
    private int antennaShort;

    /**
     * 终端主电源欠压
     */
    private int undervoltage;

    /**
     * 终端主电源掉电
     */
    private int leakage;

    /**
     * 终端显示器故障
     */
    private int fault;

    /**
     * TTS模块故障
     */
    private int ttsFault;

    /**
     * 摄像头故障
     */
    private int cameraFault;

    /**
     * 道路运输证IC卡模块故障
     */
    private int icFault;

    /**
     * 超速预警
     */
    private int  overspeedWarning;

    /**
     * 疲劳驾驶预警
     */
    private int fatigueDrivingWarning;

    /**
     * 当天累计驾驶超时
     */
    private int overtime;

    /**
     * 超时停车
     */
    private int overtimePark;

    /**
     * 进出区域
     */
    private int area;

    /**
     * 进出路线
     */
    private int line;

    /**
     * 路段行驶时间不足/过长
     */
    private int timeWarning;

    /**
     * 路段偏离报警
     */
    private int deviate;

    /**
     * 车辆VSS故障
     */
    private int vssfault;

    /**
     * 车辆油量异常
     */
    private int oilAbnormal;

    /**
     * 车辆被盗
     */
    private int stolenVehicles;

    /**
     * 非法点火
     */
    private int illegalIgnition;

    /**
     * 非法位移
     */
    private int illegalDisplacement;

    /**
     * 碰撞预警
     */
    private int collisionWarning;

    /**
     * 侧翻预警
     */
    private int rolloverWarning;

    /**
     * 非法开门预警
     */
    private int illagelOpen;

    public int getIsLogin() {
        return isLogin;
    }

    public void setIsLogin(int isLogin) {
        this.isLogin = isLogin;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getEmergencyAlarm() {
        return emergencyAlarm;
    }

    public void setEmergencyAlarm(int emergencyAlarm) {
        this.emergencyAlarm = emergencyAlarm;
    }

    public int getSpeedAlarm() {
        return speedAlarm;
    }

    public void setSpeedAlarm(int speedAlarm) {
        this.speedAlarm = speedAlarm;
    }

    public int getFatigueDriving() {
        return fatigueDriving;
    }

    public void setFatigueDriving(int fatigueDriving) {
        this.fatigueDriving = fatigueDriving;
    }

    public int getRiskWarning() {
        return riskWarning;
    }

    public void setRiskWarning(int riskWarning) {
        this.riskWarning = riskWarning;
    }

    public int getModuleFailure() {
        return moduleFailure;
    }

    public void setModuleFailure(int moduleFailure) {
        this.moduleFailure = moduleFailure;
    }

    public int getAntennaMissed() {
        return antennaMissed;
    }

    public void setAntennaMissed(int antennaMissed) {
        this.antennaMissed = antennaMissed;
    }

    public int getAntennaShort() {
        return antennaShort;
    }

    public void setAntennaShort(int antennaShort) {
        this.antennaShort = antennaShort;
    }

    public int getUndervoltage() {
        return undervoltage;
    }

    public void setUndervoltage(int undervoltage) {
        this.undervoltage = undervoltage;
    }

    public int getLeakage() {
        return leakage;
    }

    public void setLeakage(int leakage) {
        this.leakage = leakage;
    }

    public int getFault() {
        return fault;
    }

    public void setFault(int fault) {
        this.fault = fault;
    }

    public int getTtsFault() {
        return ttsFault;
    }

    public void setTtsFault(int ttsFault) {
        this.ttsFault = ttsFault;
    }

    public int getCameraFault() {
        return cameraFault;
    }

    public void setCameraFault(int cameraFault) {
        this.cameraFault = cameraFault;
    }

    public int getIcFault() {
        return icFault;
    }

    public void setIcFault(int icFault) {
        this.icFault = icFault;
    }

    public int getOverspeedWarning() {
        return overspeedWarning;
    }

    public void setOverspeedWarning(int overspeedWarning) {
        this.overspeedWarning = overspeedWarning;
    }

    public int getFatigueDrivingWarning() {
        return fatigueDrivingWarning;
    }

    public void setFatigueDrivingWarning(int fatigueDrivingWarning) {
        this.fatigueDrivingWarning = fatigueDrivingWarning;
    }

    public int getOvertime() {
        return overtime;
    }

    public void setOvertime(int overtime) {
        this.overtime = overtime;
    }

    public int getOvertimePark() {
        return overtimePark;
    }

    public void setOvertimePark(int overtimePark) {
        this.overtimePark = overtimePark;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getTimeWarning() {
        return timeWarning;
    }

    public void setTimeWarning(int timeWarning) {
        this.timeWarning = timeWarning;
    }

    public int getDeviate() {
        return deviate;
    }

    public void setDeviate(int deviate) {
        this.deviate = deviate;
    }

    public int getVssfault() {
        return vssfault;
    }

    public void setVssfault(int vssfault) {
        this.vssfault = vssfault;
    }

    public int getOilAbnormal() {
        return oilAbnormal;
    }

    public void setOilAbnormal(int oilAbnormal) {
        this.oilAbnormal = oilAbnormal;
    }

    public int getStolenVehicles() {
        return stolenVehicles;
    }

    public void setStolenVehicles(int stolenVehicles) {
        this.stolenVehicles = stolenVehicles;
    }

    public int getIllegalIgnition() {
        return illegalIgnition;
    }

    public void setIllegalIgnition(int illegalIgnition) {
        this.illegalIgnition = illegalIgnition;
    }

    public int getIllegalDisplacement() {
        return illegalDisplacement;
    }

    public void setIllegalDisplacement(int illegalDisplacement) {
        this.illegalDisplacement = illegalDisplacement;
    }

    public int getCollisionWarning() {
        return collisionWarning;
    }

    public void setCollisionWarning(int collisionWarning) {
        this.collisionWarning = collisionWarning;
    }

    public int getRolloverWarning() {
        return rolloverWarning;
    }

    public void setRolloverWarning(int rolloverWarning) {
        this.rolloverWarning = rolloverWarning;
    }

    public int getIllagelOpen() {
        return illagelOpen;
    }

    public void setIllagelOpen(int illagelOpen) {
        this.illagelOpen = illagelOpen;
    }
}
