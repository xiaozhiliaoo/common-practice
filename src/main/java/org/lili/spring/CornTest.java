package org.lili.spring;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

import java.time.LocalTime;

/**
 * @author lili
 * @date 2022/1/24 11:54
 */
public class CornTest {
    @Test
    void test() {
        System.out.println("Program starts at : " + LocalTime.now());
        CronTrigger cronTrigger = new CronTrigger("0 43 19 * * *");
        ThreadPoolTaskScheduler s = new ThreadPoolTaskScheduler();
        s.setPoolSize(5);
        s.initialize();
        for (int i = 0; i < 2; i++) {
            s.schedule(getTask(), cronTrigger);
        }
        s.getScheduledThreadPoolExecutor().shutdown();
    }


    public static Runnable getTask() {
        return () -> System.out.printf("Task: %s, Time: %s:%n",
                Thread.currentThread().getName(),
                LocalTime.now());
    }
}
