package org.lili.jdk;

import com.alibaba.fastjson.JSON;
import lombok.Data;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lili
 * @date 2020/9/17 0:30
 * @notes
 */

@Data
class UserQueryRecordReq {
    private String appKey;

    private String openId;

    private Integer userId;

    private String mobileNumber;

    private String email;

    /**
     * 每页条数,默认每页20，最大1000
     */
    private int pageSize = 20;

    /**
     * 页数，默认第1页
     */
    private int pageNumber = 1;


    public String buildPayload() {
        Map<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("pageSize", pageSize);
        params.put("pageNumber", pageNumber);
        params.put("mobileNumber", mobileNumber);
        params.put("email", email);
        return JSON.toJSONString(params);
    }

}

public class ObjectPassMethodTest {
    @Test
    public void test() {
        UserQueryRecordReq recordReq = new UserQueryRecordReq();
        recordReq.setAppKey("lilili");
        changeIt(recordReq);
        System.out.println(recordReq);
        System.out.println(recordReq.buildPayload());
    }

    public void changeIt(UserQueryRecordReq recordReq) {
        recordReq.setAppKey("alibaba");
        recordReq.setEmail("lilili");
        recordReq.setUserId(12345);
    }
}
