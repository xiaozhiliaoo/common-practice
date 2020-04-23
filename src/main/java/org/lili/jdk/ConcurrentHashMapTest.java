package org.lili.jdk;

import com.alibaba.fastjson.JSON;
import org.checkerframework.checker.units.qual.C;

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
    }
}
