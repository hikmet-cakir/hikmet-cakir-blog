package com.hikmetcakir.service;

import com.hikmetcakir.dto.ArticleUploadRequest;
import com.hikmetcakir.dto.ArticleUploadResponse;

public interface IArticleService {

    ArticleUploadResponse upload(ArticleUploadRequest request);
}
