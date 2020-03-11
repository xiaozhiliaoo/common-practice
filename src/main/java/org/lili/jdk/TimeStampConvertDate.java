package org.lili.jdk;

/**
 * @author lili
 * @date 2020/2/10 18:03
 * @description
 * @notes
 */


import java.util.*;
import java.util.concurrent.TimeUnit;

public class TimeStampConvertDate {
    public static void main(String[] args) {
        System.out.println(TimeUnit.MINUTES.toMillis(1));
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        System.out.println(date);
    }
}
