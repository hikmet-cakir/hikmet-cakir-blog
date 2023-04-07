package com.hikmetcakir.common.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequest {

    @Min(value = 1)
    private int size;

    @Min(value = 0)
    private int page;
}
