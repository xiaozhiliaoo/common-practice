package org.lili.fastjson;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections4.MapUtils;

/**
 * @author lili
 * @date 2020/3/16 19:12
 * @description
 * @notes
 */

public class TestAsMap {
    public static void main(String[] args) {
        JSONObject object = new JSONObject();
        object.put("11","222");
        object.put("22","222");
        System.out.println(MapUtils.getString(object, "11", "22"));
        System.out.println(MapUtils.getString(object, null, "22"));
    }
}
