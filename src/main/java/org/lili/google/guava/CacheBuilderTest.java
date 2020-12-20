package org.lili.google.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/8/17 23:50
 * @description
 * @notes
 */

public class CacheBuilderTest {
    @Test
    public void test() {
        Cache<Object, Object> build = CacheBuilder.newBuilder().build();

    }
}
