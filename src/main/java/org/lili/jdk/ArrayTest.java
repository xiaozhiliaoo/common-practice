package org.lili.jdk;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author lili
 * @date 2020/8/25 18:30
 * @description
 * @notes
 */

public class ArrayTest {
    @Test
    public void test() {
        String[] ips = {"112.17.245.74", "128.1.48.108", "10.1.50.27", "10.1.24.167"};
        String ip = ips[ips.length - 2];
        System.out.println(ip);//10.1.50.27

        String[] ips2 = {"112.17.245.74", "128.1.48.108", "10.1.50.27", "10.1.24.167","56.43.23.55"};
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
            for (int j = newIPs.size()-1; j >= 0; j--) {
                newIPs2.add(newIPs.get(j));
            }
            if (newIPs2.size() <= 0) {
                newIPs2.add(StringUtils.trim(split[0]));
            }

            ipStr = StringUtils.join(newIPs2, ",");
        }

        return ipStr;
    }
}