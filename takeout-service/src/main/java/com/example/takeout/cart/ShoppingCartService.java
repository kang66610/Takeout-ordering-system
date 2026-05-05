package com.example.takeout.cart;

import com.example.takeout.model.Dish;
import com.example.takeout.repository.DishRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class ShoppingCartService {

    private final DishRepository dishRepository;
    private final Map<Long, CartEntry> cartItems = new ConcurrentHashMap<>();

    public ShoppingCartService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    @Transactional(readOnly = true)
    public CartDto getCart() {
        List<CartItemDto> items = new ArrayList<>();
        int total = 0;

        for (CartEntry entry : cartItems.values()) {
            CartItemDto itemDto = entry.toDto();
            items.add(itemDto);
            total += itemDto.getTotalPriceCents();
        }

        return new CartDto(items, total);
    }

    @Transactional
    public CartDto addDish(Long dishId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero.");
        }

        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Dish not found: " + dishId));

        cartItems.compute(dishId, (id, existing) -> {
            if (existing == null) {
                return new CartEntry(dish, quantity);
            }
            existing.increaseQuantity(quantity);
            return existing;
        });

        return getCart();
    }

    @Transactional
    public CartDto updateDishQuantity(Long dishId, int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity must not be negative.");
        }

        if (!cartItems.containsKey(dishId)) {
            throw new IllegalArgumentException("Dish not found in cart: " + dishId);
        }

        if (quantity == 0) {
            cartItems.remove(dishId);
            return getCart();
        }

        Dish dish = dishRepository.findById(dishId)
                .orElseThrow(() -> new IllegalArgumentException("Dish not found: " + dishId));

        cartItems.computeIfPresent(dishId, (id, existing) -> {
            existing.setQuantity(quantity);
            existing.setDish(dish);
            return existing;
        });

        return getCart();
    }

    @Transactional
    public CartDto removeDish(Long dishId) {
        cartItems.remove(dishId);
        return getCart();
    }

    private static class CartEntry {
        private Dish dish;
        private int quantity;

        CartEntry(Dish dish, int quantity) {
            this.dish = dish;
            this.quantity = quantity;
        }

        void increaseQuantity(int amount) {
            this.quantity += amount;
        }

        void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        void setDish(Dish dish) {
            this.dish = dish;
        }

        CartItemDto toDto() {
            int unitPrice = dish.getPriceCents() != null ? dish.getPriceCents() : 0;
            int totalPrice = unitPrice * quantity;
            return new CartItemDto(
                    dish.getId(),
                    dish.getName(),
                    dish.getDescription(),
                    dish.getImageUrl(),
                    unitPrice,
                    quantity,
                    totalPrice
            );
        }
    }
}
