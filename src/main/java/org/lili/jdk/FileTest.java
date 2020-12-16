package org.lili.jdk;

import com.google.common.io.Files;
import org.apache.commons.io.FileUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author lili
 * @date 2020/3/11 22:20
 * @description
 * @notes
 */

public class FileTest {

    @Test
    public void testCreateFile() throws Exception {

        File file = new File("maven打包命名.txt");
        FileUtils.copyInputStreamToFile(new FileInputStream("C:\\Users\\chao\\Desktop\\maven打包命名.txt"), file);
        System.out.println(file.getName());
        System.out.println(file.getAbsolutePath());

        file.delete();

    }








    public static void main(String[] args) throws IOException {
        String pathSeparator = File.separator;
        File file = new File(".");
        String path = file.getAbsolutePath();
        System.out.println(path);
        String property = System.getProperty("user.dir");
        System.out.println(property);

        //同级目录下创建文件
        String currentWorkingDir = Paths.get("").toAbsolutePath().normalize().toString();
        System.out.println(currentWorkingDir);
        String pathname = currentWorkingDir + pathSeparator + "lili.txt";
        File file1 = new File(pathname);
        file1.createNewFile();
    }
}
