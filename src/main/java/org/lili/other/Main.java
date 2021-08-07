package org.lili.other;

import lombok.Data;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
class OrderInfo {

    private Long orderId;

    private List<Integer> courseIds;
}


public class Main {

    public static void main(String[] args) {
        OrderInfo o1 = new OrderInfo();
        o1.setCourseIds(Lists.newArrayList(1, 2, 3, 4, 5));
        o1.setOrderId(111L);

        OrderInfo o2 = new OrderInfo();
        o2.setCourseIds(Lists.newArrayList(11, 22, 33, 44, 55));
        o2.setOrderId(222L);

        ArrayList<OrderInfo> orderInfos = Lists.newArrayList(o1, o2);
        Map<Long, List<Integer>> collect = orderInfos.stream()
                .collect(Collectors.toMap(OrderInfo::getOrderId, OrderInfo::getCourseIds, (oo1, oo2) -> oo1));
        System.out.println(collect);

    }

    @Test
    public void test2() {
        //pass by
        ArrayList<Integer> integers = Lists.newArrayList(2,111);
        //has
        ArrayList<Integer> integers1 = Lists.newArrayList(2, 3, 12, 13);
        List<Integer> collect = integers1.stream().filter(x -> integers.contains(x)).collect(Collectors.toList());
        System.out.println(collect);
    }


}
