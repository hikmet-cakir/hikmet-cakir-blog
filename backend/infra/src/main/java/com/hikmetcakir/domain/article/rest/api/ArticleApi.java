package com.hikmetcakir.domain.article.rest.api;

import com.hikmetcakir.common.Response;
import com.hikmetcakir.domain.article.dto.*;
import org.springframework.web.bind.annotation.*;

public interface ArticleApi {

    @RequestMapping(value = "/article", method = RequestMethod.GET)
    Response<QueryArticleResponse> queryArticle(@RequestParam(value = "id") QueryArticleRequest queryArticleRequest);

    @RequestMapping(value = "/article", method = RequestMethod.DELETE)
    void deleteArticle(@RequestParam(value = "id") DeleteArticleRequest deleteArticleRequest);

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    Response<UploadArticleResponse> uploadArticle(@RequestBody UploadArticleRequest uploadArticleRequest);

    @RequestMapping(value = "/article/{id}", method = RequestMethod.PATCH)
    void updateArticle(@PathVariable String id, @RequestBody UpdateArticleRequest updateArticleRequest);
}
