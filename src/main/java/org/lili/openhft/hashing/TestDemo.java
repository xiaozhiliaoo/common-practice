package org.lili.openhft.hashing;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;
import net.openhft.hashing.LongHashFunction;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

/**
 * @author lili
 * @date 2020/4/8 11:03
 * @description
 * @notes
 */

public class TestDemo {
    @Test
    public void test() {
        long hash = LongHashFunction.wy_3().hashChars("hello");
        System.out.println(hash);


        //Guava
        String input = "hello, world";
        // 计算MD5
        System.out.println(Hashing.md5().hashBytes(input.getBytes()).toString());
        // 计算sha256
        System.out.println(Hashing.sha256().hashBytes(input.getBytes()).toString());
        // 计算sha512
        System.out.println(Hashing.sha512().hashBytes(input.getBytes()).toString());
        // 计算crc32
        System.out.println(Hashing.crc32().hashBytes(input.getBytes()).toString());
        System.out.println(Hashing.md5().hashUnencodedChars(input).toString());

        String s = "hash data";
        HashFunction hashFunction = Hashing.goodFastHash(128);
        String hashCode = hashFunction.hashString(s, StandardCharsets.UTF_8).toString();
        System.out.println(hashCode);

    }

}
