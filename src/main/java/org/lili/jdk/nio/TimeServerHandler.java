package org.lili.jdk.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: song biao wei
 * @date: 2020/9/15 21:23
 */
public class TimeServerHandler implements Runnable {

    Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            bf = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            pw = new PrintWriter(this.socket.getOutputStream(), true);
            while (true) {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("+++++++++++++++++");
                String body = bf.readLine();
                if (body == null) {
                    break;
                }
                System.out.println("-----------------");
                System.out.println("time server receive order : " + body);
                String currentTime = "QUERY TIME ORDER".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString() : "BAD ORDER";
                //提问：write和println的区别是什么？
//                pw.write(currentTime+"\r\n");
//                pw.flush();
                pw.println(currentTime);

                //pw.write 不会给客户端返回值的，必须加\r\n才可以，而println可以直接返回值
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bf != null) {
                try {
                    bf.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
            if (pw != null) {
                try {
                    pw.close();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
            }
        }
    }
}
