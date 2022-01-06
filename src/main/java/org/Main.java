package org;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.joda.time.DateTimeUtils;
import org.lili.jdk.DateUtils;

import java.math.BigDecimal;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static java.math.RoundingMode.HALF_UP;

/**
 * @author lili
 * @date 2020/11/11 15:51
 * @notes
 */
public class Main {


    public static void main(String[] args) {

        System.out.println(new Date());
        System.out.println(DateFormatUtils.format(new Date(), "yyyy-MM-dd"));














        BigDecimal a1 = new BigDecimal("48.00");
        BigDecimal b1 = new BigDecimal("8000.00");
        System.out.println("~~~~~~"+a1.divide(b1, 5, HALF_UP).setScale(5,HALF_UP).toPlainString());


        System.out.println(new BigDecimal("2.3333").toPlainString());
        double a = 2.333;
        System.out.println(new BigDecimal(a).doubleValue());
        System.out.println(new BigDecimal("2.3333").toPlainString());
        System.out.println(new BigDecimal("2.236").multiply(new BigDecimal("1")).setScale(2, HALF_UP).doubleValue());
        System.out.println(new BigDecimal("2.232").setScale(2, HALF_UP).stripTrailingZeros());
        System.out.println(new BigDecimal("2.99").setScale(2, HALF_UP).stripTrailingZeros());
        System.out.println(new BigDecimal("2.89").setScale(2, HALF_UP).stripTrailingZeros());

    }

}
