package org.lili.google.guava.collect;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author lili
 * @date 2020/1/16 21:41
 * @description
 * inherently thread-safe
 * reduce memory footprint
 * slightly increased performance
 */
public class ImmutableTest {
    @Test
    public void test() {
        List<Object> objects = Collections.unmodifiableList(new ArrayList<>());
        objects.add(new ArrayList<>());

    }
}
