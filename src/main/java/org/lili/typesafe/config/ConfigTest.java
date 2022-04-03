package org.lili.typesafe.config;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2022/3/27 14:30
 */
public class ConfigTest {
    @Test
    void test() {
        Config config1 = ConfigFactory.load("config-test");
        System.out.println("config1, complex-app.something="
                + config1.getString("complex-app.something"));
    }
}
