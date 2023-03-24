package com.hikmetcakir.article;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.usecase.UpdateArticle;
import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.UseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UpdateArticleUseCaseHandler implements UseCaseHandler<Article, UpdateArticle> {

    private final ArticlePort articlePort;

    @Override
    public Article handle(UpdateArticle useCase) {
        return articlePort.update(useCase);
    }
}
