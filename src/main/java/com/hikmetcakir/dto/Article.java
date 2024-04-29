package com.hikmetcakir.dto;

import com.hikmetcakir.entity.ArticleEntity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private String id;
    private String title;
    private String content;

    public ArticleEntity toEntity() {
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setId(id);
        articleEntity.setTitle(title);
        articleEntity.setContent(content);
        return articleEntity;
    }
}
