package com.canx.restapp.controller;

import com.canx.restapp.repository.exception.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ServiceError entityNotFoundHandler(EntityNotFoundException ex) {
        return new ServiceError(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
    }

    @ResponseBody
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ServiceError exceptionHandler(Exception ex) {
        return new ServiceError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
    }

}
