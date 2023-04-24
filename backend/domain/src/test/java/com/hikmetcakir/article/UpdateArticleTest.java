package com.hikmetcakir.article;

import com.hikmetcakir.article.adapter.ArticleFakeDataAdapter;
import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.model.Genre;
import com.hikmetcakir.article.usecase.UpdateArticle;
import com.hikmetcakir.article.usecase.UploadArticle;
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
    void when_givenArticleWithExistId_expect_updateArticleAndNonException() {
        //region Given
        String content = "HelloWorld!";
        UpdateArticle given = UpdateArticle.builder()
                .id(UUID.randomUUID().toString())
                .title("SpringSecurity")
                .genre(Genre.SPRING)
                .content(content)
                .updatedAt(LocalDateTime.now())
                .build();
        //endregion

        //region When
        var actual = updateArticleUseCase.handle(given);
        //endregion

        //region Then
        assertThatNoException();
        String expectedContent = "HelloWorld!";
        Genre expectedGenre = Genre.SPRING;
        String expectedTitle = "SpringSecurity";
        assertThat(actual).isNotNull().returns(expectedContent, Article::getContent);
        assertThat(actual).isNotNull().returns(expectedGenre, Article::getGenre);
        assertThat(actual).isNotNull().returns(expectedTitle, Article::getTitle);
        //endregion
    }

    @Test
    void when_givenArticleWithNonExistId_expect_throwArticleException() {
        //region Given
        String content = "HelloWorld!";
        UpdateArticle given = UpdateArticle.builder()
                .id("1a2b3c4d-1234-5678-1234-12345abcde99")
                .content(content)
                .updatedAt(LocalDateTime.now())
                .build();
        //endregion

        //region When
        assertThatExceptionOfType(ArticleException.class)
                .isThrownBy(() -> updateArticleUseCase.handle(given));
        //endregion
    }
}
