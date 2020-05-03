package org.lili.jdk;

import java.sql.Timestamp;

/**
 * @author lili
 * @date 2020/5/2 15:39
 * @description
 * @notes
 */

public class TimestampTest {
    public static void main(String[] args) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Timestamp timestamp2 = new Timestamp(System.currentTimeMillis());
        System.out.println(timestamp.equals(timestamp2));
        System.out.println(timestamp2.equals(timestamp));
    }
}
