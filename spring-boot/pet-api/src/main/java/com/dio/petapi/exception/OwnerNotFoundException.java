package com.dio.petapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class OwnerNotFoundException extends Exception {

    public OwnerNotFoundException(Long id) {
        super("Owner not found with ID " + id);
    }

}
