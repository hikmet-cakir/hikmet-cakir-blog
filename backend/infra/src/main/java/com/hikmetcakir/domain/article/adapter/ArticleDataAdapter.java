package com.hikmetcakir.domain.article.adapter;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.usecase.UploadArticle;
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
}
