package com.cvnavi.app.bean;

/**
 * Created by zww on 2017/8/14.
 * 初始化项
 */

public class InitializationBean {

    /**
     * 开关量初始化
     */
    private int switchInitial;

    /**
     * 手动报警解除
     */
    private int warn;

    /**
     * 终端复位
     */
    private int terminal;

    /**
     * 恢复出厂设置
     */
    private int restoreFactory;

    /**
     * 清空C1鉴权
     */
    private int clearC1;

    /**
     * 清空C2鉴权
     */
    private int clearC2;

    /**
     * 设置中心优先级
     */
    private int setPriority;

    public int getSwitchInitial() {
        return switchInitial;
    }

    public void setSwitchInitial(int switchInitial) {
        this.switchInitial = switchInitial;
    }

    public int getWarn() {
        return warn;
    }

    public void setWarn(int warn) {
        this.warn = warn;
    }

    public int getTerminal() {
        return terminal;
    }

    public void setTerminal(int terminal) {
        this.terminal = terminal;
    }

    public int getRestoreFactory() {
        return restoreFactory;
    }

    public void setRestoreFactory(int restoreFactory) {
        this.restoreFactory = restoreFactory;
    }

    public int getClearC1() {
        return clearC1;
    }

    public void setClearC1(int clearC1) {
        this.clearC1 = clearC1;
    }

    public int getClearC2() {
        return clearC2;
    }

    public void setClearC2(int clearC2) {
        this.clearC2 = clearC2;
    }

    public int getSetPriority() {
        return setPriority;
    }

    public void setSetPriority(int setPriority) {
        this.setPriority = setPriority;
    }
}
