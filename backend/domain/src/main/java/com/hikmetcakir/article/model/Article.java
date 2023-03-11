package com.hikmetcakir.article.model;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class Article {

    private String id;
    private String content;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;
}
