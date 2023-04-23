package com.hikmetcakir.user.usecase;

import com.hikmetcakir.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteUser implements UseCase {

    private String id;
}
