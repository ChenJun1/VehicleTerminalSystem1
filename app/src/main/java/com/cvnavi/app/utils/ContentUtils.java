package com.cvnavi.app.utils;

import com.apkfuns.logutils.LogUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by wangshy on 17/7/7.
 */

public class ContentUtils {


    /**
     * 获取异或值
     *
     * @param bytes
     * @return
     */
    public static byte getByte(byte[] bytes) {
        byte result = 0;
        for (byte bt : bytes) {
            result ^= bt;
        }
        return result;
    }

    /**
     * 校验字节
     *
     * @param bytes
     * @param txt
     * @return
     */
    public static boolean getByte(byte[] bytes, byte txt) {
        byte result = 0;
        for (int i = 0; i < bytes.length - 1; i++) {
            result ^= bytes[i];
        }
        return result == txt;
    }

    /**
     * 根据日期 找到对应日期的 星期几
     *
     * @param date “yyyy-mm-dd”
     * @return
     */
    public static String getDayOfWeekByDate(String date) {
        String dayOfweek = "-1";
        try {
            SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd");
            Date myDate = myFormatter.parse(date);
            SimpleDateFormat formatter = new SimpleDateFormat("E");
            String str = formatter.format(myDate);
            switch (str) {
                case ("周一"):
                    dayOfweek = "星期一";
                    break;
                case ("周二"):
                    dayOfweek = "星期二";
                    break;
                case ("周三"):
                    dayOfweek = "星期三";
                    break;
                case ("周四"):
                    dayOfweek = "星期四";
                    break;
                case ("周五"):
                    dayOfweek = "星期五";
                    break;
                case ("周六"):
                    dayOfweek = "星期六";
                    break;
                case ("周日"):
                    dayOfweek = "星期日";
                    break;
            }

        } catch (Exception e) {
            LogUtils.e("方法getDayOfWeekByDate（）日期错误");
        }
        return dayOfweek;
    }

    /**
     * 请求时间转为byte
     *
     * @param data 时间
     * @return
     */
    public static byte getByte(int data) {
        byte mbyte = 0x00;
        if (data < 1) {
            return mbyte;
        }
        if (data > 2000)
            data = data - 2000;
        if (data > 1000) {
            data = data - 1000;
        }

        mbyte = (byte) data;
        return mbyte;
    }

    /**
     * 判断开始时间和结束时间大小
     *
     * @param startYear
     * @param startMonthOfYear
     * @param startDayOfMonth
     * @param endYear
     * @param endMonthOfYear
     * @param endDayOfMonth
     * @return
     */
    public static boolean isComparison(int startYear, int startMonthOfYear,
                                       int startDayOfMonth,
                                       int endYear, int endMonthOfYear,
                                       int endDayOfMonth) {

        if (startYear > endYear || startMonthOfYear > endMonthOfYear || startDayOfMonth > endDayOfMonth)
            return false;
        else
            return true;
    }

    /**
     * Date  装换int[]
     *
     * @param cal
     * @return
     */
    public static int[] getDateTimeArry(Calendar cal) {
        if (null == cal)
            return null;
        int[] ints = new int[6];
        if (cal.get(Calendar.YEAR) > 0) {
            ints[0] = cal.get(Calendar.YEAR);
        }
        if (cal.get(Calendar.MONTH) > 0) {
            ints[1] = cal.get(Calendar.MONTH) + 1;
        }
        if (cal.get(Calendar.DATE) > 0) {
            ints[2] = cal.get(Calendar.DATE);
        }
        if (cal.get(Calendar.HOUR_OF_DAY) > 0) {
            ints[3] = cal.get(Calendar.HOUR_OF_DAY);
        }
        if (cal.get(Calendar.MINUTE) > 0) {
            ints[4] = cal.get(Calendar.MINUTE);
        }
        if (cal.get(Calendar.SECOND) > 0) {
            ints[5] = cal.get(Calendar.SECOND);
        }
        return ints;
    }


    /**
     * 十进制转BCD
     *
     * @param temp
     * @return
     */
    public static int DectoBCD(int temp) {
        if (temp > 2000) {
            temp = temp - 2000;
        }
        if (temp > 1000) {
            temp = temp - 1000;
        }
        return ((temp / 10) << 4 | temp % 10);
    }

    /**
     * TextView  换行过滤
     *
     * @param timeString
     * @return
     */
    public static String resetTimeString(String timeString) {
        if (timeString.length() >7 && timeString.contains("时")) {
            int indexOf = timeString.indexOf("时");
            StringBuffer stringBuffer = new StringBuffer(timeString);
            return stringBuffer.insert(indexOf + 1, "\n").toString();
        }
        return timeString;
    }

    /**
     * 两个int[] 结合成一个
     *
     * @param a
     * @param b
     * @return
     */
    public static int[] contact(int a[], int b[]) {
        if (null == a || b == null)
            return null;
        int[] f = new int[a.length + b.length];
        for (int i = 0; i < f.length; i++)
            if (i < a.length)
                f[i] = a[i];
            else
                f[i] = b[i - a.length];
        return f;
    }

}
