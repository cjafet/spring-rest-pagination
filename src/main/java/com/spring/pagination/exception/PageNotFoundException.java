package com.spring.pagination.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Page not found")
public class PageNotFoundException extends RuntimeException {
    public PageNotFoundException() {
        super();
    }
}
