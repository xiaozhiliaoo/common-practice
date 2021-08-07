package org.lili.jackson;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ObjectMapperTest {
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
    public void testTypeReference() {
        ObjectMapper objectMapper = new ObjectMapper();
        Student obj = new Student();
        obj.setName("mkyong");
        obj.setAge(34);
        obj.setSkills("Java");
        Map<String, Object> map = objectMapper.convertValue(obj, new TypeReference<Map<String, Object>>() {});
        System.out.println(map);
    }
}
