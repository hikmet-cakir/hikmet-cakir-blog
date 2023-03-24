package com.hikmetcakir.domain.article.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hikmetcakir.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadArticleResponse {

    private String id;

    public static UploadArticleResponse fromModel(Article article) {
        return UploadArticleResponse.builder()
                .id(article.getId())
                .build();
    }
}
