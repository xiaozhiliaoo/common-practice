package org.lili.okhttp;

import okhttp3.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 基于okhttp的工具类
 *
 * @author lili
 */
public class HttpUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpUtils.class);

    /**
     * 禁止实例化
     */
    private HttpUtils() {
        throw new AssertionError("No com.chainup.common.util.HttpUtils instances for you!");
    }

    /**
     * requestBody默认media type
     */
    private static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    /**
     * http请求没有结果或者异常
     */
    private static final String NO_RESULT = "";

    /**
     * http请求路径为http
     */
    private static final String HTTP_PREFIX = "http://";

    /**
     * http请求路径为https
     */
    private static final String HTTPS_PREFIX = "https://";

    private static final int TIME_OUT = 30;

    /**
     * okhttp client:预先实例化
     */
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
            .readTimeout(TIME_OUT, TimeUnit.SECONDS)
            .writeTimeout(TIME_OUT, TimeUnit.SECONDS)
            .build();


    /**
     * 带header的get方法
     *
     * @param url     url
     * @param headMap header的值
     * @return 请求结果
     */
    public static String getWithHead(String url, Map<String, String> headMap) {
        Headers headers = Headers.of(headMap);
        Request request = new Request.Builder()
                .url(url)
                .headers(headers)
                .build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            return response.body().string();
        } catch (Exception e) {
            LOGGER.error("getWithHead error:{},url:{},headMap:{}", e, url, headMap);
        }
        return NO_RESULT;
    }

    /**
     * 三方在Header中传递X-Api-Key参数
     *
     * @param url
     * @param headerMap
     * @param payload
     * @return 请求结果
     */
    public static String postWithHeaders(String url, Map<String, String> headerMap, String payload, String apiKey) {
        RequestBody body = RequestBody.create(JSON, payload == null ? "" : payload);
        return postHeaders(url, headerMap, body, apiKey);
    }

    /**
     * post+header+payload
     *
     * @param url       请求url
     * @param headerMap header信息
     * @param payload   payload
     * @return 请求结果
     */
    public static String postWithHead(String url, Map<String, String> headerMap, String payload) {
        RequestBody body = RequestBody.create(JSON, payload == null ? "" : payload);
        return post(url, headerMap, body);
    }

    /**
     * put+header+payload
     *
     * @param url       请求url
     * @param headerMap header信息
     * @param payload   payload
     * @return 请求结果
     */
    public static String putWithHead(String url, Map<String, String> headerMap, String payload) {
        RequestBody body = RequestBody.create(JSON, payload == null ? "" : payload);
        return put(url, headerMap, body);
    }


    /**
     * 通过post上传文件
     *
     * @param url       请求url
     * @param headerMap header信息
     * @param file      上传的文件
     * @param fileName  文件名字
     * @param paramMap  请求参数
     * @param mediaType mime-type https://en.wikipedia.org/wiki/Media_type
     * @return 请求结果
     * @apiNote 上传文件而不是文件流
     */
    public static String postWithFile(String url, Map<String, String> headerMap, File file, String fileName,
                                      Map<String, String> paramMap, String mediaType) {

        MultipartBody.Builder bodyBuilder = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("file",
                        fileName,
                        RequestBody.create(MediaType.parse(mediaType), file));
        paramMap.forEach(bodyBuilder::addFormDataPart);
        MultipartBody multipartBody = bodyBuilder.build();


        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(multipartBody);
        if (headerMap != null) {
            headerMap.forEach(builder::header);
        }
        Request request = builder.build();

        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                return body == null ? "" : body.string();
            } else {
                ResponseBody body = response.body();
                return body == null ? response.message() : body.string();
            }
        } catch (Exception e) {
            LOGGER.error("postWithFile url:{},headerMap:{},error:{}", url, headerMap, e);
        }
        return "";
    }

    public static String postWithHead(String url, Map<String, String> headerMap, Map<String, String> paramMap) {
        FormBody.Builder builder = new FormBody.Builder();
        paramMap.forEach(builder::add);
        RequestBody body = builder.build();
        return post(url, headerMap, body);
    }

    public static String putWithHead(String url, Map<String, String> headerMap, Map<String, String> paramMap) {
        FormBody.Builder builder = new FormBody.Builder();
        paramMap.forEach(builder::add);
        RequestBody body = builder.build();
        Request.Builder builder2 = new Request.Builder()
                .url(url)
                .put(body);
        if (headerMap != null) {
            headerMap.forEach(builder2::header);
        }

        Request request = builder2.build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody body1 = response.body();
                return body1 == null ? "" : body1.string();
            } else {
                ResponseBody body1 = response.body();
                return body1 == null ? response.message() : body1.string();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    private static String put(String url, Map<String, String> headerMap, RequestBody formBody) {

        Request.Builder builder = new Request.Builder()
                .url(url)
                .put(formBody);
        if (headerMap != null) {
            headerMap.forEach(builder::header);
        }

        Request request = builder.build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                return body == null ? "" : body.string();
            } else {
                ResponseBody body = response.body();
                return body == null ? response.message() : body.string();
            }
        } catch (Exception e) {
            LOGGER.error("put error url:{},headerMap:{},body:{},error:{}", url, headerMap, formBody, e);
        }
        return "";
    }

    private static String post(String url, Map<String, String> headerMap, RequestBody formBody) {

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(formBody);
        if (headerMap != null) {
            headerMap.forEach(builder::header);
        }

        Request request = builder.build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                return body == null ? "" : body.string();
            } else {
                ResponseBody body = response.body();
                return body == null ? response.message() : body.string();
            }
        } catch (Exception e) {
            LOGGER.error("post error url:{},headerMap:{},body:{},error:{}", url, headerMap, formBody, e);
        }
        return "";
    }

    /**
     * headers 传递参数
     * API key
     *
     * @param url
     * @param headerMap
     * @param formBody
     * @return
     */
    private static String postHeaders(String url, Map<String, String> headerMap, RequestBody formBody, String apiKey) {

        Request.Builder builder = new Request.Builder()
                .url(url)
                .addHeader("X-Api-Key", apiKey)
                .post(formBody);
        if (headerMap != null) {
            headerMap.forEach(builder::header);
        }

        Request request = builder.build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody body = response.body();
                return body == null ? "" : body.string();
            } else {
                ResponseBody body = response.body();
                return body == null ? response.message() : body.string();
            }
        } catch (Exception e) {
            LOGGER.error("post error url:{},headerMap:{},body:{},error:{}", url, headerMap, formBody, e);
        }
        return "";
    }

    public static String get(String url, Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        if (url.startsWith(HTTP_PREFIX) || url.startsWith(HTTPS_PREFIX)) {
            sb.append(url).append("?");
        } else {
            sb.append(HTTP_PREFIX).append(url).append("?");
        }
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        String url0 = sb.deleteCharAt(sb.length() - 1).toString();
        return get(url0);
    }

    public static String get(String url) {
        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        try {
            Response response = HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                ResponseBody body = response.body();
                return body == null ? response.message() : body.string();
            }
        } catch (IOException e) {
            LOGGER.error("get error url:{},error:{}", url, e);
        }
        return null;
    }


    /**
     * @return java.lang.String
     * @author renwei
     * Description  GET请求，带header
     * Date 2020-04-20
     * Param [url, params, headers]
     **/
    public static String get(String url, Map<String, String> params, Map<String, String> headers) {
        StringBuilder sb = new StringBuilder();
        if (url.startsWith(HTTP_PREFIX) || url.startsWith(HTTPS_PREFIX)) {
            sb.append(url).append("?");
        } else {
            sb.append(HTTP_PREFIX).append(url).append("?");
        }
        if (params != null && !params.isEmpty()) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                sb.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
            }
        }
        url = sb.deleteCharAt(sb.length() - 1).toString();
        Request.Builder builder = new Request.Builder()
                .url(url)
                .get();
        if (headers != null) {
            headers.forEach(builder::header);
        }
        Request request = builder.build();
        try {
            Response response = HTTP_CLIENT.newCall(request).execute();
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                ResponseBody body = response.body();
                return body == null ? response.message() : body.string();
            }
        } catch (IOException e) {
            LOGGER.error("get error url:{},error:{}", url, e);
        }
        return null;
    }

    /**
     *
     * @param url 请求地址
     * @param json json字符串请求参数
     * @return
     * @throws IOException
     */
    public static String postJson(String url, String json, Map<String, String> headerMap){
        RequestBody body = RequestBody.create(JSON, json);

        Request.Builder builder = new Request.Builder()
                .url(url)
                .post(body);
        if (headerMap != null) {
            headerMap.forEach(builder::header);
        }
        Request request = builder.build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                return body == null ? "" : responseBody.string();
            } else {
                ResponseBody responseBody = response.body();
                return body == null ? response.message() : responseBody.string();
            }
        } catch (Exception e) {
            LOGGER.error("post error url:{},headerMap:{},body:{},error:{}", url, headerMap, json, e);
        }
        return "";
    }
}
