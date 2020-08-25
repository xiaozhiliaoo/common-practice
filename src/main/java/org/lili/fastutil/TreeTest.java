package org.lili.fastutil;

import com.github.xiaozhiliaoo.refactor.Refactor;
import it.unimi.dsi.fastutil.ints.IntRBTreeSet;

/**
 * @author lili
 * @date 2020/4/7 16:51
 * @description
 * @notes
 */

public class TreeTest {
    public static void main(String[] args) {
        IntRBTreeSet rbTreeSet = new IntRBTreeSet();
        rbTreeSet.add(1);
        rbTreeSet.add(8);
        rbTreeSet.add(7);
        rbTreeSet.add(6);
        System.out.println(rbTreeSet);
    }
}
