package com.hikmetcakir.domain.user.dto;

import com.hikmetcakir.user.usecase.UploadUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadUserRequest {

    private String userId;
    private String password;
    private String name;
    private String lastName;

    public UploadUser toModel() {
        return UploadUser.builder()
                .userId(userId)
                .password(password)
                .name(name)
                .lastName(lastName)
                .build();
    }
}
