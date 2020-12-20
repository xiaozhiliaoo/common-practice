package org.lili.google.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.TreeMultimap;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/1/16 0:15
 * @description
 */
public class TreeMultimapTest {
    @Test
    public void test() {
        TreeMultimap multiMap  = TreeMultimap.create();
        multiMap.put("Zar","3");
        multiMap.put("Bar","2");
        multiMap.put("Bar","1");
        multiMap.put("Bar","1");
        multiMap.put("Bar","2");
        System.out.println(JSON.toJSONString(multiMap));
    }
}
