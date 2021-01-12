package com.dutra.fastcrud.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class ApiResponse {
    private boolean success;
    private HttpStatus status;
    private int statusCode;
    private String message;
    private Object body;

    public ApiResponse(HttpStatus status, boolean success, String message, Object body) {
        this.success = success;
        this.message = message;
        this.body = body;
        this.status = status;
        this.statusCode = status.value();
    }

    public ApiResponse(HttpStatus status, boolean success, String message) {
        this.success = success;
        this.message = message;
        this.status = status;
        this.statusCode = status.value();
    }
}
