package com.hikmetcakir.domain.article.rest.api;

import com.hikmetcakir.domain.article.dto.QueryArticleRequest;
import com.hikmetcakir.domain.article.dto.QueryArticleResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface ArticleApi {

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    ResponseEntity<QueryArticleResponse> queryArticle(@RequestParam(value = "id") QueryArticleRequest queryArticleRequest);
}
