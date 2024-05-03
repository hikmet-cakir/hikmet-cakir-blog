package com.hikmetcakir.service.impl;

import com.hikmetcakir.dto.Article;
import com.hikmetcakir.dto.ArticleUpdateRequest;
import com.hikmetcakir.dto.ArticleUploadRequest;
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
    public String upload(ArticleUploadRequest request) {
        var articleEntity = new ArticleEntity();
        articleEntity.setId(UUID.randomUUID().toString());
        articleEntity.setTitle(request.getTitle());
        articleEntity.setContent(request.getContent());
        return articleRepository.save(articleEntity).getId();
    }

    @Override
    public Article query(String id) {
        return articleRepository.findById(id)
                .map(articleEntity -> new Article(articleEntity.getId(), articleEntity.getTitle(), articleEntity.getContent()))
                .orElseThrow(() -> new RuntimeException("Article not found"));
    }

    @Override
    public void update(String id, ArticleUpdateRequest request) {
        var articleEntity = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        articleEntity.setTitle(request.getTitle());
        articleEntity.setContent(request.getContent());
        articleRepository.save(articleEntity);
    }

    @Override
    public void delete(String id) {
        var articleEntity = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        articleRepository.delete(articleEntity);
    }
}