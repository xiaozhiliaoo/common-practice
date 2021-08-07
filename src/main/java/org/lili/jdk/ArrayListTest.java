package org.lili.jdk;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {
    @Test
    public void testAdd() {
        List<String> result = new ArrayList<>();
        List<String> add = new ArrayList<>();
        add.add("1");
        add.add("2");
        add.add("3");
        add.add("4");
        add.stream().forEach(result::add);
        System.out.println(result);

        System.out.println(new BigDecimal("0.1").compareTo(BigDecimal.ONE));

    }


    @Test
    public void testRemove() {
        List<Integer> s1 = Lists.newArrayList(1,2,3,4,5);
        List<Integer> s2 = Lists.newArrayList(1,2,3);
        System.out.println(s1.removeAll(s2));
        System.out.println(s1);
    }


    @Test
    public void generateArray() {
        List<Integer> s1 = new ArrayList<>();
        for (int i = 10000000; i < 10010000; i++) {
            s1.add(i);
        }
        System.out.println(s1);
    }

    @Test
    public void testId() {
        System.out.println(System.currentTimeMillis() % 10000);
    }
}
