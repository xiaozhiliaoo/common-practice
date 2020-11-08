package org.lili.jdk.lang;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lili
 * @date 2020/11/7 1:10
 * @see
 * @since
 */
public class SafeVarargsTest {

    @Test
    public void test() {
        m(Lists.newArrayList("1","2","3"));
    }

    @SafeVarargs
    static void m(List<String>... stringLists) {
        Object[] array = stringLists;
        List<Integer> tmpList = Arrays.asList(42);
        array[0] = tmpList; // Semantically invalid, but compiles without warnings
        String s = stringLists[0].get(0); // Oh no, ClassCastException at runtime!
    }

    @SafeVarargs
    static void m(int... i) {
        System.out.println(i);
//        stringLists = new ArrayList<>();
    }
}
