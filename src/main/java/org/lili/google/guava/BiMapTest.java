package org.lili.google.guava;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * @author lili
 * @date 2020/1/9 11:04
 * @description
 */
public class BiMapTest {
    public static void main(String[] args) {
        BiMap<String,String> biMap = HashBiMap.create();
        biMap.put("1","Tom");
        biMap.forcePut("2","Tom");
        biMap.put("3","LiLi");
        System.out.println(biMap);
        System.out.println(biMap.get("LiLi"));
    }
}
