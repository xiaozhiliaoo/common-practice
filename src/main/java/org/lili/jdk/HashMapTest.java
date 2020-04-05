package org.lili.jdk;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lili
 * @date 2020/2/11 20:20
 * @description
 */
public class HashMapTest {
    public static void main(String[] args) {
        Map<String,Map<String,String>> mapRoot = new HashMap<>();
        mapRoot.put("1" , new HashMap<String,String>(){{
            put("11","11");
        }});
        mapRoot.put("1" , new HashMap<String,String>(){{
            put("22","22");
        }});
        System.out.println(mapRoot);

    }
}
