package org.lili.google.guava;

import com.google.common.collect.ForwardingSet;
import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

/**
 * @author lili
 * @date 2020/5/2 19:44
 * @description
 * @notes
 */

public class ForwardingSetTest {
    @Test
    public void test() {
        InstrumentedSet<String> instrumentedSet = new InstrumentedSet<>(new HashSet<>());
        instrumentedSet.add("44");
        instrumentedSet.add("445");
        instrumentedSet.add("4454");
        System.out.println(instrumentedSet.getAddCount());
    }
}
