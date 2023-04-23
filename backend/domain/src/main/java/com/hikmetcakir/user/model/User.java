package com.hikmetcakir.user.model;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class User {

    private String id;
    private String name;
    private String lastName;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
