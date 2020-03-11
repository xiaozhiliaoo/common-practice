package org.lili.jdk;

import java.util.regex.Pattern;

/**
 * @author lili
 * @date 2020/2/25 12:07
 * @description
 * @notes
 */

public class Patterns {



    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("^((?!Hello).)*$");
        System.out.println(pattern.matcher("Hello World").find());


        Pattern pattern2 = Pattern.compile(".*Hello.*");
        System.out.println(pattern2.matcher("Hello World").find());
    }
}
