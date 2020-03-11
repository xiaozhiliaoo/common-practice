package org.lili.latencyutils;

import org.HdrHistogram.Histogram;
import org.LatencyUtils.LatencyStats;

import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/3/4 22:26
 * @description
 * @notes
 */

public class Main {
    public static void main(String[] args) throws InterruptedException {
        LatencyStats myOpStats = new LatencyStats();
        long startTime = System.nanoTime();
        // Perform operation:
        TimeUnit.SECONDS.sleep(10);
        // Record operation latency:
        myOpStats.recordLatency(System.nanoTime() - startTime);


        // Later, report on stats collected:
        Histogram intervalHistogram = myOpStats.getIntervalHistogram();

        System.out.println(intervalHistogram.getHighestTrackableValue());
    }
}
