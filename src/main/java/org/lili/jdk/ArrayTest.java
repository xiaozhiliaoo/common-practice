package org.lili.jdk;

import com.google.common.collect.Maps;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author lili
 * @date 2020/8/25 18:30
 * @description
 * @notes
 */

public class ArrayTest {
    @Test
    public void test() {

        System.out.println(UUID.randomUUID().toString().replace("-", "").substring(0, 20));

        BigDecimal one = new BigDecimal("34.5");
        BigDecimal two = new BigDecimal("44.5");
        one.add(two);
        System.out.println(one);

        String[] ips = {"112.17.245.74", "128.1.48.108", "10.1.50.27", "10.1.24.167"};
        String ip = ips[ips.length - 2];
        System.out.println(ip);//10.1.50.27

        String[] ips2 = {"112.17.245.74", "128.1.48.108", "10.1.50.27", "10.1.24.167", "56.43.23.55"};
        String ip2 = ips2[ips2.length - 2];
        System.out.println(ip2); //10.1.24.167


        String ipstr = "112.17.245.74,128.1.48.108,10.1.50.27,10.1.24.167,56.43.23.55,192.168.11.120";
        System.out.println(getRewriteIP(ipstr));

    }

    public static boolean isIntranet(String ip) {
        String reg = "^(192\\.168|172\\.(1[6-9]|2\\d|3[0,1]))(\\.(2[0-4]\\d|25[0-5]|[0,1]?\\d?\\d)){2}$|^10(\\.([2][0-4]\\d|25[0-5]|[0,1]?\\d?\\d)){3}$|^127(\\.\\d+){3}$";
        Pattern p = Pattern.compile(reg);
        Matcher matcher = p.matcher(ip);
        return matcher.find();
    }


    public static String getRewriteIP(String ipStr) {
        String[] split = ipStr.split(",");
        List<String> newIPs = new ArrayList<>();
        if (split.length > 2) {
            for (int i = split.length - 1; i >= 0; i--) {
                if (!isIntranet(StringUtils.trim(split[i]))) {
                    newIPs.add(StringUtils.trim(split[i]));
                }
            }
            List<String> newIPs2 = new ArrayList<>();
            for (int j = newIPs.size() - 1; j >= 0; j--) {
                newIPs2.add(newIPs.get(j));
            }
            if (newIPs2.size() <= 0) {
                newIPs2.add(StringUtils.trim(split[0]));
            }

            ipStr = StringUtils.join(newIPs2, ",");
        }

        return ipStr;
    }


    @Test
    public void test2() {

        List<String> objects = new ArrayList<>(5);
        System.out.println(CollectionUtils.isEmpty(objects));
        objects.add("3333");
        objects.add("4444");
        objects.add("14444");
        objects.add("44344");
        List<String> collect = objects.stream().
                sorted(Comparator.comparingInt(String::length).reversed()).limit(20).collect(Collectors.toList());
        objects.sort(Comparator.comparingInt(String::length));

        System.out.println(objects.subList(0, Math.min(objects.size(), 20)));

        System.out.println(collect);


        System.out.println(CollectionUtils.isEmpty(objects));

    }
}
