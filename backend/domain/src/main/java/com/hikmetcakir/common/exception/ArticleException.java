package com.hikmetcakir.common.exception;

import com.hikmetcakir.common.exception.enums.ApiExceptionArticle;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ArticleException extends RuntimeException {

    private ExceptionCode exceptionCode;

    private String[] args;

    public ArticleException(ExceptionCode exceptionCode, String... args) {
        this.exceptionCode = exceptionCode;
        this.args = args;
    }

    public ArticleException(String message) {
        this(ApiExceptionArticle.OPERATION_FAILED, message);
    }
}
