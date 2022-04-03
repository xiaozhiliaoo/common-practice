package org.lili.google.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lili
 * @date 2020/1/9 11:04
 * @description
 */
public class BiMapTest {

    @Test
    void testMap() {
        Map<String,String> maps = new HashMap<>();
        maps.put("1","2");
        maps.put("3","6");
        HashBiMap<String, String> m = HashBiMap.create(maps);
        System.out.println(m.inverse().get("6"));
        System.out.println(m);
    }


    public static void main(String[] args) {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        biMap.forcePut("2","Tom");
        biMap.put("3","LiLi");
        System.out.println(biMap);
        System.out.println(biMap.get("LiLi"));
    }
}
