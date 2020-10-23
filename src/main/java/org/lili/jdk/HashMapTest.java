package org.lili.jdk;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
        Person person = new Person(45,"alibaba");
        System.out.println(person);
    }


    @Test
    public void ketSet() {
        Map<String, String> hash = new HashMap<>();
        hash.put("1", "21");
        hash.put("11", "22");
        hash.put("111", "23");
        hash.put("1111", "234");
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
}
