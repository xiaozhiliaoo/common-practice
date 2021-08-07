package org.lili.apache.lang3;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtilsTest {
    @Test
    public void test() {
        //10:49  返回10
        //11:02 返回 11
        Date round = DateUtils.round(new Date(), Calendar.HOUR);
        System.out.println(round);
        System.out.println(DateUtils.addHours(round, -16));
    }

    @Test
    public void test2() {
        Date round = DateUtils.round(new Date(), Calendar.HOUR);
        System.out.println(round);
        System.out.println(DateUtils.addHours(round, -8));
    }

    @Test
    public void test3()throws Exception {
        System.out.println(new Date());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        System.out.println(sdf.parse(format));
        String format1 = DateFormatUtils.format(new Date(), "yyyy-MM-dd 10:00:00");
        System.out.println(sdf.parse(format1));
    }


    @Test
    public void test4()throws Exception {
        Date date = DateUtils.parseDate("2017-12-15 09:46:01", "yyyy-MM-dd HH:mm:ss");
        System.out.println(date);
    }
}
