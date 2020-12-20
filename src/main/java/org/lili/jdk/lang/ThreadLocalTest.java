package org.lili.jdk.lang;

import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/11/15 23:40
 * @see
 * @since
 */
public class ThreadLocalTest {
    @Test
    public void test() {
        //由于一个线程拥有多个ThreadLocal会在ThreadLocalMap形成多个Entry.
        // 多个线程拥有一个ThreadLocal拥有ThreadLocalMap形成一个Entry，
        //  这也就是为什么必须设置为静态final唯一的原因.
        //存储在threadlocalmap中,一个线程可以有多个ThreadLocal，这些ThreadLocal共享一个ThreadLocalMap
        //多个线程的每个线程拥有一个ThreadLocalMap
        ThreadLocal<String> s = new ThreadLocal<>();
        s.set("alibaba1");
        s.set("tencent1");
        System.out.println(s.get());

        Thread thread = new Thread(()->{
            s.set("alibaba2");
            s.set("tencent2");
        });
        thread.setName("thread2");
        thread.start();


        //存储在threadlocalmap中
        ThreadLocal<Integer> i = new ThreadLocal<>();
        i.set(Integer.MAX_VALUE);
        System.out.println(i.get());

        s.remove();

        System.out.println(s.get());
    }
}
