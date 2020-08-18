package org.lili.jdk;

import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/6/1 14:51
 * @description
 * @notes
 */

public class SystemTest {
    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 1000000; i++) {
            TimeUnit.MINUTES.sleep(1);
        }
    }
}
