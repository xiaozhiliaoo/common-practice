package org.lili.jdk.juc;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @author lili
 * @date 2020/12/11 15:51
 * @notes
 */
public class AtomicLongTest {
    @Test
    public void test() {
        AtomicLong atomicLong = new AtomicLong(0L);
        long x = atomicLong.addAndGet(99);
        System.out.println(x);
        long andAdd = atomicLong.getAndAdd(99);
        System.out.println(andAdd);

        System.out.println(atomicLong);


        atomicLong.compareAndSet(5, System.currentTimeMillis());
        System.out.println(atomicLong);
    }

    @Test
    public void testLongAdder() {
        LongAdder longAdder = new LongAdder();
    }
}
