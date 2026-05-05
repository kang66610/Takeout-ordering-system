package com.example.takeout.cart;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    public ShoppingCartController(ShoppingCartService shoppingCartService) {
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public ResponseEntity<CartDto> getCart() {
        return ResponseEntity.ok(shoppingCartService.getCart());
    }

    @PostMapping("/items")
    public ResponseEntity<CartDto> addItem(@RequestBody CartItemRequest request) {
        if (request.getDishId() == null || request.getQuantity() == null) {
            throw new IllegalArgumentException("dishId and quantity are required.");
        }
        CartDto cart = shoppingCartService.addDish(request.getDishId(), request.getQuantity());
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/items/{dishId}")
    public ResponseEntity<CartDto> updateItem(
            @PathVariable Long dishId,
            @RequestBody CartItemRequest request) {
        if (request.getQuantity() == null) {
            throw new IllegalArgumentException("quantity is required.");
        }
        CartDto cart = shoppingCartService.updateDishQuantity(dishId, request.getQuantity());
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/items/{dishId}")
    public ResponseEntity<CartDto> removeItem(@PathVariable Long dishId) {
        CartDto cart = shoppingCartService.removeDish(dishId);
        return ResponseEntity.ok(cart);
    }
}
