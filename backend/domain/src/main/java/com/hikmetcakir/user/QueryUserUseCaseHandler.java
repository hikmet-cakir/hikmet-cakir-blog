package com.hikmetcakir.user;

import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.UseCaseHandler;
import com.hikmetcakir.user.model.User;
import com.hikmetcakir.user.port.UserPort;
import com.hikmetcakir.user.usecase.QueryUser;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainComponent
@RequiredArgsConstructor
public class QueryUserUseCaseHandler implements UseCaseHandler<List<User>, QueryUser> {


    private final UserPort userPort;

    @Override
    public List<User> handle(QueryUser useCase) {
        return userPort.query(useCase);
    }
}
