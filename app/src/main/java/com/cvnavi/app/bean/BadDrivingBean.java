package com.cvnavi.app.bean;

import java.util.List;

/**
 * Created by zww on 2017/8/22.
 */

public class BadDrivingBean {


    private List<BadDrivingItem> records;

    public static class BadDrivingItem {

        /**
         * 驾驶证号码
         */
        private String licenseNo;

        /**
         * 开始时间
         */
        private String beginTime;

        /**
         * 结束时间
         */
        private String endTime;

        /**
         * 超转次数
         */
        private String turnOverNumber;

        /**
         * 超速次数
         */
        private String speedingNumber;

        /**
         * 备用1
         */
        private String spare1;

        /**
         * 备用2
         */
        private String spare2;

        public String getLicenseNo() {
            return licenseNo;
        }

        public void setLicenseNo(String licenseNo) {
            this.licenseNo = licenseNo;
        }

        public String getBeginTime() {
            return beginTime;
        }

        public void setBeginTime(String beginTime) {
            this.beginTime = beginTime;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getTurnOverNumber() {
            return turnOverNumber;
        }

        public void setTurnOverNumber(String turnOverNumber) {
            this.turnOverNumber = turnOverNumber;
        }

        public String getSpeedingNumber() {
            return speedingNumber;
        }

        public void setSpeedingNumber(String speedingNumber) {
            this.speedingNumber = speedingNumber;
        }

        public String getSpare1() {
            return spare1;
        }

        public void setSpare1(String spare1) {
            this.spare1 = spare1;
        }

        public String getSpare2() {
            return spare2;
        }

        public void setSpare2(String spare2) {
            this.spare2 = spare2;
        }
    }

    public List<BadDrivingItem> getRecords() {
        return records;
    }

    public void setRecords(List<BadDrivingItem> records) {
        this.records = records;
    }
}
