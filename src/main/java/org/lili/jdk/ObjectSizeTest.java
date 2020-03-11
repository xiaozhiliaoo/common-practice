package org.lili.jdk;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * @author lili
 * @date 2020/2/18 1:41
 * @description
 * @notes
 */

public class ObjectSizeTest {
    public static void main(String[] args) {
        System.out.println(ObjectSizeCalculator.getObjectSize(1));
        char a = '1';
        System.out.println(ObjectSizeCalculator.getObjectSize(a));
        byte b = 1;
        System.out.println(ObjectSizeCalculator.getObjectSize(b));
        long l = 1;
        System.out.println(ObjectSizeCalculator.getObjectSize(l));
    }
}
