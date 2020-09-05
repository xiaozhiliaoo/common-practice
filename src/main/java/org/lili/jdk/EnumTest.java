package org.lili.jdk;

import java.util.Objects;

/**
 * @author lili
 * @date 2020/9/3 14:38
 * @description
 * @notes
 */

public class EnumTest {
    public static void main(String[] args) {
        checkEnum(ClientSource.APP);
    }

    private static void checkEnum(ClientSource source) {
        if (source == ClientSource.APP) {
            Objects.equals(1,1);
            System.out.println("APP");
        }else {
            System.out.println("PC");
        }
    }
}
