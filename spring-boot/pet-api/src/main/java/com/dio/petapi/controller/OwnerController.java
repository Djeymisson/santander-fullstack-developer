package com.dio.petapi.controller;

import com.dio.petapi.dto.OwnerDTO;
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
    @PostMapping(consumes="application/json", produces="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<OwnerDTO> create(@Valid @RequestBody OwnerDTO ownerDTO) throws InfoConflictException {
        OwnerDTO newOwner = ownerService.createOwner(ownerDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newOwner.getId())
                .toUri();

        return ResponseEntity.created(location).body(ownerDTO);
    }

    @ApiOperation(value = "Get a list of owners")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetched a list of owners"),
    })
    @GetMapping(produces="application/json")
    public ResponseEntity<List<OwnerDTO>> findAll() {
        return ResponseEntity.ok(ownerService.findAll());
    }

    @ApiOperation(value = "Get an owner by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetched a owner")
    })
    @GetMapping(value = "/{id}", produces="application/json")
    public ResponseEntity<OwnerDTO> findById(@PathVariable Long id) throws OwnerNotFoundException {
        return ResponseEntity.ok(ownerService.findById(id));
    }

    @ApiOperation(value = "Update an owner by id")
    @PutMapping(value = "/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<OwnerDTO> update(@PathVariable Long id, @Valid @RequestBody OwnerDTO ownerDTO) throws OwnerNotFoundException {
        return ResponseEntity.ok(ownerService.updateById(id,ownerDTO));
    }

    @ApiOperation(value = "Delete an owner by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws OwnerNotFoundException {
        ownerService.delete(id);
    }

}
