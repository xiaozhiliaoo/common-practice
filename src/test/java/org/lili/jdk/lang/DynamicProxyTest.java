package org.lili.jdk.lang;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * @author lili
 * @date 2020/12/31 20:16
 * @notes
 */
interface Li {
    void say();
}
class LiLi1 implements Li {
    @Override
    public void say() {
        System.out.println("say lili1");
    }
}


class LiLi2 implements Li {
    @Override
    public void say() {
        System.out.println("say lili2");
    }
}

class LiLi3 implements Li {
    @Override
    public void say() {
        System.out.println("say lili3");
    }
}


class DynamicProxyTest {

    @Test
    void getProxy() {
        DynamicProxy d = new DynamicProxy(new LiLi1());
        Li target = (Li)d.getTarget();
        target.say();
    }

}