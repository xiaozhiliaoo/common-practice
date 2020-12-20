package org.lili.jdk.jcf;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

/**
 * @author lili
 * @date 2020/12/3 14:35
 * @notes
 */
public class TreeMapTest {

    @Test
    public void test() {
        TreeMap<String, String> defaultAuthHeaders = new TreeMap<>();
        defaultAuthHeaders.put("app_id", "appId");
        defaultAuthHeaders.put("nonce", "nonceValue");
        defaultAuthHeaders.put("signature_method", "signatureMethod");
        defaultAuthHeaders.put("timestamp", "timestamp");
        System.out.println(defaultAuthHeaders);
    }

}
