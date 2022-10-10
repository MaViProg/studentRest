package com.ikonnikova.springboot.hibernate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class NotFoundResourceException extends Exception {

    private static final long serialVersionUID = 1L;

    public NotFoundResourceException(String message) {
        super(message);
    }
}
