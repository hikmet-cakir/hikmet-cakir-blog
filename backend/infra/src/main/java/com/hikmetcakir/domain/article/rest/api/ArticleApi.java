package com.hikmetcakir.domain.article.rest.api;

import com.hikmetcakir.domain.article.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface ArticleApi {

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    ResponseEntity<QueryArticleResponse> queryArticle(@RequestParam(value = "id") QueryArticleRequest queryArticleRequest);

    @RequestMapping(value = "/article", method = RequestMethod.DELETE)
    ResponseEntity<DeleteArticleResponse> deleteArticle(@RequestParam(value = "id") DeleteArticleRequest deleteArticleRequest);

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    ResponseEntity<UploadArticleResponse> uploadArticle(@RequestBody UploadArticleRequest uploadArticleRequest);

    @RequestMapping(value = "/article/{id}", method = RequestMethod.PATCH)
    ResponseEntity<UpdateArticleResponse> updateArticle(@PathVariable String id, @RequestBody UpdateArticleRequest updateArticleRequest);
}
