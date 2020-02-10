package org.lili.google.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.HashMultimap;
import org.junit.Test;

/**
 * @author lili
 * @date 2020/1/15 23:54
 * @description
 */
public class HashMultimapTest {
    @Test
    public void test() {
        //similiar to Map<K,Collection<V>>
        HashMultimap<String, String> multiMap = HashMultimap.create();
        multiMap.put("Bar", "1");
        multiMap.put("Bar", "2");
        multiMap.put("Bar", "3");
        multiMap.put("Bar", "3");
        multiMap.put("Bar", "3");
        System.out.println(JSON.toJSONString(multiMap));
    }
}
