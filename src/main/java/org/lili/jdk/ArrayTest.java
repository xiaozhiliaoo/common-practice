package org.lili.jdk;

import org.junit.Test;

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
        System.out.println(ip);
    }
}
