package com.ponder.sessiondata.common.exception;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/8 18:53
 */
public class BaseException extends RuntimeException{

    private BaseErrorCode errorCode;

    public BaseException() {
    }

    public BaseException(String message,BaseErrorCode baseErrorCode) {
        super(message);
        this.errorCode = baseErrorCode;
    }

    public BaseException(String message) {
        super(message);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
    }

    public BaseException(Throwable cause) {
        super(cause);
    }

    public BaseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }



}
