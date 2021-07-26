package com.dio.petapi.controller;

import com.dio.petapi.dto.PetDTO;
import com.dio.petapi.exception.OwnerNotFoundException;
import com.dio.petapi.exception.PetNotFoundException;
import com.dio.petapi.service.PetService;
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
@RequestMapping("/api/pet")
public class PetController {

    @Autowired
    private PetService petService;

    @ApiOperation(value = "Create a pet with an owner")
    @PostMapping(consumes="application/json", produces="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(value = {
            @ApiResponse(code = 404, message = "Owner not found."),
    })
    public ResponseEntity<PetDTO> createPet(@Valid @RequestBody PetDTO petDTO) throws OwnerNotFoundException {
        PetDTO newPet = petService.createPet(petDTO);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newPet.getId())
                .toUri();

        return ResponseEntity.created(location).body((newPet));
    }

    @ApiOperation(value = "Get a list of pets")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetched a list of pets"),
    })
    @GetMapping(produces="application/json")
    public ResponseEntity<List<PetDTO>> findAll() {
        return ResponseEntity.ok(petService.findAll());
    }

    @ApiOperation(value = "Get an pet by id")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetched a pet")
    })
    @GetMapping(value = "/{id}", produces="application/json")
    public ResponseEntity<PetDTO> findById(@PathVariable Long id) throws PetNotFoundException {
        return ResponseEntity.ok(petService.findById(id));
    }

    @ApiOperation(value = "Get a list of pets by owners")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Fetched a list of pets of an owner"),
            @ApiResponse(code = 404, message = "Owner not found."),
    })
    @GetMapping(value = "/owner/{id}", produces="application/json")
    public ResponseEntity<List<PetDTO>> findByOwner(@PathVariable Long id) {
        return ResponseEntity.ok(petService.findByOwner(id));
    }

    @ApiOperation(value = "Update an pet by id")
    @PutMapping(value = "/{id}", consumes="application/json", produces="application/json")
    public ResponseEntity<PetDTO> update(@PathVariable Long id, @Valid @RequestBody PetDTO petDTO) throws PetNotFoundException {
        PetDTO body = petService.updateById(id, petDTO);
        return ResponseEntity.ok(body);
    }

    @ApiOperation(value = "Delete an pet by id")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws PetNotFoundException {
        petService.delete(id);
    }

}
