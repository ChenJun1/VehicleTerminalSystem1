package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/1.
 */

public class DeviceMsgBean extends Entity {

    /**
     * 固件版本
     */
    private String firmwareVersion;

    /**
     * 硬件版本
     */
    private String hardwareVersion;

    /**
     * 通讯模块类型
     */
    private String comType;

    /**
     * 通讯模块版本
     */
    private String comVersion;

    /**
     * 定位模块类型
     */
    private String locType;

    /**
     * 定位模块版本
     */
    private String locVersion;

    /**
     * 产品生产流水号
     */
    private String serialNumber;

    /**
     * 产品型号
     */
    private String type;

    /**
     * 生产日期
     */
    private String manufactureDate;

    /**
     * CCC认证码
     */
    private String code;

    public String getFirmwareVersion() {
        return firmwareVersion;
    }

    public void setFirmwareVersion(String firmwareVersion) {
        this.firmwareVersion = firmwareVersion;
    }

    public String getHardwareVersion() {
        return hardwareVersion;
    }

    public void setHardwareVersion(String hardwareVersion) {
        this.hardwareVersion = hardwareVersion;
    }

    public String getComType() {
        return comType;
    }

    public void setComType(String comType) {
        this.comType = comType;
    }

    public String getComVersion() {
        return comVersion;
    }

    public void setComVersion(String comVersion) {
        this.comVersion = comVersion;
    }

    public String getLocType() {
        return locType;
    }

    public void setLocType(String locType) {
        this.locType = locType;
    }

    public String getLocVersion() {
        return locVersion;
    }

    public void setLocVersion(String locVersion) {
        this.locVersion = locVersion;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
