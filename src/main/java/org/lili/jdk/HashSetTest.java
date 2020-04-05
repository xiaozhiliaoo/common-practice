package org.lili.jdk;

import com.google.common.base.Stopwatch;
import com.google.common.collect.Sets;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.SetUtils;
import org.junit.Test;

import static org.junit.Assert.*;

import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/4/5 11:54
 * @description 统计元素是否存在
 * @notes
 */
@Log4j2
public class HashSetTest {
    @Test
    public void test() {
        //缺少交并补功能，并且交并补功能效率不高
        HashSet set = new HashSet<>();

        //Collection4
        //SetUtils.difference();

        //Guava
        //Sets.union()

        Set<String> visitor = new HashSet<>();
        visitor.add("192.168.0.1");
        visitor.add("74.245.10.1");
        visitor.add("10.124.22.19");
        assertTrue(visitor.contains("10.124.22.19"));
        assertFalse(visitor.contains("99.999.99.99"));

        //BloomFilter 效率：hash函数个数，初始化大小
        BloomFilter<String> bloomFilterVisitor = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 10000);
        bloomFilterVisitor.put("192.168.0.1");
        bloomFilterVisitor.put("74.245.10.1");
        bloomFilterVisitor.put("10.124.22.19");
        assertTrue(bloomFilterVisitor.mightContain("192.168.0.1"));
        assertFalse(bloomFilterVisitor.mightContain("99.999.99.99"));

        int count = 10000000;
        Stopwatch stopwatch = Stopwatch.createStarted();
        Set<String> uuids = new HashSet<>();
        for (int i = 0; i < count; i++) {
            uuids.add(UUID.randomUUID().toString());
        }
        //heap占用很大,并且速度很慢
        log.info("uuids cost:{}ms, memory size:{}MB", stopwatch.elapsed(TimeUnit.MILLISECONDS), ObjectSizeCalculator.getObjectSize(uuids) / 1024 / 1024);

        BloomFilter<String> bloomFilteruuids = BloomFilter.create(Funnels.stringFunnel(Charset.forName("UTF-8")), 100000000);
        Stopwatch stopwatch2 = Stopwatch.createStarted();
        for (int i = 0; i < count; i++) {
            bloomFilteruuids.put(UUID.randomUUID().toString());
        }
        //size越大，速度比set快,占用内存比set小
        log.info("bloomFilteruuids cost:{}ms, memory size:{}MB", stopwatch2.elapsed(TimeUnit.MILLISECONDS), ObjectSizeCalculator.getObjectSize(bloomFilteruuids) / 1024 / 1024);

    }
}
