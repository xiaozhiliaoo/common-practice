package org.lili.jdk.juc;

import org.junit.Test;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @author lili
 * @date 2020/9/14 10:46
 * @notes
 */
public class ForkJoinPoolTest {
    @Test
    public void test() {

        //ForkJoinPool.commonPool-worker-4
        IntStream.range(0,10).parallel().forEach(x->{
            try {
                if(x == 9) {
                    System.out.println(x);
                    Thread.sleep(x);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        //ForkJoinPool-1-worker-XXX
        ForkJoinPool joinPool = new ForkJoinPool();
        for (int i = 0; i < 10; i++) {
            joinPool.execute(()->{
                try {
                    Thread.currentThread().join();
                    //TimeUnit.DAYS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        ForkJoinPool joinPool2 = new ForkJoinPool();
        for (int i = 0; i < 5; i++) {
            joinPool2.execute(()->{
                try {
                    TimeUnit.DAYS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }


        ForkJoinPool joinPool3 = new ForkJoinPool();
        joinPool3.execute(()->{
            try {
                TimeUnit.DAYS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });


        ForkJoinPool joinPool4 = new ForkJoinPool();
        joinPool4.execute(()->{
            try {
                TimeUnit.DAYS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
