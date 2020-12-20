package org.lili.jdk.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author lili
 * @date 2020/11/8 22:17
 * @see
 * @since
 */
public class ThreadPoolExecutorTest {

    @Test
    public void test() {
        System.out.println(ctl);
        System.out.println(COUNT_BITS);
        System.out.println(CAPACITY);
        System.out.println(RUNNING);
        System.out.println(SHUTDOWN);
        System.out.println(STOP);
        System.out.println(TIDYING);
        System.out.println(TERMINATED);
        System.out.println("-------------runStateOf--------------");
        System.out.println(runStateOf(111));
        System.out.println("-------------workerCountOf--------------");
        System.out.println(workerCountOf(222));
        System.out.println("-------------ctlOf--------------");
        System.out.println(ctlOf(111,0));
        System.out.println(ctlOf(222,0));
        System.out.println(ctlOf(333,0));
    }

    private final AtomicInteger ctl = new AtomicInteger(ctlOf(RUNNING, 0));
    private static final int COUNT_BITS = Integer.SIZE - 3;
    private static final int CAPACITY   = (1 << COUNT_BITS) - 1;

    // runState is stored in the high-order bits
    private static final int RUNNING    = -1 << COUNT_BITS;
    private static final int SHUTDOWN   =  0 << COUNT_BITS;
    private static final int STOP       =  1 << COUNT_BITS;
    private static final int TIDYING    =  2 << COUNT_BITS;
    private static final int TERMINATED =  3 << COUNT_BITS;

    // Packing and unpacking ctl
    private static int runStateOf(int c)     { return c & ~CAPACITY; }
    private static int workerCountOf(int c)  { return c & CAPACITY; }
    private static int ctlOf(int rs, int wc) { return rs | wc; }





    @Test
    public void prestartCoreThread() throws InterruptedException {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(5,
                10,60, TimeUnit.SECONDS, new ArrayBlockingQueue<>(5));
        int i = tpe.prestartAllCoreThreads();
        for (int j = 0; j < 1000; j++) {
            tpe.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(50000000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("lili");
                }
            });
        }

        System.out.println(i);

        Thread.sleep(5000000);
    }




}
