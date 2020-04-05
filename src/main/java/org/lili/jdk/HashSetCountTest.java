package org.lili.jdk;

import com.clearspring.analytics.stream.cardinality.HyperLogLog;
import com.google.common.base.Stopwatch;
import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author lili
 * @date 2020/4/5 16:35
 * @description 统计元素不重复个数
 * @notes
 */
@Log4j2
public class HashSetCountTest {
    @Test
    public void test() {
        //cardiality
        Set<String> visitor = new HashSet<>();
        visitor.add("192.168.0.1");
        visitor.add("74.245.10.1");
        visitor.add("10.124.22.19");
        visitor.add("10.124.22.19");
        visitor.add("10.124.22.19");
        assertEquals(3, visitor.size());

        int count = 10000000;
        Stopwatch stopwatch = Stopwatch.createStarted();
        Set<String> uuids = new HashSet<>();
        for (int i = 0; i < count; i++) {
            uuids.add(UUID.randomUUID().toString());
        }
        //heap占用很大,并且速度很慢
        log.info("uuids cost:{}ms, memory size:{}MB,size:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS), ObjectSizeCalculator.getObjectSize(uuids) / 1024 / 1024, uuids.size());


        HyperLogLog hyperLogLoguuids = new HyperLogLog(0.003);
        for (int i = 0; i < count; i++) {
            hyperLogLoguuids.offer(UUID.randomUUID().toString());
        }
        log.info("hyperLogLoguuids cost:{}ms, memory size:{}MB,size:{}", stopwatch.elapsed(TimeUnit.MILLISECONDS), ObjectSizeCalculator.getObjectSize(hyperLogLoguuids) / 1024 / 1024, hyperLogLoguuids.cardinality());
        //Redis PFADD PFCOUNT
    }
}
