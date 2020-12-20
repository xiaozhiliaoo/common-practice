package org.lili.pds;

import com.clearspring.analytics.stream.frequency.CountMinSketch;
import org.junit.jupiter.api.Test;

/**
 * 频率统计，不能删除，不能遍历，不能
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
        countMinSketch.add("lili", 500);
        countMinSketch.add("lili2", 3);
        long lili = countMinSketch.estimateCount("lili");
        if(lili > 3) {
            countMinSketch.add("lili",0);
        }
        System.out.println(lili);
        System.out.println("lili:"+countMinSketch.estimateCount("lili"));
        System.out.println(countMinSketch.estimateCount("lili2"));
        System.out.println(countMinSketch.estimateCount("lili3"));

        System.out.println(countMinSketch.toString());

    }
}
