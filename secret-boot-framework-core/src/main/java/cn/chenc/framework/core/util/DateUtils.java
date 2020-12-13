package cn.chenc.framework.core.util;

import org.springframework.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class DateUtils {
    public static final String YYYYMMDDHHMMSS = "yyyy-MM-dd HH:mm:ss";
    public static final String YYYYMMDD = "yyyy-MM-dd";
    public static final String YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";
    public static final String YYYYMM = "yyyy-MM";

    public DateUtils() {
    }

    /**
     * @description: 获取当前日期字符串
     * @param var1 日期格式(例如："yyyy-MM-dd HH:mm:ss")
     * @return java.lang.String
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static String getCurrentDate(String var1) {
        return (new SimpleDateFormat(var1)).format(new Date());
    }

    /**
     * @description: 将日期字符串转化为Date对象
     * @param date 日期字符串
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date parse(String date) {
        if (StringUtils.isEmpty(date)) {
            return null;
        } else {
            try {
                return (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).parse(date);
            } catch (ParseException var2) {
                return null;
            }
        }
    }

    /**
     * @description: 将日期字符串按自定义格式化转化为Date对象
     * @param date 日期字符串
     * @param format 格式化字符串(例如:"yyyy-MM-dd HH:mm:ss")
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date parse(String date, String format) {
        if (StringUtils.isEmpty(date)) {
            return null;
        } else {
            try {
                return (new SimpleDateFormat(format)).parse(date);
            } catch (ParseException var3) {
                return null;
            }
        }
    }

    /**
     * @description: 将日期字符串格式化为"yyyy-MM-dd"的Date对象
     * @param date
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date parseToYMD(String date) {
        try {
            return (new SimpleDateFormat("yyyy-MM-dd")).parse(date);
        } catch (ParseException var2) {
            return null;
        }
    }

    /**
     * @description: Date对象格式化为"yyyy-MM-dd HH:mm:ss"的字符串
     * @param date
     * @return java.lang.String
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static String format(Date date) {
        return date != null ? (new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")).format(date) : "/";
    }

    /**
     * 将Date对象按自定义格式化为字符串
     * @param date
     * @param format
     * @return
     */
    public static String format(Date date, String format) {
        return (new SimpleDateFormat(format)).format(date);
    }

    /**
     * @description: 将Date对象增加年份
     * @param date
     * @param year
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date addYear(Date date, int year) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(1, year);
        date = calendar.getTime();
        return date;
    }

    /**
     * @description: 将Date对象增加月份
     * @param date
     * @param month
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date addMonth(Date date, int month) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(2, month);
        date = calendar.getTime();
        return date;
    }

    /**
     * @description: 将Date对象增加天数
     * @param date
     * @param day
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date addDay(Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(5, day);
        date = calendar.getTime();
        return date;
    }

    /**
     * @description: 将Date对象增加小时
     * @param date
     * @param day
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date addHour(Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(10, day);
        date = calendar.getTime();
        return date;
    }

    /**
     * @description: 将Date对象增加分钟
     * @param date
     * @param day
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date addMinute(Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(12, day);
        date = calendar.getTime();
        return date;
    }

    /**
     * @description: 将Date对象增加周数
     * @param date
     * @param day
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date addWeek(Date date, int day) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(3, day);
        date = calendar.getTime();
        return date;
    }

    /**
     * @description: 获取当前毫秒时间
     * @param
     * @return java.lang.Long
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Long getTimestamp() {
        return System.currentTimeMillis();
    }

    /**
     * @description: 获取本周开始时间和结束时间
     * @param addEndDay 是否添加最后一天
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Map<String, String> getCurrentWeek(boolean addEndDay) {
        Map<String, String> map = new HashMap(2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(2);
        int dayWeek = cal.get(7);
        if (dayWeek == 1) {
            dayWeek = 8;
        }

        cal.add(5, cal.getFirstDayOfWeek() - dayWeek);
        Date mondayDate = cal.getTime();
        String weekBegin = sdf.format(mondayDate);
        map.put("beginWeek", weekBegin);
        cal.add(5, 4 + cal.getFirstDayOfWeek());
        if (addEndDay) {
            cal.add(5, 1);
        }

        Date sundayDate = cal.getTime();
        String weekEnd = sdf.format(addDay(sundayDate, -1)) + " 23:59:59";
        map.put("endWeek", weekEnd);
        return map;
    }

    /**
     * @description: 获取本月开始时间和结束时间
     * @param addEndDay 是否添加最后一天
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Map<String, String> getCurrentMonth(boolean addEndDay) {
        Map<String, String> map = new HashMap(2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        map.put("beginMonth", format(new Date(), "yyyy-MM") + "-01");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.set(5, calendar.getActualMaximum(5));
        if (addEndDay) {
            calendar.add(5, 1);
        }

        map.put("endMonth", sdf.format(calendar.getTime()));
        return map;
    }

    /**
     * @description: 获取任意时间当月的开始时间和结束时间
     * @param addEndDay 是否添加最后一天
     * @return java.util.Map<java.lang.String, java.lang.String>
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Map<String, String> getAppointMonth(Date date, boolean addEndDay) {
        Map<String, String> map = new HashMap(2);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        map.put("beginMonth", format(date, "yyyy-MM") + "-01");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.set(5, calendar.getActualMaximum(5));
        if (addEndDay) {
            calendar.add(5, 1);
        }

        map.put("endMonth", sdf.format(calendar.getTime()));
        return map;
    }

    /**
     * @description: 将秒转化为时间字符串
     * @param second
     * @return java.lang.String
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static String secondToTime(long second) {
        long days = second / 86400L;
        second %= 86400L;
        long hours = second / 3600L;
        second %= 3600L;
        long minutes = second / 60L;
        second %= 60L;
        return 0L < days ? days + "天" + hours + "小时" + minutes + "分" + second + "秒" : hours + "小时" + minutes + "分" + second + "秒";
    }

    /**
     * @description: 获得日期的年份
     * @param date
     * @return int
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static int getYear(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY");
        return Integer.valueOf(sdf.format(date));
    }

    /**
     * @description: 获取某年的第一天
     * @param year 年份
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date getYearFirst(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, year);
        Date currYearFirst = calendar.getTime();
        return currYearFirst;
    }

    /**
     * @description: 获取某年最后一天
     * @param year
     * @return java.util.Date
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static Date getYearLast(int year) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(1, year);
        calendar.roll(6, -1);
        Date currYearLast = calendar.getTime();
        return currYearLast;
    }

    /**
     * @description: 将Date对象转化为LocalDateTime对象
     * @param date
     * @return java.time.LocalDateTime
     * @throws
     * @author secret
     * @date 2020/12/12 secret
     */
    public static LocalDateTime dateToLocalDateTime(Date date){
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = instant.atZone(zoneId).toLocalDateTime();
        return localDateTime;
    }
}
