package org.lili.jdk.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: song biao wei
 * @date: 2020/9/15 21:39
 */
public class TimeClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader bf = null;
        PrintWriter pw = null;
        try {
            socket = new Socket("127.0.0.1", 8080);
            bf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println("QUERY TIME ORDER");
            System.out.println("send order 2 server succeed");
            String resp = bf.readLine();
         //   pw.println(resp);
            System.out.println("now is " + resp);
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
