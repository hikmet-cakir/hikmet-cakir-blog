package com.hikmetcakir.service;

import com.hikmetcakir.dto.*;

public interface IArticleService {

    String upload(ArticleUploadRequest request);

    Article query(String id);

    void update(String id, ArticleUpdateRequest request);

    void delete(String id);
}
