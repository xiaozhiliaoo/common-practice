package org.lili.google.guava;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2021/6/23 12:28
 */
public class TableTest {
    @Test
    public void test() {
        Table<String, String, String> employeeTable = HashBasedTable.create();
        employeeTable.put("2","32","34");
        System.out.println(employeeTable.row("2").get("32"));
    }
}