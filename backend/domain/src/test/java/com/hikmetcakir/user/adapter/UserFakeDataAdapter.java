package com.hikmetcakir.user.adapter;

import com.hikmetcakir.common.exception.UserException;
import com.hikmetcakir.common.exception.enums.ApiExceptionUser;
import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.port.UserPort;
import com.hikmetcakir.user.usecase.DeleteUser;
import com.hikmetcakir.user.usecase.QueryUser;
import com.hikmetcakir.user.usecase.UpdateUser;
import com.hikmetcakir.user.usecase.UploadUser;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
public class UserFakeDataAdapter implements UserPort {

    private static final String USER_FAIL_ID = "1a2b3c4d-1234-5678-1234-12345abcde99";
    private static final List<String> FAILING_IDS = List.of(USER_FAIL_ID);

    @Override
    public User upload(UploadUser uploadUser) {
        return User.builder()
                .id(UUID.randomUUID().toString())
                .name(uploadUser.getName())
                .lastName(uploadUser.getLastName())
                .userId(uploadUser.getUserId())
                .password(uploadUser.getPassword())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public void delete(DeleteUser deleteUser) {
        failedUserScenario(deleteUser.getId());
        succeededUserScenario(deleteUser.getId());
    }

    @Override
    public User update(UpdateUser updateUser) {
        failedUserScenario(updateUser.getId());
        return User.builder()
                .id(UUID.randomUUID().toString())
                .name(updateUser.getName())
                .lastName(updateUser.getLastName())
                .userId(updateUser.getUserId())
                .password(updateUser.getPassword())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public List<User> query(QueryUser queryUser) {
        if(FAILING_IDS.contains(queryUser.getId())) {
            throw new UserException(ApiExceptionUser.USER_NOT_FOUND);
        }
        return List.of(User.builder()
                .id(UUID.randomUUID().toString())
                .name("John")
                .lastName("Doe")
                .userId("CK.john_doe")
                .password(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
    }

    private void failedUserScenario(String id) {
        if (USER_FAIL_ID.equals(id)) {
            throw new UserException(ApiExceptionUser.USER_NOT_FOUND);
        }
    }

    private User succeededUserScenario(String id) {
        if (!FAILING_IDS.contains(id)) {
            return User.builder()
                    .id(UUID.randomUUID().toString())
                    .name("John")
                    .lastName("Doe")
                    .userId("CK.john_doe")
                    .password(UUID.randomUUID().toString())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }
        throw new UserException(ApiExceptionUser.USER_NOT_FOUND);
    }
}
