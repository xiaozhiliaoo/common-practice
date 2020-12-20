package org.lili.jdk;

import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/10/20 10:56
 * @notes
 */
class Alibaba {
    static {
        System.out.println("init now ....");
    }
}

public class ClassTest {

    @Test
    public void test() throws ClassNotFoundException {
        Class.forName("org.lili.jdk.Alibaba");
    }
}
