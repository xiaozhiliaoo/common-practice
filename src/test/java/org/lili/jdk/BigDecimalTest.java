package org.lili.jdk;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
}
