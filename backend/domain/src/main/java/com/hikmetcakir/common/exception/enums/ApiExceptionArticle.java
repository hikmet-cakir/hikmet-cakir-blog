package com.hikmetcakir.common.exception.enums;

import com.hikmetcakir.common.exception.ExceptionCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiExceptionArticle implements ExceptionCode {

    OPERATION_FAILED("article.operationFailed"),
    ARTICLE_NOT_FOUND("article.articleNotFound");

    private final String key;

    @Override
    public String getKey() {
        return key;
    }
}
