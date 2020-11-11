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
            Thread.sleep(10000);
            return "alibaba";
        };
        ExecutorService es = Executors.newCachedThreadPool();
        Future<String> submit = es.submit(callable);
        Thread.sleep(3000);
        System.out.println(submit.get(3, TimeUnit.SECONDS));
    }
}
