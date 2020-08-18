package org.lili.jdk.juc;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author lili
 * @date 2020/5/31 11:58
 * @description
 * @notes
 */

public class LinkedBlockingQueueTest {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue queue = new ArrayBlockingQueue(2);
        queue.offer("1");
        queue.offer("2");
        queue.offer("3");
        System.out.println(queue);


        LinkedBlockingQueue queue2 = new LinkedBlockingQueue(2);
        queue2.offer("1");
        queue2.offer("2");
        queue2.offer("3");
        System.out.println(queue2);

    }
}
