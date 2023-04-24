package com.hikmetcakir.user;

import com.hikmetcakir.article.QueryArticleUseCaseHandler;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.common.exception.ArticleException;
import com.hikmetcakir.common.exception.UserException;
import com.hikmetcakir.user.adapter.UserFakeDataAdapter;
import com.hikmetcakir.user.usecase.QueryUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class QueryUserTest {

    QueryUserUseCaseHandler queryUserUseCaseHandler;

    @BeforeEach
    void setUp() {
        queryUserUseCaseHandler = new QueryUserUseCaseHandler(new UserFakeDataAdapter());
    }

    @Test
    void when_givenUserWithExistId_expect_noException() {
        //region Given
        QueryUser given = QueryUser.builder()
                .id(UUID.randomUUID().toString())
                .build();
        //endregion

        //region When
        queryUserUseCaseHandler.handle(given);
        //endregion

        //region Then
        assertThatNoException();
        //endregion
    }

    @Test
    void when_givenUserWithNonExistId_expect_throwUserException() {
        //region Given
        QueryUser given = QueryUser.builder()
                .id("1a2b3c4d-1234-5678-1234-12345abcde99")
                .build();
        //endregion

        //region When
        assertThatExceptionOfType(UserException.class)
                .isThrownBy(() -> queryUserUseCaseHandler.handle(given));
        //endregion
    }
}
