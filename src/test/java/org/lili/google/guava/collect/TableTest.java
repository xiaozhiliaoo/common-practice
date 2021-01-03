package org.lili.google.guava.collect;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.ArrayTable;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import com.google.common.collect.TreeBasedTable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


/**
 * @author lili
 * @date 2020/1/16 21:17 two-tier map
 * @description https://www.baeldung.com/guava-table
 */
public class TableTest {
    @Test
    public void givenTable_whenGet_returnsSuccessfully() {
        //Use Instead of Map<R,Map<C,V>>
        Table<String, String, Integer> universityCourseSeatTable
                = HashBasedTable.create();
        universityCourseSeatTable.put("Mumbai", "Chemical", 120);
        universityCourseSeatTable.put("Mumbai", "IT", 60);
        universityCourseSeatTable.put("Harvard", "Electrical", 60);
        universityCourseSeatTable.put("Harvard", "IT", 120);

        int seatCount = universityCourseSeatTable.get("Mumbai", "IT");
        Integer seatCountForNoEntry = universityCourseSeatTable.get("Oxford", "IT");

        assertEquals(60, seatCount);
        assertNull(seatCountForNoEntry);

        System.out.println(JSON.toJSONString(universityCourseSeatTable.toString()));
        System.out.println(JSON.toJSONString(universityCourseSeatTable));

    }

    @Test
    public void testTreeBasedTable() {
        TreeBasedTable<Comparable, Comparable, Object> treeTable = TreeBasedTable.create();
    }

    @Test
    public void testArrayTable() {
//        ArrayTable.create()
    }


    @Test
    public void test() {
        Table<String,String,Integer> w = HashBasedTable.create();
        w.put("1","1",4);
        w.put("1","3",20);
        w.put("2","3",5);
        System.out.println(w.row("1"));
        System.out.println(w.column("3"));
        System.out.println(w);
        System.out.println("----------------------");
        System.out.println(JSON.toJSONString(w));
    }


}
