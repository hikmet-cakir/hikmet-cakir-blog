package com.hikmetcakir.common.exception;

import com.hikmetcakir.common.exception.enums.ApiExceptionUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserException extends RuntimeException {

    private ExceptionCode exceptionCode;

    private String[] args;

    public UserException(ExceptionCode exceptionCode, String... args) {
        this.exceptionCode = exceptionCode;
        this.args = args;
    }

    public UserException(String message) {
        this(ApiExceptionUser.OPERATION_FAILED, message);
    }
}
