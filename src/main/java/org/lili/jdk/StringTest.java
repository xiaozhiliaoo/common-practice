package org.lili.jdk;

import com.google.common.base.Splitter;
import com.google.common.base.Strings;

import java.util.List;
import java.util.UUID;

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

    }
}
