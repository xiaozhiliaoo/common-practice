package org.lili.jdk;

import com.alibaba.fastjson.JSON;
import com.carrotsearch.sizeof.RamUsageEstimator;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableMap;
//import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;
//import jdk.internal.vm.annotation.Contended;
import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;
import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;
import org.openjdk.jol.vm.VM;
//import sun.misc.Contended;

import java.io.UnsupportedEncodingException;
import java.util.*;

import static java.lang.System.out;

/**
 * https://shipilev.net/talks/joker-Oct2014-string-catechism.pdf
 * https://shipilev.net/jvm/objects-inside-out/
 * https://www.baeldung.com/java-memory-layout
 * https://shipilev.net/
 * https://openjdk.java.net/jeps/374 : Disable and Deprecate Biased Locking
 * <p>
 * http://java-performance.info/string-intern-in-java-6-7-8/
 * http://java-performance.info/overview-of-memory-saving-techniques-java/
 * http://java-performance.info/memory-consumption-of-java-data-types-1/
 * http://java-performance.info/memory-consumption-of-java-data-types-2/
 *
 * @author lili
 * @date 2020/2/18 1:41
 * @description
 * @notes
 */
class SimpleInt {
    private int state;
}

class SimpleLong {
    private long state;
}

class FieldsArrangement {
    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public char getSecond() {
        return second;
    }

    public void setSecond(char second) {
        this.second = second;
    }

    public double getThird() {
        return third;
    }

    public void setThird(double third) {
        this.third = third;
    }

    public int getFourth() {
        return fourth;
    }

    public void setFourth(int fourth) {
        this.fourth = fourth;
    }

    public boolean isFifth() {
        return fifth;
    }

    public void setFifth(boolean fifth) {
        this.fifth = fifth;
    }

    private boolean first;
    private char second;
    private double third;
    private int fourth;
    private boolean fifth;
}

class Isolated {

    private int v1;

    private long v2;
}

class Lock {
}


public class ObjectSizeTest {

    @Test
    public void testSize() {
    }

    @Test
    public void testCache() {
        Map<Object, Object> obj = Maps.newHashMap();
        obj.put("11","11");
        obj.put("22","22");
        out.println("Map:"+ClassLayout.parseInstance(obj).instanceSize());
        out.println("Map:"+VM.current().sizeOf(obj));

        ImmutableMap<String, String> of = ImmutableMap.of("11", "11","22","22");
        out.println("ImmutableMap:"+ClassLayout.parseInstance(of).instanceSize());
        out.println("ImmutableMap:"+VM.current().sizeOf(of));
    }

    @Test
    public void test5000000IntegerSize() {
        List<Integer> integerList = new ArrayList<>();
        for (int i = 0; i < 5000000; i++) {
            integerList.add(i);
        }
//        System.out.println(ObjectSizeCalculator.getObjectSize(integerList) / 1024 / 1024 + "MB");
//        System.out.println(ObjectSizeCalculator.getObjectSize(1) + "B");
        System.out.println(GraphLayout.parseInstance(integerList).toFootprint());
        System.out.println(GraphLayout.parseInstance(integerList).totalCount());
        System.out.println(GraphLayout.parseInstance(integerList).totalSize());

    }

    @Test
    public void testByte() {
        System.out.println(ClassLayout.parseInstance((byte) 1).toPrintable());
//        System.out.println(ObjectSizeCalculator.getObjectSize((byte) 1));
    }

    @Test
    public void testShort() {
        Short s = (short) 4;
        System.out.println(ClassLayout.parseInstance(s).toPrintable());
//        System.out.println(ObjectSizeCalculator.getObjectSize(s));
    }

    @Test
    public void testArray() {
        boolean[] booleans = new boolean[3];
        System.out.println(ClassLayout.parseInstance(booleans).toPrintable());

    }

    @Test
    public void testLock() {
        System.out.println(ClassLayout.parseClass(Lock.class).toPrintable());
        Lock instance = new Lock();
        System.out.println("The identity hash code is " + System.identityHashCode(instance));
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
    }

    @Test
    public void testSynchronizedLock() {
        Lock instance = new Lock();
        synchronized (instance) {
            System.out.println(ClassLayout.parseInstance(instance).toPrintable());
        }
    }

    volatile Object consumer;

    @Test
    public void testAgeAndTenuring() {
        Object instance = new Object();
        long lastAddr = VM.current().addressOf(instance);
        ClassLayout layout = ClassLayout.parseInstance(instance);
        for (int i = 0; i < 10_000; i++) {
            long currentAddr = VM.current().addressOf(instance);
            if (currentAddr != lastAddr) {
                System.out.println(layout.toPrintable());
            }

            for (int j = 0; j < 10_000; j++) {
                consumer = new Object();
            }

            lastAddr = currentAddr;
        }
    }


    @Test
    public void testInt() {
        System.out.println(ClassLayout.parseClass(SimpleInt.class).toPrintable());
        SimpleInt instance = new SimpleInt();
        System.out.println("The identity hash code is " + System.identityHashCode(instance));
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
    }


    @Test
    public void testLong() {
        System.out.println(ClassLayout.parseClass(SimpleLong.class).toPrintable());
        SimpleLong instance = new SimpleLong();
        System.out.println("The identity hash code is " + System.identityHashCode(instance));
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
    }

    @Test
    public void testFieldsArrangement() {
        System.out.println(ClassLayout.parseClass(FieldsArrangement.class).toPrintable());
        FieldsArrangement instance = new FieldsArrangement();
        System.out.println("The identity hash code is " + System.identityHashCode(instance));
        System.out.println(ClassLayout.parseInstance(instance).toPrintable());
    }

    //-XX:-UseCompressedOops
    //https://www.baeldung.com/java-memory-layout
    @Test
    public void testHashMap() throws UnsupportedEncodingException {

        System.out.println(VM.current().details());

        out.println("-------------------------------------");

        ImmutableMap<String, String> immutableMap = ImmutableMap.of("string", "string", "string2", "string2");
//        System.out.println(ObjectSizeCalculator.getObjectSize(immutableMap));
        System.out.println(RamUsageEstimator.humanSizeOf(immutableMap));
        ClassLayout layout = ClassLayout.parseInstance(immutableMap);
        System.out.println(layout.toPrintable());
        System.out.println("immutableMap json: " + JSON.toJSONString(immutableMap));
        System.out.println("immutableMap json size: " + JSON.toJSONString(immutableMap).getBytes("UTF-8").length);

        out.println("----------------------------------------");
        Map<String, String> hashMap = new HashMap<>(2);
        hashMap.put("string", "string");
        hashMap.put("string2", "string2");
//        System.out.println(ObjectSizeCalculator.getObjectSize(hashMap));
        System.out.println(RamUsageEstimator.humanSizeOf(hashMap));

        ClassLayout layout2 = ClassLayout.parseInstance(hashMap);
        System.out.println(layout2.toPrintable());
        System.out.println("hashMap json : " + JSON.toJSONString(hashMap));
        System.out.println("hashMap json size: " + JSON.toJSONString(hashMap).getBytes("UTF-8").length);

        out.println("----------------------------------------");
        Map<String, String> map = new HashMap<>();
        synchronized (map) {
            map.put("lili", "lili2");
            ClassLayout layout3 = ClassLayout.parseInstance(map);
            System.out.println(layout3.toPrintable());
        }


    }

    public static void main(String[] args) {
//        System.out.println(ObjectSizeCalculator.getObjectSize(1));
        char a = '1';
//        System.out.println(ObjectSizeCalculator.getObjectSize(a));
        byte b = 1;
//        System.out.println(ObjectSizeCalculator.getObjectSize(b));
        long l = 1;
//        System.out.println(ObjectSizeCalculator.getObjectSize(l));
    }
}
