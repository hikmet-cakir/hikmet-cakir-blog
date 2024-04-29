package com.hikmetcakir.service.impl;

import com.hikmetcakir.dto.ArticleUploadRequest;
import com.hikmetcakir.dto.ArticleUploadResponse;
import com.hikmetcakir.repository.ArticleRepository;
import com.hikmetcakir.service.IArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ArticleService implements IArticleService {

    private final ArticleRepository articleRepository;

    @Override
    public ArticleUploadResponse upload(ArticleUploadRequest request) {
        return null;
    }
    
}
