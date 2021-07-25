package com.dio.petapi.controller;

import com.dio.petapi.dto.request.OwnerDTO;
import com.dio.petapi.dto.response.MessageResponseDTO;
import com.dio.petapi.exception.InfoConflictException;
import com.dio.petapi.exception.OwnerNotFoundException;
import com.dio.petapi.service.OwnerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/owner")
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @ApiOperation(value = "Create a owner")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Fetch a list of owners"),
            @ApiResponse(code = 400, message = "An information validation error occurred"),
            @ApiResponse(code = 409, message = "An information conflict occurred"),
            @ApiResponse(code = 500, message = "An exception occurred"),
    })
    @PostMapping(consumes="application/json",produces="application/json")
    public ResponseEntity<OwnerDTO> create(@Valid @RequestBody OwnerDTO ownerDTO) throws InfoConflictException {
        OwnerDTO newOwner = ownerService.createOwner(ownerDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newOwner.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @ApiOperation(value = "Get a list of owners")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetched a list of owners"),
            @ApiResponse(code = 500, message = "An exception occurred"),
    })
    @GetMapping(produces="application/json")
    public ResponseEntity<List<OwnerDTO>> findAll() {
        return ResponseEntity.ok(ownerService.findAll());
    }

    @ApiOperation(value = "Get an owner by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetched a owner"),
            @ApiResponse(code = 404, message = "Owner not found"),
            @ApiResponse(code = 500, message = "An exception occurred"),
    })
    @GetMapping(value = "/{id}", produces="application/json")
    public ResponseEntity<OwnerDTO> findById(@PathVariable Long id) throws OwnerNotFoundException {
        return ResponseEntity.ok(ownerService.findById(id));
    }

    @ApiOperation(value = "Update an owner by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Owner updated"),
            @ApiResponse(code = 400, message = "An information validation error occurred"),
            @ApiResponse(code = 404, message = "Owner not found"),
            @ApiResponse(code = 500, message = "An exception occurred"),
    })
    @PutMapping(value = "/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<OwnerDTO> update(@PathVariable Long id, @Valid @RequestBody OwnerDTO ownerDTO) throws OwnerNotFoundException {
        return ResponseEntity.ok(ownerService.updateById(id,ownerDTO));
    }

    @ApiOperation(value = "Delete an owner by id")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Owner deleted"),
            @ApiResponse(code = 404, message = "Owner not found"),
            @ApiResponse(code = 500, message = "An exception occurred"),
    })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws OwnerNotFoundException {
        ownerService.delete(id);
    }

}
