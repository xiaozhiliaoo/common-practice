package org.lili.apache.lang3;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.jupiter.api.Test;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * @author lili
 * @date 2020/1/16 0:20
 * @description
 */
class Callablea implements Callable<String> {
    @Override
    public String call() throws Exception {
        return null;
    }
}

public class BagTest {
    @Test
    public void test() {

        Bag bag = new HashBag();
        bag.add("Test1", 3);
        bag.add("Test2");

        System.out.println(JSON.toJSONString(bag));
    }
}
