package org.lili.jdk;

import com.google.common.base.Supplier;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.TreeMap;

/**
 * @author lili
 * @date 2020/5/12 0:28
 * @description
 * @notes
 */
class Boundary {

    public void hello(String name, int age) {

    }
}

public class ParameterTest {
    public static void main(String[] args) {
        Method[] methods = Boundary.class.getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + "(");
            Parameter[] parameters = method.getParameters();
            for (Parameter parameter : parameters) {
                System.out.print(parameter.getType().getName() + " " + parameter.getName() + " ");
            }

        }

        Supplier<TreeMap<String, String>> treeMapSupplier = () -> new TreeMap<String, String>();
        TreeMap<String, String> stringStringTreeMap = treeMapSupplier.get();

        System.out.println();
        System.out.println(to().orElse("4444"));
    }

    public static Optional<String> to() {
        return Optional.empty();
    }
}
