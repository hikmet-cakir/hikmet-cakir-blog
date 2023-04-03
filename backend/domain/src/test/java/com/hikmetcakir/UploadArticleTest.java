package com.hikmetcakir;

import com.hikmetcakir.adapter.ArticleFakeDataAdapter;
import com.hikmetcakir.article.UploadArticleUseCaseHandler;
import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.usecase.UploadArticle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UploadArticleTest {

    UploadArticleUseCaseHandler uploadArticleUseCase;

    @BeforeEach
    void setUp() {
        uploadArticleUseCase = new UploadArticleUseCaseHandler(new ArticleFakeDataAdapter());
    }

    @Test
    void when_givenContent_expect_takeSavedArticle() {
        // Given
        String content = "HelloWorld!";
        UploadArticle given = UploadArticle.builder()
                .content(content)
                .build();

        // When
        var actual = uploadArticleUseCase.handle(given);

        // Then
        assertThat(actual).isNotNull().returns(content, Article::getContent);
    }
}
