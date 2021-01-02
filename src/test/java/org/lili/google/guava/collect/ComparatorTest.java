package org.lili.google.guava.collect;

import com.google.common.base.Function;
import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lili
 * @date 2020/1/17 10:31
 * @description
 */
@Builder
@Setter
@Getter
@ToString
class Persons {
    private String name;
    private int sort;
}

public class ComparatorTest {


    List<Persons> list = new ArrayList<>();

    @BeforeEach
    void setUp() {
        Persons lili = Persons.builder().name("lili").sort(1).build();
        Persons lili2 = Persons.builder().name("lili2").sort(2).build();
        Persons lili3 = Persons.builder().name("lili3").sort(3).build();
        Persons lili4 = Persons.builder().name("lili4").sort(4).build();
        list = Lists.newArrayList(lili, lili2, lili3, lili4);
    }

    @Test
    public void testSort() {

        Collections.sort(list, new Comparator<Persons>() {
            @Override
            public int compare(Persons o1, Persons o2) {
                return o1.getSort() - o2.getSort();
            }
        });
        System.out.println(list);
    }

    @Test
    public void testSort2() {

        List<Persons> collect = list.stream().sorted(Comparator.comparingInt(Persons::getSort)).collect(Collectors.toList());
        System.out.println(collect);

    }









    @Test
    public void test() {
        Comparator<String> byReverseOffSetThenName =  new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ComparisonChain.start().compare(o1,o2).compare(o1.length(),o2.length()).result();
            }
        };

        Comparator<String> byReverseOffSetThenName2 = Ordering
                .natural()
                .reverse()
                .onResultOf(tzToOffset())
                .compound(Ordering.natural());
    }

    private Function<String,Integer> tzToOffset() {
        return new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return getOffSet(input);
            }
        };
    }

    private Integer getOffSet(String input) {
        return null;
    }
}
