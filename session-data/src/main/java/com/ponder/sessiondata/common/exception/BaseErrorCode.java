package com.ponder.sessiondata.common.exception;

/**
 * @auth ponder
 * @Email gponder.g@gmail.com
 * @create 2020/5/8 18:54
 */
public enum BaseErrorCode {
    VALIDATOR_ERROR(500);

    private int code;

    BaseErrorCode(int code) {
        this.code = code;
    }

}
