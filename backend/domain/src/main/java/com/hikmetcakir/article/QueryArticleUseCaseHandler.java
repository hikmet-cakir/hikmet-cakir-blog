package com.hikmetcakir.article;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.UseCaseHandler;

@DomainComponent
public class QueryArticleUseCaseHandler implements UseCaseHandler<Article, QueryArticle> {

    @Override
    public Article handle(QueryArticle useCase) {
        return null;
    }
}
