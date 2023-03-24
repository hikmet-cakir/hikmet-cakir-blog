package com.hikmetcakir.article.model;

import lombok.Builder;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@Builder
public class Article {

    private String id;
    private String content;
    private ZonedDateTime createdAt;
    private ZonedDateTime updatedAt;


}
