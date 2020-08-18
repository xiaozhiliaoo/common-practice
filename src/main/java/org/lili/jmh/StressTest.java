package org.lili.jmh;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.OperationsPerInvocation;
import org.openjdk.jmh.annotations.Threads;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.HashMap;

/**
 * @author lili
 * @date 2020/4/14 19:45
 * @description
 * @notes
 */
public class StressTest {

    @Benchmark
    @OperationsPerInvocation(1)
    @Threads(1)
    public void httpPost() {
        System.out.println("1111");
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StressTest.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(1)
                .build();
        new Runner(opt).run();
    }
}
