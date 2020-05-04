package org.lili.jdk;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * @author lili
 * @date 2020/2/16 10:30
 * @description
 * @notes
 */

public class ByteTest {
    public static void main(String[] args) {

        Byte a1 = new Byte("1");
        Byte a2 = new Byte("1");
        Byte a3 = new Byte("1");
        System.out.println(ObjectSizeCalculator.getObjectSize(a1 + a2 + a3));

        Byte b1 = Byte.valueOf("1");
        Byte b2 = Byte.valueOf("1");
        Byte b3 = Byte.valueOf("1");
        System.out.println(ObjectSizeCalculator.getObjectSize(b1 + b2 + b3));

    }
}
