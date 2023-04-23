package com.hikmetcakir.domain.user.rest;

import com.hikmetcakir.common.rest.BaseController;
import com.hikmetcakir.common.rest.Response;
import com.hikmetcakir.domain.user.dto.DeleteUserRequest;
import com.hikmetcakir.domain.user.dto.QueryUserRequest;
import com.hikmetcakir.domain.user.dto.QueryUserResponse;
import com.hikmetcakir.domain.user.rest.api.UserApi;
import com.hikmetcakir.user.DeleteUserUseCaseHandler;
import com.hikmetcakir.user.QueryUserUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController extends BaseController implements UserApi {

    private final QueryUserUseCaseHandler queryUserUseCaseHandler;

    private final DeleteUserUseCaseHandler deleteUserUseCaseHandler;

    @Override
    public Response<QueryUserResponse> queryUser(QueryUserRequest queryUserRequest) {
        var users = queryUserUseCaseHandler.handle(queryUserRequest.toModel());
        return respond(QueryUserResponse.fromModel(users));
    }

    @Override
    public void deleteUser(DeleteUserRequest deleteUserRequest) {
        deleteUserUseCaseHandler.handle(deleteUserRequest.toModel());
    }
}
