package com.cvnavi.app.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by zww on 2017/7/26.
 * 采集事故疑点实体类
 */

public class AccidentRecordBean {

    private List<AccidentRecordItem> records;

    public static class AccidentRecordItem implements Parcelable {

        /**
         * 经度
         */
        private String longitude;

        /**
         * 纬度
         */
        private String latitude;

        /**
         * 海拔
         */
        private String altitude;

        /**
         * 行驶结束时间
         */
        private String endTime;

        /**
         * 驾驶证号码
         */
        private String licenseNo;

        /**
         * 速度
         */
        private int[] speed;

        /**
         * 状态
         */
        private String[] state;

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getAltitude() {
            return altitude;
        }

        public void setAltitude(String altitude) {
            this.altitude = altitude;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public String getLicenseNo() {
            return licenseNo;
        }

        public void setLicenseNo(String licenseNo) {
            this.licenseNo = licenseNo;
        }

        public int[] getSpeed() {
            return speed;
        }

        public void setSpeed(int[] speed) {
            this.speed = speed;
        }


        public String[] getState() {
            return state;
        }

        public void setState(String[] state) {
            this.state = state;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.longitude);
            dest.writeString(this.latitude);
            dest.writeString(this.altitude);
            dest.writeString(this.endTime);
            dest.writeString(this.licenseNo);
            dest.writeIntArray(this.speed);
            dest.writeStringArray(this.state);
        }

        public AccidentRecordItem() {
        }

        protected AccidentRecordItem(Parcel in) {
            this.longitude = in.readString();
            this.latitude = in.readString();
            this.altitude = in.readString();
            this.endTime = in.readString();
            this.licenseNo = in.readString();
            this.speed = in.createIntArray();
            this.state = in.createStringArray();
        }

        public static final Parcelable.Creator<AccidentRecordItem> CREATOR = new Parcelable.Creator<AccidentRecordItem>() {
            @Override
            public AccidentRecordItem createFromParcel(Parcel source) {
                return new AccidentRecordItem(source);
            }

            @Override
            public AccidentRecordItem[] newArray(int size) {
                return new AccidentRecordItem[size];
            }
        };
    }

    public List<AccidentRecordItem> getRecords() {
        return records;
    }

    public void setRecords(List<AccidentRecordItem> records) {
        this.records = records;
    }
}
