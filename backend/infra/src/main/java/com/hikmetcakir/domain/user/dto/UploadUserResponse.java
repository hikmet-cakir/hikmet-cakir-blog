package com.hikmetcakir.domain.user.dto;

import com.hikmetcakir.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadUserResponse {

    private String id;

    public static UploadUserResponse fromModel(User user) {
        return UploadUserResponse.builder()
                .id(user.getId())
                .build();
    }
}
