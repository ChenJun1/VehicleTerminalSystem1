package com.cvnavi.app.bean;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by zww on 2017/7/26.
 * 疲劳驾驶数据信息实体类
 */

public class FatigueDrivingBean implements Parcelable {

    private List<FatigueDrivingItem> records;


    public static class FatigueDrivingItem implements Parcelable {

        /**
         * 驾驶证号码
         */
        private String licenseNo;

        /**
         * 连续驾驶开始时间
         */
        private String beginTime;

        /**
         * 连续驾驶结束时间
         */
        private String endTime;


        /**
         * 连续驾驶开始时间经度
         */
        private String beginLongitude;

        /**
         * 连续驾驶开始时间纬度
         */
        private String beginLatitude;

        /**
         * 连续驾驶开始时间海拔
         */
        private String beginAltitude;

        /**
         * 连续驾驶结束时间经度
         */
        private String endLongitude;

        /**
         * 连续驾驶结束时间纬度
         */
        private String endLatitude;

        /**
         * 连续驾驶结束时间海拔
         */
        private String endAltitude;


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

        public String getBeginLongitude() {
            return beginLongitude;
        }

        public void setBeginLongitude(String beginLongitude) {
            this.beginLongitude = beginLongitude;
        }

        public String getBeginLatitude() {
            return beginLatitude;
        }

        public void setBeginLatitude(String beginLatitude) {
            this.beginLatitude = beginLatitude;
        }

        public String getBeginAltitude() {
            return beginAltitude;
        }

        public void setBeginAltitude(String beginAltitude) {
            this.beginAltitude = beginAltitude;
        }

        public String getEndLongitude() {
            return endLongitude;
        }

        public void setEndLongitude(String endLongitude) {
            this.endLongitude = endLongitude;
        }

        public String getEndLatitude() {
            return endLatitude;
        }

        public void setEndLatitude(String endLatitude) {
            this.endLatitude = endLatitude;
        }

        public String getEndAltitude() {
            return endAltitude;
        }

        public void setEndAltitude(String endAltitude) {
            this.endAltitude = endAltitude;
        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.licenseNo);
            dest.writeString(this.beginTime);
            dest.writeString(this.endTime);
            dest.writeString(this.beginLongitude);
            dest.writeString(this.beginLatitude);
            dest.writeString(this.beginAltitude);
            dest.writeString(this.endLongitude);
            dest.writeString(this.endLatitude);
            dest.writeString(this.endAltitude);
        }

        public FatigueDrivingItem() {
        }

        protected FatigueDrivingItem(Parcel in) {
            this.licenseNo = in.readString();
            this.beginTime = in.readString();
            this.endTime = in.readString();
            this.beginLongitude = in.readString();
            this.beginLatitude = in.readString();
            this.beginAltitude = in.readString();
            this.endLongitude = in.readString();
            this.endLatitude = in.readString();
            this.endAltitude = in.readString();
        }

        public static final Parcelable.Creator<FatigueDrivingItem> CREATOR = new Parcelable.Creator<FatigueDrivingItem>() {
            @Override
            public FatigueDrivingItem createFromParcel(Parcel source) {
                return new FatigueDrivingItem(source);
            }

            @Override
            public FatigueDrivingItem[] newArray(int size) {
                return new FatigueDrivingItem[size];
            }
        };
    }

    public List<FatigueDrivingItem> getRecords() {
        return records;
    }

    public void setRecords(List<FatigueDrivingItem> records) {
        this.records = records;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(this.records);
    }

    public FatigueDrivingBean() {
    }

    protected FatigueDrivingBean(Parcel in) {
        this.records = in.createTypedArrayList(FatigueDrivingItem.CREATOR);
    }

    public static final Parcelable.Creator<FatigueDrivingBean> CREATOR = new Parcelable.Creator<FatigueDrivingBean>() {
        @Override
        public FatigueDrivingBean createFromParcel(Parcel source) {
            return new FatigueDrivingBean(source);
        }

        @Override
        public FatigueDrivingBean[] newArray(int size) {
            return new FatigueDrivingBean[size];
        }
    };
}
