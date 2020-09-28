package org.lili.netty;

public class TimeClient {
    public static void main(String[] args) {
        new Thread(new TimeClientHandle("127.0.0.1", 8080), "client0111").start();
    }
}
