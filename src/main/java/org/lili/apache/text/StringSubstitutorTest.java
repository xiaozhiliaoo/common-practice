package org.lili.apache.text;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.Data;
import org.apache.commons.text.StringSubstitutor;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

@Data
class Animal {
    private String animal;
    private String target;
    private String source;

    public Animal(String animal, String target, String source) {
        this.animal = animal;
        this.target = target;
        this.source = source;
    }
}

public class StringSubstitutorTest {
    @Test
    public void test() {
        Animal animal = new Animal("dog", "table", "floor");
        JSONObject jsonObject = (JSONObject) JSON.toJSON(animal);
        String templateString = "The ${animal} jumped over the ${target} from ${source}.";
        StringSubstitutor sub = new StringSubstitutor(jsonObject);
        String resolvedString = sub.replace(templateString);
        System.out.println(resolvedString);
    }
}
