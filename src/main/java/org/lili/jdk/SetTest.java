package org.lili.jdk;

/**
 * @author lili
 * @date 2020/2/10 20:19
 * @description
 * @notes
 */



import com.google.common.collect.Sets;
import org.junit.jupiter.api.Test;

import java.util.*;

public class SetTest {
    public static void main(String[] args) {
        Set<String> hashSet = new HashSet<>();

    }

    @Test
    public void test() {
        HashSet<Integer> s1 = Sets.newHashSet(1, 2, 3,4,4,4,3,3, 4);
        HashSet<Integer> s2 = Sets.newHashSet(1, 2, 3);
        System.out.println(Sets.difference(s1, s2));
        System.out.println(Sets.intersection(s1, s2));
        System.out.println(Sets.union(s1, s2));
    }
}
