package com.cvnavi.app.bean;

import java.util.List;

/**
 * Created by zww on 2017/10/16.
 * 胎压
 */

public class TirePressureBean {

    /**
     * 车型
     */
    private int type;

    private List<PressureBeanItem> records;

    /**
     *
     */
    public static class PressureBeanItem {

        /**
         * 车轴位置
         */
        private String axlePosition;

        /**
         * 轮胎位置
         */
        private String tirePosition;

        /**
         * 轮胎压力
         */
        private String tirePressure;

        /**
         * 轮胎温度
         */
        private String tireTemperature;

        /**
         * 传感器状态
         */
        private String sensorState;

        /**
         * 漏气状态
         */
        private String leakState;

        /**
         * 高温警告
         */
        private String temperatureWarn;

        /**
         * 传感器信号接受状态
         */
        private String signalState;

        /**
         * 流水号
         */
        private String no;

        /**
         * 压力阀检测
         */
        private String pressureTest;


        public String getAxlePosition() {
            return axlePosition;
        }

        public void setAxlePosition(String axlePosition) {
            this.axlePosition = axlePosition;
        }

        public String getTirePosition() {
            return tirePosition;
        }

        public void setTirePosition(String tirePosition) {
            this.tirePosition = tirePosition;
        }

        public String getTirePressure() {
            return tirePressure;
        }

        public void setTirePressure(String tirePressure) {
            this.tirePressure = tirePressure;
        }

        public String getTireTemperature() {
            return tireTemperature;
        }

        public void setTireTemperature(String tireTemperature) {
            this.tireTemperature = tireTemperature;
        }

        public String getSensorState() {
            return sensorState;
        }

        public void setSensorState(String sensorState) {
            this.sensorState = sensorState;
        }

        public String getLeakState() {
            return leakState;
        }

        public void setLeakState(String leakState) {
            this.leakState = leakState;
        }

        public String getTemperatureWarn() {
            return temperatureWarn;
        }

        public void setTemperatureWarn(String temperatureWarn) {
            this.temperatureWarn = temperatureWarn;
        }

        public String getSignalState() {
            return signalState;
        }

        public void setSignalState(String signalState) {
            this.signalState = signalState;
        }

        public String getNo() {
            return no;
        }

        public void setNo(String no) {
            this.no = no;
        }

        public String getPressureTest() {
            return pressureTest;
        }

        public void setPressureTest(String pressureTest) {
            this.pressureTest = pressureTest;
        }
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<PressureBeanItem> getRecords() {
        return records;
    }

    public void setRecords(List<PressureBeanItem> records) {
        this.records = records;
    }
}
