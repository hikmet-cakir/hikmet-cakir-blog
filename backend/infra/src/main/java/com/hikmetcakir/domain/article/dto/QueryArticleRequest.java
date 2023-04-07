package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.model.Genre;
import com.hikmetcakir.article.usecase.QueryArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryArticleRequest {

    private String id;
    private String content;
    private Genre genre;
    private LocalDateTime createdAt;

    public QueryArticle toModel() {
        return QueryArticle.builder()
                .id(id)
                .content(content)
                .genre(genre)
                .createdAt(createdAt)
                .build();
    }
}
