package org.lili.google.guava;

import com.google.common.base.CharMatcher;
import com.google.common.hash.HashCode;
import com.google.common.hash.Hashing;
import lombok.Data;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author lili
 * @date 2020/1/17 14:52
 * @description
 */
@Data
class Person{
    private int id;
    private String firstName;
    private byte channel;
}

public class HashCodeTest {
    @Test
    public void test() {
        Person person = new Person();
        person.setId(1);
        person.setFirstName("lili");
        person.setChannel((byte) 1);
        HashCode hashCode = Hashing.murmur3_128().newHasher().
                putInt(person.getId()).
                putString(person.getFirstName(), StandardCharsets.UTF_8).
                putByte(person.getChannel()).hash();
        System.out.println(hashCode.asLong());
    }
}
