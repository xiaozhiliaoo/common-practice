package org.lili.pds;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import org.junit.Test;

/**
 * @author lili
 * @date 2020/12/10 13:50
 * @notes
 */
public class HashMultisetTest {

    private static final Multiset<String> API_METRICS = HashMultiset.create();
    ;


    @Test
    public void test() {
        API_METRICS.add("aaaa");
        API_METRICS.add("aaaa");
        API_METRICS.add("aaaa");
        API_METRICS.add("aaaa");
        API_METRICS.add("aaaa");
        API_METRICS.add("aaaab");
        API_METRICS.add("aaaab");
        API_METRICS.add("aaaab");
        API_METRICS.add("aaaab");
        API_METRICS.add("aaaab");
        API_METRICS.add("aaaab");
        API_METRICS.add("aaaav");
        API_METRICS.add("aaaav");
        for (Multiset.Entry<String> stringEntry : API_METRICS.entrySet()) {
            System.out.println(stringEntry.getElement() + "----" + stringEntry.getCount());
        }
        System.out.println(API_METRICS.size());
        API_METRICS.clear();
        System.out.println(API_METRICS);
    }
}
