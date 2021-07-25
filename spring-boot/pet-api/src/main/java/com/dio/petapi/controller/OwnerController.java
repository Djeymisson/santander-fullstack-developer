package com.dio.petapi.controller;

import com.dio.petapi.dto.request.OwnerDTO;
import com.dio.petapi.dto.response.MessageResponseDTO;
import com.dio.petapi.exception.InfoConflictException;
import com.dio.petapi.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createOwner(@RequestBody @Valid OwnerDTO ownerDTO) throws InfoConflictException {
        return ownerService.createOwner(ownerDTO);
    }

}
