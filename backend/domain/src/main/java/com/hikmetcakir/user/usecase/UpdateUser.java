package com.hikmetcakir.user.usecase;

import com.hikmetcakir.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UpdateUser implements UseCase {

    private String id;
    private String name;
    private String lastName;
    private LocalDateTime updatedAt;
}
