package org.lili.jdk.stream;

import lombok.Data;
import org.apache.commons.math3.analysis.function.Add;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author lili
 * @date 2021/1/9 19:36
 * @notes
 */
@Data
class Person {
    private int id;
    private String name;
    private int age;
    private Address address;
}


@Data
class Address {
    private int id;
    private String where;
}

public class OptionalTest {


    public static Optional<Address> getAddress() {
        return Optional.empty();
    }

    @Test
    public void orElse() {
        Optional<Address> address = getAddress();
        Address x = address.orElse(new Address());
        System.out.println(x);
    }


    @Test
    public void orElseThrow() {
        Optional<Address> address = getAddress();
        Address x = address.orElseThrow();
        System.out.println(x);
    }


    @Test
    public void orElseThrowException() {
        Optional<Address> address = getAddress();
        Address x = address.orElseThrow(RuntimeException::new);
        System.out.println(x);
    }


    @Test
    public void test() {
        Person p = new Person();
        Address a = new Address();
        a.setWhere("where");
        a.setId(123);
        p.setAddress(a);
        p.setId(4);
        p.setAge(18);
        p.setName("lili");

        String s = Optional.ofNullable(p)
                .map(w -> w.getAddress())
                .map(w -> w.getWhere())
                .orElse("");
        assertEquals(s, "where");


        Person p1 = null;
        String s1 = Optional.ofNullable(p1)
                .map(w -> w.getAddress())
                .map(x -> x.getWhere())
                .orElse("alibaba");
        assertEquals(s1, "alibaba");
    }
}
