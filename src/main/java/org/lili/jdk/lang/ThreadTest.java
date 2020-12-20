package org.lili.jdk.lang;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lili
 * @date 2020/12/11 18:37
 * @notes
 */
public class ThreadTest {

    @Test
    public void test() {

        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        Set<String> stacks = new HashSet<>();
        for (StackTraceElement st : stackTrace) {
//            String cls = st.getClassName();
//            String stack = String.format((Locale)null, "%s%s(%s:%s)",
//                    cls,
//                    st.getMethodName(),
//                    st.getFileName(),
//                    st.getLineNumber());
            stacks.add(st.toString());
        }
        System.out.println(stacks);
    }

}
