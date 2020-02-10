package org.lili.apache.lang3;

import org.apache.commons.collections4.map.LRUMap;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author lili
 * @date 2020/1/15 23:40
 * @description
 */
public class LRUMapTest {
    @Test
    public void test() {
        Map map = new LRUMap(3);
    }
}