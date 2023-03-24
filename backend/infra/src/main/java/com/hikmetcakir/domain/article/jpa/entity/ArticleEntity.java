package com.hikmetcakir.domain.article.jpa.entity;

import com.hikmetcakir.article.model.Article;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

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

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Article toModel() {
        return Article.builder()
                .id(id)
                .content(content)
                .updatedAt(updatedAt)
                .createdAt(createdAt)
                .build();
    }
}
