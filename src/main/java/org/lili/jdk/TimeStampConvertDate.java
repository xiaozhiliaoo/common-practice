package org.lili.jdk;

/**
 * @author lili
 * @date 2020/2/10 18:03
 * @description
 * @notes
 */


import java.util.*;

public class TimeStampConvertDate {
    public static void main(String[] args) {
        long now = System.currentTimeMillis();
        Date date = new Date(now);
        System.out.println(date);
    }
}
