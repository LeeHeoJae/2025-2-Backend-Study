package com.example.demo.order.dto;

import lombok.Getter;

// id, sepc
@Getter
public class OrderCreateRequest {
    private String id;
    private String spec;

    public OrderCreateRequest(String id, String spec) {
        this.id = id;
        this.spec = spec;
    }
}
