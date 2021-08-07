package org.lili.google.guava;

import com.google.common.collect.Lists;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author lili
 * @date 2020/1/17 15:15
 * @description
 */
public class BloomFilterTest {
    @Test
    public void test() {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
        filter.put(1);
        filter.put(2);
        filter.put(3);
        assertTrue(filter.mightContain(1));
        assertTrue(filter.mightContain(2));
        assertTrue(filter.mightContain(3));
        assertFalse(filter.mightContain(100));
        System.out.println(new BigDecimal("1.00").compareTo(BigDecimal.ONE) <= 1);
        List<Integer> s = Lists.newArrayList(1,2,3,4,5);
        List<Integer> collect = s.stream().filter(x -> x == 1).collect(Collectors.toList());
        System.out.println(collect);
    }


    @Test
    public void testInsert() {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 5, 0.01);
        IntStream.range(0, 100_000).forEach(filter::put);
        filter.put(1_000_000);
        assertTrue(filter.mightContain(1));
        assertTrue(filter.mightContain(2));
        assertTrue(filter.mightContain(3));
        assertTrue(filter.mightContain(3));
        assertTrue(filter.mightContain(1_000_000));
    }
}
