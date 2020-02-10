package org.lili.fastjson;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lili
 * @date 2020/2/5 20:37
 * @description
 */
public class TestTest {

    @Test
    public void test() {
        try {
            String s = JSON.parseObject(null, String.class);
            System.out.println(s.toLowerCase());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}