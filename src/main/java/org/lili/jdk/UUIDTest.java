package org.lili.jdk;


import java.util.UUID;

/**
 * @author lili
 * @date 2020/1/10 20:51
 * @description
 */
public class UUIDTest {
    public static void main(String[] args) {
        // Creating a random UUID (Universally unique identifier).
        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        System.out.println("Random UUID String = " + randomUUIDString);
        System.out.println("UUID version       = " + uuid.version());
        System.out.println("UUID variant       = " + uuid.variant());
    }
}
