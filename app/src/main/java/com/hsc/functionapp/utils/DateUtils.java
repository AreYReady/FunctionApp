package com.hsc.functionapp.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * Created by wangyali on 2017/6/7.
 */

public class DateUtils {
    //后期需要到别的模式再加
    public static final String FORMAT_YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";//年月日时分秒
    public static final String FORMAT_YYYYMMDDHHMMSS = "yyyyMMddHHmmss";//年月日时分秒
    public static final String FORMAT_YYYYMMDDHHMM = "yyyy-MM-dd HH:mm";//年月日时分
    public static final String FORMAT_MMDDHHMM = "MM-dd HH:mm";//月日时分
    public static final String FORMAT_YYYYMMDD = "yyyy-MM-dd";//年月日
    public static final String FORMAT_YYYYMM = "yyyy-MM";//年月
    public static final String FORMAT_YYYY = "yyyy";//年
    public static final String YEAR_MONTH_DAY_HOUR_MINUTE_MILL = "yyyy年MM月dd日 HH时mm分ss秒";
    public static final String YEAR_MONTH_DAY = "yyyy年MM月dd日";//年月日
    public static final String MONTH_DAY = "MM月dd日";//月日
    public static final String YEAR_MONTH = "yyyy年MM月";//年月
    public static final String YEAR = "yyyy年";//年
    public static final String FORMAT_YYYYMMDD_= "yyyy/MM/dd";
    public static final String FORMAT_MMDD_= "MM/dd";//月日

    /**
     * 通过传入时间获取固定的时间格式  yyyy-MM-dd HH:mm:ss
     * @param t
     * @return
     */
    public static String getFormatYyyymmddhhmmss(String t){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYY_MM_DD_HH_MM_SS);
        Date date = new Date(Long.parseLong(t) * 1000);
        return simpleDateFormat.format(date);
    }

    /**
     * 通过传入时间获取固定的时间格式  MM-dd HH:mm
     * @param t
     * @return
     */
    public static String getFormatMmddhhmm(String t){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_MMDDHHMM);
        Date date = new Date(Long.parseLong(t) * 1000);
        return simpleDateFormat.format(date);
    }

    /**
     * 通过传入时间获取固定的时间格式 yyyy-MM-dd yyyy年MM月dd日 HH时mm分ss秒
     * @param t
     * @return
     */
    public static String getFormatYyyymmdd(String t){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYYMMDD);
        Date date = new Date(Long.parseLong(t) * 1000);
        return simpleDateFormat.format(date);
    }

    /**
     * 通过传入时间获取固定的时间格式 yyyy年MM月dd日 HH时mm分ss秒
     * @param t
     * @return
     */
    public static String getYearMonthDayHourMinuteMill(String t){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEAR_MONTH_DAY_HOUR_MINUTE_MILL);
        Date date = new Date(Long.parseLong(t) * 1000);
        return simpleDateFormat.format(date);
    }
    /**
     * 通过传入时间获取固定的时间格式 yyyy年MM月dd日
     * @param t
     * @return
     */
    public static String getYearMonthDay(String t){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(YEAR_MONTH_DAY);
        Date date = new Date(Long.parseLong(t) * 1000);
        return simpleDateFormat.format(date);
    }

    /**
     * 通过传入时间获取固定的时间格式  yyyy/MM/dd
     * @param t
     * @return
     */
    public static String getFormatYyyymmdd_(String t){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(FORMAT_YYYYMMDD_);
        Date date = new Date(Long.parseLong(t) * 1000);
        return simpleDateFormat.format(date);
    }
    /**
     * 通过传时间戳 和时间格式获取时间
     * @param t
     * @param format  时间格式
     * @return
     */
    public static String getFormat(String t, String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date(Long.parseLong(t) * 1000);
        return simpleDateFormat.format(date);
    }
    public static long getFormatStringToLong(String open_time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        try {
            return sdf.parse(open_time).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static String getFormatLongToString(Long date,String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date(date));
    }


    /**
     * 通过传入的格式  获取当前时间
     * @param format  显示格式
     * @return
     */
    public static String getCurrentTime(String format){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        return simpleDateFormat.format(new Date(System.currentTimeMillis()));
    }

    /**
     * 获取当前时间的时间戳
     * @return
     */
    public static long getCurrentTime(){
        return new Timestamp(System.currentTimeMillis()).getTime();
    }

    /**
     *消息列表格式化时间---暂时还没x1000   如果后期有用到这个方法  然后修改x1000
     * @param timeInMillis 目标时间
     * @return  目前返回的格式都是 年-月-   "-"类型的  如果有需要  后期修改
     */
    public static String parseTimeChat(long timeInMillis) {
        Calendar now = Calendar.getInstance(); // 当前时间
        Calendar time = Calendar.getInstance();// 目标时间
        time.setTimeInMillis(timeInMillis);
        String pattern = null;
        // 比较
        if (now.get(Calendar.DAY_OF_YEAR) == time.get(Calendar.DAY_OF_YEAR)) {// 今天
            return getDynamicTime(time.getTimeInMillis(),now.getTimeInMillis());
        } else if (getDatetimeIntervalUsingDay(new Date(System.currentTimeMillis()), new Date(time.getTimeInMillis()))<=7) {// 7天内
            return getMonthAndDay(new Date(time.getTimeInMillis()));
        } else {
            pattern = FORMAT_YYYYMMDD;//显示时间的格式 yyyy-MM-dd
        }
        SimpleDateFormat sdf = new SimpleDateFormat(pattern, Locale.CHINA);
        return sdf.format(time.getTime());
    }
    /**
     *
     * @param strDate  目标时间
     * @param current   现在的时间
     * @return
     */
    public static String getDynamicTime(long strDate, long current) {
        String result = "未知";
        Date createDate = new Date(strDate);
        Date currentDate = new Date(current);

        if (isYeaterday(createDate, currentDate) == -1) {//今天
            SimpleDateFormat formatTime = new SimpleDateFormat(
                    FORMAT_YYYYMMDDHHMM);
            String createTimeStr = formatTime.format(createDate);
            String currentTimeStr = formatTime.format(currentDate);

            String[] createTimeArray = createTimeStr.split(" ");
            String[] createHourAndMinuteArray = createTimeArray[1].split(":");
            String createHour = createHourAndMinuteArray[0];// 创建的小时
            String createMinute = createHourAndMinuteArray[1];// 创建的分钟

            String[] currentTimeArray = currentTimeStr.split(" ");
            String[] currentHourAndMinuteArray = currentTimeArray[1].split(":");
            String currentHour = currentHourAndMinuteArray[0];// 当前的小时
            String currentMinute = currentHourAndMinuteArray[1];// 当前的分钟
            int gapMunite = (Integer.valueOf(currentHour) * 60 + Integer
                    .valueOf(currentMinute))
                    - ((Integer.valueOf(createHour) * 60 + Integer
                    .valueOf(createMinute)));
            if (gapMunite == 0) {
                result = "刚刚";
            } else if (gapMunite < 60 && gapMunite > 0) {
                result = gapMunite + "分钟前";
            } else if (gapMunite >= 60) {
                result = gapMunite / 60 + "小时前";
            } else {
                result = "刚刚";
            }
        } else {
            SimpleDateFormat format = new SimpleDateFormat(
                    FORMAT_YYYYMMDD);
            result = format.format(createDate);
        }
        return result;
    }
    /**
     *
     * @param date1  当前时间
     * @param date2  目标时间
     * @return
     */
    public static long getDatetimeIntervalUsingDay(Date date1, Date date2) {
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_YYYYMMDD);
        String todayStr = format.format(date1);
        Date today=null;
        try {
            today = format.parse(todayStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long interval = today.getTime() - date2.getTime();
        if (interval <= 0) {
            return 0;
        } else {
            return interval / (24 * 60 * 60 * 1000) + 1;
        }
    }
    /**
     *
     * @param date 目标时间
     * @return
     */
    public static String getMonthAndDay(Date date) {
        if (date == null) {
            return "时间为空";
        }
        /** 当前时间 **/
        Date currentDate = new Date(System.currentTimeMillis());
        /** 两个时间差的天数 **/
        long ApartDays = getDatetimeIntervalUsingDay(currentDate, date);
        int isYeater=isYeaterday(date, currentDate);
        /** 得到消息的小时 **/
        String hourAndMin = getHourAndMinites(date);
        if (ApartDays == 0) {// 今天
            if(isYeater==0){
                return "昨天";
            }
            return hourAndMin;
        } else if (ApartDays == 1) {// 昨天
            return "昨天";
        } else if (ApartDays <= 7) {// 7天内
            return ApartDays+"天前";
        } else {// 一周之前
            return new SimpleDateFormat(FORMAT_YYYYMMDD, Locale.CHINA).format(date);
        }
    }
    public static String getHourAndMinites(Date date) {
        String longDate = dateToStrNoSS(date);
        return longDate.substring(11);
    }
    public static String dateToStrNoSS(Date dateDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(FORMAT_YYYYMMDDHHMM);
        String dateString = formatter.format(dateDate);
        return dateString;
    }
    public static  int isYeaterday(Date oldTime,Date newTime){
        if(newTime==null){
            newTime=new Date();
        }
        //将下面的 理解成  yyyy-MM-dd 00：00：00 更好理解点
        SimpleDateFormat format = new SimpleDateFormat(FORMAT_YYYYMMDD);
        String todayStr = format.format(newTime);
        Date today=null;
        try {
            today = format.parse(todayStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //昨天 86400000=24*60*60*1000 一天
        if((today.getTime()-oldTime.getTime())>0 && (today.getTime()-oldTime.getTime())<=86400000) {
            return 0;
        }
        else if((today.getTime()-oldTime.getTime())<=0){ //至少是今天
            return -1;
        }
        else{ //至少是前天
            return 1;
        }
    }
}
