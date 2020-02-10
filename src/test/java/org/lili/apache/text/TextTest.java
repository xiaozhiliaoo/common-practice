package org.lili.apache.text;

import org.apache.commons.lang3.text.StrSubstitutor;
import org.apache.commons.text.StringSubstitutor;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lili
 * @date 2020/1/16 16:34
 * @description org.apache.commons.text
 */
public class TextTest {
    @Test
    public void testStringSubstitutor() {
        Map<String, String> valuesMap = new HashMap<>();
        valuesMap.put("animal", "quick brown fox");
        valuesMap.put("target", "lazy dog");
        String templateString = "The ${animal} jumped over the ${target}.";
        StringSubstitutor sub = new StringSubstitutor(valuesMap);
        String resolvedString = sub.replace(templateString);
        System.out.println(resolvedString);


        Map valuesMap2 = new HashMap<>();
        valuesMap2.put("animal", "quick brown fox");
        valuesMap2.put("target", "lazy dog");
        String templateString2 = "The ${animal} jumped over the ${target}. ${undefined.number:-1234567890}.";
        StringSubstitutor sub2 = new StringSubstitutor(valuesMap2);
        String resolvedString2 = sub.replace(templateString2);
    }
}
