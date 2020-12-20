package org.lili.google.guava;

import com.google.common.collect.MapMaker;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentMap;

/**
 * @author lili
 * @date 2020/8/17 23:25
 * @description
 * @notes
 */

public class MapMakerTest {
    @Test
    public void testWeakKeyHardValue() throws InterruptedException {
        ConcurrentMap<String, String> map = new MapMaker().weakKeys().makeMap();
        map.put(new String("lili"), "lili");
        System.gc();
        Thread.sleep(3000);
        System.out.println(map); //{}
    }

    @Test
    public void testWeakValues() throws InterruptedException {
        ConcurrentMap<String, String> map = new MapMaker().weakValues().makeMap();
        map.put("lili", new String("lili"));
        System.gc();
        Thread.sleep(3000);
        System.out.println(map);//{}
    }


    @Test
    public void testWeakKeysValues() throws InterruptedException {
        ConcurrentMap<String, String> map = new MapMaker().weakKeys().weakValues().makeMap();
        map.put(new String("lili"), "lili");
        System.gc();
        Thread.sleep(3000);
        System.out.println(map);//{}
    }

}
