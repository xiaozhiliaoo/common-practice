package org.lili.okhttp;

import okhttp3.*;
import org.apache.commons.io.FilenameUtils;
import org.junit.Test;

import java.io.File;

/**
 * @author lili
 * @date 2020/12/15 19:31
 */
public class OkHttpTest {


    @Test
    public void test() throws Exception {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        String string = com.google.common.net.MediaType.JPEG.toString();
        System.out.println(string);
        File file = new File("/C:/Users/chao/Desktop/agile-approach-to-legacy-systems.pdf");
        System.out.println(FilenameUtils.getExtension(file.getName()));
        System.out.println(file);


        MediaType parse = MediaType.parse("image/jpg");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("category", "identification")
                .addFormDataPart("type", "others")
                .addFormDataPart("file", "/C:/Users/chao/Desktop/agile-approach-to-legacy-systems.pdf",
                        RequestBody.create(parse, file))
                .build();
        Request request = new Request.Builder()
                .url("https://sandbox-api.propine.com/v1/onboarding/individuals/0356c8fd-ea9f-42ee-99fb-8ea1419fc62f/document")
                .method("POST", body)
                .addHeader("authorization", "82d20a72-d720-49a8-babd-76b046b4beba")
                .addHeader("Cookie", "AWSALB=8rKoKrgkgKEZ9CuzEEPlag/2azYbU1w83NtVQ2DscATOCuC+wbD0FWIwhn6XwgGjj4FRcOfcqB3BfOxBQJGiS0n3wfROtEGwBZksB9lkHfqjjLKi5NqHNbBhq21q; AWSALBCORS=8rKoKrgkgKEZ9CuzEEPlag/2azYbU1w83NtVQ2DscATOCuC+wbD0FWIwhn6XwgGjj4FRcOfcqB3BfOxBQJGiS0n3wfROtEGwBZksB9lkHfqjjLKi5NqHNbBhq21q")
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }
}
