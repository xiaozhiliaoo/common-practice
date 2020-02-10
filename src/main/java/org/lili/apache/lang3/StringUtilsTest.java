package org.lili.apache.lang3;

import org.apache.commons.lang3.StringUtils;

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
}
