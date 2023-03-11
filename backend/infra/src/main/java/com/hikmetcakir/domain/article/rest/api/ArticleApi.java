package com.hikmetcakir.domain.article.rest.api;

import com.hikmetcakir.domain.article.dto.QueryArticleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface ArticleApi {

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    ResponseEntity<QueryArticleResponse> queryArticle(@PathVariable(value = "id") String id);
}
