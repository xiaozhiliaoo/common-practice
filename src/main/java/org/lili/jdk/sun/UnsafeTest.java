package org.lili.jdk.sun;

import org.junit.Test;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.security.AccessController;
import java.security.PrivilegedAction;

/**
 * @author lili
 * @date 2020/10/31 20:02
 * @see
 * @since
 */
public class UnsafeTest {

    private static final Unsafe UNSAFE = findUnsafe();

    private static long VERSION_OFFSET = 3;
    // Updated through Unsafe only!
    private volatile long version = 0;

    @Test
    public void atomicUpdate() {

    }


    @Test
    public void test() throws Exception {
        Unsafe unsafe = findUnsafe();
        Player p = new Player();
        int andSetInt = unsafe.getAndSetInt(p.id, 1, 3);
        System.out.println(andSetInt);
        System.out.println(p.id);
    }

    class Player {
        int id;
    }

    @Test
    public void test2() throws Exception {
        Field f = Unsafe.class.getDeclaredField("theUnsafe"); //Internal reference
        f.setAccessible(true);
        Unsafe unsafe = (Unsafe) f.get(null);

        //This creates an instance of player class without any initialization
        Player p = (Player) unsafe.allocateInstance(Player.class);

        unsafe.freeMemory(p.hashCode());
    }


    private static Unsafe findUnsafe() {
        try {
            return Unsafe.getUnsafe();
        } catch (SecurityException se) {
            return AccessController.doPrivileged(new PrivilegedAction<Unsafe>() {
                @Override
                public Unsafe run() {
                    try {
                        Class<Unsafe> type = Unsafe.class;
                        try {
                            Field field = type.getDeclaredField("theUnsafe");
                            field.setAccessible(true);
                            return type.cast(field.get(type));
                        } catch (Exception e) {
                            for (Field field : type.getDeclaredFields()) {
                                if (type.isAssignableFrom(field.getType())) {
                                    field.setAccessible(true);
                                    return type.cast(field.get(type));
                                }
                            }
                        }
                    } catch (Exception e) {
                        throw new RuntimeException("Unsafe unavailable", e);
                    }
                    throw new RuntimeException("Unsafe unavailable");
                }
            });
        }
    }
}
