package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryArticleResponse {

    private String id;
    private String content;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;

    public static QueryArticleResponse fromModel(Article article) {
        return QueryArticleResponse.builder()
                .id(article.getId())
                .content(article.getContent())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .build();
    }
}
