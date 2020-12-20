package org.lili.google.guava.collect;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


/**
 * @author lili
 * @date 2020/1/16 20:43
 * @description
 */
public class MultiSetTest {
    @Test
    public void testMultiSet() {
        //simlar to Map<E,count>
        Multiset<String> bookStore = HashMultiset.create();
        bookStore.add("Potter");
        bookStore.add("Potter");
        bookStore.add("Potter");
        bookStore.add("Potter2");
        bookStore.add("Potter2");
        assertTrue(bookStore.contains("Potter"));
        assertEquals(3, bookStore.count("Potter"));
        assertEquals(2, bookStore.count("Potter2"));

        bookStore.setCount("Java", 50);
        assertEquals(50, bookStore.count("Java"));

    }

    public void test() {
        Multiset<Object> multiset = HashMultiset.create();
        multiset.setCount("Potter", -1);
    }
}
