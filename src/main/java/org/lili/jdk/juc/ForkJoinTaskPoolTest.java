package org.lili.jdk.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * @author lili
 * @date 2020/9/14 11:39
 * @notes
 */
public class ForkJoinTaskPoolTest {
    public static void main(String args[]) throws Exception {
        ForkJoinTaskPoolTest test = new ForkJoinTaskPoolTest();
        test.executeTasks();
    }

    /**
     * parallel streams use their own Fork Join Pools instead of sharing the common pool.
     * you need to create your own ForkJoinPool object and use this pool to contain the
     * stream code.
     *
     * @throws Exception
     */
    void executeTasks() throws Exception {
        final List<Integer> firstRange = buildIntRange();
        final List<Integer> secondRange = buildIntRange();

        ForkJoinPool forkJoinPool = new ForkJoinPool(4);
        forkJoinPool.submit(() -> {
            firstRange.parallelStream().forEach((number) -> {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
            });
        });

        ForkJoinPool forkJoinPool2 = new ForkJoinPool(4);
        forkJoinPool2.submit(() -> {
            secondRange.parallelStream().forEach((number) -> {
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                }
            });
        });

        Thread.sleep(20_000);
    }


    private List<Integer> buildIntRange() {
        List<Integer> numbers = new ArrayList<>(5);
        for (int i = 0; i < 60_000; i++)
            numbers.add(i);
        return Collections.unmodifiableList(numbers);
    }
}
