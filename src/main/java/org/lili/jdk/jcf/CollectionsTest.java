package org.lili.jdk.jcf;

import ch.qos.logback.core.db.dialect.H2Dialect;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lili
 * @date 2020/11/1 2:46
 * @see
 * @since
 */
public class CollectionsTest {
    @Test
    public void test() {
        List<Integer> objects = new ArrayList<>();

        Collections.sort(objects);

        Collections.sort(objects, Collections.reverseOrder());


        objects.sort(Comparator.reverseOrder());
    }


    @Test
    public void unmodifiableMap() {
        ConcurrentHashMap<String,String> a = new ConcurrentHashMap<>();
        a.put("1","2");
        a.put("11","2");
        a.put("12","2");
        a.put("13","2");
        Map<String, String> stringStringMap = Collections.unmodifiableMap(a);
        stringStringMap.entrySet().add(new Map.Entry<String, String>() {
            @Override
            public String getKey() {
                return "null1";
            }

            @Override
            public String getValue() {
                return "values-1";
            }

            @Override
            public String setValue(String value) {
                return "2222";
            }
        });
        stringStringMap.put("22","22");
        System.out.println(stringStringMap);
    }
}
