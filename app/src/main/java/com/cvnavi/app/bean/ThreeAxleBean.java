package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/14.
 * 三轴设备
 */

public class ThreeAxleBean {

    /**
     * 角度查询X轴
     */
    private String angleX;

    /**
     * 角度查询Y轴
     */
    private String angleY;

    /**
     * 角度查询Z轴
     */
    private String angleZ;

    /**
     * 加速度值查询X
     */
    private String accelerationX;

    /**
     * 加速度值查询Y
     */
    private String accelerationY;

    /**
     * 加速度值查询Z
     */
    private String accelerationZ;

    /**
     * 设备状态
     */
    private String deviceState;

    /**
     * 陀螺仪查询X
     */
    private String gyroscopeX;

    /**
     * 陀螺仪查询Y
     */
    private String gyroscopeY;

    /**
     * 陀螺仪查询Z
     */
    private String gyroscopeZ;

    /**
     * 陀螺仪设备状态
     */
    private String gyroscopeState;

    /**
     * 按钮点击状态
     */
    private int state;

    public String getAngleX() {
        return angleX;
    }

    public void setAngleX(String angleX) {
        this.angleX = angleX;
    }

    public String getAngleY() {
        return angleY;
    }

    public void setAngleY(String angleY) {
        this.angleY = angleY;
    }

    public String getAngleZ() {
        return angleZ;
    }

    public void setAngleZ(String angleZ) {
        this.angleZ = angleZ;
    }

    public String getAccelerationX() {
        return accelerationX;
    }

    public void setAccelerationX(String accelerationX) {
        this.accelerationX = accelerationX;
    }

    public String getAccelerationY() {
        return accelerationY;
    }

    public void setAccelerationY(String accelerationY) {
        this.accelerationY = accelerationY;
    }

    public String getAccelerationZ() {
        return accelerationZ;
    }

    public void setAccelerationZ(String accelerationZ) {
        this.accelerationZ = accelerationZ;
    }

    public String getDeviceState() {
        return deviceState;
    }

    public void setDeviceState(String deviceState) {
        this.deviceState = deviceState;
    }

    public String getGyroscopeX() {
        return gyroscopeX;
    }

    public void setGyroscopeX(String gyroscopeX) {
        this.gyroscopeX = gyroscopeX;
    }

    public String getGyroscopeY() {
        return gyroscopeY;
    }

    public void setGyroscopeY(String gyroscopeY) {
        this.gyroscopeY = gyroscopeY;
    }

    public String getGyroscopeZ() {
        return gyroscopeZ;
    }

    public void setGyroscopeZ(String gyroscopeZ) {
        this.gyroscopeZ = gyroscopeZ;
    }

    public String getGyroscopeState() {
        return gyroscopeState;
    }

    public void setGyroscopeState(String gyroscopeState) {
        this.gyroscopeState = gyroscopeState;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
