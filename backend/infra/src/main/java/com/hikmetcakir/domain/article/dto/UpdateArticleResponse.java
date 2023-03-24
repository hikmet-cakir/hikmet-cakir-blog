package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArticleResponse {

    private String id;

    public static UpdateArticleResponse fromModel(Article article) {
        return UpdateArticleResponse.builder()
                .id(article.getId())
                .build();
    }
}
