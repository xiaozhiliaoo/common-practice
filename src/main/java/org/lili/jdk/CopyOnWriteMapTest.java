package org.lili.jdk;

import org.apache.commons.lang3.ObjectUtils;
import org.elasticsearch.common.collect.CopyOnWriteHashMap;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @author lili
 * @date 2020/9/16 19:31
 * @notes
 */
public class CopyOnWriteMapTest {


    @Test
    public void test03() {
        Map<String, Object> cwMap = new HashMap<String, Object>();
        cwMap.put("name", "lisi");
        cwMap.put("age", 18);
        cwMap.put("level", "middle-school");
        cwMap.put("addr", "首农南海中心");
        cwMap.put("emotion", "single");
        cwMap.put("name1", "lisi");
        cwMap.put("age1", 18);
        cwMap.put("level1", "middle-school");
        cwMap.put("addr1", "首农南海中心");
        cwMap.put("emotion1", "single");

        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                CopyOnWriteHashMap<String, Object> copyOf = CopyOnWriteHashMap.copyOf(cwMap);
                Set<Map.Entry<String, Object>> entrySet1 = copyOf.entrySet();
                Iterator<Map.Entry<String, Object>> iterator1 = entrySet1.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry<String, Object> next = iterator1.next();
                    if ("addr1".equals(next.getKey())) {
                        Object value = next.getValue();
                        System.out.println(Thread.currentThread().getName() + ":" + value);
                        copyOf.copyAndPut("addr2", "123");
                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {

            @Override
            public void run() {
                CopyOnWriteHashMap<String, Object> copyOf = CopyOnWriteHashMap.copyOf(cwMap);
                Set<Map.Entry<String, Object>> entrySet1 = copyOf.entrySet();
                Iterator<Map.Entry<String, Object>> iterator1 = entrySet1.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry<String, Object> next = iterator1.next();
                    Object value = next.getValue();
                    System.out.println(Thread.currentThread().getName() + ":" + value);
                }
            }
        });

        th1.start();
        th2.start();
    }

    @Test
    public void test04() {
        Map<String, Object> cwMap = new HashMap<String, Object>();
        cwMap.put("name", "lisi");
        cwMap.put("age", 18);
        cwMap.put("level", "middle-school");
        cwMap.put("addr", "首农南海中心");
        cwMap.put("emotion", "single");
        cwMap.put("name1", "lisi");
        cwMap.put("age1", 18);
        cwMap.put("level1", "middle-school");
        cwMap.put("addr1", "首农南海中心");
        cwMap.put("emotion1", "single");

        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                Map<String, Object> copyOf = ObjectUtils.cloneIfPossible(cwMap);
                Set<Map.Entry<String, Object>> entrySet1 = copyOf.entrySet();
                Iterator<Map.Entry<String, Object>> iterator1 = entrySet1.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry<String, Object> next = iterator1.next();
                    if ("addr1".equals(next.getKey())) {
                        Object value = next.getValue();
                        System.out.println(Thread.currentThread().getName() + ":" + value);
                        copyOf.put("addr2", "123");
                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {

            @Override
            public void run() {
                Map<String, Object> copyOf = ObjectUtils.cloneIfPossible(cwMap);
                Set<Map.Entry<String, Object>> entrySet1 = copyOf.entrySet();
                Iterator<Map.Entry<String, Object>> iterator1 = entrySet1.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry<String, Object> next = iterator1.next();
                    Object value = next.getValue();
                    System.out.println(Thread.currentThread().getName() + ":" + value);
                }
            }
        });

        th1.start();
        th2.start();
    }

    @Test
    public void test05() {
        Map<String, Object> cwMap = new HashMap<String, Object>();
        cwMap.put("name", "lisi");
        cwMap.put("age", 18);
        cwMap.put("level", "middle-school");
        cwMap.put("addr", "首农南海中心");
        cwMap.put("emotion", "single");
        cwMap.put("name1", "lisi");
        cwMap.put("age1", 18);
        cwMap.put("level1", "middle-school");
        cwMap.put("addr1", "首农南海中心");
        cwMap.put("emotion1", "single");

        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {
                Map<String, Object> copyOf = ObjectUtils.cloneIfPossible(cwMap);
                Set<Map.Entry<String, Object>> entrySet1 = copyOf.entrySet();
                Iterator<Map.Entry<String, Object>> iterator1 = entrySet1.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry<String, Object> next = iterator1.next();
                    if ("addr1".equals(next.getKey())) {
                        Object value = next.getValue();
                        System.out.println(Thread.currentThread().getName() + ":" + value);
                        copyOf.put("addr2", "123");
                    }
                }
            }
        });

        Thread th2 = new Thread(new Runnable() {

            @Override
            public void run() {
                Map<String, Object> copyOf = ObjectUtils.cloneIfPossible(cwMap);
                Set<Map.Entry<String, Object>> entrySet1 = copyOf.entrySet();
                Iterator<Map.Entry<String, Object>> iterator1 = entrySet1.iterator();
                while (iterator1.hasNext()) {
                    Map.Entry<String, Object> next = iterator1.next();
                    Object value = next.getValue();
                    System.out.println(Thread.currentThread().getName() + ":" + value);
                }
            }
        });

        th1.start();
        th2.start();
    }
}
