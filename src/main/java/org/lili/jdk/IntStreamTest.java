package org.lili.jdk;

import java.util.stream.IntStream;

/**
 * @author lili
 * @date 2020/4/30 18:04
 * @description
 * @notes
 */

public class IntStreamTest {
    public static void main(String[] args) {
       // IntStream.range(0,100).forEach(i-> System.out.println(i));
        IntStream.range(0,100).parallel().forEach(i-> System.out.println(i));
    }
}
