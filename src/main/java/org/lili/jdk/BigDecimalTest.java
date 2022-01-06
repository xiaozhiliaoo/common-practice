package org.lili.jdk;

/**
 * @author lili
 * @date 2020/2/10 21:06
 * @description
 * @notes
 */


import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.RoundingMode.HALF_UP;

public class BigDecimalTest {

    @Test
    public void test() {
        System.out.println(new BigDecimal("2.236").setScale(2, HALF_UP).stripTrailingZeros());
    }

    @Test
    public void testCompare() {
        BigDecimal decimal = new BigDecimal("45.66670000");
        BigDecimal decimal2 = new BigDecimal("45.66670000");
        System.out.println(decimal.compareTo(decimal2));
    }

    @Test
    public void testIt() {
        BigDecimal one = new BigDecimal("34.5");
        BigDecimal two = new BigDecimal("44.5");
        System.out.println(one.add(two));
        System.out.println(one);
    }

    @Test
    public void testZero() {



        String s = new BigDecimal(34777370)
                .divide(new BigDecimal(Math.pow(10, 8)), 4, RoundingMode.DOWN).toPlainString();
        System.out.println(s);

        String sss = "12765.665500000000";
        BigDecimal s1 = new BigDecimal(sss);
        System.out.println(s1.stripTrailingZeros().toPlainString());
    }

    @Test
    public void testAdd2() {
        BigDecimal one = new BigDecimal("34.5");
        BigDecimal two = new BigDecimal("44.5");
        System.out.println(one.add(two));
    }
}
