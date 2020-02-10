package org.lili.google.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.LinkedListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author lili
 * @date 2020/1/15 23:47
 * @description
 */
public class ArrayListMultimapTest {
    @Test
    public void testArrayListMultiMap() {
        ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("Foo", "1");
        multiMap.put("Foo", "2");
        multiMap.put("Foo", "3");
        System.out.println(JSON.toJSONString(multiMap));
        List<String> expected = Lists.newArrayList("1", "2", "3");
        List<String> strings = multiMap.get("Foo");
        assertEquals(strings, expected);
    }


    @Test
    public void testArrayListMultimapDifferentKeyValue() {
        ArrayListMultimap<String, String> multiMap = ArrayListMultimap.create();
        multiMap.put("Bar", "1");
        multiMap.put("Bar", "2");
        multiMap.put("Foo", "1");
        multiMap.put("Foo", "2");
        multiMap.put("Foo", "3");

        Map<String, ArrayList<String>> expectedMap = new HashMap<>();
        expectedMap.put("Bar", Lists.newArrayList("1", "2"));
        expectedMap.put("Foo", Lists.newArrayList("1", "2", "3"));

        assertEquals(JSON.toJSONString(multiMap), JSON.toJSONString(expectedMap));
        assertNotEquals(expectedMap, multiMap);

        Map<String, Collection<String>> convertToMap = multiMap.asMap();
        assertEquals(expectedMap, convertToMap);

        Collection<String> expected = Lists.newArrayList("1", "2", "1", "2", "3");
        Collection<String> values = multiMap.values();
        assertNotEquals(expected, values);
        assertEquals(expected.toString(), values.toString());

    }
}
