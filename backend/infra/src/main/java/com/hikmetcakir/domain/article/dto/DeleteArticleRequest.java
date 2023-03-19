package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.usecase.DeleteArticle;
import com.hikmetcakir.article.usecase.QueryArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeleteArticleRequest {

    private String id;

    public DeleteArticle toModel() {
        return DeleteArticle.builder()
                .id(id)
                .build();
    }
}
