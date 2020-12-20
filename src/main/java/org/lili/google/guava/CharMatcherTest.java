package org.lili.google.guava;

import com.google.common.base.CharMatcher;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author lili
 * @date 2020/8/27 0:12
 * @description
 * @notes
 */

public class CharMatcherTest {
    @Test
    public void whenRemoveSpecialCharacters_thenRemoved(){
        String input = "H*el.lo,}12";
        CharMatcher matcher = CharMatcher.javaLetterOrDigit();
        String result = matcher.retainFrom(input);
        assertEquals("Hello12", result);
    }

    @Test
    public void whenRemoveNonASCIIChars_thenRemoved() {
        String input = "あhello₤";

        String result = CharMatcher.ascii().retainFrom(input);
        assertEquals("hello", result);

        result = CharMatcher.inRange('0', 'z').retainFrom(input);
        assertEquals("hello", result);
    }

    @Test
    public void whenReplaceFromString_thenReplaced() {
        String input = "apple-banana.";

        String result = CharMatcher.anyOf("-.").replaceFrom(input, '!');
        assertEquals("apple!banana!", result);

        result = CharMatcher.is('-').replaceFrom(input, " and ");
        assertEquals("apple and banana.", result);

        String remove = StringUtils.remove("www.baidu.com////`/coCommon/forward", "/coCommon/forward");
        System.out.println("remove"+ remove);


        System.out.println("www.baidu.com////`/coCommon/forward".replaceAll("/coCommon/forward", ""));

        CharMatcher any = CharMatcher.noneOf("/coCommon/forward");
        String s = any.retainFrom("www.baidu.com////`/coCommon/forward");
        System.out.println(s);

    }
}
