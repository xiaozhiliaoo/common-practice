package org.lili.jdk.jcf;

import org.junit.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author lili
 * @date 2020/10/31 16:01
 * @see
 * @since
 */
public class LinkedHashMapTest {
    @Test
    public void test() {
        LinkedHashMap<String,String> l = new LinkedHashMap<>();
        l.put("11","22");

        l.get("22");

    }
}
