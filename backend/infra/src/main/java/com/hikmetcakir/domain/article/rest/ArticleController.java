package com.hikmetcakir.domain.article.rest;

import com.hikmetcakir.article.DeleteArticleUseCaseHandler;
import com.hikmetcakir.article.QueryArticleUseCaseHandler;
import com.hikmetcakir.article.UpdateArticleUseCaseHandler;
import com.hikmetcakir.article.UploadArticleUseCaseHandler;
import com.hikmetcakir.common.BaseController;
import com.hikmetcakir.common.Response;
import com.hikmetcakir.domain.article.dto.*;
import com.hikmetcakir.domain.article.rest.api.ArticleApi;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController extends BaseController implements ArticleApi {

    private final QueryArticleUseCaseHandler queryArticleUseCaseHandler;

    private final UploadArticleUseCaseHandler uploadArticleUseCaseHandler;

    private final DeleteArticleUseCaseHandler deleteArticleUseCaseHandler;

    private final UpdateArticleUseCaseHandler updateArticleUseCaseHandler;

    @Override
    public Response<QueryArticleResponse> queryArticle(QueryArticleRequest queryArticleRequest) {
        var articles = queryArticleUseCaseHandler.handle(queryArticleRequest.toModel());
        return respond(QueryArticleResponse.fromModel(articles));
    }

    @Override
    public void deleteArticle(DeleteArticleRequest deleteArticleRequest) {
        deleteArticleUseCaseHandler.handle(deleteArticleRequest.toModel());
    }

    @Override
    public Response<UploadArticleResponse> uploadArticle(UploadArticleRequest uploadArticleRequest) {
        var article = uploadArticleUseCaseHandler.handle(uploadArticleRequest.toModel());
        return respond(UploadArticleResponse.fromModel(article));
    }

    @Override
    public void updateArticle(String id, UpdateArticleRequest updateArticleRequest) {
        updateArticleUseCaseHandler.handle(updateArticleRequest.toModel(id));
    }
}
