package org.lili.jdk.juc;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentSkipListSet;

public class ConcurrentSkipListSetTest {
    @Test
    public void test() {
        ConcurrentSkipListSet<Integer> ckls = new ConcurrentSkipListSet();
        ckls.add(45);
        ckls.add(41);
        ckls.add(42);
        System.out.println(ckls);

    }
}
