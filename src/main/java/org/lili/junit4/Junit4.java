package org.lili.junit4;

import org.assertj.core.data.Offset;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author lili
 * @date 2022/3/3 18:03
 */
public class Junit4 {
    @Test
    public void test() {
        assertThat(0.001).isCloseTo(0.001, Offset.offset(0.001));
        assertThat(0.002).isCloseTo(0.001, Offset.offset(0.001));
    }

    @Test
    public void test2() {
        assertEquals(0.001, 0.001, 0.001);
        assertEquals(0.001, 0.002, 0.001);
    }

    @Test
    public void test3() {
        assertThat(0.004).isNotCloseTo(0.001, Offset.offset(0.001));
        assertThat(0.004).isNotCloseTo(0.001, Offset.offset(0.001));
    }

    @Test
    public void test4() {
        assertNotEquals(0.001, 0.004, 0.001);
        assertNotEquals(0.001, 0.004, 0.001);
    }

    @Test
    public void test5() {
        assertThat(0.001).isNotCloseTo(0.001, Offset.offset(0.001));
        assertThat(0.001).isNotCloseTo(0.001, Offset.offset(0.001));
    }

    @Test
    public void test6() {
        assertNotEquals(0.001, 0.001, 0.001);
        assertNotEquals(0.001, 0.001, 0.001);
    }




    public double getActual() {
        return 0.001;
    }
}
