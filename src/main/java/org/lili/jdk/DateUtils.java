package org.lili.jdk;


import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;


public class DateUtils {

    private DateUtils(){}

    public static String formatDate(Date date) {
        if (date == null) {
            return "";
        }
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(date);
    }


    public static String formatDate(Date date, String pattern) {
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }

    public static String getDateTime() {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 得到当前时间的前N小时
     * 
     * @return
     */
    public static Date getBeforeByHour(int ihour) {
        Date returnDate = new Date();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - ihour);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            returnDate = df.parse(df.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnDate;
    }

    public static Date getBeforeByMonth(int month) {
        Date returnDate = new Date();
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - month);
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            returnDate = df.parse(df.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return returnDate;
    }

    public static String countDateLength(Date endDate, Date startDate) {
        long diff = endDate.getTime() - startDate.getTime();
        long days = diff / (1000 * 60 * 60 * 24);
        long hours = (diff - days * (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);
        long minutes = (diff - days * (1000 * 60 * 60 * 24) - hours * (1000 * 60 * 60)) / (1000 * 60);
        String hireTimeStr = days + "天" + hours + "小时" + minutes + "分";
        return hireTimeStr;
    }

    public static void main(String[] args) {
        System.out.println(getBeforeByHour(24));
        System.out.println(getBeforeByMonth(12));
        System.out.println(countDateLength(getBeforeByHour(240), new Date()));
    }


}
