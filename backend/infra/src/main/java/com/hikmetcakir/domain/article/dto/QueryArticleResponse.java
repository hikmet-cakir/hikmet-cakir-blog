package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryArticleResponse {

    private List<Article> articles;

    public static QueryArticleResponse fromModel(List<Article> articles) {
        return QueryArticleResponse.builder()
                .articles(articles)
                .build();
    }
}
