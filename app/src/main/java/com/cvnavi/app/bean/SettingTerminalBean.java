package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/22.
 */

public class SettingTerminalBean {

    /**
     * 终端机型号
     */
    private String terminalModel;

    /**
     * 制造商id
     */
    private String manufacturerId;

    /**
     *终端id
     */
    private String terminalId;

    /**
     * 车牌号码
     */
    private String vehicleNo;

    /**
     * 车牌颜色
     */
    private int vehicleColor;

    /**
     * vin
     */
    private String vin;

    /**
     * 省域id
     */
    private String provinceId;

    /**
     * 市县域id
     */
    private String cityId;

    /**
     * 终端手机号
     */
    private String terminalPhone;

    /**
     * 车主手机号
     */
    private String ownerPhone;

    /**
     * 车主姓名
     */
    private String ownerName;

    public String getTerminalModel() {
        return terminalModel;
    }

    public void setTerminalModel(String terminalModel) {
        this.terminalModel = terminalModel;
    }

    public String getManufacturerId() {
        return manufacturerId;
    }

    public void setManufacturerId(String manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public String getTerminalId() {
        return terminalId;
    }

    public void setTerminalId(String terminalId) {
        this.terminalId = terminalId;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }



    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public int getVehicleColor() {
        return vehicleColor;
    }

    public void setVehicleColor(int vehicleColor) {
        this.vehicleColor = vehicleColor;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getTerminalPhone() {
        return terminalPhone;
    }

    public void setTerminalPhone(String terminalPhone) {
        this.terminalPhone = terminalPhone;
    }

    public String getOwnerPhone() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone = ownerPhone;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }
}
