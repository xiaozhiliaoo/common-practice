package org.lili.bigfraction;

import com.github.kiprobinson.bigfraction.BigFraction;
import org.junit.Test;

import java.math.BigInteger;

/**
 * @author lili
 * @date 2020/4/9 0:30
 * @description
 * @notes
 */

public class Main {
    @Test
    public void test() {
        System.out.println(BigFraction.valueOf(11));
        //numerator 分子  denominator 分母
        BigFraction.valueOf(11, 17);  // 11/17
        BigFraction.valueOf("19/81"); // 19/81

    }
}
