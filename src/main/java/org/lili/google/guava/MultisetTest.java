package org.lili.google.guava;

import com.clearspring.analytics.stream.frequency.CountMinSketch;
import com.google.common.base.Stopwatch;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author lili
 * @date 2020/4/5 16:11
 * @description 统计元素出现个数
 * @notes
 */
@Log4j2
public class MultisetTest {
    @Test
    public void test() {
        //HashBag， Map<String, Integer> counter = new HashMap<String, Integer>();
        Multiset<String> hits = HashMultiset.create();
        hits.add("192.169.0.1");
        hits.add("74.245.10.1");
        hits.add("10.124.22.19");
        hits.add("10.124.22.19");
        assertEquals(2,hits.count("10.124.22.19"));
        assertEquals(0,hits.count("99.99.999.99"));

        //epsilon, delta, random seed
        CountMinSketch cms = new CountMinSketch(0.001, 0.99, 1);
        cms.add("192.169.0.1",1);
        cms.add("74.245.10.1",1);
        cms.add("10.124.22.19",2);
        assertEquals(2,cms.estimateCount("10.124.22.19"));
        assertEquals(0,cms.estimateCount("99.99.999.99"));

        Multiset<String> uuids = HashMultiset.create();
        int count = 10000000;
        Stopwatch stopwatch = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            uuids.add(UUID.randomUUID().toString());
        }
        //heap占用很大,并且速度很慢
        log.info("uuids cost:{}ms, memory size:{}MB", stopwatch.elapsed(TimeUnit.MILLISECONDS), ObjectSizeCalculator.getObjectSize(uuids) / 1024 / 1024);

        //top 10,top visitor,word count,any kind of frequency tracking,NLP,heavy-hitters,range-query
        CountMinSketch cmsuuids = new CountMinSketch(0.001, 0.99, 1);
        Stopwatch stopwatch2 = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            cmsuuids.add(UUID.randomUUID().toString(),1);
        }
        //速度和内存取决于CountMinSketch参数配置
        log.info("cmsuuids cost:{}ms, memory size:{}MB", stopwatch2.elapsed(TimeUnit.MILLISECONDS), ObjectSizeCalculator.getObjectSize(cmsuuids) / 1024 / 1024);

    }
}
