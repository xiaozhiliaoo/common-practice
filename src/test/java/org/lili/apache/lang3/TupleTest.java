package org.lili.apache.lang3;

import javafx.util.Pair;
import org.apache.commons.lang3.tuple.MutableTriple;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lili
 * @date 2020/1/16 16:22
 * @description Package org.apache.commons.lang3.tuple
 */
public class TupleTest {

    @Test
    public void testPair() {
        Pair<String, String> pair = new Pair<>("name", "lili");
        List<Pair<String,String>> pairs = new ArrayList<>();

    }

    @Test
    public void testTuple() {
        Triple<String, String, String> triple = new MutableTriple<>("lili", "age", "23");

    }

}
