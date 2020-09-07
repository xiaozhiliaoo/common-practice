package org.lili.jdk;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author lili
 * @date 2020/9/3 14:38
 * @description
 * @notes
 */

public class EnumTest {

    @Test
    public void testIt() {
        List<String> strings = AutomaticMainSymbol.listConfigSymbol();
        System.out.println(strings);
    }

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
