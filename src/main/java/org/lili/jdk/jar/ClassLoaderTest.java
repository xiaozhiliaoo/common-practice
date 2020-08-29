package org.lili.jdk.jar;

import com.google.common.collect.MapMaker;
import com.sun.nio.zipfs.ZipInfo;
import sun.net.spi.nameservice.dns.DNSNameService;

import javax.crypto.Cipher;
import java.net.URL;

/**
 * @author lili
 * @date 2020/8/29 20:24
 * @description
 * @notes
 */

public class ClassLoaderTest {
    public static void main(String[] args) {
        //null值来代表引导类加载器的约定规则,BootstrapClassLoader C++写的，对Java不可见
        System.out.println(Object.class.getClassLoader());
        System.out.println(String.class.getClassLoader());
        System.out.println(Cipher.class.getClassLoader());
        System.out.println(MapMaker.class.getClassLoader());
        System.out.println("ClassLoaderTest:"+ClassLoaderTest.class.getClassLoader());
        System.out.println("ClassLoaderTest Parent:"+ClassLoaderTest.class.getClassLoader().getParent());
        System.out.println("ClassLoaderTest Parent Parent:"+ClassLoaderTest.class.getClassLoader().getParent().getParent());
        System.out.println(ClassLoader.getSystemClassLoader());
        //C:\Program Files\Java\jdk1.8.0_181\jre\lib\ext
        System.out.println(DNSNameService.class.getClassLoader());
        System.out.println(ZipInfo.class.getClassLoader());
        String classPath = System.getProperty("java.class.path");
        for (String path : classPath.split(";")) {
            System.out.println(path);
        }

        URL[] urLs = sun.misc.Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urLs) {
            System.out.println(url.toExternalForm());
        }

        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
