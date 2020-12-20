package org.lili.google.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Maps;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author lili
 * @date 2020/1/15 23:03
 * @description
 */
public class BiMapTestTest {
    @Test
    public void testSplitter() {
        String startString = "Washington D.C=Redskins=New York City=Giants=Philadelphia=Eagles=Dallas=Cowboys";
        Iterable<String> split = Splitter.on('=').split(startString);
        AtomicInteger integer = new AtomicInteger();
        for (String s : split) {
            System.out.println(s);
        }
    }
}