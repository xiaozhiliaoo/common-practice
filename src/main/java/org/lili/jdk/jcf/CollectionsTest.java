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
        stringStringMap.put("22","22");
    }
}
