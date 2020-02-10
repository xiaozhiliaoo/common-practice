package org.lili.google.guava.timelimiter;

import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/1/17 16:09
 * @description
 */
public class MethodLongRunningImpl implements MethodLongRunning {
    @Override
    public void longRunning() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
