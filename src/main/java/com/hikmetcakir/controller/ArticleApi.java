package com.hikmetcakir.controller;

import com.hikmetcakir.dto.ArticleUploadRequest;
import com.hikmetcakir.dto.ArticleUploadResponse;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ArticleApi {

    @ApiOperation(
            value = "Upload Article",
            nickname = "UploadArticle",
            notes = "It is used to save an article",
            response = ArticleUploadResponse.class,
            tags = { "Upload", "Article" }
    )
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = ArticleUploadResponse.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    ResponseEntity<ArticleUploadResponse> upload(@RequestBody ArticleUploadRequest request);
}
