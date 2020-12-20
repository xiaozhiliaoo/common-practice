package org.lili.apache.lang3;

import org.apache.commons.lang3.exception.ContextedException;
import org.apache.commons.lang3.exception.ContextedRuntimeException;
import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2020/1/16 15:57
 * @description
 */
public class ContextedRuntimeExceptionTest {
    @Test
    public void testContextedRuntimeException() {
        ContextedRuntimeException exception = new ContextedRuntimeException();
        exception.addContextValue("userName", "lili");
        exception.addContextValue("userAge", "23");
        throw exception;
    }

    @Test
    public void testContextedException() {

        try {
            throw new ContextedException();
        } catch (ContextedException e) {
            e.printStackTrace();
        }
    }
}
