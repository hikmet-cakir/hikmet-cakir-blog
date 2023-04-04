package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.model.Genre;
import com.hikmetcakir.article.usecase.UploadArticle;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UploadArticleRequest {

    private String content;
    private Genre genre;

    public UploadArticle toModel() {
        return UploadArticle.builder()
                .content(content)
                .genre(genre)
                .build();
    }
}
