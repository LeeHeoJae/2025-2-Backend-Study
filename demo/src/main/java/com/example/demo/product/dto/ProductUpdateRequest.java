package com.example.demo.product.dto;

import lombok.Getter;

// id, spec
@Getter
public class ProductUpdateRequest {

    private String id;
    private String spec;

    public ProductUpdateRequest(String id, String spec) {
        this.id = id;
        this.spec = spec;
    }
}
