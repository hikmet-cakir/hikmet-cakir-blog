package com.hikmetcakir.user;

import com.hikmetcakir.common.exception.UserException;
import com.hikmetcakir.user.adapter.UserFakeDataAdapter;
import com.hikmetcakir.user.usecase.UpdateUser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

public class UpdateUserTest {

    UpdateUserUseCaseHandler updateUserUseCase;

    @BeforeEach
    void setUp() {
        updateUserUseCase = new UpdateUserUseCaseHandler(new UserFakeDataAdapter());
    }

    @Test
    void when_givenUserWithExistId_expect_noException() {
        //region Given
        UpdateUser given = UpdateUser.builder()
                .id(UUID.randomUUID().toString())
                .name("John")
                .lastName("Doe")
                .userId("CK.john_doe")
                .password(UUID.randomUUID().toString())
                .updatedAt(LocalDateTime.now())
                .build();
        //endregion

        //region When
        updateUserUseCase.handle(given);
        //endregion

        //region Then
        assertThatNoException();
        //endregion
    }

    @Test
    void when_givenUserWithNonExistId_expect_throwUserException() {
        //region Given
        UpdateUser given = UpdateUser.builder()
                .id("1a2b3c4d-1234-5678-1234-12345abcde99")
                .name("John")
                .lastName("Doe")
                .userId("CK.john_doe")
                .password(UUID.randomUUID().toString())
                .updatedAt(LocalDateTime.now())
                .build();
        //endregion

        //region When
        assertThatExceptionOfType(UserException.class)
                .isThrownBy(() -> updateUserUseCase.handle(given));
        //endregion
    }
}
