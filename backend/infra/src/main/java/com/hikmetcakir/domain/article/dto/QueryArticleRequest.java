package com.hikmetcakir.domain.article.dto;

import com.hikmetcakir.article.model.Genre;
import com.hikmetcakir.article.usecase.QueryArticle;
import com.hikmetcakir.common.rest.PageRequest;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QueryArticleRequest extends PageRequest {

    private String id;
    private String title;
    private String content;
    private Genre genre;
    private LocalDateTime createdAt;

    public QueryArticle toModel() {
        return QueryArticle.builder()
                .id(id)
                .title(title)
                .content(content)
                .genre(genre)
                .size(this.getSize())
                .page(this.getPage())
                .createdAt(createdAt)
                .build();
    }
}
