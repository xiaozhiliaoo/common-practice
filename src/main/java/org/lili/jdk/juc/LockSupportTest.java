package org.lili.jdk.juc;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @author lili
 * @date 2020/11/12 22:53
 * @see
 * @since
 */

class FIFOMutex {
    private final AtomicBoolean locked = new AtomicBoolean(false);
    private final Queue<Thread> waiters = new ConcurrentLinkedQueue<>();

    public void lock() {

        boolean wasInterrupted = false;
        // publish current thread for unparkers
        waiters.add(Thread.currentThread());

        //只有第一个能获取锁，别的线程获取不到锁
        // Block while not first in queue or cannot acquire lock
        while (waiters.peek() != Thread.currentThread() ||
                !locked.compareAndSet(false, true)) {
            LockSupport.park(this);
            // ignore interrupts while waiting
            if (Thread.interrupted())
                wasInterrupted = true;
        }

        waiters.remove();
        // ensure correct interrupt status on return
        if (wasInterrupted)
            Thread.currentThread().interrupt();
    }

    public void unlock() {
        locked.set(false);
        LockSupport.unpark(waiters.peek());
    }

    static {
        // Reduce the risk of "lost unpark" due to classloading
        Class<?> ensureLoaded = LockSupport.class;
    }
}


public class LockSupportTest {
    public static void main(String[] args) {

        FIFOMutex mutex = new FIFOMutex();
        mutex.lock();

        new Thread(()->{
            mutex.lock();
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



        new Thread(()->{
            mutex.lock();
            try {
                Thread.sleep(50000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();



//        LockSupport.park("lili");
    }
}
