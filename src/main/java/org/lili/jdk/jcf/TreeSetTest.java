package org.lili.jdk.jcf;

import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    @Test
    public void test() {
        Set<Integer> number = new TreeSet<>();
        number.add(2140);
        number.add(111);
        number.add(10365);
        number.add(211);
        number.add(31);
        number.add(31);
        number.add(31);
        System.out.println(number);

    }
}
