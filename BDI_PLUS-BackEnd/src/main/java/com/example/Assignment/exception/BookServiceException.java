package com.example.Assignment.exception;

import org.springframework.http.HttpStatus;

public class BookServiceException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;

    public BookServiceException(HttpStatus httpStatus) {
        super();
        this.httpStatus = httpStatus;
    }

    public BookServiceException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
