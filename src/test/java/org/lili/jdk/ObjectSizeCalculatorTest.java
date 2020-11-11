package org.lili.jdk;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author lili
 * @date 2020/1/16 13:57
 * @description
 */
public class ObjectSizeCalculatorTest {
    @Test
    public void test() {
        Map<String, String> obj = new HashMap<>();
        obj.put("1", "1");
        obj.put("2", "2");
//        System.out.println(ObjectSizeCalculator.getObjectSize(obj));

        Map<String, String> obj2 = new HashMap<>();
        obj2.put("1", "1");
        obj2.put("2", "2");
        ImmutableMap<Object, Object> build = ImmutableMap.builder().putAll(obj2).build();
//        System.out.println(ObjectSizeCalculator.getObjectSize(build));
        Map<String, String> objNUll = null;
//        System.out.println(ObjectSizeCalculator.getObjectSize(ImmutableMap.builder().putAll(objNUll)));

        Map<String, String> obj3 = new HashMap<>();
        obj3.put("1", "1");
        obj3.put("2", "2");
//        System.out.println(ObjectSizeCalculator.getObjectSize(Collections.unmodifiableMap(obj3)));

        System.out.println("=====================");
        Map<String, List<String>> objMap = new HashMap<>();
        Map<String, List<String>> objMap2 = Maps.newHashMap();
//        System.out.println(ObjectSizeCalculator.getObjectSize(objMap));
//        System.out.println(ObjectSizeCalculator.getObjectSize(objMap2));
        objMap.put("1", Lists.newArrayList("1", "2", "3"));
        objMap.put("2", Lists.newArrayList("1", "2", "3"));
        objMap2.put("1", Lists.newArrayList("1", "2", "3"));
        objMap2.put("2", Lists.newArrayList("1", "2", "3"));
//        System.out.println("普通map占用内存:"+ObjectSizeCalculator.getObjectSize(objMap));
//        System.out.println("Guava不可变map占用内存:"+ ObjectSizeCalculator.getObjectSize(new ImmutableMap.Builder<String, List<String>>().putAll(objMap2).build()));
//        System.out.println("JDK自带不可变map占用内存:"+ ObjectSizeCalculator.getObjectSize(Collections.unmodifiableMap(objMap2)));


        Map<String, String> map = new HashMap<>();
        map.put("1","1");
//        System.out.println(ObjectSizeCalculator.getObjectSize(map));
        Map<String, String> map2 = ImmutableMap.of("1", "1");
//        System.out.println(ObjectSizeCalculator.getObjectSize(map2));


        ImmutableMap.Builder<String, String> requestBuilder = new ImmutableMap.Builder<>();
        requestBuilder.put("1","1");
        requestBuilder.put("2","1");
//        System.out.println(ObjectSizeCalculator.getObjectSize(requestBuilder.build()));
        System.out.println(JSON.toJSONString(requestBuilder.build()));

        Map<String,String> maps = new HashMap<>();
        maps.put("1","1");
        maps.put("2","1");
//        System.out.println(ObjectSizeCalculator.getObjectSize(maps));


    }
}
