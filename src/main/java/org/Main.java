package org;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lili
 * @date 2020/11/11 15:51
 * @notes
 */
public class Main {
    public static void main(String[] args) {
        String suffix =  System.currentTimeMillis() + "alibaba.pdf".substring("alibaba.pdf".lastIndexOf("."));
        System.out.println(suffix);

        List<String> a = new ArrayList<>();
        a.add("ddd1");
        a.add("ddd2");
        a.add("ddd3");
        a.add("ddd4");
        List<String> collect = a.stream().filter(x -> x.equals("ddd1")).collect(Collectors.toList());
        System.out.println(collect);

    }
}
