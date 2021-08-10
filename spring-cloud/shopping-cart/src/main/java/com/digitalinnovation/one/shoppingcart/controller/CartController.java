package com.digitalinnovation.one.shoppingcart.controller;

import com.digitalinnovation.one.shoppingcart.model.Cart;
import com.digitalinnovation.one.shoppingcart.model.Item;
import com.digitalinnovation.one.shoppingcart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @PostMapping("/{id}")
    public Cart addItem(@PathVariable("id") Integer id, @RequestBody Item item) {
        Cart cart = cartRepository.findById(id)
                .orElse(new Cart(id));

        cart.getItems().add(item);
        return cartRepository.save(cart);
    }

    @GetMapping("/{id}")
    public Optional<Cart> findById(@PathVariable("id") Integer id) {
        return cartRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void clear(@PathVariable("id") Integer id) {
        cartRepository.deleteById(id);
    }


}
