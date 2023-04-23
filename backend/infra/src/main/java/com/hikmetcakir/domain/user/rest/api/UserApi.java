package com.hikmetcakir.domain.user.rest.api;

import com.hikmetcakir.common.rest.Response;
import com.hikmetcakir.domain.user.dto.DeleteUserRequest;
import com.hikmetcakir.domain.user.dto.QueryUserRequest;
import com.hikmetcakir.domain.user.dto.QueryUserResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

public interface UserApi {

    @ApiOperation(value = "Query User", nickname = "queryUser", notes = "", response = QueryUserResponse.class, tags = {"Query", "User"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = QueryUserResponse.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    Response<QueryUserResponse> queryUser(@ModelAttribute @Valid QueryUserRequest queryUserRequest);

    @ApiOperation(value = "Delete User", nickname = "deleteUser", notes = "", response = Void.class, tags = {"Delete", "User"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = Void.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/user", method = RequestMethod.DELETE)
    void deleteUser(@RequestParam(value = "id") DeleteUserRequest deleteUserRequest);
}
