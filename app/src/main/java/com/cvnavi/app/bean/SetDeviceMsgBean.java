package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/7.
 */

public class SetDeviceMsgBean extends Entity {

    /**
     * 脉冲系数
     */
    private String pulseCoefficient;

    /**
     * 累计里程
     */
    private String accumulatedileage;

    /**
     * 疲劳驾驶门限
     */
    private String fatigueDriving;

    /**
     * 超速速度阀值
     */
    private String speedingValue;

    /**
     * 报警提示方式
     */
    private String warning;

    /**
     * GNSS定位模式
     */
    private String gnssGps;

    /**
     * TTS音量调节
     */
    private String ttsVoice;

    /**
     * 休眠方式
     */
    private String sleepType;

    /**
     * 休眠等待时间
     */
    private String sleepWaitTime;

    /**
     * 休眠唤醒时间
     */
    private String sleepWakeTime;

    public String getPulseCoefficient() {
        return pulseCoefficient;
    }

    public void setPulseCoefficient(String pulseCoefficient) {
        this.pulseCoefficient = pulseCoefficient;
    }

    public String getAccumulatedileage() {
        return accumulatedileage;
    }

    public void setAccumulatedileage(String accumulatedileage) {
        this.accumulatedileage = accumulatedileage;
    }

    public String getFatigueDriving() {
        return fatigueDriving;
    }

    public void setFatigueDriving(String fatigueDriving) {
        this.fatigueDriving = fatigueDriving;
    }

    public String getSpeedingValue() {
        return speedingValue;
    }

    public void setSpeedingValue(String speedingValue) {
        this.speedingValue = speedingValue;
    }

    public String getWarning() {
        return warning;
    }

    public void setWarning(String warning) {
        this.warning = warning;
    }

    public String getGnssGps() {
        return gnssGps;
    }

    public void setGnssGps(String gnssGps) {
        this.gnssGps = gnssGps;
    }

    public String getTtsVoice() {
        return ttsVoice;
    }

    public void setTtsVoice(String ttsVoice) {
        this.ttsVoice = ttsVoice;
    }

    public String getSleepType() {
        return sleepType;
    }

    public void setSleepType(String sleepType) {
        this.sleepType = sleepType;
    }

    public String getSleepWaitTime() {
        return sleepWaitTime;
    }

    public void setSleepWaitTime(String sleepWaitTime) {
        this.sleepWaitTime = sleepWaitTime;
    }

    public String getSleepWakeTime() {
        return sleepWakeTime;
    }

    public void setSleepWakeTime(String sleepWakeTime) {
        this.sleepWakeTime = sleepWakeTime;
    }
}
