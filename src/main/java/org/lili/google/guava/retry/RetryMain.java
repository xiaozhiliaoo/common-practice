package org.lili.google.guava.retry;

import com.github.rholder.retry.*;
import com.google.common.base.Predicates;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/8/15 11:21
 * @description https://github.com/rholder/guava-retrying
 * @notes
 */

public class RetryMain {

    private static int count = 0;

    public static void main(String[] args) {
        Callable<Boolean> requestResult = new Callable<Boolean>() {
            public Boolean call() throws Exception {
                TimeUnit.MILLISECONDS.sleep(500);
                count++;
                // do something useful here
                return true;
            }
        };

        Retryer<Boolean> retryer = RetryerBuilder.<Boolean>newBuilder()
                .retryIfResult(Predicates.<Boolean>isNull())
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withAttemptTimeLimiter(AttemptTimeLimiters.fixedTimeLimit(1,TimeUnit.SECONDS))
                .withStopStrategy(StopStrategies.stopAfterAttempt(3))
                .withWaitStrategy(WaitStrategies.exponentialWait(100, 5, TimeUnit.MINUTES))
                .withRetryListener(new RetryListener() {
                    @Override
                    public <V> void onRetry(Attempt<V> attempt) {
                        System.out.println("retry it");
                    }
                })
                .build();

        try {
            retryer.call(requestResult);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }

        System.out.println("retry count:" + count);


        Retryer<Boolean> retryer2 = RetryerBuilder.<Boolean>newBuilder()
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withWaitStrategy(WaitStrategies.exponentialWait(100, 5, TimeUnit.MINUTES))
                .withStopStrategy(StopStrategies.neverStop())
                .build();

        try {
            retryer2.call(requestResult);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }


        Retryer<Boolean> retryer3 = RetryerBuilder.<Boolean>newBuilder()
                .retryIfExceptionOfType(IOException.class)
                .retryIfRuntimeException()
                .withWaitStrategy(WaitStrategies.fibonacciWait(100, 2, TimeUnit.MINUTES))
                .withStopStrategy(StopStrategies.neverStop())
                .build();

        try {
            retryer3.call(requestResult);
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (RetryException e) {
            e.printStackTrace();
        }
    }
}
