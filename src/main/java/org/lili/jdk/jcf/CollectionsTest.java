package org.lili.jdk.jcf;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author lili
 * @date 2020/11/1 2:46
 * @see
 * @since
 */
public class CollectionsTest {
    @Test
    public void test() {
        List<Integer> objects = new ArrayList<>();

        Collections.sort(objects);

        Collections.sort(objects, Collections.reverseOrder());


        objects.sort(Comparator.reverseOrder());
    }
}
