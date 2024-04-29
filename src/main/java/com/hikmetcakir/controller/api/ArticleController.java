package com.hikmetcakir.controller.api;

import com.hikmetcakir.controller.ArticleApi;
import com.hikmetcakir.dto.ArticleUploadRequest;
import com.hikmetcakir.dto.ArticleUploadResponse;
import com.hikmetcakir.service.impl.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ArticleController implements ArticleApi {

    private final ArticleService articleService;

    @Override
    public ResponseEntity<ArticleUploadResponse> upload(ArticleUploadRequest request) {
        var response = articleService.upload(request);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
