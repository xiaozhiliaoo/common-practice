package org.lili.google.guava;

import com.google.common.util.concurrent.ExecutionList;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lili
 * @date 2020/9/12 3:06
 * @notes
 */
public class ExecutionListTest {

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(33);
        ExecutionList executionList = new ExecutionList();
        executionList.add(() -> {
            System.out.println("4444");
        }, executorService);
        executionList.add(() -> {
            System.out.println("4444");
        }, executorService);
        executionList.add(() -> {
            System.out.println("4444");
        }, executorService);
        executionList.execute();
    }
}
