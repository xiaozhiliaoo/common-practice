package org.lili.jdk;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.Builder;
import lombok.ToString;

/**
 * @author lili
 * @date 2020/9/9 20:33
 * @see
 * @since
 */
@Builder
public class Params {
    private String[] aa;
    private String arg1;
    private String arg2;
    private String arg3;
    private String arg4;


    public static void main(String[] args) {
        System.out.println(Params.builder().arg1("44").build());
        System.out.println(Params.builder().arg1("44").arg4("556").build());
    }
}
