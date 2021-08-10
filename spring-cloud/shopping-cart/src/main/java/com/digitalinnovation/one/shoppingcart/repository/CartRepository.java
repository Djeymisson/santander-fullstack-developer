package com.digitalinnovation.one.shoppingcart.repository;

import com.digitalinnovation.one.shoppingcart.model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Integer> {

    Cart findByCustomerId(Integer customerId);

}
