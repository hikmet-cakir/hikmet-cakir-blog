package com.hikmetcakir;

import com.hikmetcakir.adapter.ArticleFakeDataAdapter;
import com.hikmetcakir.article.UpdateArticleUseCaseHandler;
import com.hikmetcakir.article.usecase.UpdateArticle;
import com.hikmetcakir.common.exception.ArticleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.*;

public class UpdateArticleTest {

    UpdateArticleUseCaseHandler updateArticleUseCase;

    @BeforeEach
    void setUp() {
        updateArticleUseCase = new UpdateArticleUseCaseHandler(new ArticleFakeDataAdapter());
    }

    @Test
    void when_givenArticleWithExistId_expect_noException() {
        // Given
        String content = "HelloWorld!";
        UpdateArticle given = UpdateArticle.builder()
                .id(UUID.randomUUID().toString())
                .content(content)
                .updatedAt(LocalDateTime.now())
                .build();

        // When
        updateArticleUseCase.handle(given);

        // Then
        assertThatNoException();
    }

    @Test
    void when_givenArticleWithNonExistId_expect_throwArticleException() {
        // Given
        String content = "HelloWorld!";
        UpdateArticle given = UpdateArticle.builder()
                .id("1a2b3c4d-1234-5678-1234-12345abcde99")
                .content(content)
                .updatedAt(LocalDateTime.now())
                .build();

        // When
        assertThatExceptionOfType(ArticleException.class)
                .isThrownBy(() -> updateArticleUseCase.handle(given));
    }
}
