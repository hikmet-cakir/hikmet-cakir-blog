package com.hikmetcakir.service;

import com.hikmetcakir.dto.*;

import java.util.List;

public interface IArticleService {

    String upload(ArticleUploadRequest request);

    List<Article> query(ArticleQueryRequest request);

    void update(String id, ArticleUpdateRequest request);

    void delete(String id);
}
