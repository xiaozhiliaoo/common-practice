package org.lili.apache.collections4;

import org.apache.commons.collections4.Factory;
import org.apache.commons.collections4.map.LazyMap;
import org.eclipse.collections.impl.bimap.mutable.HashBiMap;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

public class LazyMapTest {
    @Test
    public void test() {
        LazyMap<String, String> map = LazyMap.lazyMap(new HashMap<>(), new Factory<String>() {
            @Override
            public String create() {
                return "lili";
            }
        });

        map.put("ali","222");
        map.get("alli");

        System.out.println(map);
    }
}
