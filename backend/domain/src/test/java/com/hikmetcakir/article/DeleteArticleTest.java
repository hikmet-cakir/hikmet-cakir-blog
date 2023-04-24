package com.hikmetcakir.article;

import com.hikmetcakir.article.adapter.ArticleFakeDataAdapter;
import com.hikmetcakir.article.usecase.DeleteArticle;
import com.hikmetcakir.common.exception.ArticleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class DeleteArticleTest {

    DeleteArticleUseCaseHandler deleteArticleUseCase;

    @BeforeEach
    void setUp() {
        deleteArticleUseCase = new DeleteArticleUseCaseHandler(new ArticleFakeDataAdapter());
    }

    @Test
    void when_givenArticleWithExistId_expect_noException() {
        //region Given
        DeleteArticle given = DeleteArticle.builder()
                .id(UUID.randomUUID().toString())
                .build();
        //endregion

        //region When
        deleteArticleUseCase.handle(given);
        //endregion

        //region Then
        assertThatNoException();
        //endregion
    }

    @Test
    void when_givenArticleWithNonExistId_expect_throwArticleException() {
        //region Given
        DeleteArticle given = DeleteArticle.builder()
                .id("1a2b3c4d-1234-5678-1234-12345abcde99")
                .build();
        //endregion

        //region When
        assertThatExceptionOfType(ArticleException.class)
                .isThrownBy(() -> deleteArticleUseCase.handle(given));
        //endregion
    }
}
