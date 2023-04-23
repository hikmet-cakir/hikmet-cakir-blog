package com.hikmetcakir.user;

import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.VoidUseCaseHandler;
import com.hikmetcakir.user.port.UserPort;
import com.hikmetcakir.user.usecase.UpdateUser;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UpdateUserUseCaseHandler implements VoidUseCaseHandler<UpdateUser> {

    private final UserPort userPort;

    @Override
    public void handle(UpdateUser useCase) {
        userPort.update(useCase);
    }
}
