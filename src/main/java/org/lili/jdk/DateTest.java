package org.lili.jdk;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author lili
 * @date 2020/3/21 17:19
 * @description
 * @notes
 */

public class DateTest {

    @Test
    public void test2() {
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void test() {
        Date date = new Date();
        System.out.println(date);
    }

    @Test
    public void test3() {
        Date date = new Date();  // 对应的北京时间是2017-08-24 11:17:10

        SimpleDateFormat bjSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");     // 北京
        bjSdf.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));  // 设置北京时区

        SimpleDateFormat tokyoSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  // 东京
        tokyoSdf.setTimeZone(TimeZone.getTimeZone("Asia/Tokyo"));  // 设置东京时区

        SimpleDateFormat londonSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); // 伦敦
        londonSdf.setTimeZone(TimeZone.getTimeZone("Europe/London"));  // 设置伦敦时区

        System.out.println("毫秒数:" + date.getTime() + ", 北京时间:" + bjSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 东京时间:" + tokyoSdf.format(date));
        System.out.println("毫秒数:" + date.getTime() + ", 伦敦时间:" + londonSdf.format(date));
    }
}
