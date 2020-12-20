package org.lili.google.guava.timelimiter;

import com.google.common.util.concurrent.SimpleTimeLimiter;
import com.google.common.util.concurrent.TimeLimiter;
import com.google.common.util.concurrent.UncheckedTimeoutException;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

/**
 * @author lili
 * @date 2020/1/17 16:01
 * @description
 */


public class TimeLimiterTest {
    @Test
    public void testNewProxy() {
        ExecutorService es = Executors.newFixedThreadPool(1);
        TimeLimiter limiter = SimpleTimeLimiter.create(es);
        MethodLongRunning longRunning = new MethodLongRunningImpl();
        try {
            MethodLongRunning proxy = limiter.newProxy(longRunning, MethodLongRunning.class, 2, TimeUnit.SECONDS);
            proxy.longRunning();
        } catch (UncheckedTimeoutException e) {
            e.printStackTrace();
            System.out.println("超时结束");
        }
    }

    @Test
    public void testCallWithTimeout() {
        ExecutorService es = Executors.newFixedThreadPool(1);
        TimeLimiter limiter = SimpleTimeLimiter.create(es);
        try {
            String longCostString = limiter.callWithTimeout(new Callable<String>() {
                @Override
                public String call() throws Exception {
                    return "longCostString";
                }
            }, 5, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("超时结束");
        }
    }

    @Test
    public void testRunWithTimeout() {
        ExecutorService es = Executors.newFixedThreadPool(1);
        TimeLimiter limiter = SimpleTimeLimiter.create(es);
        try {
            limiter.runWithTimeout(new Runnable() {
                @Override
                public void run() {

                }
            },2, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
