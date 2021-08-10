package com.digitalinnovation.one.productcatalog.repository;

import com.digitalinnovation.one.productcatalog.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}
