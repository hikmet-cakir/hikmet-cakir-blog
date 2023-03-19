package com.hikmetcakir.article.usecase;

import com.hikmetcakir.common.model.UseCase;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UploadArticle implements UseCase {

    private String content;
}
