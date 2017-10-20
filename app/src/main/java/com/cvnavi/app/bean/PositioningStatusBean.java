package com.cvnavi.app.bean;

/**
 * Created by wangshy on 17/8/2.
 */

public class PositioningStatusBean {

    private String time;
    /**
     * 时间
     */
    private String dataTime;
    /**
     * 定位状态
     */
    private String positioningStatus;
    /**
     * 纬度
     */
    private String latitude;
    /**
     * 纬度方向
     */
    private String latitudeDirection;
    /**
     * 经度
     */
    private String ongitude;
    /**
     * 经度方向
     */
    private String ongitudeDirection;
    /**
     * 视野内卫星数
     */
    private String numberOfSatellites;
    /**
     * 高度
     */
    private String height;
    /**
     * 地面速度
     */
    private String groundSpeed;
    /**
     * 地面航向
     */
    private String groundCourse;
    /**
     * 模式指示
     */
    private String modeIndication;

    public String getDataTime() {
        return dataTime;
    }

    public void setDataTime(String dataTime) {
        this.dataTime = dataTime;
    }

    public String getPositioningStatus() {
        return positioningStatus;
    }

    public void setPositioningStatus(String positioningStatus) {
        this.positioningStatus = positioningStatus;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitudeDirection() {
        return latitudeDirection;
    }

    public void setLatitudeDirection(String latitudeDirection) {
        this.latitudeDirection = latitudeDirection;
    }

    public String getOngitude() {
        return ongitude;
    }

    public void setOngitude(String ongitude) {
        this.ongitude = ongitude;
    }

    public String getOngitudeDirection() {
        return ongitudeDirection;
    }

    public void setOngitudeDirection(String ongitudeDirection) {
        this.ongitudeDirection = ongitudeDirection;
    }

    public String getNumberOfSatellites() {
        return numberOfSatellites;
    }

    public void setNumberOfSatellites(String numberOfSatellites) {
        this.numberOfSatellites = numberOfSatellites;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getGroundSpeed() {
        return groundSpeed;
    }

    public void setGroundSpeed(String groundSpeed) {
        this.groundSpeed = groundSpeed;
    }

    public String getGroundCourse() {
        return groundCourse;
    }

    public void setGroundCourse(String groundCourse) {
        this.groundCourse = groundCourse;
    }

    public String getModeIndication() {
        return modeIndication;
    }

    public void setModeIndication(String modeIndication) {
        this.modeIndication = modeIndication;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
