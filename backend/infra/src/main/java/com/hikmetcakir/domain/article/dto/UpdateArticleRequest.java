package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.model.Genre;
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

    private String title;
    private String content;
    private Genre genre;

    public UpdateArticle toModel(String id) {
        return UpdateArticle.builder()
                .id(id)
                .title(title)
                .genre(genre)
                .content(content)
                .build();
    }
}
