package org.lili.google.guava;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.junit.Assert;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
    }


    @Test
    public void testInsert() {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 5, 0.01);
        IntStream.range(0,100_000).forEach(filter::put);
        filter.put(1_000_000);
        assertTrue(filter.mightContain(1));
        assertTrue(filter.mightContain(2));
        assertTrue(filter.mightContain(3));
        assertTrue(filter.mightContain(3));
        assertTrue(filter.mightContain(1_000_000));
    }
}
