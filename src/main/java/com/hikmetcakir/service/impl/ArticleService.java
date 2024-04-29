package com.hikmetcakir.service.impl;

import com.hikmetcakir.dto.Article;
import com.hikmetcakir.dto.ArticleUploadRequest;
import com.hikmetcakir.dto.ArticleUploadResponse;
import com.hikmetcakir.entity.ArticleEntity;
import com.hikmetcakir.repository.ArticleRepository;
import com.hikmetcakir.service.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ArticleUploadResponse upload(ArticleUploadRequest request) {
        Article article = request.toArticle();
        article.setId(UUID.randomUUID().toString());
        ArticleEntity articleEntity = articleRepository.save(article.toEntity());
        return ArticleUploadResponse.from(articleEntity.getId());
    }

}
