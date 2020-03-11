package org.lili.jdk;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;

/**
 * @author lili
 * @date 2020/3/11 22:20
 * @description
 * @notes
 */

public class FileTest {
    public static void main(String[] args) throws IOException {
        System.out.println("lili");
        String pathSeparator = File.separator;
        System.out.println(pathSeparator);
        File file = new File("config" + pathSeparator + "lili.txt");
        file.mkdir();
    }
}
