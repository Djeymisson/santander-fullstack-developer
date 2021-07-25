package com.dio.petapi.controller;

import com.dio.petapi.dto.request.OwnerDTO;
import com.dio.petapi.dto.response.MessageResponseDTO;
import com.dio.petapi.exception.InfoConflictException;
import com.dio.petapi.exception.OwnerNotFoundException;
import com.dio.petapi.service.OwnerService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @PostMapping(consumes="application/json",produces="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO create(@Valid @RequestBody OwnerDTO ownerDTO) throws InfoConflictException {
        return ownerService.createOwner(ownerDTO);
    }

    @GetMapping(produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetch a list of owners"),
            @ApiResponse(code = 500, message = "An exception occurred"),
    })
    public ResponseEntity<List<OwnerDTO>> findAll() {
        return ResponseEntity.ok(ownerService.findAll());
    }

    @GetMapping(value = "/{id}", produces="application/json")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetch a owner"),
            @ApiResponse(code = 404, message = "Owner not found"),
            @ApiResponse(code = 500, message = "An exception occurred"),
    })
    public ResponseEntity<OwnerDTO> findById(@PathVariable Long id) throws OwnerNotFoundException {
        return ResponseEntity.ok(ownerService.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<OwnerDTO> update(@PathVariable Long id, @Valid @RequestBody OwnerDTO ownerDTO) throws OwnerNotFoundException {
        return ResponseEntity.ok(ownerService.updateById(id,ownerDTO));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) throws OwnerNotFoundException {
        ownerService.delete(id);
    }

}
