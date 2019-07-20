package com.canx.restapp.controller;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@ControllerAdvice
public class ControllerBodyAdvice implements ResponseBodyAdvice<Object> {


    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Nullable
    @Override
    public Object beforeBodyWrite(@Nullable Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        return body instanceof ServiceError ? new ResponseErrorWrapper<>(body) : new ResponseBodyWrapper<>(body);
    }

    public static class ResponseBodyWrapper<T> {
        private final T data;


        public ResponseBodyWrapper(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }
    }

    public static class ResponseErrorWrapper<T> {
        private final T error;


        public ResponseErrorWrapper(T error) {
            this.error = error;
        }

        public T getError() {
            return error;
        }
    }
}
