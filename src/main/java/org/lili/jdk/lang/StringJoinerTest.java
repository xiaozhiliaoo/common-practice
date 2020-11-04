package org.lili.jdk.lang;

import org.junit.Test;

import java.util.StringJoiner;

/**
 * @author lili
 * @date 2020/10/24 22:09
 * @notes
 */
public class StringJoinerTest {
    @Test
    public void test() {
        StringJoiner sj = new StringJoiner(":", "[", "]");
        sj.add("George").add("Sally").add("Fred").add("fff");
        String desiredString = sj.toString();
        System.out.println(sj);
    }
}
