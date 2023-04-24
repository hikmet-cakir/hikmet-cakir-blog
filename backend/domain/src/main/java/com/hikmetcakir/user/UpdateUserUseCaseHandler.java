package com.hikmetcakir.user;

import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.UseCaseHandler;
import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.port.UserPort;
import com.hikmetcakir.user.usecase.UpdateUser;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UpdateUserUseCaseHandler implements UseCaseHandler<User, UpdateUser> {

    private final UserPort userPort;

    @Override
    public User handle(UpdateUser useCase) {
        return userPort.update(useCase);
    }
}
