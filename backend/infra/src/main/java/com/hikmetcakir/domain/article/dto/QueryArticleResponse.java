package com.hikmetcakir.domain.article.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.model.Genre;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryArticleResponse {

    private String id;

    private String content;

    private Genre genre;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime createdAt;

    @JsonFormat(pattern = "dd/MM/yyyy hh:mm:ss a")
    private LocalDateTime updatedAt;

    public static QueryArticleResponse fromModel(Article article) {
        return QueryArticleResponse.builder()
                .id(article.getId())
                .content(article.getContent())
                .genre(article.getGenre())
                .createdAt(article.getCreatedAt())
                .updatedAt(article.getUpdatedAt())
                .build();
    }
}
