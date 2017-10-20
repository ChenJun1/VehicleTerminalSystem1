package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/21.
 */

public class FaultAlarmBean {

    /**
     * 严重故障
     */
    private int seriousFault;

    /**
     * 制动气压报警
     */
    private int brakeAirPressureAlarm;

    /**
     * 油压报警
     */
    private int oilPressureAlarm;

    /**
     * 水位低报警
     */
    private int lowWaterLevelAlarm;

    /**
     * 制动蹄片报警
     */
    private int brakeShoeAlarm;

    /**
     * 空滤堵塞报警
     */
    private int airFilterBlockingAlarm;

    /**
     * 燃油警告
     */
    private int fuelWarning;

    /**
     * 缓速器高温报警
     */
    private int alarmForRetarder;

    /**
     * 仓温报警
     */
    private int storehouseTemperatureAlarm;

    /**
     * 机油温度报警
     */
    private int oilTemperatureAlarm;

    public int getSeriousFault() {
        return seriousFault;
    }

    public void setSeriousFault(int seriousFault) {
        this.seriousFault = seriousFault;
    }

    public int getBrakeAirPressureAlarm() {
        return brakeAirPressureAlarm;
    }

    public void setBrakeAirPressureAlarm(int brakeAirPressureAlarm) {
        this.brakeAirPressureAlarm = brakeAirPressureAlarm;
    }

    public int getOilPressureAlarm() {
        return oilPressureAlarm;
    }

    public void setOilPressureAlarm(int oilPressureAlarm) {
        this.oilPressureAlarm = oilPressureAlarm;
    }

    public int getLowWaterLevelAlarm() {
        return lowWaterLevelAlarm;
    }

    public void setLowWaterLevelAlarm(int lowWaterLevelAlarm) {
        this.lowWaterLevelAlarm = lowWaterLevelAlarm;
    }

    public int getBrakeShoeAlarm() {
        return brakeShoeAlarm;
    }

    public void setBrakeShoeAlarm(int brakeShoeAlarm) {
        this.brakeShoeAlarm = brakeShoeAlarm;
    }

    public int getAirFilterBlockingAlarm() {
        return airFilterBlockingAlarm;
    }

    public void setAirFilterBlockingAlarm(int airFilterBlockingAlarm) {
        this.airFilterBlockingAlarm = airFilterBlockingAlarm;
    }

    public int getFuelWarning() {
        return fuelWarning;
    }

    public void setFuelWarning(int fuelWarning) {
        this.fuelWarning = fuelWarning;
    }

    public int getAlarmForRetarder() {
        return alarmForRetarder;
    }

    public void setAlarmForRetarder(int alarmForRetarder) {
        this.alarmForRetarder = alarmForRetarder;
    }

    public int getStorehouseTemperatureAlarm() {
        return storehouseTemperatureAlarm;
    }

    public void setStorehouseTemperatureAlarm(int storehouseTemperatureAlarm) {
        this.storehouseTemperatureAlarm = storehouseTemperatureAlarm;
    }

    public int getOilTemperatureAlarm() {
        return oilTemperatureAlarm;
    }

    public void setOilTemperatureAlarm(int oilTemperatureAlarm) {
        this.oilTemperatureAlarm = oilTemperatureAlarm;
    }
}
