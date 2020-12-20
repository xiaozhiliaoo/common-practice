package org.lili.google.guava.collect;

import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;
import org.apache.commons.collections4.comparators.ComparatorChain;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * @author lili
 * @date 2020/1/17 10:31
 * @description
 */
public class ComparatorTest {
    @Test
    public void test() {
        Comparator<String> byReverseOffSetThenName =  new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ComparisonChain.start().compare(o1,o2).compare(o1.length(),o2.length()).result();
            }
        };

        Comparator<String> byReverseOffSetThenName2 = Ordering
                .natural()
                .reverse()
                .onResultOf(tzToOffset())
                .compound(Ordering.natural());
    }

    private Function<String,Integer> tzToOffset() {
        return new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return getOffSet(input);
            }
        };
    }

    private Integer getOffSet(String input) {
        return null;
    }
}
