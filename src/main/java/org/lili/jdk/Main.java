package org.lili.jdk;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.*;

/**
 * @author lili
 * @date 2020/5/13 11:18
 * @description
 * @notes
 */

public class Main {


    public static final Integer LIMITEND = 5;

    private static final int PAGE_NUM = 5000;

    @Test
    public void test() throws InterruptedException {
        Runnable task = () -> {
            System.out.println("lilil");
        };
        task.run();
    }



    public static void main(String[] args) {

        ArrayList<String> strings = Lists.newArrayList("22", "33", "44", "55");

        for (String string : strings) {
            if (string.equals("22")) {
                continue;
            }
            System.out.println(string);
        }


        createPageNumMap(113472);
    }

    private static void createPageNumMap(Integer sum) {
        List<Integer> pageIndex = new LinkedList<>();
        //页数
        int page = (sum % PAGE_NUM) == 0 ? sum / PAGE_NUM : (sum / PAGE_NUM) + 1;
        for (int i = 0; i < page; i++) {
            if(i == 0) {
                pageIndex.add(0);
            }else {
                pageIndex.add(i*PAGE_NUM);
            }
        }
        System.out.println(pageIndex);
    }
}
