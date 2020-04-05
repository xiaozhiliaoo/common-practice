package org.lili.pds;

import com.clearspring.analytics.stream.cardinality.HyperLogLogPlus;
import com.clearspring.analytics.util.TopK;
import org.junit.Test;

/**
 * @author lili
 * @date 2020/4/5 21:58
 * @description
 * @notes
 */

public class HyperLogLogPlusTest {
    @Test
    public void test() {
        long count = 0;
        HyperLogLogPlus card = new HyperLogLogPlus(14, 25);
        card.offer("foo");
        card.offer("foo");
        card.offer("foo");
        card.offer("bar");
        card.offer("bar");
        System.out.println(formatSummary(count, card.cardinality()));
    }

    protected static String formatSummary(long count, long cardinality) {
        String cntStr = Long.toString(count);
        int len = cntStr.length();
        int l1 = Math.max(len, 10);
        int l2 = Math.max(len, 20);
        String fmt = "%" + l1 + "s %" + l2 + "s";
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(fmt, "Item Count", "Cardinality Estimate")).append('\n');
        sb.append(String.format(fmt, TopK.string('-', l1), TopK.string('-', l2))).append('\n');
        sb.append(String.format(fmt, count, cardinality)).append('\n');
        return sb.toString();
    }
}
