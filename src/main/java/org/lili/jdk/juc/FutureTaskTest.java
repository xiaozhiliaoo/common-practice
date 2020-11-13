package org.lili.jdk.juc;

import org.junit.Test;

import java.util.concurrent.*;

/**
 * @author lili
 * @date 2020/11/10 2:19
 * @see
 * @since
 */
public class FutureTaskTest {
    @Test
    public void test() throws ExecutionException, InterruptedException {
        String result = "";
        FutureTask<String> task = new FutureTask<>(() -> {
            System.out.println("lulu");
        }, result);
        System.out.println(result);
        new Thread(task).start();
    }

    @Test
    public void get() throws ExecutionException, InterruptedException {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(10000);
                return "alibaba";
            }
        };
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> submit = es.submit(callable);
        Thread.sleep(3000);
        System.out.println(submit.get());
    }


    @Test
    public void getLimitTime() throws ExecutionException, InterruptedException, TimeoutException {
        Callable<String> callable = () -> {
            Thread.sleep(1000000);
            return "alibaba";
        };
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> submit = es.submit(callable);
        Thread.sleep(3000);

        Thread thread1 = new Thread(() -> {
            try {
                System.out.println(submit.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread1.setName("first");
        thread1.start();

        Thread.sleep(1000);

        Thread thread2 = new Thread(() -> {
            try {
                System.out.println(submit.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread2.setName("second");
        thread2.start();

        Thread.sleep(1000);



        Thread thread3 = new Thread(() -> {
            try {
                System.out.println(submit.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread3.setName("third");
        thread3.start();

        Thread.sleep(1000);


        Thread thread4 = new Thread(() -> {
            try {
                System.out.println(submit.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        thread4.setName("fourth");
        thread4.start();

        Thread.sleep(50000000);

        //System.out.println(submit.get(3000000, TimeUnit.SECONDS));
    }
}
