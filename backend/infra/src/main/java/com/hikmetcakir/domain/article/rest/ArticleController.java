package com.hikmetcakir.domain.article.rest;

import com.hikmetcakir.article.QueryArticleUseCaseHandler;
import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.domain.article.dto.QueryArticleResponse;
import com.hikmetcakir.domain.article.rest.api.ArticleApi;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleController implements ArticleApi {


    private final QueryArticleUseCaseHandler queryArticleUseCaseHandler;

    public ArticleController(QueryArticleUseCaseHandler queryArticleUseCaseHandler) {
        this.queryArticleUseCaseHandler = queryArticleUseCaseHandler;
    }

    @Override
    public ResponseEntity<QueryArticleResponse> queryArticle(String id) {
        Article handle = queryArticleUseCaseHandler.handle(new QueryArticle());
        return ResponseEntity.ok(new QueryArticleResponse());
    }
}
