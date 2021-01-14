package org.lili.jdk.lang;

import org.junit.jupiter.api.Test;

/**
 * @author lili
 * @date 2021/1/10 2:40
 * @notes
 */
class BaseException extends Exception {
    public BaseException(Exception ex) {
        super(ex);
    }

    private static final long serialVersionUID = 3987852541476867869L;
}

public class DisappearedExceptionTest {

    public void show() throws BaseException {
        try {
            Integer.parseInt("Hello");
        } catch (NumberFormatException e1) {
            throw new BaseException(e1);
        } finally {
            try {
                int result = 2 / 0;
            } catch (ArithmeticException e2) {
                throw new BaseException(e2);
            }
        }
    }


    public void show2() throws BaseException {
        NumberFormatException nfe = null;
        try {
            Integer.parseInt("Hello");
        } catch (NumberFormatException e1) {
            nfe = e1;
            throw new BaseException(e1);
        } finally {
            try {
                int result = 2 / 0;
            } catch (ArithmeticException e2) {
                e2.addSuppressed(nfe);
                throw new BaseException(e2);
            }
        }
    }

    @Test
    public void testShow() throws BaseException {
        show();
    }

    @Test
    public void testShow2() throws BaseException {
        show2();
    }
}
