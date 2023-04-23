package com.hikmetcakir.domain.user.dto;

import com.hikmetcakir.article.model.Genre;
import com.hikmetcakir.article.usecase.UpdateArticle;
import com.hikmetcakir.user.usecase.UpdateUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    private String userId;
    private String password;
    private String name;
    private String lastName;

    public UpdateUser toModel(String id) {
        return UpdateUser.builder()
                .id(id)
                .userId(userId)
                .password(password)
                .name(name)
                .lastName(lastName)
                .build();
    }
}
