package org.lili.jdk;

import com.alibaba.fastjson.JSON;
import org.checkerframework.checker.units.qual.C;
import org.junit.Test;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lili
 * @date 2020/4/22 14:15
 * @description
 * @notes
 */

public class ConcurrentHashMapTest {
    public static void main(String[] args) {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap();
        System.out.println(map.computeIfAbsent("lili", k -> k+"eeeelili"));
        System.out.println(map.computeIfAbsent("lili", k -> "eeeelili2"));
        System.out.println(map.computeIfAbsent("lili2", k -> "eeee2"));
        System.out.println(map.computeIfAbsent("lili2", k -> "eeee2"));
        System.out.println(map.computeIfAbsent("lili2", k -> "eeee2"));
        System.out.println(JSON.toJSONString(map));

        ConcurrentHashMap.KeySetView<String, String> view = map.keySet();

        Set<Map.Entry<String, String>> entries = map.entrySet();
        Collection<String> values = map.values();
        Enumeration<String> keys = map.keys();
        Enumeration<String> elements = map.elements();


    }

    @Test
    public void test() {
        ConcurrentHashMap<String,String> map = new ConcurrentHashMap<>(15,0.75f,8);
        String alibaba = map.get("alibaba");
        String put = map.put("alibaba", "idst");
    }
}
