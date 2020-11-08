package org.lili.jdk;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;
import java.util.UUID;
import java.util.stream.IntStream;

/**
 * @author lili
 * @date 2020/3/19 15:36
 * @description
 * @notes
 */

public class StringTest {
    public static void main(String[] args) {
        System.out.println(String.format("content", null));
        System.out.println(UUID.randomUUID().toString().substring(0,8));
        String email = "wdedwce$USDT$@qqq.com";
        List<String> split = Splitter.on("$").splitToList(email);
        System.out.println(split.get(1));
        System.out.println(split);


        String app = "eeee%s...%s";
        System.out.println(String.format(app, "1", "2"));


    }

    @Test
    public void codePoints() {
        IntStream intStream = "alibaba".codePoints();
        intStream.forEach(System.out::println);
        System.out.println("--------------------------");
        IntStream chars = "alibaba".chars();
        chars.forEach(System.out::println);
    }


    @Test
    public void test() {
        String name = null;
        String age = null;
        String id = "555";
        System.out.println(isOnlyOneParams(name, age, id));
    }

    private static boolean isOnlyOneParams(final CharSequence... args) {
        if (ArrayUtils.isEmpty(args)) {
            return false;
        }
        int i = 0;
        for (CharSequence arg : args) {
            if(arg != null) {
                i++;
            }
            if(i > 1) {
                return false;
            }
        }
        return true;
    }
}
