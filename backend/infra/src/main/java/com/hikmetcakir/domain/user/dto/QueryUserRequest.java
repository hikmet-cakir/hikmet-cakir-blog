package com.hikmetcakir.domain.user.dto;

import com.hikmetcakir.common.rest.PageRequest;
import com.hikmetcakir.user.usecase.QueryUser;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryUserRequest extends PageRequest {

    private String id;
    private String userId;
    private String name;
    private String lastName;
    private LocalDateTime createdAt;

    public QueryUser toModel() {
        return QueryUser.builder()
                .id(id)
                .userId(userId)
                .name(name)
                .lastName(lastName)
                .createdAt(createdAt)
                .build();
    }
}
