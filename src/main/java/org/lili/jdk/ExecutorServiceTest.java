package org.lili.jdk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import okhttp3.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;


/**
 * @author lili
 * @date 2020/4/14 19:57
 * @description
 * @notes
 */

public class ExecutorServiceTest {

    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build();

    @Test
    public void test() throws InterruptedException {
        Thread[] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new AnalogUser(i));
        }
        for (Thread thread : threads) {
            thread.start();
        }
        for (Thread thread : threads) {
            thread.join();
        }
        //防止主线程消失，而其他线程任务没执行完而退出
        //Thread.sleep(10000);
    }

    @Test
    public void testImmediatelyExit() {
        for (int i = 0; i < 10; i++) {
            new Thread(new AnalogUser(i)).start();
        }
        //直接结束，因为主线程退出了，jvm退出所有线程退出
    }

    private class AnalogUser implements Runnable {

        private int i;

        public AnalogUser(int i) {
            this.i=i;
        }

        @Override
        public void run() {
            long starTime = 0;
            try {
                starTime = System.currentTimeMillis();
                System.out.println("请求开始了"+i);
                JSONObject jsonObject = httpPost();
                System.out.println("返回的状态码为：" + jsonObject.get("code"));
                System.out.println("返回的状态信息：" + jsonObject.get("msg"));
                System.out.println("返回的内容为：" + jsonObject.get("data"));
            } catch (Exception e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            Long t = endTime - starTime;
            System.out.println(t / 1000F + "秒");
        }

        private JSONObject httpPost() {
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
                Response response = httpClient.newCall(request).execute();
                jsonObj = JSONObject.parseObject(response.body().string());
                System.out.println("返回：" + jsonObj.toJSONString());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return jsonObj;
        }
    }

    private JSONObject httpPost() {
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

            System.out.println("返回：" + jsonObj.toJSONString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return jsonObj;
    }

    @Test
    public void testSingle() {
        httpPost();
    }


}