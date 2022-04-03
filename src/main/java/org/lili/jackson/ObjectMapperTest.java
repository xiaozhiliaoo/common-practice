package org.lili.jackson;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ObjectMapperTest {
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    static class Person {
        @JsonProperty(value = "name")
        private String name;
    }

    @SneakyThrows
    @Test
    void testNull() {
        ObjectMapper objectMapper = new ObjectMapper();
        Person person = objectMapper.readValue("{}", Person.class);
        System.out.println(person);
    }


    @Test
    public void test() {
        ObjectMapper objectMapper = new ObjectMapper();
        Student obj = new Student();
        obj.setName("mkyong");
        obj.setAge(34);
        obj.setSkills("Java");
        Map<String, Object> map = objectMapper.convertValue(obj, Map.class);
        System.out.println(map);
    }

    @Test
    @SneakyThrows
    public void stringToMap() {
        ObjectMapper objectMapper = new ObjectMapper();
        String data = "{\"11\":11,\"22\":33}";
        Map<Integer, Integer> map = objectMapper.readValue(data, new TypeReference<Map<Integer, Integer>>() {
        });
        System.out.println(map);
    }

    @Test
    public void testTypeReference() {
        ObjectMapper objectMapper = new ObjectMapper();
        Student obj = new Student();
        obj.setName("mkyong");
        obj.setAge(34);
        obj.setSkills("Java");
        BiMap<String, Object> map = objectMapper.convertValue(obj, new TypeReference<HashBiMap<String, Object>>() {
        });
        System.out.println(map);
    }

    private <T> void doPush(List<T> t) {
        for (T t1 : t) {
            System.out.println(JSON.toJSONString(t1));
        }
    }

    @Data
    class Ali {
        private int id;
        private String name;

        public Ali(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    @Test
    void testPush() {
        doPush(Lists.newArrayList(1, 2, 3, 4, 5));
        doPush(Lists.newArrayList(new Ali(1,"name1"), new Ali(2,"name2"), 2, 3, 4, 5));
    }
}
