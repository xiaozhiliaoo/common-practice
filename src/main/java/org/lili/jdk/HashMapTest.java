package org.lili.jdk;

import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author lili
 * @date 2020/2/11 20:20
 * @description
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String, Map<String, String>> mapRoot = new HashMap<>();
        mapRoot.put("1", new HashMap<String, String>() {{
            put("11", "11");
        }});
        mapRoot.put("1", new HashMap<String, String>() {{
            put("22", "22");
        }});
        System.out.println(mapRoot);

    }

    class Person {

        private int age;
        private String name;

        public Person(int age, String name) {
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return "age:" + age + ",name" + name;
        }
    }

    @Test
    public void test() {
        Person person = new Person(45, "alibaba");
        System.out.println(person);
    }


    @Test
    public void ketSet() {
        Map<String, String> hash = new HashMap<>();
        hash.put("1", "21");
        hash.put("11", "22");
        hash.put("111", "23");
        hash.put("1111", "234");
        //entrySet遍历方法
        hash.entrySet().parallelStream().forEach(x -> {
            System.out.println(x.getKey() + x.getValue());
        });
        System.out.println(hash);
        Set<String> strings = hash.keySet();

        //keySet的值是从哪里来的？ KeySet extends AbstractSet<K> extends AbstractCollection<E>
        //toString() ->  Iterator ->  KeyIterator()
        Set<String> stringsRemove = hash.keySet();
        System.out.println("keySet:" + strings);

        Collection<String> values = hash.values();
        values.remove("23");

        System.out.println(hash);


    }

    @Test
    public void tableSizeFor() {
        assertEquals(1, tableSizeFor(-4));
        assertEquals(1, tableSizeFor(0));
        assertEquals(1, tableSizeFor(1));
        assertEquals(2, tableSizeFor(2));
        assertEquals(4, tableSizeFor(3));
        assertEquals(8, tableSizeFor(7));
        assertEquals(16, tableSizeFor(11));
        assertEquals(16, tableSizeFor(12));
        assertEquals(16, tableSizeFor(13));
        assertEquals(16, tableSizeFor(15));
        assertEquals(32, tableSizeFor(17));
    }

    @Test
    public void hash() {
        System.out.println();
        System.out.println((32 - 1) & hash("stff"));
        System.out.println((16 - 1) & hash("stff"));
        System.out.println((8 - 1) & hash("stff"));
        System.out.println((4 - 1) & hash("stff"));
        System.out.println((4 - 1) & hash("stff4"));
        System.out.println((4 - 1) & hash("stff5"));
        System.out.println((4 - 1) & hash("4ttttffvvv"));
    }

    static final int MAXIMUM_CAPACITY = 1 << 30;


    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }


    static final int hash(Object key) {
        int h;
        //hashCode 异或  hashCode无符号右移16位
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }


    @Test
    public void putVal() {
        HashMap<String, String> hash = new HashMap<>();
        System.out.println(hash.put("1", "21"));
        System.out.println(hash.put("1", "21"));
        System.out.println(hash.put("11", "22"));
        System.out.println(hash.put("111", "23"));
        System.out.println(hash.put("111", "23"));
        System.out.println(hash.put("1111", "234"));
    }
}
