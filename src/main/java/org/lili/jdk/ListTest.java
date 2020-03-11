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


public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("11");
        list.add(null);
        list.add(null);
        list.add(null);
        list.add(null);
        System.out.println(removeNullElement(list));
    }

    private static List<String> removeNullElement(List<String> list) {
        list.removeAll(Collections.singleton(null));
        return list;
    }
}
