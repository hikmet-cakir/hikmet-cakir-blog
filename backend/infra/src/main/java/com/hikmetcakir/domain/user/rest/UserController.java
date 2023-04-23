package com.hikmetcakir.domain.user.rest;

import com.hikmetcakir.common.rest.BaseController;
import com.hikmetcakir.common.rest.Response;
import com.hikmetcakir.domain.user.dto.QueryUserRequest;
import com.hikmetcakir.domain.user.dto.QueryUserResponse;
import com.hikmetcakir.domain.user.rest.api.UserApi;
import com.hikmetcakir.user.QueryUserUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController extends BaseController implements UserApi {

    private final QueryUserUseCaseHandler queryUserUseCaseHandler;

    @Override
    public Response<QueryUserResponse> queryUser(QueryUserRequest queryUserRequest) {
        var users = queryUserUseCaseHandler.handle(queryUserRequest.toModel());
        return respond(QueryUserResponse.fromModel(users));
    }
}
