package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/21.
 */

public class VehicleInformationBean {

    /**
     * 终端ID
     */
    private String id;

    /**
     * vin
     */
    private String vin;

    /**
     * sim卡号
     */
    private String sim;

    /**
     * 车牌号
     */
    private String vehicleNo;

    /**
     * 发动机号
     */
    private String engineNumber;

    /**
     * 车型
     */
    private String models;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getSim() {
        return sim;
    }

    public void setSim(String sim) {
        this.sim = sim;
    }

    public String getEngineNumber() {
        return engineNumber;
    }

    public void setEngineNumber(String engineNumber) {
        this.engineNumber = engineNumber;
    }

    public String getModels() {
        return models;
    }

    public void setModels(String models) {
        this.models = models;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }
}
