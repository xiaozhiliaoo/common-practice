package org.lili.jdk;

import org.junit.jupiter.api.Test;

import java.lang.annotation.Target;
import java.math.BigDecimal;

/**
 * @author lili
 * @date 2020/9/19 15:25
 * @notes
 */
public class BigDecimalTest2 {


    @Test
    public void testCompare() {
        BigDecimal decimal = new BigDecimal("45.66670000");
        BigDecimal decimal2 = new BigDecimal("45.66670000");
        System.out.println(decimal.compareTo(decimal2));
    }

    @Test
    public void test() {
        BigDecimal bigDecimal = new BigDecimal("1");
        BigDecimal augend = new BigDecimal("67");
        BigDecimal add = bigDecimal.add(augend);
        System.out.println(add);
    }


    @Test
    public void test2() {
        BigDecimal bigDecimal = BigDecimal.ONE;
        for (int i = 0; i < 100; i++) {
            bigDecimal = bigDecimal.add(new BigDecimal(1));
        }
        System.out.println(bigDecimal);
    }
}
