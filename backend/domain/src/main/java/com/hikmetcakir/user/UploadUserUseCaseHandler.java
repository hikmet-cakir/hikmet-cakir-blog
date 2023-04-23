package com.hikmetcakir.user;

import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.UseCaseHandler;
import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.port.UserPort;
import com.hikmetcakir.user.usecase.UploadUser;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UploadUserUseCaseHandler implements UseCaseHandler<User, UploadUser> {

    private final UserPort userPort;

    @Override
    public User handle(UploadUser uploadUser) {
        return userPort.upload(uploadUser);
    }
}
