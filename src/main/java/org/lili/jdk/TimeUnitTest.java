package org.lili.jdk;

import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author lili
 * @date 2020/5/4 20:24
 * @description
 * @notes
 */

public class TimeUnitTest {

    @Test
    public void test3() {
        System.out.println();
    }

    @Test
    public void test() {
        assertEquals(24 * 60 * 60 * 1000, TimeUnit.DAYS.toMillis(1));
        assertEquals(24 * 60 * 60 * 1000, TimeUnit.HOURS.toMillis(24));
        assertEquals(24 * 60 * 60 * 1000 * 7, TimeUnit.DAYS.toMillis(7));
        assertEquals(24 * 60 * 60 * 1000 * 14, TimeUnit.DAYS.toMillis(14));
        assertEquals(24 * 60 * 60 * 1000 * 30L, TimeUnit.DAYS.toMillis(30));
    }

    @Test
    public void test4() {
        assertEquals(10 * 60 * 1000, TimeUnit.MINUTES.toMillis(10));

    }


    @Test
    public void test2() {
        System.out.println(TimeUnit.MILLISECONDS.toDays((24 * 60 * 60 * 1000) * 3 / 2));
        System.out.println(TimeUnit.MILLISECONDS.toMinutes((24 * 60 * 60 * 1000) * 3 / 2));
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.DAYS.toMillis(1));

    }

    @Test
    public void test333() {
        mmm();
    }

    public void mmm() {
        m1();
        System.out.println(m2());
    }

    public void m1() {
        System.out.println("11111111");
        return;
    }

    public int m2() {
        System.out.println("2222222");
        return 100;
    }
}
