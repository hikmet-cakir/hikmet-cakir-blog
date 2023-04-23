package com.hikmetcakir.user;

import com.hikmetcakir.article.UploadArticleUseCaseHandler;
import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.usecase.UploadArticle;
import com.hikmetcakir.user.adapter.UserFakeDataAdapter;
import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.usecase.UploadUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class UploadUserTest {

    UploadUserUseCaseHandler uploadUserUseCase;

    @BeforeEach
    void setUp() {
        uploadUserUseCase = new UploadUserUseCaseHandler(new UserFakeDataAdapter());
    }

    @Test
    void when_givenContent_expect_takeSavedArticle() {
        // Given
        String content = "HelloWorld";
        UploadUser given = UploadUser.builder()
                .name(content)
                .build();

        // When
        var actual = uploadUserUseCase.handle(given);

        // Then
        assertThat(actual).isNotNull().returns(content, User::getName);
    }
}
