package org.lili.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import lombok.Data;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author lili
 * @date 2020/8/4 21:21
 * @description
 * @notes
 */

@Data
class User {
    private int id;
    private String username;
    private Date birthday;
}

public class SerializationTest {

    private List<User> userList = new ArrayList<>();

    private String userListJSON;

    @BeforeEach
    public void setUp() {
        for (int i = 0; i < 1000000; i++) {
            User user = new User();
            user.setId(i);
            user.setUsername("张三" + i);
            user.setBirthday(new Date());
            userList.add(user);
        }
        userListJSON = JSON.toJSONString(userList);
    }


    @Test
    public void testSerialization() throws JsonProcessingException {
        //测试gson用时
        Gson gson = new Gson();
        long start = new Date().getTime();
        gson.toJson(userList);
        long end = new Date().getTime();
        System.out.println("gson转换共用时：" + (end - start) + "ms");

        //测试fastjson用时
        long start1 = new Date().getTime();
        JSON.toJSONString(userList);
        long end1 = new Date().getTime();
        System.out.println("fastjson转换共用时：" + (end1 - start1) + "ms");

        //测试jackson用时
        long start2 = new Date().getTime();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValueAsString(userList);
        long end2 = new Date().getTime();
        System.out.println("jackson转换共用时：" + (end2 - start2) + "ms");
    }


    @Test
    public void testdeserialization() throws JsonProcessingException {
        long start = System.currentTimeMillis();
        List<User> user = JSONArray.parseArray(userListJSON, User.class);
        System.out.println("JSON反序列化" + (System.currentTimeMillis() - start));

        long startStream = System.currentTimeMillis();
        List<User> users = new ArrayList<>(1);
        JSONReader reader = new JSONReader(new StringReader(userListJSON));
        reader.startArray();
        while (reader.hasNext()) {
            User vo = reader.readObject(User.class);
            users.add(vo);
        }
        reader.endArray();
        reader.close();
        System.out.println("JSON stream反序列化" + (System.currentTimeMillis() - startStream));
    }
}
