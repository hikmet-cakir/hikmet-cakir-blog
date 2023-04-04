package com.hikmetcakir.article.usecase;

import com.hikmetcakir.article.model.Genre;
import com.hikmetcakir.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UpdateArticle implements UseCase {

    private String id;
    private String content;
    private Genre genre;
    private LocalDateTime updatedAt;
}
