package org.lili.jdk.lang.reflect;

import java.util.Arrays;
import java.util.List;

/**
 * @author lili
 * @date 2020/11/21 21:39
 * @see
 * @since
 */
public class TeacherImpl implements Teacher {
    @Override
    public List<String> getMoney() {
        return Arrays.asList("aaa,rrr,555,ggg".split(","));
    }
}
