package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.usecase.QueryArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class QueryArticleRequest {

    private String id;

    public QueryArticle toModel() {
        return QueryArticle.builder()
                .id(id)
                .build();
    }
}
