package org.lili.apache.lang3;

import org.apache.commons.lang3.concurrent.Computable;
import org.apache.commons.lang3.concurrent.Memoizer;

/**
 * @author lili
 * @date 2020/4/19 23:35
 * @description
 * @notes
 */

public class MemoizerTest {
    public static void main(String[] args) {
        Memoizer memoizer = new Memoizer(new Computable() {
            @Override
            public Object compute(Object arg) throws InterruptedException {
                return null;
            }
        });

    }
}
