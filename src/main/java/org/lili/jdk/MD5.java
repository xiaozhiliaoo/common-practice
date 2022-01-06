package org.lili.jdk;

import com.google.common.collect.Maps;
import org.lili.okhttp.HttpUtils;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.HashMap;

/**
 * @author lili
 * @date 2021/9/15 17:25
 */
public class MD5 {
    public static String digest(String rawString) {
        return digest(rawString, "utf-8");
    }

    public static String digest(String rawString, String charset) {
        Charset cs = Charset.forName(charset);
        try {
            return compute(rawString, cs);
        } catch (Exception e) {
            return "";
        }
    }

    private static String compute(String inStr, Charset charset)
            throws Exception {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] md5Bytes = md5.digest(inStr.getBytes(charset));
        return toHexString(md5Bytes);
    }


    public static String toHexString(byte[] bytes) {
        StringBuffer hexValue = new StringBuffer();
        for (int i = 0; i < bytes.length; i++) {
            int val = ((int) bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
            hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }

    public static void main(String[] args) {
        long timeStamp = System.currentTimeMillis();
        HashMap<String, Object> header = Maps.newHashMap();
        header.put("version","v1");
        header.put("timestamp",timeStamp);
        header.put("appKey","");
        header.put("signature","22701e4bf74f58cdf8561f2c83d1dd53");

        HttpUtils.get("http://mm-easyds.inner.youdao.com/easy-data-api/course_data/internal/finance_alipay_bill?day=2021-09-14&serialNumber=2021091222001497901435377536");
        long time = timeStamp;
        String appSecret = "1f483b8d248a4a8889386bdd41623373";
        String signature = MD5.digest(appSecret + time);
        System.out.println(time);
        System.out.println(signature);
    }
}
