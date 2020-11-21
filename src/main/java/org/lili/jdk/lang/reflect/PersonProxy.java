package org.lili.jdk.lang.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lili
 * @date 2020/11/21 17:19
 * @notes
 */
class My implements InvocationHandler {


    private Person person;

    public My(Person p) {
        this.person = p;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getName().equals("setName")) {
            method.invoke(person, args);
        }
        Object result = null;
        if (method.getName().equals("getName")) {
            System.out.println("getName begin");
            result = method.invoke(person, args);
            System.out.println("getName end");
        }
        return result;
    }
}


public class PersonProxy {

    public static void main(String[] args) {
        Person p = new PersonImpl();

        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");

        Person proxyPerson = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new My(p));

//        System.out.println(proxyPerson.getName());
//        InvocationHandler invocationHandler = Proxy.getInvocationHandler(proxyPerson);
//        System.out.println(Proxy.isProxyClass(Person.class));
//        System.out.println(Proxy.isProxyClass(proxyPerson.getClass()));
//        Class<?> proxyClass = Proxy.getProxyClass(proxyPerson.getClass().getClassLoader(), Person.class);
//        System.out.println(proxyClass);
//        Class<?> proxyClass1 = Proxy.getProxyClass(p.getClass().getClassLoader(), Person.class);
//        System.out.println(proxyClass1);
        proxyPerson.setName("lili");
        System.out.println(proxyPerson.getName());


        Person proxyPerson2 = (Person) Proxy.newProxyInstance(Person.class.getClassLoader(), new Class[]{Person.class}, new My(p));
        proxyPerson2.setName("lili2");
        System.out.println(proxyPerson2.getName());

        Teacher teacher = new TeacherImpl();
        Teacher teacherProxy = (Teacher) Proxy.newProxyInstance(Teacher.class.getClassLoader(), new Class[]{Teacher.class}, new MyInvocationHandler(teacher));
        System.out.println(teacher.getMoney());
    }
}
