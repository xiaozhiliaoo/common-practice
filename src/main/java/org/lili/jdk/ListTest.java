package org.lili.jdk;

import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

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

    @Data
    class User {
        private String name;
        private int age;
        private boolean is;

        public User(String name, int age, boolean is) {
            this.name = name;
            this.age = age;
            this.is = is;
        }
    }

    @Test
    public void removeDup() {
        User user1 = new User("zhangsan1", 20, true);
        User user2 = new User("zhangsan2", 20, true);
        User user3 = new User("zhangsan1", 30, true);
        List<User> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);

        list = list.stream().collect(Collectors.collectingAndThen(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(User::getName))), ArrayList::new));
        System.out.println(list);

    }

}
