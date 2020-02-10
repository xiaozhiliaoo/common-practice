package org.lili.apache.lang3;

import org.apache.commons.lang3.ObjectUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2020/1/9 10:56
 * @description
 */
public class ObjectUtilsTest {
    public static void main(String[] args) {
        System.out.println(TimeUnit.MINUTES.toMillis(10));

        List<String> before = new ArrayList<>();
        before.add("111");
        before.add("222");
        before.add("333");
        List<String> beforeClone = before;
        before.add("4444");
        System.out.println(beforeClone);
        System.out.println(before);


        List<String> before2 = new ArrayList<>();
        before2.add("111");
        before2.add("222");
        before2.add("333");
        List<String> beforeClone2 = ObjectUtils.clone(before2);
        before2.add("4444");
        System.out.println(beforeClone2);
        System.out.println(before2);


    }
}
