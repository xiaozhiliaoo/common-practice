package org.lili.google.guava;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.ObjectUtils;
import org.junit.jupiter.api.Test;

import java.util.Objects;
import java.util.Random;

/**
 * @author lili
 * @date 2020/4/30 17:01
 * @description
 * @notes
 */

public class HashingTest {

    @Test
    public void consistentHash() {
        //模拟减少了机器
        System.out.println("-----模拟减少了机器-------");
        System.out.println(Hashing.consistentHash(1, 222));
        System.out.println(Hashing.consistentHash(2, 222));
        System.out.println(Hashing.consistentHash(3, 222));
        System.out.println(Hashing.consistentHash(4, 222));
        System.out.println(Hashing.consistentHash(5, 222));
        System.out.println("-----模拟正常机器-------");
        System.out.println(Hashing.consistentHash(1, 223));
        System.out.println(Hashing.consistentHash(2, 223));
        System.out.println(Hashing.consistentHash(3, 223));
        System.out.println(Hashing.consistentHash(4, 223));
        System.out.println(Hashing.consistentHash(5, 223));
        System.out.println("-------模拟新加3台机器------");
        System.out.println(Hashing.consistentHash(1, 226));
        System.out.println(Hashing.consistentHash(2, 226));
        System.out.println(Hashing.consistentHash(3, 226));
        System.out.println(Hashing.consistentHash(4, 226));
        System.out.println(Hashing.consistentHash(5, 226));
        System.out.println("--------模拟宕机很多-----------");
        System.out.println(Hashing.consistentHash(1, 20));
        System.out.println(Hashing.consistentHash(2, 20));
        System.out.println(Hashing.consistentHash(3, 20));
        System.out.println(Hashing.consistentHash(4, 20));
        System.out.println(Hashing.consistentHash(5, 20));
    }


    public static void main(String[] args) {
        System.out.println(Objects.hashCode("0xca4a21d43a9937640ad53f1c913db2e7bd90632b"));
        System.out.println(Objects.hashCode("0xca4a21d43a9937640ad53f1c913db2e7bd906321"));
        System.out.println(Objects.hashCode("0xca4a21d43a9937640ad53f1c913db2e7bd906322"));
        System.out.println(Objects.hashCode("0xca4a21d43a9937640ad53f1c913db2e7bd906323"));
        System.out.println("0xca4a21d43a9937640ad53f1c913db2e7bd906323".hashCode());

        Random random = new Random();


    }
}
