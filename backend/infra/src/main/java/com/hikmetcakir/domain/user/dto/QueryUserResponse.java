package com.hikmetcakir.domain.user.dto;

import com.hikmetcakir.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryUserResponse {

    private List<User> users;

    public static QueryUserResponse fromModel(List<User> users) {
        return QueryUserResponse.builder()
                .users(users)
                .build();
    }
}
