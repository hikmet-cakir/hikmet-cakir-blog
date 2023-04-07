package com.hikmetcakir.article;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.UseCaseHandler;
import lombok.RequiredArgsConstructor;

import java.util.List;

@DomainComponent
@RequiredArgsConstructor
public class QueryArticleUseCaseHandler implements UseCaseHandler<List<Article>, QueryArticle> {

    private final ArticlePort articlePort;

    @Override
    public List<Article> handle(QueryArticle useCase) {
        return articlePort.query(useCase);
    }
}
