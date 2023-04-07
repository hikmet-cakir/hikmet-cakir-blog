package com.hikmetcakir.domain.article.jpa.entity;

import com.hikmetcakir.article.model.Article;
import com.hikmetcakir.article.model.Genre;
import com.hikmetcakir.common.entity.AbstractEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import javax.persistence.*;

@Getter
@Setter
@Entity
@FieldNameConstants
@Table(name = "article")
public class ArticleEntity extends AbstractEntity {

    @Column(name =  "content")
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(name = "genre")
    private Genre genre;

    public Article toModel() {
        return Article.builder()
                .id(this.getId())
                .content(content)
                .genre(genre)
                .updatedAt(this.getUpdatedAt())
                .createdAt(this.getCreatedAt())
                .build();
    }
}
