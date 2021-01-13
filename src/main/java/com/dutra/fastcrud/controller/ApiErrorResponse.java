package com.dutra.fastcrud.controller;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.List;

@Getter
public class ApiErrorResponse {
    private HttpStatus status;
    private int statusCode;
    private boolean success = false;
    private String message;
    private List<String> body;

    public ApiErrorResponse(HttpStatus status, String message, List<String> errors) {
        super();
        this.status = status;
        this.message = message;
        this.body = errors;
        this.statusCode = status.value();
    }

    public ApiErrorResponse(HttpStatus status, String message, String error) {
        super();
        this.status = status;
        this.message = message;
        body = Arrays.asList(error);
        this.statusCode = status.value();
    }
}

