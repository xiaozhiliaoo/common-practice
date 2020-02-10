package org.lili.google.guava.collect;

import com.google.common.collect.BiMap;
import com.google.common.collect.EnumHashBiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.ImmutableBiMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lili
 * @date 2020/1/16 21:00
 * @description use instead of maintaining two separate map
 */

class MyEnum {
}

public class BiMapTest {
    @Test
    public void test() {
        BiMap<String, String> capitalCountryBiMap = HashBiMap.create();
        capitalCountryBiMap.put("lili","lili2");
        capitalCountryBiMap.put("jiandan","jiandan2");
        //BiMap<MyEnum, String> operationStringBiMap = EnumHashBiMap.create(MyEnum.class);
        ImmutableBiMap<Object, Object> build = ImmutableBiMap.builder().put("new delhi", "India").build();
    }

    @Test
    public void givenBiMap_whenQueryByValue_shouldReturnKey() {
        BiMap<String, String> capitalCountryBiMap = HashBiMap.create();
        capitalCountryBiMap.put("New Delhi", "India");
        capitalCountryBiMap.put("Washington, D.C.", "USA");
        capitalCountryBiMap.put("Moscow", "Russia");
        String keyFromBiMap = capitalCountryBiMap.inverse().get("Russia");
        String valueFromBiMap = capitalCountryBiMap.get("Washington, D.C.");
        assertEquals("Moscow", keyFromBiMap);
        assertEquals("USA", valueFromBiMap);
    }

    @Test(expected = IllegalArgumentException.class)
    public void givenBiMap_whenSameValueIsPresent_shouldThrowException() {
        BiMap<String, String> capitalCountryBiMap = HashBiMap.create();
        capitalCountryBiMap.put("Mumbai", "India");
        capitalCountryBiMap.put("Washington, D.C.", "USA");
        capitalCountryBiMap.put("Moscow", "Russia");
        capitalCountryBiMap.put("New Delhi", "India");
    }

    @Test
    public void givenSameValueIsPresent_whenForceput_completesSuccessfully() {
        BiMap<String, String> capitalCountryBiMap = HashBiMap.create();
        capitalCountryBiMap.put("Mumbai", "India");
        capitalCountryBiMap.put("Washington, D.C.", "USA");
        capitalCountryBiMap.put("Moscow", "Russia");
        capitalCountryBiMap.forcePut("New Delhi", "India");
        assertEquals("USA", capitalCountryBiMap.get("Washington, D.C."));
        assertEquals("Washington, D.C.", capitalCountryBiMap.inverse().get("USA"));
    }




}
