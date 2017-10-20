package com.cvnavi.app.bean;


import java.util.List;

public class DrivingBehaviorBean extends Entity {


    // 驾驶行为评价
    /**
     * 本次里程
     */
    private String mileage;
    /**
     * 本次油耗
     */
    private String oilConsumption;
    /**
     * 平均油耗
     */
    private String averageOilConsumption;

    /**
     * 平均分数
     */
    private String averagescore;

    /**
     * 当前转速X轴
     */
    private String speedX;
    /**
     * 当前扭矩百分比（Y轴）
     */
    private String percent;
    /**
     * 当前分数
     */
    private String fraction;

    /**
     * 100分的百分比比例显示
     */
    private String percent100;

    /**
     * 80分的百分比比例显示
     */
    private String percent80;

    /**
     * 60分的百分比比例显示
     */
    private String percent60;

    /**
     * 20分的百分比比例显示
     */
    private String percent20;




    private List<DriveingRecordItem> records;


    public static class DriveingRecordItem extends Entity {
        /**
         * 开始时间
         */
        private String begin;

        /**
         * 结束时间
         */
        private String end;

        /**
         * 里程
         */
        private String mileage;

        /**
         * 油耗
         */
        private String oilConsumption;

        /**
         * 平均油耗
         */
        private String averageOilConsumption;

        /**
         * 平均分数
         */
        private String averagescore;

        public String getBegin() {
            return begin;
        }

        public void setBegin(String begin) {
            this.begin = begin;
        }

        public String getEnd() {
            return end;
        }

        public void setEnd(String end) {
            this.end = end;
        }

        public String getMileage() {
            return mileage;
        }

        public void setMileage(String mileage) {
            this.mileage = mileage;
        }

        public String getOilConsumption() {
            return oilConsumption;
        }

        public void setOilConsumption(String oilConsumption) {
            this.oilConsumption = oilConsumption;
        }

        public String getAverageOilConsumption() {
            return averageOilConsumption;
        }

        public void setAverageOilConsumption(String averageOilConsumption) {
            this.averageOilConsumption = averageOilConsumption;
        }

        public String getAveragescore() {
            return averagescore;
        }

        public void setAveragescore(String averagescore) {
            this.averagescore = averagescore;
        }
    }


    /**
     * X轴油耗刻度个数
     */
    private String xAmount;

    /**
     * 轴油耗刻度个数
     */
    private String yAmount;

    /**
     * X轴刻度值
     */
    private String xScale;

    /**
     * Y轴刻度值
     */
    private String yScale;

    /**
     * 坐标矩阵分值
     */
    private String coordinate;

    /**
     * 总时长
     */
    private String allTime;

    /**
     * 总里程
     */
    private String allMile;

    /**
     * 总油耗
     */
    private String allOilConsumption;

    /**
     * 平均油耗
     */
    private String averageOilConsumption2;

    /**
     * 平均分数
     */
    private String averagescore03;




    public String getMileage() {
        return mileage;
    }

    public void setMileage(String mileage) {
        this.mileage = mileage;
    }

    public String getOilConsumption() {
        return oilConsumption;
    }

    public void setOilConsumption(String oilConsumption) {
        this.oilConsumption = oilConsumption;
    }

    public String getAverageOilConsumption() {
        return averageOilConsumption;
    }

    public void setAverageOilConsumption(String averageOilConsumption) {
        this.averageOilConsumption = averageOilConsumption;
    }

    public String getAveragescore() {
        return averagescore;
    }

    public void setAveragescore(String averagescore) {
        this.averagescore = averagescore;
    }

    public String getSpeedX() {
        return speedX;
    }

    public void setSpeedX(String speedX) {
        this.speedX = speedX;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getFraction() {
        return fraction;
    }

    public void setFraction(String fraction) {
        this.fraction = fraction;
    }

    public String getPercent100() {
        return percent100;
    }

    public void setPercent100(String percent100) {
        this.percent100 = percent100;
    }

    public String getPercent80() {
        return percent80;
    }

    public void setPercent80(String percent80) {
        this.percent80 = percent80;
    }

    public String getPercent60() {
        return percent60;
    }

    public void setPercent60(String percent60) {
        this.percent60 = percent60;
    }

    public String getPercent20() {
        return percent20;
    }

    public void setPercent20(String percent20) {
        this.percent20 = percent20;
    }

    public List<DriveingRecordItem> getRecords() {
        return records;
    }

    public void setRecords(List<DriveingRecordItem> records) {
        this.records = records;
    }

    public String getxAmount() {
        return xAmount;
    }

    public void setxAmount(String xAmount) {
        this.xAmount = xAmount;
    }

    public String getyAmount() {
        return yAmount;
    }

    public void setyAmount(String yAmount) {
        this.yAmount = yAmount;
    }

    public String getxScale() {
        return xScale;
    }

    public void setxScale(String xScale) {
        this.xScale = xScale;
    }

    public String getyScale() {
        return yScale;
    }

    public void setyScale(String yScale) {
        this.yScale = yScale;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getAllTime() {
        return allTime;
    }

    public void setAllTime(String allTime) {
        this.allTime = allTime;
    }

    public String getAllMile() {
        return allMile;
    }

    public void setAllMile(String allMile) {
        this.allMile = allMile;
    }

    public String getAllOilConsumption() {
        return allOilConsumption;
    }

    public void setAllOilConsumption(String allOilConsumption) {
        this.allOilConsumption = allOilConsumption;
    }

    public String getAverageOilConsumption2() {
        return averageOilConsumption2;
    }

    public void setAverageOilConsumption2(String averageOilConsumption2) {
        this.averageOilConsumption2 = averageOilConsumption2;
    }

    public String getAveragescore03() {
        return averagescore03;
    }

    public void setAveragescore03(String averagescore03) {
        this.averagescore03 = averagescore03;
    }
}
