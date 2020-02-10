package org.lili.google.guava.collect;

import com.google.common.base.Function;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author lili
 * @date 2020/1/17 10:56
 * @description
 */
@Data
@ToString
@AllArgsConstructor
class Person {
    private String name;
    private Integer age;
}

public class OrderingTest {
    @Test
    public void test() {
        List<Integer> integers = Arrays.asList(3, 2, 1);
        integers.sort(Ordering.natural());
        assertEquals(Arrays.asList(1, 2, 3), integers);
    }

    @Test
    public void testOrderPerson() {
        List<Person> persons = Arrays.asList(
                new Person("Michael", 10), new Person("Alice", 3));
        Ordering<Person> orderingByAge = new Ordering<Person>() {
            @Override
            public int compare(@Nullable Person left, @Nullable Person right) {
                return Ints.compare(left.getAge(), right.getAge());
            }
        };
        persons.sort(orderingByAge);
        assertEquals(Arrays.asList(new Person("Alice", 3), new Person("Michael", 10)), persons);
    }

    @Test
    public void testCombineOrder() {
        List<Person> persons = Arrays.asList(
                new Person("Michael", 10),
                new Person("Alice", 3),
                new Person("Thomas", null));

        Ordering<Person> ordering = Ordering
                .natural()
                .nullsFirst()
                .onResultOf(new Function<Person, Comparable>() {
                    @Override
                    public Comparable apply(Person person) {
                        return person.getAge();
                    }
                });

        persons.sort(ordering);

        assertEquals(Arrays.asList(
                new Person("Thomas", null),
                new Person("Alice", 3),
                new Person("Michael", 10)), persons);
    }
}
