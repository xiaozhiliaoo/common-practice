package org.lili.google.guava;

import com.google.common.base.Stopwatch;
import org.junit.jupiter.api.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/7/28 20:46
 * @description
 * @notes
 */

public class StopWatchTest {
    @Test
    public void test() throws InterruptedException {
        Stopwatch stopwatch = Stopwatch.createStarted();

        for (int i = 0; i < 4; i++) {
            Thread.sleep(1000);
        }

        System.out.println(stopwatch.elapsed());

        stopwatch.reset().start();
        Thread.sleep(3000);

        System.out.println(stopwatch.elapsed());

        stopwatch.reset().start();
        Thread.sleep(5000);
        System.out.println(stopwatch.elapsed(TimeUnit.MILLISECONDS));


    }

    @Test
    public void getStart() throws InterruptedException {
        Stopwatch started = Stopwatch.createStarted();
        //System.out.println(started.elapsed());
        Thread.sleep(135);
        started.elapsed(TimeUnit.MILLISECONDS);
        System.out.println(started);
    }
}
