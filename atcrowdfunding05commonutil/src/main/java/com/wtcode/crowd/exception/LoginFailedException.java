package com.wtcode.crowd.exception;

/**
 * 登录失败后抛出的异常
 * @author wtcode
 * @date 2021/1/26 - 17:19
 */
public class LoginFailedException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    public LoginFailedException() {
        super();
    }

    public LoginFailedException(String message) {
        super(message);
    }

    public LoginFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginFailedException(Throwable cause) {
        super(cause);
    }

    protected LoginFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
