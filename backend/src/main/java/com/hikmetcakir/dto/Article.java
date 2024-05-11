package com.hikmetcakir.dto;

import com.hikmetcakir.entity.ArticleEntity;

import java.time.LocalDate;

public record Article(String id,
                      String title,
                      String content,
                      String topic,
                      LocalDate updatedDate,
                      LocalDate createdDate) {

    public Article(ArticleEntity articleEntity) {
        this(
                articleEntity.getId(),
                articleEntity.getTitle(),
                articleEntity.getContent(),
                articleEntity.getTopic(),
                articleEntity.getUpdatedDate(),
                articleEntity.getCreatedDate()
        );
    }
}
