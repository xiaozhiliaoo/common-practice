package org;

import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author lili
 * @date 2020/11/11 15:51
 * @notes
 */
public class Main {

    public static final Long ORDER_ID = 987654321L;
    public static final String CONTENT = "订单[987654321]的课程[123456]拆分后的结算金额为负:课程金额:56.77,物料金额:45.66";


    @Test
    void testParse2() {
        List<Integer> integers = Arrays.asList(210250779, 210065262, 209936193, 209683941, 210356242, 210247386, 210193071, 210165856, 210089186, 210006466, 209991341, 209903932, 209893247, 209879062, 209857593, 209836140, 209809127, 209766517, 209706062, 209656003, 209523274, 209844642, 209814379, 209814344, 209812864, 209812862, 209810783, 209810758, 209758633, 209758629, 209757357, 209757355, 209757346, 209285476, 209197621, 207927891, 207781677, 207773140, 207540440, 207093146, 207066166, 206990809);
        List<Integer> integers2 = Arrays.asList(209197621,209285476,209523274,209656003,209683941,209706062,209757346,209757355,209757357,209758629,209758633,209766517,209809127,209810758,209810783,209812862,209812864,209814344,209814379,209836140,209844642,209857593,209879062,209893247,209903932,209936193,209991341,210006466,210065262,210089186,210165856,210193071,210247386,210250779,210356242);
        Sets.SetView difference = Sets.difference(new HashSet(integers), new HashSet<>(integers2));
        System.out.println(difference);


    }


    public static String parseOrderId(String message) {
        if (StringUtils.isBlank(message) ||
                !message.contains("[") ||
                !message.contains("]")) return null;
        return message.substring(message.indexOf("[") + 1, message.indexOf("]"));
    }

}
