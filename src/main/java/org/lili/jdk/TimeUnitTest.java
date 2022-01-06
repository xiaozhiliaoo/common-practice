package org.lili.jdk;

import com.google.common.collect.Lists;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author lili
 * @date 2020/5/4 20:24
 * @description
 * @notes
 */

public class TimeUnitTest {

    @Test
    public void test3() {
        System.out.println();
    }

    @Test
    public void test() {
        assertEquals(24 * 60 * 60 * 1000, TimeUnit.DAYS.toMillis(1));
        assertEquals(24 * 60 * 60 * 1000, TimeUnit.HOURS.toMillis(24));
        assertEquals(24 * 60 * 60 * 1000 * 7, TimeUnit.DAYS.toMillis(7));
        assertEquals(24 * 60 * 60 * 1000 * 14, TimeUnit.DAYS.toMillis(14));
        assertEquals(24 * 60 * 60 * 1000 * 30L, TimeUnit.DAYS.toMillis(30));
    }

    @Test
    public void test4() {
        assertEquals(10 * 60 * 1000, TimeUnit.MINUTES.toMillis(10));

    }


    @Test
    public void test2() {
        System.out.println(TimeUnit.MILLISECONDS.toDays((24 * 60 * 60 * 1000) * 3 / 2));
        System.out.println(TimeUnit.MILLISECONDS.toMinutes((24 * 60 * 60 * 1000) * 3 / 2));
    }

    public static void main(String[] args) {
        System.out.println(TimeUnit.DAYS.toMillis(1));

    }

    @Test
    public void m2() {
        List<String> result = Lists.newArrayList();
        List<String> a = Lists.newArrayList("2","3","4","5");
        List<String> b = Lists.newArrayList("1","2","3");
        System.out.println(a.stream().filter(x -> x.equalsIgnoreCase("2")).collect(Collectors.toList()));
    }


    @Test
    @SneakyThrows
    public void tt() {
        throw  new Exception();
    }
}
