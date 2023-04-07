package com.hikmetcakir.domain.article.jpa.entity;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.model.Genre;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@FieldNameConstants
@Table(name = "article")
public class ArticleEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name =  "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Article toModel() {
        return Article.builder()
                .id(id)
                .content(content)
                .genre(genre)
                .updatedAt(updatedAt)
                .createdAt(createdAt)
                .build();
    }
}
