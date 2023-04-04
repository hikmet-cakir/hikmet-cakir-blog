package com.hikmetcakir.article.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class Article {

    private String id;
    private String content;
    private Genre genre;
    private LocalDateTime updatedAt;
    private LocalDateTime createdAt;
}
