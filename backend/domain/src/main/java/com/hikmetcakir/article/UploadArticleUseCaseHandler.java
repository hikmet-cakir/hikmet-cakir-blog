package com.hikmetcakir.article;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.usecase.UploadArticle;
import com.hikmetcakir.common.DomainComponent;
import com.hikmetcakir.common.UseCaseHandler;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class UploadArticleUseCaseHandler implements UseCaseHandler<Article, UploadArticle> {

    private final ArticlePort articlePort;

    @Override
    public Article handle(UploadArticle uploadArticle) {
        return articlePort.upload(uploadArticle);
    }
}
