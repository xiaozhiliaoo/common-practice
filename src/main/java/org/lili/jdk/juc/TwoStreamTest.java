package org.lili.jdk.juc;


import org.lili.jdk.ThreadTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lili
 * @date 2020/9/14 11:37
 * @notes https://zhuanlan.zhihu.com/p/34205253
 */
public class TwoStreamTest {
    public static void main(String args[]) throws Exception {
        TwoStreamTest test = new TwoStreamTest();
        test.executeTasks();
    }

    void executeTasks() throws Exception {
        final List<Integer> firstRange = buildIntRange();
        final List<Integer> secondRange = buildIntRange();

        Runnable firstTask = () -> {
            firstRange.parallelStream().forEach((number) -> {
                try {
                    // do something slow
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
            });
        };

        Runnable secondTask = () -> {
            secondRange.parallelStream().forEach((number) -> {
                try {
                    // do something slow
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
            });
        };

        Thread t1 = new Thread(firstTask);
        Thread t2 = new Thread(secondTask);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
    }

    private List<Integer> buildIntRange() {
        List<Integer> numbers = new ArrayList<>(5);
        for (int i = 0; i < 60_000; i++) {
            numbers.add(i);
        }
        return Collections.unmodifiableList(numbers);
    }
}
