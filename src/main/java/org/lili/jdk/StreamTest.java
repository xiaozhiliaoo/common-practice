package org.lili.jdk;

import java.util.stream.IntStream;

/**
 * @author lili
 * @date 2020/5/10 14:44
 * @description
 * @notes
 */

public class StreamTest {
    public static void main(String[] args) {
//        IntStream.range(0, 100000000).parallel().forEach(x-> System.out.println(x));

        for (int i = 0; i < 100000; i++) {
            System.out.println(i);
        }
    }
}
