package org.lili.google.guava;

import com.google.common.collect.HashBasedTable;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/1/15 23:51
 * @description
 */
public class HashBasedTableTest {
    @Test
    public void test() {
        HashBasedTable<Integer,Integer,String> table = HashBasedTable.create();
        table.put(1,1,"Rook");
        table.put(1,2,"Knight");
        table.put(1,3,"Bishop");
        boolean contains11 = table.contains(1,1);
        boolean containColumn2 = table.containsColumn(2);
        boolean containsRow1 = table.containsRow(1);
        boolean containsRook = table.containsValue("Rook");
        table.remove(1,3);
        table.get(3,4);
    }
}
