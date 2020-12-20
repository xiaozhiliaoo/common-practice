package org.lili.jdk;

import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author lili
 * @date 2020/3/21 17:19
 * @description
 * @notes
 */

public class DateTest {

    @Test
    public void testForEach() {
        List<Object> objects = null;
        for (Object object : objects) {
            System.out.println(object);
        }
    }

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
    public void dateTo() {
        Date date = new Date();
        SimpleDateFormat bjSdf = new SimpleDateFormat("HH:mm:ss");
//        String format = bjSdf.(date);
//        System.out.println(format.toString());

    }

    @Test
    public void aa() {
        assertEquals(get(0),get2(0));
        assertEquals(get(1),get2(1));
        assertEquals(get(2),get2(2));
    }

    private boolean get(int number) {
        if (number == 0) {
            return false;
        } else {
            return true;
        }
    }
    private boolean get2(int number) {
        return ! (number == 0);
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
