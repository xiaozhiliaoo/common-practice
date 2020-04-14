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
    @OperationsPerInvocation(3)
    @Threads(5)
    public JSONObject httpPost() {
        OkHttpClient client = new OkHttpClient();

        String url = "http://localhost:9666/finance/get_charge_address";
        HashMap<String, Object> dataMap = new HashMap<String, Object>();
        dataMap.put("symbol", "eth");
        String jsonStr = JSON.toJSONString(dataMap);
        System.out.println("参数：" + jsonStr);
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, jsonStr);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        JSONObject jsonObj = null;
        try {
            Response response = client.newCall(request).execute();
            jsonObj = JSONObject.parseObject(response.body().string());
//			if("200".equals(jsonObj.get("code"))) {
//				System.out.println(jsonObj.get("message"));
//			}
            System.out.println("返回：" + jsonObj.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(StressTest.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(5)
                .build();
        new Runner(opt).run();
    }
}
