package com.digitalinnovation.one.productcatalog.controller;

import com.digitalinnovation.one.productcatalog.model.Product;
import com.digitalinnovation.one.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping(value = "/product")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping
    Product create(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @GetMapping(value = "/{id}")
    Product findById(@PathVariable Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "entity not found"
                ));
    }

}
