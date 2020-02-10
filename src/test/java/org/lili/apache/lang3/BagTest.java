package org.lili.apache.lang3;

import com.alibaba.fastjson.JSON;
import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.junit.Test;

/**
 * @author lili
 * @date 2020/1/16 0:20
 * @description
 */
public class BagTest {
    @Test
    public void test() {
        Bag bag = new HashBag();
        bag.add("Test1", 3);
        bag.add("Test2");

        System.out.println(JSON.toJSONString(bag));
    }
}
