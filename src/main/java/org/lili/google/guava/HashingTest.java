package org.lili.google.guava;

import com.google.common.hash.Hashing;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;
import java.util.Random;

/**
 * @author lili
 * @date 2020/4/30 17:01
 * @description
 * @notes
 */

public class HashingTest {
    public static void main(String[] args) {
        System.out.println(Objects.hashCode("0xca4a21d43a9937640ad53f1c913db2e7bd90632b"));
        System.out.println(Objects.hashCode("0xca4a21d43a9937640ad53f1c913db2e7bd906321"));
        System.out.println(Objects.hashCode("0xca4a21d43a9937640ad53f1c913db2e7bd906322"));
        System.out.println(Objects.hashCode("0xca4a21d43a9937640ad53f1c913db2e7bd906323"));
        System.out.println("0xca4a21d43a9937640ad53f1c913db2e7bd906323".hashCode());

        Random random = new Random();


    }
}
