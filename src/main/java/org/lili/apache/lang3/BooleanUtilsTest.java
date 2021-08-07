package org.lili.apache.lang3;

import org.apache.commons.lang.BooleanUtils;
import org.junit.jupiter.api.Test;

public class BooleanUtilsTest {
    @Test
    public void test() {

        System.out.println(BooleanUtils.toInteger(true));
        System.out.println(BooleanUtils.toInteger(false));
    }

    @Test
    public void test2() {
        test3();
    }

    private void test3() {
        System.out.println("test3");
        test4();
        System.out.println("test3 end");
        return;
    }

    private void test4() {
        System.out.println("test4");
        return;
    }
}
