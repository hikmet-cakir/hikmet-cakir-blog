package com.hikmetcakir.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUploadResponse {

    private String id;

    public static ArticleUploadResponse from(String id) {
        ArticleUploadResponse response = new ArticleUploadResponse();
        response.id = id;
        return response;
    }
}
