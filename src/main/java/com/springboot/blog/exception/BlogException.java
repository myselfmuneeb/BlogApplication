package com.springboot.blog.exception;

import org.springframework.http.HttpStatus;

public class BlogException  extends RuntimeException{
    private HttpStatus httpStatus;
    private String message;

    public BlogException(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    public BlogException(String message, HttpStatus httpStatus, String message1) {
        super(message);
        this.httpStatus = httpStatus;
        this.message = message1;
    }
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public String getMessage() {
        return message;
    }

}
