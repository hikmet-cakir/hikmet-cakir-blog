package com.hikmetcakir.domain.article.adapter;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.common.port.CachePort;
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
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleDataAdapter implements ArticlePort {

    private final ArticleJpaRepository articleJpaRepository;

    private final CachePort cachePort;

    @Override
    public Article upload(UploadArticle uploadArticle) {
        var articleEntity = new ArticleEntity();
        articleEntity.setId(UUID.randomUUID().toString());
        articleEntity.setTitle(uploadArticle.getTitle());
        articleEntity.setContent(uploadArticle.getContent());
        articleEntity.setGenre(uploadArticle.getGenre());
        articleEntity.setUpdatedAt(LocalDateTime.now());
        articleEntity.setCreatedAt(LocalDateTime.now());
        var article = articleJpaRepository.save(articleEntity).toModel();
        cachePort.putValue(article.getId(), article);
        return article;
    }

    @Override
    public List<Article> query(QueryArticle queryArticle) {
        return articleJpaRepository.queryArticle(queryArticle).stream()
                .map(ArticleEntity::toModel)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(DeleteArticle deleteArticle) {
        var articleEntity = articleJpaRepository.findById(deleteArticle.getId())
                .orElseThrow(() -> new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND));
        articleJpaRepository.delete(articleEntity);
        cachePort.deleteValue(articleEntity.getId());
    }

    @Override
    public void update(UpdateArticle updateArticle) {
        var articleEntity = articleJpaRepository.findById(updateArticle.getId())
                .orElseThrow(() -> new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND));
        articleEntity.setTitle(updateArticle.getTitle());
        articleEntity.setContent(updateArticle.getContent());
        articleEntity.setGenre(updateArticle.getGenre());
        articleEntity.setUpdatedAt(updateArticle.getUpdatedAt());
        articleJpaRepository.save(articleEntity);
        cachePort.putValue(updateArticle.getId(), articleEntity.toModel());
    }
}
