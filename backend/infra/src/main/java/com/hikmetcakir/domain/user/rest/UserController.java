package com.hikmetcakir.domain.user.rest;

import com.hikmetcakir.common.rest.BaseController;
import com.hikmetcakir.common.rest.Response;
import com.hikmetcakir.domain.user.dto.*;
import com.hikmetcakir.domain.user.rest.api.UserApi;
import com.hikmetcakir.user.DeleteUserUseCaseHandler;
import com.hikmetcakir.user.QueryUserUseCaseHandler;
import com.hikmetcakir.user.UploadUserUseCaseHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequiredArgsConstructor
public class UserController extends BaseController implements UserApi {

    private final QueryUserUseCaseHandler queryUserUseCaseHandler;

    private final DeleteUserUseCaseHandler deleteUserUseCaseHandler;

    private final UploadUserUseCaseHandler uploadUserUseCaseHandler;

    @Override
    public Response<QueryUserResponse> queryUser(QueryUserRequest queryUserRequest) {
        var users = queryUserUseCaseHandler.handle(queryUserRequest.toModel());
        return respond(QueryUserResponse.fromModel(users));
    }

    @Override
    public void deleteUser(DeleteUserRequest deleteUserRequest) {
        deleteUserUseCaseHandler.handle(deleteUserRequest.toModel());
    }

    @Override
    public Response<UploadUserResponse> uploadUser(UploadUserRequest uploadUserRequest) {
        var user = uploadUserUseCaseHandler.handle(uploadUserRequest.toModel());
        return respond(UploadUserResponse.fromModel(user));
    }
}
