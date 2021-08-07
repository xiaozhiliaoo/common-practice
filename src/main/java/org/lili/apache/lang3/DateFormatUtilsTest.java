package org.lili.apache.lang3;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;

public class DateFormatUtilsTest {
    @Test
    public void test() {
        System.out.println(DateFormatUtils.format(new Date(), "yyyy年MM月dd日 HH时-mm分-ss秒"));
    }
}
