package com.dio.petapi.controller;

import com.dio.petapi.dto.request.OwnerDTO;
import com.dio.petapi.dto.response.MessageResponseDTO;
import com.dio.petapi.exception.InfoConflictException;
import com.dio.petapi.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@Valid @RequestBody OwnerDTO ownerDTO) throws InfoConflictException {
        return ownerService.createOwner(ownerDTO);
    }

    @GetMapping
    public ResponseEntity<List<OwnerDTO>> findAll() throws InfoConflictException {
        return ResponseEntity.ok(ownerService.findAll());
    }

}
