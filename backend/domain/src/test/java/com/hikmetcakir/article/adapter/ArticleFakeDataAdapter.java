package com.hikmetcakir.article.adapter;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.port.ArticlePort;
import com.hikmetcakir.article.usecase.DeleteArticle;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.article.usecase.UpdateArticle;
import com.hikmetcakir.article.usecase.UploadArticle;
import com.hikmetcakir.common.exception.ArticleException;
import com.hikmetcakir.common.exception.enums.ApiExceptionArticle;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Slf4j
public class ArticleFakeDataAdapter implements ArticlePort {

    private static final String ARTICLE_FAIL_ID = "1a2b3c4d-1234-5678-1234-12345abcde99";
    private static final List<String> FAILING_IDS = List.of(ARTICLE_FAIL_ID);

    @Override
    public Article upload(UploadArticle uploadArticle) {
        return Article.builder()
                .id(UUID.randomUUID().toString())
                .content(uploadArticle.getContent())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build();
    }

    @Override
    public void delete(DeleteArticle deleteArticle) {
        failedArticleScenario(deleteArticle.getId());
        succeededArticleScenario(deleteArticle.getId());
    }

    @Override
    public void update(UpdateArticle updateArticle) {
        failedArticleScenario(updateArticle.getId());
        succeededArticleScenario(updateArticle.getId());
    }

    @Override
    public List<Article> query(QueryArticle queryArticle) {
        if(FAILING_IDS.contains(queryArticle.getId())) {
            throw new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND);
        }
        return List.of(Article.builder()
                .id(UUID.randomUUID().toString())
                .content(UUID.randomUUID().toString())
                .createdAt(LocalDateTime.now())
                .updatedAt(LocalDateTime.now())
                .build());
    }

    private void failedArticleScenario(String id) {
        if (ARTICLE_FAIL_ID.equals(id)) {
            throw new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND);
        }
    }

    private Article succeededArticleScenario(String id) {
        if (!FAILING_IDS.contains(id)) {
            return Article.builder()
                    .id(UUID.randomUUID().toString())
                    .content(UUID.randomUUID().toString())
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
        }
        throw new ArticleException(ApiExceptionArticle.ARTICLE_NOT_FOUND);
    }
}
