package com.hikmetcakir.common.exception.enums;


import com.hikmetcakir.common.exception.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiExceptionUser implements ExceptionCode {

    OPERATION_FAILED("user.operationFailed"),
    USER_NOT_FOUND("user.userNotFound");

    private final String key;

    @Override
    public String getKey() {
        return key;
    }
}
