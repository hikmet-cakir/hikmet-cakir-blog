package com.hikmetcakir.domain.article.adapter;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.usecase.DeleteArticle;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.article.usecase.UpdateArticle;
import com.hikmetcakir.article.usecase.UploadArticle;
import com.hikmetcakir.common.exception.ArticleException;
import com.hikmetcakir.common.exception.enums.ApiExceptionArticle;
import com.hikmetcakir.domain.article.jpa.entity.ArticleEntity;
import com.hikmetcakir.domain.article.jpa.repository.ArticleJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleDataAdapter implements ArticlePort {

    private final ArticleJpaRepository articleJpaRepository;

    @Override
    public Article upload(UploadArticle uploadArticle) {
        var articleEntity = new ArticleEntity();
        articleEntity.setId(UUID.randomUUID().toString());
        articleEntity.setContent(uploadArticle.getContent());
        return articleJpaRepository.save(articleEntity).toModel();
    }

    @Override
    public void delete(DeleteArticle deleteArticle) {
        var article = articleJpaRepository.findById(deleteArticle.getId())
                .orElseThrow(() -> new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND));
        articleJpaRepository.delete(article);
    }

    @Override
    public Article query(QueryArticle queryArticle) {
        return articleJpaRepository.findById(queryArticle.getId())
                .map(ArticleEntity::toModel)
                .orElseThrow(() -> new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND));
    }

    @Override
    public Article update(UpdateArticle updateArticle) {
        var article = articleJpaRepository.findById(updateArticle.getId())
                .orElseThrow(() -> new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND));
        article.setContent(updateArticle.getContent());
        return articleJpaRepository.save(article).toModel();
    }
}
