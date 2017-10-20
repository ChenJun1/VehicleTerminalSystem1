package com.cvnavi.app.bean;

/**
 * 版权所有 上海势航网络科技
 * Created:  June Chen
 * CreatedTime:  2017/9/8 14:18
 * version:
 * Depict: 渣土车电子运营证页面
 */

public class OperatingLicenseBean {
    private String beginHour; // 开始小时
    private String beginMinute; //开始分钟
    private String day;         //当日 or 次日
    private String endHour;     //  结束小时
    private String endMinute;   //  结束分钟
    private String beginDataTime; // 有效日期  开始日
    private String endDataTime;   // 有效日期  结束日
    private String engineeringName;  //工程名
    private String numberPlate;      //公司车号

    public String getBeginHour() {
        return beginHour;
    }

    public void setBeginHour(String beginHour) {
        this.beginHour = beginHour;
    }

    public String getBeginMinute() {
        return beginMinute;
    }

    public void setBeginMinute(String beginMinute) {
        this.beginMinute = beginMinute;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getEndHour() {
        return endHour;
    }

    public void setEndHour(String endHour) {
        this.endHour = endHour;
    }

    public String getEndMinute() {
        return endMinute;
    }

    public void setEndMinute(String endMinute) {
        this.endMinute = endMinute;
    }

    public String getBeginDataTime() {
        return beginDataTime;
    }

    public void setBeginDataTime(String beginDataTime) {
        this.beginDataTime = beginDataTime;
    }

    public String getEndDataTime() {
        return endDataTime;
    }

    public void setEndDataTime(String endDataTime) {
        this.endDataTime = endDataTime;
    }

    public String getEngineeringName() {
        return engineeringName;
    }

    public void setEngineeringName(String engineeringName) {
        this.engineeringName = engineeringName;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    public void setNumberPlate(String numberPlate) {
        this.numberPlate = numberPlate;
    }
}
