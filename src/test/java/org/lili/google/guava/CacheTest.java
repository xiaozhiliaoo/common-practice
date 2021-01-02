package org.lili.google.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/1/17 15:35
 * @description on-heap cache
 */
public class CacheTest {

    private Cache<Integer, Cache<String, String>> allCompanyCache =
            CacheBuilder.newBuilder().build();



    @Test
    public void test() {

        Cache<String, String> companyCache1 = CacheBuilder.newBuilder().build();
        Cache<String, String> companyCache2 = CacheBuilder.newBuilder().build();
        Cache<String, String> companyCache3 = CacheBuilder.newBuilder().build();
        companyCache1.put("c11","n1");
        companyCache1.put("c12","n2");
        companyCache1.put("c13","n3");
        companyCache2.put("c21","n1");
        companyCache2.put("c22","n2");
        companyCache2.put("c23","n3");
        companyCache3.put("c31","n1");
        companyCache3.put("c32","n2");
        companyCache3.put("c33","n3");
        allCompanyCache.put(1, companyCache1);
        allCompanyCache.put(2, companyCache2);
        allCompanyCache.put(3, companyCache2);

        System.out.println(allCompanyCache.asMap());


    }
}
