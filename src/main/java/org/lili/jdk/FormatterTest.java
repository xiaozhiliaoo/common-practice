package org.lili.jdk;

import org.junit.Test;

import java.util.Formatter;

/**
 * @author lili
 * @date 2020/7/17 11:36
 * @description
 * @notes
 */

public class FormatterTest {

    private static Formatter formatter = new Formatter();

    private static final int count = 1000000000;


    @Test
    public void formatterStatic() {
        for (int i = 0; i < count; i++) {
            Formatter format = formatter.format("%s%s", "11", "22");
            //System.out.println(format.toString());
        }
    }

    @Test
    public void stringFormat() {
        for (int i = 0; i < count; i++) {
            String format = String.format("%s%s", "11", "22");
            //System.out.println(format);
        }
    }
}
