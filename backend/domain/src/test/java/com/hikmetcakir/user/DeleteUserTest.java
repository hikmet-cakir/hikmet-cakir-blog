package com.hikmetcakir.user;

import com.hikmetcakir.article.DeleteArticleUseCaseHandler;
import com.hikmetcakir.article.usecase.DeleteArticle;
import com.hikmetcakir.common.exception.ArticleException;
import com.hikmetcakir.common.exception.UserException;
import com.hikmetcakir.user.adapter.UserFakeDataAdapter;
import com.hikmetcakir.user.usecase.DeleteUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class DeleteUserTest {

    DeleteUserUseCaseHandler deleteUserUseCaseHandler;

    @BeforeEach
    void setUp() {
        deleteUserUseCaseHandler = new DeleteUserUseCaseHandler(new UserFakeDataAdapter());
    }

    @Test
    void when_givenUserWithExistId_expect_noException() {
        // Given
        DeleteUser given = DeleteUser.builder()
                .id(UUID.randomUUID().toString())
                .build();

        // When
        deleteUserUseCaseHandler.handle(given);

        // Then
        assertThatNoException();
    }

    @Test
    void when_givenUserWithNonExistId_expect_throwUserException() {
        // Given
        DeleteUser given = DeleteUser.builder()
                .id("1a2b3c4d-1234-5678-1234-12345abcde99")
                .build();

        // When
        assertThatExceptionOfType(UserException.class)
                .isThrownBy(() -> deleteUserUseCaseHandler.handle(given));
    }
}
