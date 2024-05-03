package com.hikmetcakir.controller;

import com.hikmetcakir.dto.Article;
import com.hikmetcakir.dto.ArticleUpdateRequest;
import com.hikmetcakir.dto.ArticleUploadRequest;
import com.hikmetcakir.service.impl.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ArticleController {

    private final ArticleService articleService;

    @RequestMapping(value = "/article", method = RequestMethod.POST)
    public ResponseEntity<String> upload(@RequestBody ArticleUploadRequest request) {
        var response = articleService.upload(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.GET)
    public ResponseEntity<Article> query(@PathVariable String id) {
        var response = articleService.query(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.PATCH)
    public void update(@PathVariable String id, @RequestBody ArticleUpdateRequest request) {
        articleService.update(id, request);
    }

    @RequestMapping(value = "/article/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String id) {
        articleService.delete(id);
    }
}
