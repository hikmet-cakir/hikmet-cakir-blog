package com.hikmetcakir.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleUploadRequest {

    private String title;
    private String content;
}
