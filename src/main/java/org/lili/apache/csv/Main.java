package org.lili.apache.csv;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.time.DateUtils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

/**
 * @author lili
 * @date 2022/2/8 11:46
 */
public class Main {




    public static void main(String[] args) throws IOException {
        System.out.println(convertDate(20210112).after(convertDate(20210312)));
        System.out.println(convertDate(20210112).after(convertDate(20200312)));
    }

    @SneakyThrows
    public static Date convertDate(int date) {
        return DateUtils.parseDate(String.valueOf(date), "yyyyMMdd");
    }
}
