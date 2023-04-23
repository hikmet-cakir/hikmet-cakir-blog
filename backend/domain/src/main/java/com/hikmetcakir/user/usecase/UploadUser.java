package com.hikmetcakir.user.usecase;

import com.hikmetcakir.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadUser implements UseCase {

    private String userId;
    private String password;
    private String name;
    private String lastName;
}
