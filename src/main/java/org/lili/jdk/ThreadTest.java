package org.lili.jdk;

import lombok.SneakyThrows;

import static java.lang.Thread.sleep;

/**
 * @author lili
 * @date 2020/7/30 11:46
 * @description
 * @notes
 */
class Task implements Runnable {

    @Override
    public void run() {
        try {
            sleep(50000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("......");
    }
}

public class ThreadTest {
    public static void main(String[] args) {

        System.out.println(8%1);
        Thread pcAdminUpdate = new Thread(new Task());
        pcAdminUpdate.setName("LiLi");
        pcAdminUpdate.start();
        Thread pcAdminUpdate2 = new Thread(new Task());
        pcAdminUpdate2.setName("LiLi");
        pcAdminUpdate2.start();
    }
}
