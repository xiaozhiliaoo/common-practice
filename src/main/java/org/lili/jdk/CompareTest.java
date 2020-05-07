package org.lili.jdk;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

/**
 * @author lili
 * @date 2020/5/6 16:11
 * @description
 * @notes
 */
class User {
    int id;
    String name;
    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name='" + name + '\'' + '}';
    }
}


public class CompareTest {
    public static void main(String[] args) {
        User u1 = new User(1,"lili1");
        User u2 = new User(99911,"lili2");
        User u3 = new User(1111119,"lili3");
        ArrayList<User> users = Lists.newArrayList(u1, u2, u3);
        Optional<Integer> max = users.stream().map(User::getId).max(Comparator.naturalOrder());
        System.out.println(max.get());

    }

}
