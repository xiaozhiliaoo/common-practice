package org.lili.pds;

import com.clearspring.analytics.stream.Counter;
import com.clearspring.analytics.stream.StreamSummary;
import org.junit.Test;

import java.util.List;

/**
 * @author lili
 * @date 2020/4/5 21:53
 * @description
 * @notes
 */

public class TopKTest {
    @Test
    public void test() {
        long updateRate = -1;
        long count = 0;
        int capacity = 1000;

        StreamSummary<String> topkElement = new StreamSummary<String>(capacity);
        topkElement.offer("foo");
        topkElement.offer("foo");
        topkElement.offer("foo");
        topkElement.offer("bar");
        topkElement.offer("bar");
        System.out.println(formatSummary(topkElement));

    }
    public static String formatSummary(StreamSummary<String> topk) {
        StringBuilder sb = new StringBuilder();

        List<Counter<String>> counters = topk.topK(topk.getCapacity());
        String itemHeader = "item";
        String countHeader = "count";
        String errorHeader = "error";

        int maxItemLen = itemHeader.length();
        int maxCountLen = countHeader.length();
        int maxErrorLen = errorHeader.length();

        for (Counter<String> counter : counters) {
            maxItemLen = Math.max(counter.getItem().length(), maxItemLen);
            maxCountLen = Math.max(Long.toString(counter.getCount()).length(), maxCountLen);
            maxErrorLen = Math.max(Long.toString(counter.getError()).length(), maxErrorLen);
        }

        sb.append(String.format("%" + maxItemLen + "s %" + maxCountLen + "s %" + maxErrorLen + "s", itemHeader, countHeader, errorHeader));
        sb.append('\n');
        sb.append(String.format("%" + maxItemLen + "s %" + maxCountLen + "s %" + maxErrorLen + "s", string('-', maxItemLen), string('-', maxCountLen), string('-', maxErrorLen)));
        sb.append('\n');

        for (Counter<String> counter : counters) {
            sb.append(String.format("%" + maxItemLen + "s %" + maxCountLen + "d %" + maxErrorLen + "d", counter.getItem(), counter.getCount(), counter.getError()));
            sb.append('\n');
        }

        return sb.toString();
    }

    public static String string(char c, int len) {
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++) {
            sb.append(c);
        }
        return sb.toString();
    }

}
