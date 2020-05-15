package org.lili.jdk;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author lili
 * @date 2020/5/13 11:18
 * @description
 * @notes
 */

public class Main {

    private static int page=10;

    public static final Integer LIMITEND = 5;


    public static void main(String[] args) {


        System.out.println(Integer.valueOf(StringUtils.defaultIfBlank("1111", "0")));

        //size=10 sum=99 index:0,10,20,30,40
        int count =100;
        int num = count % LIMITEND == 0 ? count / LIMITEND : (count / LIMITEND) + 1 ;
        System.out.println(num);

        List<Integer> s = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            s.add(i*LIMITEND);
        }
        System.out.println(s);

        System.out.println(createPageNumMap(101));
    }

    private static Map<Integer, Integer> createPageNumMap(Integer sum) {
        int count = sum % page;
        Map<Integer,Integer> map = new TreeMap<>();
        for (int i = 0,j=1; i < count; i+=count) {
            map.put(i,i+count);
        }
        return map;
    }
}
