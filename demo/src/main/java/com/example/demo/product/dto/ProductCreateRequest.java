package com.example.demo.product.dto;

import lombok.Getter;

// id, spec
@Getter
public class ProductCreateRequest {

    private String id;
    private String spec;

    public ProductCreateRequest(String id, String spec) {
        this.id = id;
        this.spec = spec;
    }
}
