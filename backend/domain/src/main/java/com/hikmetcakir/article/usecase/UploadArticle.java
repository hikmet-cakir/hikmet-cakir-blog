package com.hikmetcakir.article.usecase;

import com.hikmetcakir.article.model.Genre;
import com.hikmetcakir.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadArticle implements UseCase {

    private String title;
    private String content;
    private Genre genre;
}
