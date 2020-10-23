package org.lili.google.guava;

import com.google.common.base.Preconditions;
import org.junit.Test;

/**
 * @author lili
 * @date 2020/10/20 16:57
 * @notes
 */
public class PreconditionsTest {
    @Test
    public void test() {
        check(null);
    }

    public void check(String data) {
        Preconditions.checkNotNull(data,"dddd %s", "fff");
    }
}
