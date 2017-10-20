package com.cvnavi.app.utils;

import android.text.TextUtils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by zww on 2017/7/14.
 */
public class DateUtils {
    public final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    public final static SimpleDateFormat tdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public final static DateFormat dateFormat_1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private static String date; //保存系统日期
    private static String time; //保存系统时间


    public static String getDate() {
        return date;
    }

    public static void setDate(String date) {
        DateUtils.date = date;
    }

    public static String getTime() {
        return time;
    }

    public static void setTime(String time) {
        DateUtils.time  = time;
    }

    public static String getDataTime() {
        if(TextUtils.isEmpty(getDate())||TextUtils.isEmpty(getTime()))
            return null;
        return getDate() + " " + getTime();
    }


    public static String getDateStringByLong(long millis) {
        Date date = new Date(millis);
        return sdf.format(date);
    }

    public static String getTimeStringByLong(long millis) {
        Date date = new Date(millis);
        return tdf.format(date);
    }

    public static Date getDateByString(String dateStr) {
        if (dateStr == null)
            return null;

        try {
            return sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static long getLongByStrDate(String dateStr) {
        if (dateStr == null)
            return -1;

        try {
            return sdf.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public static long getLongByStrTime(String dateStr) {
        if (dateStr == null)
            return -1;

        try {
            return tdf.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }

    /**
     * 字符串 转Date
     *
     * @param dateTime   时间
     * @param dateFormat 类型
     * @return
     */
    public static Date strToData(String dateTime, DateFormat dateFormat) {
        if (TextUtils.isEmpty(dateTime))
            return null;
        try {
            return dateFormat.parse(dateTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Date 转Calendar 可取时间差
     *
     * @param dateTime 时间
     * @param field    时间类型 Calendar的常量
     * @param amout    时间差值
     * @return
     */
    public static Calendar dateToCalendar(Date dateTime, int field, int amout) {
        if (null == dateTime)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        cal.add(field, amout);
        return cal;
    }

    /**
     * Date 转Calendar
     *
     * @param dateTime 时间
     * @return
     */
    public static Calendar dateToCalendar(Date dateTime) {
        if (null == dateTime)
            return null;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dateTime);
        return cal;
    }
}
