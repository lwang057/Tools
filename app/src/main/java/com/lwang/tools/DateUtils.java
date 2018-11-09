package com.lwang.tools;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by lwang on 2017/7/11.
 */

public class DateUtils {

    /**
     * 获取现在时间
     *
     * @return时间格式 yyyy-MM-dd
     */
    public static String getStrTimeYMD() {
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long l = Long.valueOf(getTime());
        timeString = sdf.format(new Date(l * 1000l));//单位秒
        return timeString;
    }

    public static String getTime() {
        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳
        return String.valueOf(time + 90 * 24 * 60 * 60);
    }

    /**
     * 获取现在时间
     *
     * @return时间格式 yyyy-MM-dd
     */
    public static String getSysYMD() {
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        timeString = sdf.format(new Date(System.currentTimeMillis() / 1000 * 1000l));//单位秒
        return timeString;
    }

    /**
     * 获取现在时间
     *
     * @return时间格式 yyyy-MM-dd
     */
    public static String getStrTimeYMDHundred() {
        String timeString = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        long l = Long.valueOf(getTimeHundred());
        timeString = sdf.format(new Date(l * 1000l));//单位秒
        return timeString;
    }

    public static String getTimeHundred() {
        long time = System.currentTimeMillis() / 1000;//获取系统时间的10位的时间戳
        return String.valueOf(time + 365 * 24 * 60 * 60 * 100);
    }

    public static String getEndTime() {
        Calendar calendar = Calendar.getInstance();
        Date date = new Date(System.currentTimeMillis());
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, 99);
        date = calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.format(date);
    }

    public static String getDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentTime = new Date();
        return dateFormat.format(currentTime);
    }

    public static Date stringToDate(String dateString) {
        ParsePosition position = new ParsePosition(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateValue = simpleDateFormat.parse(dateString, position);
        return dateValue;
    }

    public static Date stringToDateMinute(String dateString) {
        ParsePosition position = new ParsePosition(0);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateValue = simpleDateFormat.parse(dateString, position);
        return dateValue;
    }

    public static String getCurrentTime() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentTime = new Date();
        return simpleDateFormat.format(currentTime);
    }

}
