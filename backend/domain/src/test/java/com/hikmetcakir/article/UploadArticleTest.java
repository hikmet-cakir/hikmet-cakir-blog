package com.hikmetcakir.article;

import com.hikmetcakir.article.adapter.ArticleFakeDataAdapter;
import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.model.Genre;
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
        //region Given
        String content = "HelloWorld!";
        Genre genre = Genre.SPRING;
        String title = "Spring Security";
        UploadArticle given = UploadArticle.builder()
                .title(title)
                .genre(genre)
                .content(content)
                .build();
        //endregion

        //region When
        var actual = uploadArticleUseCase.handle(given);
        //endregion

        //region Then
        String expectedContent = "HelloWorld!";
        Genre expectedGenre = Genre.SPRING;
        String expectedTitle = "Spring Security";
        assertThat(actual).isNotNull().returns(expectedContent, Article::getContent);
        assertThat(actual).isNotNull().returns(expectedGenre, Article::getGenre);
        assertThat(actual).isNotNull().returns(expectedTitle, Article::getTitle);
        //endregion
    }
}
