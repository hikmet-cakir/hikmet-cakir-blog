package com.hikmetcakir.dto;

import com.hikmetcakir.entity.ArticleEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Article {

    private String id;
    private String title;
    private String content;
    private String topic;
    private LocalDate updatedDate;
    private LocalDate createdDate;

    public static Article from(ArticleEntity articleEntity) {
        Article article = new Article();
        article.setId(articleEntity.getId());
        article.setTitle(articleEntity.getTitle());
        article.setContent(articleEntity.getContent());
        article.setTopic(articleEntity.getTopic());
        article.setUpdatedDate(articleEntity.getUpdatedDate());
        article.setCreatedDate(articleEntity.getCreatedDate());
        return article;
    }
}
