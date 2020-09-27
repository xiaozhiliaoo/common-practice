package org.lili.jdk.jcf;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/**
 * 理解通过接口创建对象
 *
 * @author lili
 * @date 2020/9/20 18:43
 * @notes
 */
public class MapTest {
    @Test
    public void test() {

        List<Integer> integers = JSONObject.parseObject("444", new TypeReference<List<Integer>>() {
        });


        //TreeMap
        Map<String, String> map = new TreeMap<>();
        AbstractMap<String, String> abstractMap = new TreeMap<>();
        SortedMap<String, String> sortedMap = new TreeMap<>();
        NavigableMap<String, String> navigableMap = new TreeMap<>();
        TreeMap<String, String> treeMap = new TreeMap<>();

        //ConcurrentSkipListMap
        Map<String, String> m = new ConcurrentSkipListMap<>();
        AbstractMap<String, String> am = new ConcurrentSkipListMap<>();
        SortedMap<String, String> sm = new ConcurrentSkipListMap<>();
        NavigableMap<String, String> nm = new ConcurrentSkipListMap<>();
        ConcurrentMap<String, String> cn = new ConcurrentSkipListMap<>();
        ConcurrentNavigableMap<String, String> cnm = new ConcurrentSkipListMap<>();
        ConcurrentSkipListMap<String, String> cslm = new ConcurrentSkipListMap<>();


        test((NavigableMap<String, String>) m);
    }

    public static void test(NavigableMap<String, String> map) {
        map.ceilingKey("333");
        System.out.println(map);
    }
}
