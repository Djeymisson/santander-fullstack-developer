package com.dio.petapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class InfoConflictException extends Exception{
    public InfoConflictException(String info) {
        super(info + " already in use.");
    }
}
