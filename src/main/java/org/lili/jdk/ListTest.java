package org.lili.jdk;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author lili
 * @date 2020/2/13 12:48
 * @description
 * @notes
 */
class Person {

    private int id;

    public Person(int id) {
        this.id = id;
    }



    @Override
    public boolean equals(Object obj) {
        return false;
    }
}

public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(removeNullElement(list));

        List<Person> people = new ArrayList<>();
        Person p1 = new Person(2);
        people.add(p1);
        System.out.println(people.contains(p1)); //fasle
        System.out.println(people.size());
        System.out.println(people.get(0));

    }

    private static List<String> removeNullElement(List<String> list) {
        list.removeAll(Collections.singleton(null));
        return list;
    }
}
