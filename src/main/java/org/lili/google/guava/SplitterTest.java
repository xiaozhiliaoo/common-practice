package org.lili.google.guava;

import com.google.common.base.Splitter;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

/**
 * @author lili
 * @date 2020/11/29 14:47
 * @notes
 */
public class SplitterTest {
    @Test
    public void test() {
        List<String> user = Splitter.on("|").omitEmptyStrings().trimResults().splitToList("");
        assertThat(user).isEmpty();

    }
}
