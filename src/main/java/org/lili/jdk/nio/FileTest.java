package org.lili.jdk.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * @author lili
 * @date 2020/11/1 1:59
 * @see
 * @since
 */
public class FileTest {
    @Test
    public void test() throws IOException {
        Stream<Path> walk = Files.walk(null);
    }
}
