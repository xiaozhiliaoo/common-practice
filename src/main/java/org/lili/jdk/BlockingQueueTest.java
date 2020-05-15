package org.lili.jdk;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author lili
 * @date 2020/5/13 10:27
 * @description
 * @notes
 */

public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(10);
        blockingQueue.add("1");
        System.out.println(blockingQueue);
        System.out.println(blockingQueue.remove("1"));
        System.out.println(blockingQueue);
        System.out.println("-----------------------");
        BlockingQueue<String> blockingQueue2 = new ArrayBlockingQueue<>(10);
        blockingQueue2.offer("1");
        System.out.println(blockingQueue2);
        System.out.println(blockingQueue2.poll());
        System.out.println(blockingQueue2);

    }
}
