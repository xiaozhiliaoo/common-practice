package org.lili.jdk;

import org.checkerframework.checker.units.qual.A;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.IntStream;

/**
 * @author lili
 * @date 2020/6/2 11:53
 * @description
 * @notes
 */

public class AtomicBooleanTest {
    public static void main(String[] args) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
//        boolean b = atomicBoolean.get();
//        System.out.println(b);
//
//        boolean andSet = atomicBoolean.getAndSet(true);
//        System.out.println(andSet);

        IntStream.range(0, 10000).parallel().forEach(i -> {
            if (!atomicBoolean.get()) {
                if (i == 300) {
                    atomicBoolean.set(true);
                }
                System.out.println("my number" + i);
            }
        });

        System.out.println(atomicBoolean.get());

    }
}
