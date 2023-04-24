package com.hikmetcakir.article;

import com.hikmetcakir.article.adapter.ArticleFakeDataAdapter;
import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.common.exception.ArticleException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThat;

public class QueryArticleTest {

    QueryArticleUseCaseHandler queryArticleUseCaseHandler;

    @BeforeEach
    void setUp() {
        queryArticleUseCaseHandler = new QueryArticleUseCaseHandler(new ArticleFakeDataAdapter());
    }

    @Test
    void when_givenArticleWithExistId_expect_noException() {
        //region Given
        QueryArticle given = QueryArticle.builder()
                .id(UUID.randomUUID().toString())
                .build();
        //endregion

        //region When
        queryArticleUseCaseHandler.handle(given);
        //endregion

        //region Then
        assertThatNoException();
        //endregion
    }

    @Test
    void when_givenArticleWithNonExistId_expect_throwArticleException() {
        //region Given
        QueryArticle given = QueryArticle.builder()
                .id("1a2b3c4d-1234-5678-1234-12345abcde99")
                .build();
        //endregion

        //region When
        assertThatExceptionOfType(ArticleException.class)
                .isThrownBy(() -> queryArticleUseCaseHandler.handle(given));
        //endregion
    }

    @Test
    void when_queryExistArticleWithTitle_expect_getExistArticle() {
        //region Given
        QueryArticle given = QueryArticle.builder()
                .title("SpringCloud")
                .build();
        //endregion

        //region When
        var actual = queryArticleUseCaseHandler.handle(given);
        //endregion

        //region Then
        String expectedArticleTitle = "SpringCloud";
        assertThat(actual)
                .hasSize(1)
                .extracting(Article::getTitle)
                .containsExactlyInAnyOrder(expectedArticleTitle);
        //endregion
    }

    @Test
    void when_queryExistArticlesWithTitle_expect_getExistArticles() {
        //region Given
        QueryArticle given = QueryArticle.builder()
                .content("HelloWorld")
                .createdAt(LocalDateTime.now())
                .size(1)
                .page(0)
                .build();
        //endregion

        //region When
        var actual = queryArticleUseCaseHandler.handle(given);
        //endregion

        //region Then
        String expectedContentMaterial = "HelloWorld";
        assertThat(actual)
                .hasSize(1)
                .extracting(Article::getContent)
                .containsExactlyInAnyOrder(expectedContentMaterial);
        //endregion
    }
}
