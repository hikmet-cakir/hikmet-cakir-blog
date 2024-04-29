package com.hikmetcakir.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUploadRequest {

    private String title;
    private String content;

    public Article toArticle() {
        Article article = new Article();
        article.setTitle(title);
        article.setContent(content);
        return article;
    }
}
