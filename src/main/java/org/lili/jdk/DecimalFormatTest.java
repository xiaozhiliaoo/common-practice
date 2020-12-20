package org.lili.jdk;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * @author lili
 * @date 2020/3/24 11:52
 * @description
 * @notes
 */

public class DecimalFormatTest {

    private static final DecimalFormat VOLUME_FORMATTER = new DecimalFormat("###,###.0000");
    private static final DecimalFormat VOLUME_FORMATTER2 = new DecimalFormat("###,###.000000");

    @Test
    public void test() {
        System.out.println(VOLUME_FORMATTER.format(new BigDecimal("14456663.4566")));
        System.out.println(VOLUME_FORMATTER2.format(new BigDecimal("14456663.4566")));
    }
}
