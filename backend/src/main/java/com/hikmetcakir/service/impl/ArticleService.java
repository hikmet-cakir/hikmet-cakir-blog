package com.hikmetcakir.service.impl;

import com.hikmetcakir.dto.Article;
import com.hikmetcakir.dto.ArticleQueryRequest;
import com.hikmetcakir.dto.ArticleUpdateRequest;
import com.hikmetcakir.dto.ArticleUploadRequest;
import com.hikmetcakir.entity.ArticleEntity;
import com.hikmetcakir.repository.ArticleRepository;
import com.hikmetcakir.service.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        articleEntity.setTopic(request.getTopic());
        articleEntity.setCreatedDate(LocalDate.now());
        return articleRepository.save(articleEntity).getId();
    }

    @Override
    public List<Article> query(ArticleQueryRequest request) {
        return articleRepository.findByFilter(request, request.buildPageable())
                .stream()
                .map(Article::new)
                .collect(Collectors.toList());
    }

    @Override
    public void update(String id, ArticleUpdateRequest request) {
        var articleEntity = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        articleEntity.setTitle(request.getTitle());
        articleEntity.setContent(request.getContent());
        articleEntity.setTopic(request.getTopic());
        articleEntity.setUpdatedDate(LocalDate.now());
        articleRepository.save(articleEntity);
    }

    @Override
    public void delete(String id) {
        var articleEntity = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("Article not found"));
        articleRepository.delete(articleEntity);
    }
}