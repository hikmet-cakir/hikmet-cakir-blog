package com.hikmetcakir.user;

import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.VoidUseCaseHandler;
import com.hikmetcakir.user.port.UserPort;
import com.hikmetcakir.user.usecase.DeleteUser;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class DeleteUserUseCaseHandler implements VoidUseCaseHandler<DeleteUser> {

    private final UserPort userPort;

    @Override
    public void handle(DeleteUser deleteUser) {
        userPort.delete(deleteUser);
    }
}
