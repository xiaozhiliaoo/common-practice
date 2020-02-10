package org.lili.google.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.LinkedHashMultimap;
import org.junit.Test;

/**
 * @author lili
 * @date 2020/1/16 0:13
 * @description
 */
public class LinkedHashMultimapTest {
    @Test
    public void test() {
        LinkedHashMultimap multiMap = LinkedHashMultimap.create();
        multiMap.put("Bar","1");
        multiMap.put("Bar","2");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        multiMap.put("Bar","3");
        System.out.println(JSON.toJSONString(multiMap));
    }
}
