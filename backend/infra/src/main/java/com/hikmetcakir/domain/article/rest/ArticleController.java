package com.hikmetcakir.domain.article.rest;

import com.hikmetcakir.article.DeleteArticleUseCaseHandler;
import com.hikmetcakir.article.QueryArticleUseCaseHandler;
import com.hikmetcakir.article.UpdateArticleUseCaseHandler;
import com.hikmetcakir.article.UploadArticleUseCaseHandler;
import com.hikmetcakir.domain.article.dto.*;
import com.hikmetcakir.domain.article.rest.api.ArticleApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController implements ArticleApi {

    private final QueryArticleUseCaseHandler queryArticleUseCaseHandler;

    private final UploadArticleUseCaseHandler uploadArticleUseCaseHandler;

    private final DeleteArticleUseCaseHandler deleteArticleUseCaseHandler;

    private final UpdateArticleUseCaseHandler updateArticleUseCaseHandler;

    @Override
    public ResponseEntity<QueryArticleResponse> queryArticle(QueryArticleRequest queryArticleRequest) {
        var article = queryArticleUseCaseHandler.handle(queryArticleRequest.toModel());
        return ResponseEntity.ok(QueryArticleResponse.fromModel(article));
    }

    @Override
    public ResponseEntity<DeleteArticleResponse> deleteArticle(DeleteArticleRequest deleteArticleRequest) {
        deleteArticleUseCaseHandler.handle(deleteArticleRequest.toModel());
        return ResponseEntity.ok(new DeleteArticleResponse());
    }

    @Override
    public ResponseEntity<UploadArticleResponse> uploadArticle(UploadArticleRequest uploadArticleRequest) {
        var article = uploadArticleUseCaseHandler.handle(uploadArticleRequest.toModel());
        return ResponseEntity.ok(UploadArticleResponse.fromModel(article));
    }

    @Override
    public ResponseEntity<UpdateArticleResponse> updateArticle(String id, UpdateArticleRequest updateArticleRequest) {
        var article = updateArticleUseCaseHandler.handle(updateArticleRequest.toModel(id));
        return ResponseEntity.ok(UpdateArticleResponse.fromModel(article));
    }
}
