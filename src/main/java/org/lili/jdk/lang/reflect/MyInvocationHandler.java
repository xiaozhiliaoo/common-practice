package org.lili.jdk.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author lili
 * @date 2020/11/21 21:46
 * @see
 * @since
 */
public class MyInvocationHandler implements InvocationHandler {

    private Teacher teacher;

    public MyInvocationHandler(Teacher teacher) {
        this.teacher = teacher;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke");
        Object invoke = method.invoke(teacher, args);
        System.out.println("after invoke");
        return invoke;
    }
}
