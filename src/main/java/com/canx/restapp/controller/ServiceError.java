package com.canx.restapp.controller;

public class ServiceError {
    private final int code;
    private final String message;

    public ServiceError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
