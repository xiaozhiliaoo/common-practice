package org.lili.pds;

import com.clearspring.analytics.stream.frequency.CountMinSketch;
import org.junit.Test;

/**
 * 频率统计
 *
 * @author lili
 * @date 2020/9/9 18:21
 * @description
 * @notes
 */
public class CountMinSketchTest {
    @Test
    public void test() {
        CountMinSketch countMinSketch = new CountMinSketch(0.001, 0.99, 1);
        countMinSketch.add("lili", 1);
        countMinSketch.add("lili", 1);
        countMinSketch.add("lili", 1);
        countMinSketch.add("lili2", 3);
        System.out.println(countMinSketch.estimateCount("lili"));
        System.out.println(countMinSketch.estimateCount("lili2"));
        System.out.println(countMinSketch.estimateCount("lili3"));
    }
}
