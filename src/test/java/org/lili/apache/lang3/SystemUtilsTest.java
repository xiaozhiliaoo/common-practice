package org.lili.apache.lang3;

import org.apache.commons.lang3.JavaVersion;
import org.apache.commons.lang3.SystemUtils;
import org.junit.Test;

import java.util.Map;

import static java.util.Collections.singletonMap;
import static org.apache.commons.lang3.JavaVersion.JAVA_1_7;
import static org.junit.Assert.*;
import static org.junit.Assume.assumeTrue;

/**
 * @author lili
 * @date 2020/1/16 15:31
 * @description
 */
public class SystemUtilsTest {
    @Test
    public void test() {
        assertTrue(SystemUtils.IS_JAVA_1_8);
        String hostName = SystemUtils.getHostName();
        System.out.println(hostName);
        System.out.println(SystemUtils.getEnvironmentVariable("java.class.path", ""));

    }

    @Test
    public void java_version_specific_test() {
        assumeAtLeast(JAVA_1_7);
        // do something only possbile with Java 7+
    }

    private static void assumeAtLeast(JavaVersion version) {
        assumeTrue(SystemUtils.isJavaVersionAtLeast(version));
    }
}
