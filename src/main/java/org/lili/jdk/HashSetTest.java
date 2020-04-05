package org.lili.jdk;

import com.google.common.collect.Sets;
import org.apache.commons.collections4.SetUtils;
import org.junit.Test;

import java.util.HashSet;

/**
 * @author lili
 * @date 2020/4/5 11:54
 * @description
 * @notes
 */

public class HashSetTest {
    @Test
    public void test() {
        //缺少交并补功能，并且交并补功能效率不高
        HashSet set = new HashSet<>();

        //Collection4
        //SetUtils.difference();

        //Guava
        //Sets.union()
    }
}
