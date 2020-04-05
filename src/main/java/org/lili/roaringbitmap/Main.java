package org.lili.roaringbitmap;

/**
 * @author lili
 * @date 2020/4/5 11:24
 * @description
 * @notes
 */

public class Main {
    public static void main(String[] args) {
        int c = 0;
        int [] A = new int[1024];
        int [] B = new int[1024];
        for (int i = 0; i < 1024; i++) {
           c += Long.bitCount(A[i] & B[i]);
        }
        System.out.println(c);
        System.out.println(Long.bitCount(345654345));
    }
}
