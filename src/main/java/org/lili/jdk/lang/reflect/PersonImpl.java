package org.lili.jdk.lang.reflect;

/**
 * @author lili
 * @date 2020/11/21 17:20
 * @notes
 */
public class PersonImpl implements Person {
    private String name;
    @Override
    public String getName() { return name; }
    @Override
    public void setName(String name) { this.name = name; }
}
