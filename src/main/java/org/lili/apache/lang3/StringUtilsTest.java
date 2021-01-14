package org.lili.apache.lang3;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/1/9 13:55
 * @description
 */
public class StringUtilsTest {
    public static void main(String[] args) {
        String payments = "支付宝,银行卡,微信,";
        String substring = StringUtils.substring(payments, 0, payments.length() - 1);
        System.out.println(substring);
    }

    @Test
    public void isAnyBlank() {
        System.out.println(StringUtils.isAnyBlank("", "222"));
        System.out.println(StringUtils.isAnyBlank(null, "222"));
        System.out.println(StringUtils.isAnyBlank("111", "222"));
        System.out.println(StringUtils.isAnyBlank("ddd", "222"));
    }

    @Test
    public void isAllBlank() {
        System.out.println(StringUtils.isAllBlank("", "222"));
        System.out.println(StringUtils.isAllBlank(null, "222"));
        System.out.println(StringUtils.isAllBlank("111", "222"));
        System.out.println(StringUtils.isAllBlank("ddd", "222"));
    }


    @Test
    public void isNoneBlank() {
        System.out.println(StringUtils.isNoneBlank("", "222"));
        System.out.println(StringUtils.isNoneBlank(null, "222"));
        System.out.println(StringUtils.isNoneBlank("111", "222"));
        System.out.println(StringUtils.isNoneBlank("ddd", "222"));
    }
}
