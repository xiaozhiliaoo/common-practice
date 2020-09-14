package org.lili.jdk.stream;

import org.junit.Test;

import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * @author lili
 * @date 2020/9/12 1:41
 * @notes
 */
public class ParallelStreamtest {
    @Test
    public void test() {
        
        System.out.println(Stream.iterate(BigInteger.valueOf(2), BigInteger::nextProbablePrime).collect(Collectors.toSet()));
    }



}
