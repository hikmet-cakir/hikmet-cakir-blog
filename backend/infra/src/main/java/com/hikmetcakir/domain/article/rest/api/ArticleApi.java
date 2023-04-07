package com.hikmetcakir.domain.article.rest.api;

import com.hikmetcakir.common.Response;
import com.hikmetcakir.domain.article.dto.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.web.bind.annotation.*;

public interface ArticleApi {

    @ApiOperation(value = "Query Article", nickname = "queryArticle", notes = "", response = QueryArticleResponse.class, tags = {"Query", "Article"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = QueryArticleResponse.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/article", method = RequestMethod.GET)
    Response<QueryArticleResponse> queryArticle(@RequestBody QueryArticleRequest queryArticleRequest);

    @ApiOperation(value = "Delete Article", nickname = "deleteArticle", notes = "", response = Void.class, tags = {"Delete", "Article"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = Void.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/article", method = RequestMethod.DELETE)
    void deleteArticle(@RequestParam(value = "id") DeleteArticleRequest deleteArticleRequest);

    @ApiOperation(value = "Upload Article", nickname = "uploadArticle", notes = "", response = UploadArticleResponse.class, tags = {"Upload", "Article"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = UploadArticleResponse.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/article", method = RequestMethod.POST)
    Response<UploadArticleResponse> uploadArticle(@RequestBody UploadArticleRequest uploadArticleRequest);

    @ApiOperation(value = "Update Article", nickname = "updateArticle", notes = "", response = Void.class, tags = {"Update", "Article"})
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful operation", response = Void.class),
            @ApiResponse(code = 400, message = "Invalid Params"),
            @ApiResponse(code = 500, message = "Internal Error")
    })
    @RequestMapping(value = "/article/{id}", method = RequestMethod.PATCH)
    void updateArticle(@PathVariable String id, @RequestBody UpdateArticleRequest updateArticleRequest);
}
