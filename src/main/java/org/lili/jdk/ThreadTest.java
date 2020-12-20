package org.lili.jdk;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.util.concurrent.*;

import static java.lang.Thread.sleep;

/**
 * @author lili
 * @date 2020/7/30 11:46
 * @description
 * @notes
 */
class Task implements Runnable {

    @Override
    public void run() {
        try {
            sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("......");
    }
}

public class ThreadTest {

    /**
     * 场外发短信专用
     */
    private static ExecutorService otcSendMessageExecutor = Executors.newSingleThreadExecutor();

    @Test
    public void test2() {
        executeWithCompanyId(124, () -> {
            System.out.println("333333333333");
        });
    }

    public static void executeWithCompanyId(Integer companyId, Runnable runnable) {
        otcSendMessageExecutor.execute(() -> {
            CompanyUtils.setCompanyId(companyId);
            System.out.println("before:" + companyId);
            runnable.run();
            System.out.println(CompanyUtils.getCompanyId());
            CompanyUtils.remove();
            System.out.println(CompanyUtils.getCompanyId());
        });

        otcSendMessageExecutor.execute(() -> {
            System.out.println("before:" + CompanyUtils.getCompanyId());
            runnable.run();
            System.out.println(CompanyUtils.getCompanyId());
            //CompanyUtils.remove();
            System.out.println(CompanyUtils.getCompanyId());
        });
    }

    private static ThreadFactory threadFactory = new ThreadFactoryBuilder()
            .setNameFormat("thread-pool-%d").build();

    private static ExecutorService pool = new ThreadPoolExecutor(
            16, //核心线程数
            32, //最大线程
            60L, TimeUnit.SECONDS, //超过corePoolSize，但是小于maximumPoolSize的线程数存活时间
            new LinkedBlockingQueue<>(1024), //，超过核心线程数的任务被排列在工作队列
            threadFactory, //线程工厂
            new ThreadPoolExecutor.AbortPolicy());  //超过最大线程数会线程拒绝策略


    @Test
    public void test() throws InterruptedException {

        int cpuAvailableCount = Runtime.getRuntime().availableProcessors();
        String maxMemory = Runtime.getRuntime().maxMemory() / 1000 / 1000 + "M";
        String freeMemory = Runtime.getRuntime().freeMemory() / 1000 / 1000 + "M";
        String totalMemory = Runtime.getRuntime().totalMemory() / 1000 / 1000 + "M";

        System.out.println(pool);
        System.out.println(maxMemory);
        System.out.println(freeMemory);
        System.out.println(totalMemory);

        LinkedBlockingQueue queue = new LinkedBlockingQueue(15);
        System.out.println(queue.size());
        ArrayBlockingQueue aq = new ArrayBlockingQueue(15);
        System.out.println(aq.size());
//        queue.offer("33");
//        queue.offer("33");
//        queue.offer("33");
//        queue.offer("33");
//        queue.offer("33");
//        queue.offer("33");
//        queue.offer("33");


        Executors.newFixedThreadPool(5);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadScheduledExecutor();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        System.out.println(executorService.toString());

        Thread thread = new Thread(() -> {
            System.out.println("alibaba");
//            try {
//                Thread.sleep(50000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        });
        thread.setName("alibaba");
        thread.setDaemon(true);
        thread.start();
        StackTraceElement[] stackTrace = thread.getStackTrace();
        System.out.println(stackTrace);
        System.out.println(thread.toString());

        for (int i = 1; i < stackTrace.length; i++) {
            StackTraceElement s = stackTrace[i];
            System.out.println("\tat " + s.getClassName() + "." + s.getMethodName()
                    + "(" + s.getFileName() + ":" + s.getLineNumber() + ")");
        }


        Thread thread2 = new Thread(() -> {
            System.out.println("alibaba2");
        });
        thread.setName("alibab2");
        thread2.start();

        Thread.sleep(10000);
    }

    public static void main(String[] args) {

        System.out.println(8 % 1);
        Thread pcAdminUpdate = new Thread(new Task());
        pcAdminUpdate.setName("LiLi");
        pcAdminUpdate.start();
        Thread pcAdminUpdate2 = new Thread(new Task());
        pcAdminUpdate2.setName("LiLi");
        pcAdminUpdate2.start();
    }


    @Test
    public void testSleel() {
        try {
            Thread.sleep(5000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public synchronized void testWait() throws InterruptedException {
        wait();
    }


    @Test
    public synchronized void testWait2() throws InterruptedException {
        "111".wait();
    }
}
