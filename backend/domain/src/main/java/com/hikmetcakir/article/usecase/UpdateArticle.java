package com.hikmetcakir.article.usecase;

import com.hikmetcakir.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UpdateArticle implements UseCase {

    private String id;
    private String content;
    private LocalDateTime updatedAt;
}
