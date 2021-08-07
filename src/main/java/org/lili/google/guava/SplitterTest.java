package org.lili.google.guava;

import com.google.common.base.Splitter;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringSubstitutor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author lili
 * @date 2020/11/29 14:47
 * @notes
 */
public class SplitterTest {
    @Test
    public void test() {
        List<String> user = Splitter.on("|").omitEmptyStrings().trimResults().splitToList("");
        assertThat(user).isEmpty();

    }

    @Test
    public void test2() {
        String desc = "（全国通用）【初二语文】六项全能春季班 课程消耗:60.00% (9/15) 可退金额:540元\n" +
                " 资料费:-43.75元 邮费:-8元 实际申请退款:488.25元";
        String courseTitle = StringUtils.substringBetween(desc, "", " 课程消耗");
        String data = StringUtils.substringBetween(desc, "课程消耗", " 可退金额");
        String precent = StringUtils.substringBetween(data, ":", "%");
        String processDoneNum = StringUtils.substringBetween(data, "(", "/");
        String processPlanNum = StringUtils.substringBetween(data, "/", ")");
        System.out.println(new BigDecimal(precent).stripTrailingZeros().divide(new BigDecimal("100")).stripTrailingZeros());
        System.out.println(processDoneNum);
        System.out.println(processPlanNum);
        System.out.println(courseTitle);

    }

    class User {
        String name;
        String phone;
        String address;
        BigDecimal scope;

        public User(String name, String phone, String address) {
            this.name = name;
            this.phone = phone;
            this.address = address;
        }

        public User(String name, String phone, String address, BigDecimal scope) {
            this.name = name;
            this.phone = phone;
            this.address = address;
            this.scope = scope;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", phone='" + phone + '\'' +
                    ", address='" + address + '\'' +
                    ", scope=" + scope +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name) &&
                    Objects.equals(phone, user.phone) &&
                    Objects.equals(address, user.address) &&
                    Objects.equals(scope, user.scope);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, phone, address);
        }
    }

    @Test
    void test3() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("tom", "bb", "cc", new BigDecimal("34.55")));
        users.add(new User("tom", "bb", "cc", new BigDecimal("340.55")));
        users.add(new User("jerry", "dd", "ee", new BigDecimal("355")));
        users.add(new User("jerry", "dd", "ee", new BigDecimal("4.55")));
        System.out.println(users);
    }


    @Test
    void test4() {
        HashSet<Integer> x = Sets.newHashSet(1, 2, 3, 4, 5);
        HashSet<Integer> y = Sets.newHashSet(4, 5);
        System.out.println(Sets.difference(x, y));
    }
}
