package org;

/**
 * @author lili
 * @date 2020/11/11 15:51
 * @notes
 */
public class Main {
    public static void main(String[] args) {
        String suffix =  System.currentTimeMillis() + "alibaba.pdf".substring("alibaba.pdf".lastIndexOf("."));
        System.out.println(suffix);
    }
}
