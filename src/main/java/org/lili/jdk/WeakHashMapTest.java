package org.lili.jdk;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author lili
 * @date 2020/8/17 22:33
 * @description
 * @notes
 */

public class WeakHashMapTest {
    @Test
    public void test() throws InterruptedException {
        //Case1:
        WeakHashMap<String,String> mapCase1 = new WeakHashMap<>();
        mapCase1.put("name", "Bob");
        System.gc();
        Thread.sleep(3000);
        System.out.println(mapCase1); //{name=Bob}
        //Case2:
        WeakHashMap<String,String> mapCase2 = new WeakHashMap<>();
        mapCase2.put(new String("name"), "Bob");
        System.gc();
        Thread.sleep(3000);
        System.out.println(mapCase2); //{}
        //Case3:
        WeakHashMap<String,String> mapCase3 = new WeakHashMap<>();
        String map3Key = new String("name");
        mapCase3.put(map3Key, "Bob");
        //map3Key= null;
        System.gc();
        Thread.sleep(3000);
        System.out.println(mapCase3); //{name=Bob}
    }

    class MyKey {
        public String toString() {
            return "key1";
        }
    }

    @Test
    public void test11() throws InterruptedException {
        MyKey myKey = new MyKey();
        WeakHashMap map = new WeakHashMap();
        map.put(myKey, "value");
        System.out.println(map);
        myKey = null;
        System.gc();
        Thread.sleep(3000);
        System.out.println(map);
    }

    @Test
    public void test11HhashMap() throws InterruptedException {
        MyKey myKey = new MyKey();
        HashMap map = new HashMap();
        map.put(myKey, "value");
        System.out.println(map);
        myKey = null;
        System.gc();
        Thread.sleep(3000);
        System.out.println(map);
    }


    @Test
    public void test2() {
        HashMap<String, String> map = new HashMap<>();
        String name = "name";
        map.put(name, "lili");
        assertTrue(map.containsKey("name"));
        name = null;
        System.out.println(map);
    }

    private static Map map;

    @Test
    public void test3() {
        map = new WeakHashMap();
        map.put(new String("Maine"), "Augusta");

        Runnable runner = new Runnable() {
            public void run() {
                while (map.containsKey("Maine")) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ignored) {
                    }
                    System.out.println("Thread waiting");
                    System.gc();
                }
            }
        };
        Thread t = new Thread(runner);
        t.start();
        System.out.println("Main waiting");
        try {
            t.join();
        } catch (InterruptedException ignored) {
        }

    }

}
