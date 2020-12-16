package org.lili.jdk.juc;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/12/10 17:44
 * @notes
 */
public class ScheduledExecutorServiceTest {
    @Test
    public void test() throws InterruptedException {
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(2);
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            System.out.println("1111" + System.currentTimeMillis());
        }, 0,1, TimeUnit.SECONDS);




    }
}
