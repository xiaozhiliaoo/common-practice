package org.lili.jdk;

/**
 * @author lili
 * @date 2020/2/10 21:06
 * @description
 * @notes
 */



import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;

public class BigDecimalTest {
    public static void main(String[] args) {
        String s = new BigDecimal(34777370)
                .divide(new BigDecimal(Math.pow(10, 8)), 4, RoundingMode.DOWN).toPlainString();
        System.out.println(s);

        String sss = "12765.665500000000";
        BigDecimal s1 = new BigDecimal(sss);
        System.out.println(s1.stripTrailingZeros().toPlainString());
    }
}
