package com.hikmetcakir.article.usecase;

import com.hikmetcakir.common.model.UseCase;
import lombok.Builder;

@Builder
public class QueryArticle implements UseCase {

    private String id;
}
