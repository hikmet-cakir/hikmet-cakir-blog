package com.hikmetcakir.article;

import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.usecase.DeleteArticle;
import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.VoidUseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class DeleteArticleUseCaseHandler implements VoidUseCaseHandler<DeleteArticle> {

    private final ArticlePort articlePort;

    @Override
    public void handle(DeleteArticle deleteArticle) {
        articlePort.delete(deleteArticle);
    }
}
