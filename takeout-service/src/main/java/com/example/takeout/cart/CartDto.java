package com.example.takeout.cart;

import java.util.List;

public class CartDto {

    private List<CartItemDto> items;
    private Integer totalPriceCents;

    public CartDto() {
    }

    public CartDto(List<CartItemDto> items, Integer totalPriceCents) {
        this.items = items;
        this.totalPriceCents = totalPriceCents;
    }

    public List<CartItemDto> getItems() {
        return items;
    }

    public Integer getTotalPriceCents() {
        return totalPriceCents;
    }
}
