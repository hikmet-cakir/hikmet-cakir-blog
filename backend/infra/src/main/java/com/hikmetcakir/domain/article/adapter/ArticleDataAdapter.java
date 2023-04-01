package com.hikmetcakir.domain.article.adapter;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.port.CachePort;
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

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleDataAdapter implements ArticlePort {

    private final ArticleJpaRepository articleJpaRepository;

    private final CachePort cachePort;

    @Override
    public Article upload(UploadArticle uploadArticle) {
        var articleEntity = new ArticleEntity();
        articleEntity.setId(UUID.randomUUID().toString());
        articleEntity.setContent(uploadArticle.getContent());
        articleEntity.setUpdatedAt(LocalDateTime.now());
        articleEntity.setCreatedAt(LocalDateTime.now());
        return articleJpaRepository.save(articleEntity).toModel();
    }

    @Override
    public Article query(QueryArticle queryArticle) {
        Article article = cachePort.getValue(queryArticle.getId(), Article.class);
        if(Objects.isNull(article)) {
            article = articleJpaRepository.findById(queryArticle.getId())
                    .map(ArticleEntity::toModel)
                    .orElseThrow(() -> new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND));
            cachePort.putValue(article.getId(), article);
        }
        return article;
    }

    @Override
    public void delete(DeleteArticle deleteArticle) {
        var articleEntity = articleJpaRepository.findById(deleteArticle.getId())
                .orElseThrow(() -> new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND));
        cachePort.deleteValue(articleEntity.getId());
        articleJpaRepository.delete(articleEntity);
    }

    @Override
    public void update(UpdateArticle updateArticle) {
        var articleEntity = articleJpaRepository.findById(updateArticle.getId())
                .orElseThrow(() -> new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND));
        articleEntity.setContent(updateArticle.getContent());
        articleEntity.setUpdatedAt(updateArticle.getUpdatedAt());
        articleJpaRepository.save(articleEntity);
    }
}
