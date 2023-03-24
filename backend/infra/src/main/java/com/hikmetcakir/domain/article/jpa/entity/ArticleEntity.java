package com.hikmetcakir.domain.article.jpa.entity;

import com.hikmetcakir.article.model.Article;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "article")
public class ArticleEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name =  "content")
    private String content;

    public Article toModel() {
        return Article.builder()
                .id(id)
                .content(content)
                .build();
    }
}
