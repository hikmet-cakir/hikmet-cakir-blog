package com.hikmetcakir.domain.user.rest.api;

import com.hikmetcakir.common.rest.Response;
import com.hikmetcakir.domain.article.dto.UpdateArticleRequest;
import com.hikmetcakir.domain.article.dto.UploadArticleResponse;
import com.hikmetcakir.domain.user.dto.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

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

    @ApiOperation(value = "Upload User", nickname = "uploadUser", notes = "", response = UploadUserResponse.class, tags = {"Upload", "User"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = UploadUserResponse.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    Response<UploadUserResponse> uploadUser(@RequestBody UploadUserRequest uploadUserRequest);

    @ApiOperation(value = "Update User", nickname = "updateUser", notes = "", response = Void.class, tags = {"Update", "User"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = Void.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/user/{id}", method = RequestMethod.PATCH)
    void updateUser(@PathVariable String id, @RequestBody UpdateUserRequest updateUserRequest);
}
