package com.hikmetcakir.article;

import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.usecase.UpdateArticle;
import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UpdateArticleUseCaseHandler implements VoidUseCaseHandler<UpdateArticle> {

    private final ArticlePort articlePort;

    @Override
    public void handle(UpdateArticle useCase) {
        articlePort.update(useCase);
    }
}
