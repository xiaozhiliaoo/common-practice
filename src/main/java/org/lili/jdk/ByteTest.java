package org.lili.jdk;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import lombok.ToString;
import org.junit.Test;

/**
 * @author lili
 * @date 2020/2/16 10:30
 * @description
 * @notes
 */

public class ByteTest {

    @Test
    public void testInit() {
        Byte b = new Byte("11");
        System.out.println(b);

        Byte aByte = Byte.valueOf("33");
        System.out.println(aByte.byteValue());
        System.out.println(aByte.shortValue());
        System.out.println(aByte.intValue());
        System.out.println(aByte.longValue());
        System.out.println(aByte.floatValue());
        System.out.println(aByte.doubleValue());

        //NumberFormatException
        Byte bByte = Byte.valueOf("3333");

    }


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
