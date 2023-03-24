package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.usecase.UpdateArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateArticleRequest {

    private String content;

    public UpdateArticle toModel(String id) {
        return UpdateArticle.builder()
                .id(id)
                .content(content)
                .build();
    }
}
