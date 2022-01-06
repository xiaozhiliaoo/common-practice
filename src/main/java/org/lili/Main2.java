package org.lili;

/**
 * @author lili
 * @date 2021/10/14 16:14
 */
public class Main2 {
    public static void main(String[] args) {
        System.out.println("ssss111".matches(".*[a-z].*"));
        System.out.println("111".matches(".*[a-z].*"));
        System.out.println("111-222-333".matches(".*[a-z].*"));
        System.out.println("111@@222@@333".matches(".*[a-z].*"));
    }
}