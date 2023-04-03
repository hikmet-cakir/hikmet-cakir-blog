package com.hikmetcakir;

import com.hikmetcakir.adapter.ArticleFakeDataAdapter;
import com.hikmetcakir.article.QueryArticleUseCaseHandler;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.common.exception.ArticleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class QueryArticleTest {

    QueryArticleUseCaseHandler queryArticleUseCaseHandler;

    @BeforeEach
    void setUp() {
        queryArticleUseCaseHandler = new QueryArticleUseCaseHandler(new ArticleFakeDataAdapter());
    }

    @Test
    void when_givenArticleWithExistId_expect_noException() {
        // Given
        QueryArticle given = QueryArticle.builder()
                .id(UUID.randomUUID().toString())
                .build();

        // When
        queryArticleUseCaseHandler.handle(given);

        // Then
        assertThatNoException();
    }

    @Test
    void when_givenArticleWithNonExistId_expect_throwArticleException() {
        // Given
        QueryArticle given = QueryArticle.builder()
                .id("1a2b3c4d-1234-5678-1234-12345abcde99")
                .build();

        // When
        assertThatExceptionOfType(ArticleException.class)
                .isThrownBy(() -> queryArticleUseCaseHandler.handle(given));
    }
}
