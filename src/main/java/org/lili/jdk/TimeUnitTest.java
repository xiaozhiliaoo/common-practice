package org.lili.jdk;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/5/4 20:24
 * @description
 * @notes
 */

public class TimeUnitTest {

    @Test
    public void test() {
        System.out.println(System.currentTimeMillis());
        Assert.assertEquals(24 * 60 * 60 * 1000, TimeUnit.DAYS.toMillis(1));
        Assert.assertEquals(24 * 60 * 60 * 1000 * 7, TimeUnit.DAYS.toMillis(7));
        Assert.assertEquals(24 * 60 * 60 * 1000 * 14, TimeUnit.DAYS.toMillis(14));
        Assert.assertEquals(24 * 60 * 60 * 1000 * 30L, TimeUnit.DAYS.toMillis(30));
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.DAYS.toMillis(1));

    }
}
