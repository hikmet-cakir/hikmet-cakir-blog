package com.hikmetcakir.domain.user.dto;

import com.hikmetcakir.user.usecase.DeleteUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteUserRequest {

    private String id;

    public DeleteUser toModel() {
        return DeleteUser.builder()
                .id(id)
                .build();
    }
}
