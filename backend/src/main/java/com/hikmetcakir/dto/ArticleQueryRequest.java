package com.hikmetcakir.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArticleQueryRequest {

    private String id;
    private String topic;
    private int pageNumber;
    private int pageSize;

    public Pageable buildPageable() {
        return PageRequest.of(pageNumber, pageSize);
    }
}
