package org.lili.jdk;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
import org.junit.Assert;
import org.junit.Test;

import java.util.BitSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author lili
 * @date 2020/4/5 10:25
 * @description
 * @notes
 */

public class BitSetTest {
    @Test
    public void test() {
        BitSet bits1 = new BitSet(16);
        BitSet bits2 = new BitSet(16);
        System.out.println(bits1);
        System.out.println(bits2);

        for(int i = 0; i < 16; i++) {
            if((i % 2) == 0) bits1.set(i);
            if((i % 5) != 0) bits2.set(i);
        }

        //8个true  cardinality 基数
        System.out.println(bits1.cardinality());
        //12个true
        System.out.println(bits2.cardinality());
        assertFalse(bits1.get(1));
        assertTrue(bits1.get(2));

        System.out.println("Initial pattern in bits1: ");
        System.out.println(bits1);
        System.out.println("Initial pattern in bits2: ");
        System.out.println(bits2);

        bits2.and(bits1);
        System.out.println("bits2 AND bits1: ");
        System.out.println(bits2);

        bits2.or(bits1);
        System.out.println("bits2 OR bits1: ");
        System.out.println(bits2);

        // XOR bits
        bits2.xor(bits1);
        System.out.println("bits2 XOR bits1: ");
        System.out.println(bits2);


        BitSet bits3 = new BitSet(Integer.MAX_VALUE);
        bits3.set(Integer.MAX_VALUE);
        //没有被压缩，占用很大内存
        System.out.println(ObjectSizeCalculator.getObjectSize(bits3));
        System.out.println(bits3);


        BitSet bits4 = new BitSet(1);
        bits4.set(1);
        System.out.println(ObjectSizeCalculator.getObjectSize(bits4));
        System.out.println(bits4);
    }
}
