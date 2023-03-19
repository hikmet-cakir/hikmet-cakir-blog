package com.hikmetcakir.domain.article.rest;

import com.hikmetcakir.article.QueryArticleUseCaseHandler;
import com.hikmetcakir.article.UploadArticleUseCaseHandler;
import com.hikmetcakir.domain.article.dto.QueryArticleRequest;
import com.hikmetcakir.domain.article.dto.QueryArticleResponse;
import com.hikmetcakir.domain.article.dto.UploadArticleRequest;
import com.hikmetcakir.domain.article.dto.UploadArticleResponse;
import com.hikmetcakir.domain.article.rest.api.ArticleApi;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController implements ArticleApi {

    private final QueryArticleUseCaseHandler queryArticleUseCaseHandler;

    private final UploadArticleUseCaseHandler uploadArticleUseCaseHandler;

    @Override
    public ResponseEntity<QueryArticleResponse> queryArticle(QueryArticleRequest queryArticleRequest) {
        var article = queryArticleUseCaseHandler.handle(queryArticleRequest.toModel());
        return ResponseEntity.ok(QueryArticleResponse.fromModel(article));
    }

    @Override
    public ResponseEntity<UploadArticleResponse> uploadArticle(UploadArticleRequest uploadArticleRequest) {
        var article = uploadArticleUseCaseHandler.handle(uploadArticleRequest.toModel());
        return ResponseEntity.ok(UploadArticleResponse.fromModel(article));
    }
}
