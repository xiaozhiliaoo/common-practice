package org.lili.netty;

import io.netty.util.HashedWheelTimer;
import io.netty.util.Timeout;
import io.netty.util.Timer;
import io.netty.util.TimerTask;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * hierarchical timer wheel
 * 时间轮算法：https://github.com/ben-manes/caffeine/blob/master/caffeine/src/main/java/com/github/benmanes/caffeine/cache/TimerWheel.java
 * kafka.utils.timer.SystemTimer
 * https://cwiki.apache.org/confluence/display/KAFKA/Purgatory+Redesign+Proposal
 *
 * @author lili
 * @date 2021/1/2 21:19
 * @notes
 */
public class HashedWheelTimerTest {
    @Test
    public void test() {
        final Timer timer = new HashedWheelTimer(Executors.defaultThreadFactory(), 5, TimeUnit.SECONDS, 2);

        TimerTask task1 = new TimerTask() {
            public void run(Timeout timeout) throws Exception {
                System.out.println("task 1 will run per 5 seconds ");
                timer.newTimeout(this, 5, TimeUnit.SECONDS);//结束时候再次注册
            }
        };
        timer.newTimeout(task1, 5, TimeUnit.SECONDS);


        TimerTask task2 = new TimerTask() {
            public void run(Timeout timeout) throws Exception {
                System.out.println("task 2 will run per 10 seconds");
                timer.newTimeout(this, 10, TimeUnit.SECONDS);//结束时候再注册
            }
        };
        timer.newTimeout(task2, 10, TimeUnit.SECONDS);


        //该任务仅仅运行一次
        timer.newTimeout(new TimerTask() {
            public void run(Timeout timeout) throws Exception {
                System.out.println("task 3 run only once ! ");
            }
        }, 15, TimeUnit.SECONDS);

    }
}
