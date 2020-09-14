package org.lili.fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.annotation.JSONField;
import lombok.ToString;

/**
 * @author lili
 * @date 2020/2/5 20:37
 * @description
 */
@lombok.Data
class Data {
    @JSONField(name = "id_id")
    private int id;
    @JSONField(name = "name_name")
    private String name;
}

public class Test {
    public static void main(String[] args) {
        Data data = new Data();
        data.setId(1);
        data.setName("name");
        System.out.println(JSON.toJSONString(data));
        //hget  不一定就是json啊
        Data data1 = JSON.parseObject("{'empty','emtpy'}", Data.class);
        System.out.println(data1);
    }
}
