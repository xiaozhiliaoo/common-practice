package org.lili.jdk;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author lili
 * @date 2020/2/3 20:55
 * @description
 */
public class BigDecimalTest {
    @Test
    public void test() {
        String s = "1.40000";
        BigDecimal bigDecimal = NumberUtils.createBigDecimal(s).stripTrailingZeros();
        BigDecimal s1 = new BigDecimal(1.4000).stripTrailingZeros();
        System.out.println(bigDecimal.compareTo(s1));


        System.out.println(new BigDecimal("1.4890").multiply(new BigDecimal(100)).stripTrailingZeros().toPlainString());
    }

    private static final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");


    @Test
    public void test2() {
        System.out.println(decimalFormat.format(22345223.021));
        String obj = new BigDecimal("11134697654.23").toPlainString();
        System.out.println(obj);
        System.out.println(decimalFormat.format(new BigDecimal("11134697654.23")));
        System.out.println(decimalFormat.format(new BigDecimal("0.23")));
        System.out.println(decimalFormat.format(new BigDecimal("113.53")));


    }



    @Test
    public void divide() {
        if (new BigDecimal("-5.6").compareTo(BigDecimal.ZERO) < 0) {
            throw new RuntimeException("");
        }
    }
}
